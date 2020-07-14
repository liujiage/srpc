package org.jiage.srpc.server.mq.rabbit;
public interface Service {

    void process(boolean crash) throws Exception;

}
