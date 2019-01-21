package org.jiage.srpc.server.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jiage.srpc.server.vo.ProtocolVO;

public class ProtocolServerHandlerTest extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        System.out.println("1.Server connect client channelActive...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("2.Server read message from client");
        ProtocolVO p = (ProtocolVO)msg;
        System.out.println("received message from client : "+new String(p.getMessage()));
        ctx.writeAndFlush(new ProtocolVO("Server response message.".getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }


}
