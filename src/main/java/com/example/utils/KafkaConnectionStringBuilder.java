package com.example.utils;

import com.example.config.KafkaConfig;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class KafkaConnectionStringBuilder {

    /**
     * Builds the Kafka connection string dynamically.
     * @param kafkaConfig - Kafka configuration properties.
     * @param topicName - Kafka topic name.
     * @return - Formatted Kafka connection string.
     */
    public static String buildKafkaConnection(KafkaConfig kafkaConfig, String topicName) {
        try {
            StringBuilder kafka = new StringBuilder();
            kafka.append("kafka:").append(topicName);
            kafka.append("?brokers=").append(kafkaConfig.getBootstrapServers());
            kafka.append("&maxPollRecords=").append(kafkaConfig.getMaxPollRecords());
            kafka.append("&consumersCount=").append(kafkaConfig.getConsumersCount());
            kafka.append("&seekTo=").append(kafkaConfig.getSeekTo());
            kafka.append("&groupId=").append(kafkaConfig.getGroupId());
            kafka.append("&autoOffsetReset=").append(kafkaConfig.getAutoOffsetReset());
            kafka.append("&securityProtocol=").append(kafkaConfig.getSecurity().getProtocol());
            kafka.append("&saslMechanism=").append(kafkaConfig.getProperties().getSasl().getMechanism());

            // Encode JAAS Config for safe URL transmission
            String jaasConfigEncoded = URLEncoder.encode(kafkaConfig.getJaasConfig(), StandardCharsets.UTF_8);
            kafka.append("&saslJaasConfig=").append(jaasConfigEncoded);

            return kafka.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error building Kafka connection string", e);
        }
    }
}
