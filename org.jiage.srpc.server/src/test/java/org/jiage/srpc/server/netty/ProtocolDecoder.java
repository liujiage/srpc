package org.jiage.srpc.server.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jiage.srpc.server.constant.ProtocolConstant;
import org.jiage.srpc.server.vo.ProtocolVO;

import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        System.out.println("decode......");
        if (in.readableBytes() < ProtocolConstant.MIN_LENGTH) {
            return;
        }
        int read = in.readInt();
        if(read == ProtocolConstant.BUFFER_START){
            int len = in.readInt();
            //to do split things ...............
            byte[] message = new byte[len];
            in.readBytes(message);
            System.out.println("message: "+new String(message));
            out.add(new ProtocolVO(message));
        }
    }
}
