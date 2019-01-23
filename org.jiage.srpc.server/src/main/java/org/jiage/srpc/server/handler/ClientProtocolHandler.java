package org.jiage.srpc.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.jiage.srpc.api.message.vo.ProtocolVO;

public class ClientProtocolHandler extends AbstractHandler<ProtocolVO> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //2.Client received message from server
        ProtocolVO protocol = (ProtocolVO) msg;
        System.out.println("Client received message from server "+new String(protocol.getMessage()));
        this.put(protocol);
        ctx.close();
    }

}
