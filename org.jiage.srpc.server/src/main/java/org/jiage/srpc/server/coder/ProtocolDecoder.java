package org.jiage.srpc.server.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jiage.srpc.api.message.constant.ProtocolConst;
import org.jiage.srpc.api.message.vo.ProtocolVO;

import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        System.out.println("decode......");
        if (in.readableBytes() < ProtocolConst.MIN_LENGTH) {
            return;
        }
        int read = in.readInt();
        if(read == ProtocolConst.BUFFER_START){
            int format = in.readInt();
            System.out.println("message format: "+format);
            int len = in.readInt();
            //to do split things ...............
            byte[] message = new byte[len];
            in.readBytes(message);
            System.out.println("message: "+new String(message));
            out.add(new ProtocolVO(message));
        }
    }
}
