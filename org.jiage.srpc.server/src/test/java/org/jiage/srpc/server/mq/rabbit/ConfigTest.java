package org.jiage.srpc.server.mq.rabbit;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ConfigTest {

    @Bean
    public MessageTest messageTest(){
        return new MessageTest();
    }
}
