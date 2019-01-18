package org.jiage.srpc.server.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.jiage.srpc.server.vo.ProtocolVO;

public class ProtocolEncoder extends MessageToByteEncoder<ProtocolVO> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ProtocolVO msg, ByteBuf out) {
        System.out.println("encode...");
        out.writeInt(msg.getBufferStart());
        out.writeInt(msg.getSize());
        out.writeBytes(msg.getMessage());
    }
}