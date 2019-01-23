package org.jiage.srpc.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jiage.srpc.api.message.constant.ProtocolConst;
import org.jiage.srpc.api.message.vo.ProtocolVO;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public abstract class AbstractHandler<T> extends ChannelInboundHandlerAdapter {

    private SynchronousQueue<T> queue = new SynchronousQueue();

    protected void put(T t){
        try {
            queue.put(t);
        }catch (Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
    }

    public T poll(){
        try {
            return queue.poll(ProtocolConst.CLIENT_POLL_TIMEOUT, TimeUnit.MINUTES);
        }catch(Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
        return null;
    }

    public T poll(long timeout, TimeUnit unit){
        try {
            return queue.poll(timeout, unit);
        }catch(Exception e){
            e.printStackTrace();
            /*do nothing*/
        }
        return null;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
