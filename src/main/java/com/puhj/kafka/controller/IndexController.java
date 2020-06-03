package com.puhj.kafka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("indexController")
public class IndexController {

    @GetMapping("/")
    public String forwardIndex() {
        return "apush";
    }
}
