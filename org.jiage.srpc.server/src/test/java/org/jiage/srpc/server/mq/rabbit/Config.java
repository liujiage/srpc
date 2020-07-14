package org.jiage.srpc.server.mq.rabbit;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Config {

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //rabbitTemplate.setRoutingKey("txTestQ2");
        rabbitTemplate.setQueue("test.queue");
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("dt.mq.lan");
        cachingConnectionFactory.setUsername("admin");
        cachingConnectionFactory.setPassword("admin");
        //cachingConnectionFactory.setPublisherConfirms(false);
        //cachingConnectionFactory.setPublisherReturns(true);
        return new CachingConnectionFactory();
    }

    @Bean
    public RabbitTransactionManager transactionManager() {
        return new RabbitTransactionManager(connectionFactory());
    }

    @Bean
    public Service service() {
//		return new ServiceImpl1();
        return new ServiceImpl2();
    }
}
