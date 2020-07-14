package org.jiage.srpc.server.mq.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitApplicationTest.class})
@Import(ConfigTest.class)
@TestPropertySource("classpath:test-application.properties")
public class ProducerTest {

    @Autowired
    private SendTest sendTest;

    @Value("${test.transaction.routing:}")
    private String RABBIT_ROUTING;
    @Value("${rabbitmq.exchange:}")
    private String RABBITMQ_EXCHANGE;
    @Value("${rabbitmq.queue:}")
    private String RABBITMQ_QUEUE;

    @Test
    public void send(){
        MessageTest message = new MessageTest(1,1,1,"test");
        sendTest.send(RABBITMQ_EXCHANGE,RABBIT_ROUTING,message);

    }

    @Test
    public void sendTransaction(){
        MessageTest message = new MessageTest(1,1,1,"test");
        sendTest.sendTransaction(RABBITMQ_EXCHANGE,RABBIT_ROUTING,message);

    }

    @Test
    public void received(){
        MessageTest message = (MessageTest)sendTest.getRabbitTemplate().
                receiveAndConvert(RABBITMQ_QUEUE);
        System.out.println(message);
    }

}