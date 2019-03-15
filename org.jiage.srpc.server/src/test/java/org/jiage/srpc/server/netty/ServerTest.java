package org.jiage.srpc.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.jiage.srpc.api.message.constant.ServerConst;
import org.jiage.srpc.api.message.constant.TransferConst;
import org.jiage.srpc.api.message.vo.TransferVO;
import org.jiage.srpc.server.service.ServerService;
import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class ServerTest {

    private final static ServerService serverService = new ServerService();
    public static void main(String[] args) throws Exception {
        serverService.start();
        //serverService.stop();
    }

}
