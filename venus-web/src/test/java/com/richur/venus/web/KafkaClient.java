package com.richur.venus.web;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaClient {
    public static void main(String[] args) {
        KafkaProducer prd = new KafkaProducer(getCommonParams());
        prd.send(new ProducerRecord("topic", "value"));


    }


    private static final String KAFKA_SERVERS = "172.19.40.183:9092,172.19.40.184:9092,"
            + "172.19.40.185:9092,172.19.40.186:9092,172.19.40.187:9092,172.19.40.188:92,"
            + "172.19.40.189:9092,172.19.40.190:9092,172.19.40.191:9092,172.19.40.192:9092";

    private static Map<String, Object> getCommonParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("bootstrap.servers", KAFKA_SERVERS);
        params.put("key.deserializer", StringDeserializer.class);
        params.put("value.deserializer", StringDeserializer.class);
        params.put("key.serializer", StringSerializer.class);
        params.put("value.serializer", StringSerializer.class);
        return params;
    }
}

