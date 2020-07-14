package org.jiage.srpc.server.mq.rabbit;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
public class TxTest {

    @Test
    public void test() throws Exception{
        final AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        template.convertAndSend("", "txTestQ1", "foo");
        Service service = context.getBean(Service.class);
        service.process(false);
        Object o = template.receiveAndConvert("txTestQ1");
        assertNull(o);
        o = template.receiveAndConvert("txTestQ2");
        assertNotNull(o);
        System.out.println("message " + o + " moved from Q1 to Q2");

        template.convertAndSend("", "txTestQ1", "bar");
        try {
            service.process(true);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        o = template.receiveAndConvert("txTestQ1");
        assertNotNull(o);
        System.out.println("message " + o + " still in Q1");
        o = template.receiveAndConvert("txTestQ2");
        assertNull(o);
    }
}
