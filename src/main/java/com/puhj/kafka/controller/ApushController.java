package com.puhj.kafka.controller;

import com.puhj.kafka.msgmgr.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller("apushController")
public class ApushController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/apush")
    public String push(String content, String phoneList) {
        kafkaProducer.send(content, Arrays.asList(phoneList.split(",")));
        return "apush";
    }
}
