package com.puhj.kafka.entity;

public class Message {

    private String content;

    public Message(String message) {
        this.content = message;
    }

    public String getMessage() {
        return content;
    }

    public void setMessage(String message) {
        this.content = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }

}
