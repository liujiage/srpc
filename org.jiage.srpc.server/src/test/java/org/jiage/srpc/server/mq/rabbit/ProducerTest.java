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
    private MessageTest messageTest;

    @Value("${rabbitmq.exchange:}")
    private String RABBITMQ_EXCHANGE;

    @Test
    public void send(){
        System.out.println(RABBITMQ_EXCHANGE);
        System.out.println(messageTest);
    }

}
