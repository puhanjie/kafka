package com.puhj.kafka.msgmgr;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Value("${apush.config.receive-topic}")
    private String receiveTopic;

    //监听消息
    @KafkaListener(topics = {"apush-msg-topic-tdh"})    //监听topic为apush-msg-topic-tdh的消息
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("接收记录 ----->>>>> record = " + record);
            logger.info("接收消息 ----->>>>> message = " + message);
        }
    }
}
