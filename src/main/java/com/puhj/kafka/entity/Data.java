package com.puhj.kafka.entity;

public class Data {

    private String version;
    private String ack_mode;
    private String sequence;
    private String msg_type;
    private String create_time;
    private Audience audience;
    private Message message;

    public Data(String version, String ack_mode, String sequence, String msg_type, String create_time, Audience audience, Message message) {
        this.version = version;
        this.ack_mode = ack_mode;
        this.sequence = sequence;
        this.msg_type = msg_type;
        this.create_time = create_time;
        this.audience = audience;
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAckMode() {
        return ack_mode;
    }

    public void setAckMode(String ack_mode) {
        this.ack_mode = ack_mode;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getMsgType() {
        return msg_type;
    }

    public void setMsgType(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getCreateTime() {
        return create_time;
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Data{" +
                "version='" + version + '\'' +
                ", ack_mode='" + ack_mode + '\'' +
                ", sequence='" + sequence + '\'' +
                ", msg_type='" + msg_type + '\'' +
                ", create_time=" + create_time +
                ", audience=" + audience +
                ", message=" + message +
                '}';
    }

}
