package org.jiage.srpc.server.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jiage.srpc.server.vo.ProtocolVO;

public class ProtocolClientHandlerTest extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connect to server.....");
        //1.Client send message to server
        ProtocolVO p = new ProtocolVO("Hello world!".getBytes());
        ctx.writeAndFlush(p);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Client received message from server ");
        //2.Client received message from server
        ProtocolVO m = (ProtocolVO) msg;
        System.out.println(m);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }



}
