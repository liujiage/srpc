package org.jiage.srpc.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.jiage.srpc.api.message.constant.ServerConst;
import org.jiage.srpc.api.message.constant.TransferConst;
import org.jiage.srpc.api.message.vo.TransferVO;

public class ServerTest {

    public static void main(String[] args) throws Exception {

        new ServerTest().transfer(new TransferVO(TransferConst.PORT));
    }

    public void transfer(TransferVO transferVO) throws Exception {
        final int port = transferVO.getPort();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ProtocolEncoder(),new ProtocolDecoder(),new ProtocolServerHandlerTest());
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
    }


}
