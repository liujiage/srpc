package org.jiage.srpc.server.transfer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.jiage.srpc.api.message.constant.ClientConst;
import org.jiage.srpc.api.message.transfer.Transfer;
import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.TransferVO;
import org.jiage.srpc.server.coder.ProtocolDecoder;
import org.jiage.srpc.server.coder.ProtocolEncoder;
import org.jiage.srpc.server.handler.ClientProtocolHandler;

public class ClientTransfer implements Transfer {

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    @Override
    public ProtocolVO transfer(TransferVO transfer) throws Exception {
        final String host = transfer.getHost();
        final int port = transfer.getPort();
        ProtocolVO protocol = null;
        try {
            final ClientProtocolHandler clientHandler = new ClientProtocolHandler();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, ClientConst.SO_KEEPALIVE);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProtocolEncoder(),new ProtocolDecoder(),clientHandler);
                }
            });
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            // Send request
            f.channel().writeAndFlush(transfer.getProtocol());
            protocol = clientHandler.poll();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return protocol;
    }

    @Override
    public void transferImmediate(TransferVO transfer) throws Exception {
        this.transfer(transfer);
    }

    @Override
    public void disconnect() {
        try{
            workerGroup.shutdownGracefully();
        }catch(Exception e){
            /*do nothing*/
        }
    }
}
