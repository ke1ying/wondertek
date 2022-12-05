package com.miu.web.kfka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author keying
 * @date 2022-08-03 10:30:09
 */
public class AuditPartitioner implements Partitioner {

    private Random random;

    @Override
    public int partition(String topic, Object keyObj, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String key = (String) keyObj;
        List<PartitionInfo> partitionInfoList = cluster.availablePartitionsForTopic(topic);
        int auditPartition = partitionInfoList.size() - 1;
        return key == null || key.isEmpty() ||
                !key.contains("audit") ? random.nextInt(partitionInfoList.size() - 1) : auditPartition;
        //return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {
        random = new Random();
    }
}