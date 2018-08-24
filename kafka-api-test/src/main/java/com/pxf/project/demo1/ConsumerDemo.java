package com.pxf.project.demo1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {

    public static void main(String[] args){
        Properties properties = new Properties();
        //设置kafka集群的地址
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        //设置消费者组，组名字自定义，组名字相同的消费者在一个组
        properties.put("group.id", "group-1");
        //开启offset自动提交
        properties.put("enable.auto.commit", "true");
        //自动提交时间间隔
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        //序列化器
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //实例化一个消费者
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        //消费者订阅主题，可以订阅多个主题
        kafkaConsumer.subscribe(Arrays.asList("HelloWorld"));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, value = %s", record.offset(), record.value());
                System.out.println();
            }
        }

    }

}
