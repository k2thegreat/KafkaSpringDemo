package com.example.kafkaspringdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
public class KafkaProducerTest {

    @Autowired
    private KafkaTemplate template;

    @Test
    public void sendMessageToketantopic(){
        for(int i=0;i<10;i++)
        template.send("ketantopic","How you doing! " + i);
    }
}
