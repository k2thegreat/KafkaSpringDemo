package com.example.kafkaspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* Commands to start zookeeper and kafka broker
* Quick start URL - https://kafka.apache.org/documentation/#quickstart
* bin/zookeeper-server-start.sh config/zookeeper.properties   - for starting the zookeeper for maintaining the cluster and nodes
* bin/kafka-server-start.sh config/server.properties    - for starting the Kafka broker so that topics can be created and data can be sent to them
* bin/kafka-console-consumer.sh --topic <topic_name> --from-beginning --bootstrap-server localhost:9092  - command to start consumer listener and read all the data producer writes to the specified topic
* */

@SpringBootApplication
public class KafkaSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringDemoApplication.class, args);
    }

}
