package org.jiage.srpc.server.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jiage.srpc.api.message.constant.ProtocolConst;
import org.jiage.srpc.api.message.vo.ProtocolVO;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class ProtocolClientHandlerTest extends ChannelInboundHandlerAdapter {

    private SynchronousQueue<ProtocolVO> queue = new SynchronousQueue();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //2.Client received message from server
        ProtocolVO protocol = (ProtocolVO) msg;
        System.out.println("Client received message from server "+new String(protocol.getMessage()));
        this.put(protocol);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private void put(ProtocolVO protocol){
        try {
            queue.put(protocol);
        }catch (Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
    }

    public ProtocolVO poll(){
        try {
            return queue.poll(ProtocolConst.CLIENT_POLL_TIMEOUT, TimeUnit.MINUTES);
        }catch(Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
        return null;
    }

    public ProtocolVO poll(long timeout, TimeUnit unit){
        try {
            return queue.poll(timeout, unit);
        }catch(Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
        return null;
    }



}
