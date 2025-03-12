package com.example.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private final KafkaConfig kafkaConfig;

    public KafkaProducerConfig(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // Security configurations
        configProps.put("security.protocol", kafkaConfig.getSecurity().getProtocol()); // SASL_PLAINTEXT
        configProps.put(SaslConfigs.SASL_MECHANISM, kafkaConfig.getProperties().getSasl().getMechanism()); // SCRAM-SHA-512
        configProps.put(SaslConfigs.SASL_JAAS_CONFIG, kafkaConfig.getJaasConfig());

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
