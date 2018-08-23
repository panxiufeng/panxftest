package com.pxf.project.demo3;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.Random;

/**
 * 创建自定义的分区，根据数据的key来进行划分
 * <p>
 * 可以根据key或者value的hashCode
 * 还可以根据自己业务上的定义将数据分散在不同的分区中
 * 需求：
 * 根据用户输入的key的hashCode值和partition个数求模
 */
public class MyKafkaPartitioner implements Partitioner {


    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Integer partitionNums = cluster.partitionCountForTopic(topic);
        int targetPartition = -1;
        if (key == null || keyBytes == null) {
            targetPartition = new Random().nextInt(10000) % partitionNums;
        } else {
            int hashCode = key.hashCode();
            targetPartition = hashCode % partitionNums;
            System.out.println("key: " + key + ", value: " + value + ", hashCode: " + hashCode + ", partition: " + targetPartition);
        }
        return targetPartition;
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
