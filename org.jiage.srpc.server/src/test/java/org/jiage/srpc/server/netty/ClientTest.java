package org.jiage.srpc.server.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.jiage.srpc.server.constant.TransferConstant;
import org.jiage.srpc.server.vo.ProtocolVO;
import org.jiage.srpc.server.vo.TransferVO;

import java.util.concurrent.TimeUnit;

public class ClientTest {

    public static void main(String[] args) throws Exception {

        ProtocolVO protocol = new ClientTest().transfer(new TransferVO(TransferConstant.HOST,
                TransferConstant.PORT));
        System.out.println("protocol message: "+  new String(protocol.getMessage()));

    }

    private  ProtocolVO transfer(TransferVO transferVO) throws Exception{
        final String host = transferVO.getHost();
        final int port = transferVO.getPort();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ProtocolVO response = null;
        try {
            final ProtocolClientHandlerTest protocolClientHandler = new ProtocolClientHandlerTest();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProtocolEncoder(),new ProtocolDecoder(),protocolClientHandler);
                }
            });
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            //System.out.println("protocolClientHandler: "+protocolClientHandler.getProtocolVO());
            response = protocolClientHandler.poll();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return response;
    }
}
