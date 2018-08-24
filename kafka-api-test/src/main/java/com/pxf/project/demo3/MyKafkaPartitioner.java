package com.pxf.project.demo3;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建自定义的分区，根据数据的key来进行划分
 * <p>
 * 可以根据key或者value的hashCode
 * 还可以根据自己业务上的定义将数据分散在不同的分区中
 * 需求：
 * 根据用户输入的key的hashCode值和partition个数求模
 */
public class MyKafkaPartitioner implements Partitioner {

    /**
        topic:主题
        key:动态绑定的，传的什么类型就是什么类型
        keyBytes:Ascii码数组
        value:动态绑定的，传的什么类型就是什么类型
        valueBytes:Ascii码数组
        cluster:kafka集群
    */
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        //拿到所有分区
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        //分区数量
        int numPartitions = partitions.size();
        //如果key为空，则取消息作为分区依据
        if (keyBytes == null) {
            int nextValue = this.nextValue(topic);
            //可用分区，我在想应该是
            List<PartitionInfo> availablePartitions = cluster.availablePartitionsForTopic(topic);
            //可用分区数
            if (availablePartitions.size() > 0) {
                //计算分区索引
                int part = Utils.toPositive(nextValue) % availablePartitions.size();
                //返回分区
                return ((PartitionInfo)availablePartitions.get(part)).partition();
            } else {
                //如果可用分区=0，则直接返回所有分区中的一个
                return Utils.toPositive(nextValue) % numPartitions;
            }
        } else {
            //key有值，则返回所有分区中的一个
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }
    }

    private final ConcurrentMap<String, AtomicInteger> topicCounterMap = new ConcurrentHashMap();

    //如果没有key，则调用该方法那消息来做分区依据
    private int nextValue(String topic) {
        AtomicInteger counter = (AtomicInteger)this.topicCounterMap.get(topic);
        if (null == counter) {
            counter = new AtomicInteger(ThreadLocalRandom.current().nextInt());
            AtomicInteger currentCounter = (AtomicInteger)this.topicCounterMap.putIfAbsent(topic, counter);
            if (currentCounter != null) {
                counter = currentCounter;
            }
        }
        return counter.getAndIncrement();
    }

//    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
//        Integer partitionNums2 = cluster.partitionCountForTopic(topic);
//        int targetPartition = -1;
//        if (key == null || keyBytes == null) {
//            targetPartition = new Random().nextInt(10000) % partitionNums2;
//        } else {
//            int hashCode = key.hashCode();
//            targetPartition = hashCode % partitionNums2;
//            System.out.println("key: " + key + ", value: " + value + ", hashCode: " + hashCode + ", partition: " + targetPartition);
//        }
//        return targetPartition;
//    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
