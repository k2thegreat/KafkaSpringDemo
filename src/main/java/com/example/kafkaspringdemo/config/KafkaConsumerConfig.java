package com.example.kafkaspringdemo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String configServer;

    @Bean
    public Map<String,Object> getConfigProps(){
        Map<String,Object> propsConfig = new HashMap<>();
        propsConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        propsConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,configServer);
        return propsConfig;
    }

    @Bean
    public ConsumerFactory<String,String> getConsumerFactory(){
        return new DefaultKafkaConsumerFactory(getConfigProps());
    }

// ConcurrentMessageListenerContainer is used as there could be multiple producers writing to the single thread
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> consumerListener(){
        ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(getConsumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }

}
