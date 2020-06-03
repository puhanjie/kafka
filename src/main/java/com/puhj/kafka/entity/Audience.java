package com.puhj.kafka.entity;

import java.util.List;

public class Audience {
    private int type;
    private List<String> targets;

    public Audience(int type, List<String> targets) {
        this.type = type;
        this.targets = targets;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "Audience{" +
                "type=" + type +
                ", targets=" + targets +
                '}';
    }
}
