package com.puhj.kafka.msgmgr;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.puhj.kafka.entity.Audience;
import com.puhj.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //从application.properties配置文件中注入自定义属性
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
        Audience audience = new Audience(1, phoneList); //接收方信息对象
        Message message = new Message(content); //消息内容
        //添加kafka接口参数
        Map<String, Object> param = new LinkedHashMap<>();
        param.put("version", version);
        param.put("ack_mode", ackMode);
        param.put("sequence", sequence);
        param.put("msg_type", msgType);
        param.put("create_time", dateForm24.format(new Date()));
        param.put("audience", audience);
        param.put("message", message);
        String jsonStr = JSON.toJSONString(param);

        logger.info("发送消息 ----->>>>> message = {}", jsonStr);
        kafkaTemplate.send(sendTopic, jsonStr);  //发送消息到kafka
    }
}

