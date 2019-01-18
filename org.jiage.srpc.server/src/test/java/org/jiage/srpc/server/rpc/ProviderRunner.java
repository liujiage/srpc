package org.jiage.srpc.server.rpc;

import java.io.IOException;

public class ProviderRunner {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServerImpl(8088);
                    serviceServer.register(SayHello.class, SayHelloImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
