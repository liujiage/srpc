package org.jiage.srpc.server.mq.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class SendTest implements RabbitTemplate.ReturnCallback {


    @Resource(name="rabbitTemplateTransaction")
    private RabbitTemplate rabbitTemplateTransaction;

    @Resource(name="rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    private void init(){
        rabbitTemplate.setReturnCallback(this);
    }

    @Transactional(rollbackFor = Exception.class,transactionManager = "rabbitTransactionManager")
    public void sendTransaction(String exchange,String queue,Object message) {
        System.out.println("transaction send....");
        rabbitTemplateTransaction.convertAndSend(exchange,queue,message);
    }

    public void send(String exchange,String queue,Object message){
        rabbitTemplate.convertAndSend(exchange,queue,message);
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("returnedMessage");
    }

}
