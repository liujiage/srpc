package org.jiage.srpc.server.mq.rabbit;

        import org.springframework.amqp.rabbit.annotation.RabbitListener;
        import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class ConsumeListenerTransactionTest {

    @RabbitListener(queues = "${rabbitmq.queue.transaction}",
            containerFactory="rabbitListenerTransaction")
    public void consumeMessage(MessageTest message) throws Exception{
        System.out.println("transaction: "+message);
    }
}
