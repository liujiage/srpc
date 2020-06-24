package org.jiage.srpc.server.mq.rabbit;

import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class MessageTest {
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
