package org.jiage.srpc.server.mq.rabbit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@Import(ConfigTest.class)
@PropertySource("classpath:test-application.properties")
public class ConsumerTest {

    public static void main(String args[]){
        SpringApplication.run(ConsumerTest.class, args);
    }
}
