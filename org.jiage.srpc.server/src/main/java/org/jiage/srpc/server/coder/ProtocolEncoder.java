package org.jiage.srpc.server.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.jiage.srpc.api.message.vo.ProtocolVO;

public class ProtocolEncoder extends MessageToByteEncoder<ProtocolVO> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ProtocolVO msg, ByteBuf out) {
        System.out.println("encode...");
        out.writeInt(msg.getBufferStart());
        out.writeInt(msg.getFormat());
        out.writeInt(msg.getMessage().length);
        out.writeBytes(msg.getMessage());
    }
}