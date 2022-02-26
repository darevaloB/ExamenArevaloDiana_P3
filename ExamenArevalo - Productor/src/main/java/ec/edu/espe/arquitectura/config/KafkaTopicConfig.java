/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 *
 * @author DIANA
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic amigoscodeTopic() {
        return TopicBuilder.name("pagoPrestamos").build();
    }
}
