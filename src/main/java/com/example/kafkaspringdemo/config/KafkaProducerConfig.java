package com.example.kafkaspringdemo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String configServer;


    @Bean
    public Map<String,Object> getKafkaFactory(){
        Map<String,Object> propsMap = new HashMap<>();
        propsMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        propsMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,configServer);
        propsMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return propsMap;
    }

    // ProducerFactory<String,Customer/Notification> - eg if you want Customer data or Notification data to be sent to Topic.
    // Below example is simple for String type data
    @Bean
    public ProducerFactory<String,String> getProducerFactory(){
        return new DefaultKafkaProducerFactory<>(getKafkaFactory());
    }

    @Bean
    public KafkaTemplate<String,String> getKafkaTemplate(){
        return new KafkaTemplate<>(getProducerFactory());
    }
}
