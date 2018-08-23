package com.pxf.project.demo3;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class KafkaConsumerOps {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream in = KafkaConsumerOps.class.getClassLoader().getResourceAsStream("consumer.properties");
        properties.load(in);
        Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        Collection<String> topics = Arrays.asList("hadoop");
        // 消费者订阅topic
        consumer.subscribe(topics);
        ConsumerRecords<String, String> consumerRecords = null;
        while (true) {
            // 接下来就要从topic中拉取数据
            consumerRecords = consumer.poll(1000);
            // 遍历每一条记录
            for (ConsumerRecord consumerRecord : consumerRecords) {
                long offset = consumerRecord.offset();
                int partition = consumerRecord.partition();
                Object key = consumerRecord.key();
                Object value = consumerRecord.value();
                System.out.format("%d\t%d\t%s\t%s\n", offset, partition, key, value);
            }

        }
    }

}
