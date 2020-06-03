package com.puhj.kafka.msgmgr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.puhj.kafka.entity.Audience;
import com.puhj.kafka.entity.Data;
import com.puhj.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class KafkaProducer {

    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private Gson gson = new GsonBuilder().create();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${apush.config.version}")
    private String version;
    @Value("${apush.config.ack-mode}")
    private String ackMode;
    @Value("${apush.config.sequence}")
    private String sequence;
    @Value("${apush.config.msg-type}")
    private String msgType;
    @Value("${apush.config.send-topic}")
    private String sendTopic;

    //发送消息方法
    public void send(String content, List<String> phoneList) {
        SimpleDateFormat dateForm24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Audience audience = new Audience(1, phoneList);
        Message message = new Message(content);
        Data data = new Data(version, ackMode, sequence, msgType, dateForm24.format(new Date()), audience, message);

        logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(data));
        kafkaTemplate.send(sendTopic, gson.toJson(data));
    }
}

