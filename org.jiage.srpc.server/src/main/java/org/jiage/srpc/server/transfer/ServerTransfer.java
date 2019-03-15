package org.jiage.srpc.server.transfer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.jiage.srpc.api.message.constant.ServerConst;
import org.jiage.srpc.api.message.transfer.Transfer;
import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.TransferVO;
import org.jiage.srpc.server.coder.ProtocolDecoder;
import org.jiage.srpc.server.coder.ProtocolEncoder;
import org.jiage.srpc.server.handler.ServerProtocolHandler;

public class ServerTransfer implements Transfer {

    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    @Override
    public ProtocolVO transfer(TransferVO transfer) throws Exception {
        final int port = transfer.getPort();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ProtocolEncoder(),new ProtocolDecoder(),new ServerProtocolHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, ServerConst.SO_BACKLOG)
                    .childOption(ChannelOption.SO_KEEPALIVE, ServerConst.SO_KEEPALIVE);
            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
        return null;
    }

    @Override
    public void transferImmediate(TransferVO transfer) throws Exception {
        this.transfer(transfer);
    }

    @Override
    public void disconnect() {
        try{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }catch(Exception e){
            /*do nothing*/
        }

    }
}
