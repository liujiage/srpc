package org.jiage.srpc.server.mq.rabbit;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ConfigTest {

    @Value("${rabbitmq.host:}")
    private String RABBITMQ_HOST;
    @Value("${rabbitmq.username:}")
    private String RABBITMQ_USERNAME;
    @Value("${rabbitmq.password:}")
    private String RABBITMQ_PASSWORD;

    //building a factory to connect rabbit mq without transaction
    @Bean("connectionFactory")
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(RABBITMQ_HOST);
        cachingConnectionFactory.setUsername(RABBITMQ_USERNAME);
        cachingConnectionFactory.setPassword(RABBITMQ_PASSWORD);
        return cachingConnectionFactory;
    }

    //building a factory to connect rabbit mq with transaction
    @Bean("connectionFactoryTransaction")
    public ConnectionFactory connectionFactoryTransaction(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(RABBITMQ_HOST);
        cachingConnectionFactory.setUsername(RABBITMQ_USERNAME);
        cachingConnectionFactory.setPassword(RABBITMQ_PASSWORD);
        cachingConnectionFactory.setPublisherConfirms(false);
        cachingConnectionFactory.setPublisherReturns(true);
        return cachingConnectionFactory;
    }

    //register a listener to consume message
    @Bean("rabbitListener")
    public SimpleRabbitListenerContainerFactory rabbitListener() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    //register a listener to consume message
    @Bean("rabbitListenerTransaction")
    public SimpleRabbitListenerContainerFactory rabbitListenerTransaction() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactoryTransaction());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

    //get a rabbit template to use send and received message without transaction
    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

    //get a rabbit template to use send and received message with transaction
    @Bean("rabbitTemplateTransaction")
    public RabbitTemplate rabbitTemplateTransaction(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactoryTransaction());
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }

    @Bean
    public SendTest sendTest(){
        return new SendTest();
    }

    //manager transaction
    @Bean("rabbitTransactionManager")
    public RabbitTransactionManager rabbitTransactionManager() {
        return new RabbitTransactionManager(connectionFactoryTransaction());
    }

}
