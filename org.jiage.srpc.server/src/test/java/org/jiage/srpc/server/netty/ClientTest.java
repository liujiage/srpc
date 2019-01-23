package org.jiage.srpc.server.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.jiage.srpc.api.message.parse.Parse;
import org.jiage.srpc.api.message.vo.ResponseVO;
import org.jiage.srpc.api.message.constant.ClientConst;
import org.jiage.srpc.api.message.constant.TransferConst;
import org.jiage.srpc.server.parse.ProtocolToResponseParse;
import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.TransferVO;

public class ClientTest {

    public static void main(String[] args) throws Exception {

        ProtocolVO protocol = new ClientTest().transfer(new TransferVO(TransferConst.HOST,
                TransferConst.PORT,new ProtocolVO("Hello world!".getBytes())));
        System.out.println("protocol message: "+  new String(protocol.getMessage()));
        Parse<ResponseVO,ProtocolVO> parse = new ProtocolToResponseParse();
        ResponseVO response =  parse.convert(protocol);
        System.out.println("response: "+response.getData());

    }

    private  ProtocolVO transfer(TransferVO transferVO) throws Exception{
        final String host = transferVO.getHost();
        final int port = transferVO.getPort();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ProtocolVO protocol = null;
        try {
            final ProtocolClientHandlerTest protocolClientHandler = new ProtocolClientHandlerTest();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, ClientConst.SO_KEEPALIVE);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProtocolEncoder(),new ProtocolDecoder(),protocolClientHandler);
                }
            });
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            // Send request
            f.channel().writeAndFlush(transferVO.getProtocol());
            protocol = protocolClientHandler.poll();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return protocol;
    }
}
