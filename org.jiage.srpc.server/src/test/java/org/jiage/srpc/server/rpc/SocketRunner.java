package org.jiage.srpc.server.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        SayHello service = RPCClient.getRemoteProxyObj(SayHello.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHello("hello jhz!"));
    }


}
