package com.pxf.project.demo1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {
    
    public static void main(String[] args) {
        Properties properties = new Properties();
        //设置kafka集群的地址
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        //ack模式，all是最慢但最安全的
        properties.put("acks", "-1"); //all
        //失败重试次数
        properties.put("retries", 0);
        //每个分区未发送消息总字节大小（单位：字节），超过设置的值就会提交数据到服务端
        properties.put("batch.size", 100);
        //消息在缓冲区保留的时间，超过设置的值就会被提交到服务端
        properties.put("linger.ms", 10000);
        //整个Producer用到总内存的大小，如果缓冲区满了会提交数据到服务端
        //buffer.memory要大于batch.size，否则会报申请内存不足的错误
        properties.put("buffer.memory", 10240);
        //序列化器
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 100; i++) {
                String msg = "Message " + i;
                producer.send(new ProducerRecord<String, String>("HelloWorld", msg));
                System.out.println("Sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }

    }
}
