package org.jiage.srpc.server.rpc;

public class SayHelloImpl implements SayHello{
    @Override
    public String sayHello(String name) {
        return "rpc response to "+name;
    }
}
