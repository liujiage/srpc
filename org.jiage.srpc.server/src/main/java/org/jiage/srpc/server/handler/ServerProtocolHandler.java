package org.jiage.srpc.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.jiage.srpc.api.message.vo.ProtocolVO;

public class ServerProtocolHandler extends AbstractHandler<ProtocolVO> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("2.Server read message from client");
        ProtocolVO p = (ProtocolVO)msg;
        System.out.println("received message from client : "+new String(p.getMessage()));
        ctx.writeAndFlush(new ProtocolVO("Server response message.".getBytes()));
    }
}
