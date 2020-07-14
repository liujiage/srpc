package org.jiage.srpc.server.mq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class ConsumeListenerTest {

    @RabbitListener(queues = "${rabbitmq.queue}",containerFactory="rabbitListener" )
    public void consumeMessage(MessageTest message) throws Exception{
        System.out.println(message);
    }

}