package com.example.kafkaspringdemo.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    // we specify the groupId as there could be multiple instances of the Consumer application/ microservice and all should belong to the same group
    @KafkaListener(topics="ketantopic",groupId = "ketangroup")
    public void listener(String data){
    System.out.println("Recieved on Listener : "+data);
    }

}
