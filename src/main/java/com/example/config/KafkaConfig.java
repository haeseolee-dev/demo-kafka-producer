package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "dev.kafka")
@Component
public class KafkaConfig {

    private String bootstrapServers;
    private String jaasUser;
    private String jaasPassword;
    private Topics topics;
    private String autoOffsetReset;
    private String maxPollRecords;
    private String consumersCount;
    private String groupId;
    private String seekTo;
    private Security security;
    private ProducerProperties properties;

    public String getJaasConfig() {
        return String.format(
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";",
                this.getJaasUser(), this.getJaasPassword()
        );
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }
    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }
    public void setJaasUser(String jaasUser) {
        this.jaasUser = jaasUser;
    }
    public void setJaasPassword(String jaasPassword) {
        this.jaasPassword = jaasPassword;
    }
    public void setTopics(Topics topics) {
        this.topics = topics;
    }
    public void setSeekTo(String seekTo) {
        this.seekTo = seekTo;
    }
    public void setSecurity(Security security) {
        this.security = security;
    }
    public void setProperties(ProducerProperties properties) {
        this.properties = properties;
    }
    public void setMaxPollRecords(String maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }
    public void setConsumersCount(String consumersCount) {
        this.consumersCount = consumersCount;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getBootstrapServers() { return bootstrapServers; }
    public String getJaasUser() { return jaasUser; }
    public String getJaasPassword() { return jaasPassword; }
    public Topics getTopics() { return topics; }
    public String getSeekTo() { return seekTo; }
    public Security getSecurity() { return security; }
    public ProducerProperties getProperties() { return properties; }
    public String getMaxPollRecords() { return maxPollRecords; }
    public String getConsumersCount() { return consumersCount; }
    public String getGroupId() { return groupId; }
    public String getAutoOffsetReset() { return autoOffsetReset; }

    public static class Topics {
        private String if5;

        public String getIf5() { return if5; }
        public void setIf5(String if5) { this.if5 = if5; }
    }

    public static class Security {
        private String protocol;

        public String getProtocol() { return protocol; }
        public void setProtocol(String protocol) { this.protocol = protocol; }
    }

    public static class ProducerProperties {
        private Sasl sasl;

        public Sasl getSasl() { return sasl; }
        public void setSasl(Sasl sasl) { this.sasl = sasl; }
    }

    public static class Sasl {
        private String mechanism;
        private String jaasConfig;

        public String getMechanism() { return mechanism; }
        public void setMechanism(String mechanism) { this.mechanism = mechanism; }

        public String getJaasConfig() { return jaasConfig; }
        public void setJaasConfig(String jaasConfig) { this.jaasConfig = jaasConfig; }
    }
}
