package org.jiage.srpc.server.mq.rabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
public class ServiceImpl2 implements Service {

    @Autowired
    private RabbitTemplate template;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void process(boolean crash) throws Exception {
        Object o = template.receiveAndConvert();
        if (crash) {
            throw new FooEx("crash");
        }
        if (o != null) {
            System.out.println(o);
            template.convertAndSend(o);
        }
    }

    @SuppressWarnings("serial")
    private class FooEx extends Exception {

        private FooEx(String message) {
            super(message);
        }

    }
}
