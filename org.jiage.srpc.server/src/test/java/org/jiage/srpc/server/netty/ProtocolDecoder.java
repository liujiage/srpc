package org.jiage.srpc.server.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jiage.srpc.server.vo.ProtocolVO;

import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        System.out.println("decode......");
        if (in.readableBytes() < 4) {
            return;
        }
        //to do split things ...............
        byte[] message = new byte[1234];
        in.readBytes(message);
        out.add(new ProtocolVO(message));
    }
}
