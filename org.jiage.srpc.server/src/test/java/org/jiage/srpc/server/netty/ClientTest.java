package org.jiage.srpc.server.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.jiage.srpc.api.message.parse.Parse;
import org.jiage.srpc.api.message.vo.ResponseVO;
import org.jiage.srpc.api.message.constant.ClientConst;
import org.jiage.srpc.api.message.constant.TransferConst;
import org.jiage.srpc.server.handler.ClientProtocolHandler;
import org.jiage.srpc.server.parse.ProtocolToResponseParse;
import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.TransferVO;
import org.jiage.srpc.server.transfer.ClientTransfer;
import org.junit.Ignore;

@Ignore
public class ClientTest {

    public static void main(String[] args) throws Exception {

        ProtocolVO protocol = new ClientTransfer().transfer((new TransferVO(TransferConst.HOST,
                          TransferConst.PORT,new ProtocolVO("Hello world!".getBytes()))));
        System.out.println("protocol message: "+  new String(protocol.getMessage()));
        Parse<ResponseVO,ProtocolVO> parse = new ProtocolToResponseParse();
        ResponseVO response =  parse.convert(protocol);
        System.out.println("response: "+response.getData());

    }

}
