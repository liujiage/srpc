package org.jiage.srpc.server.mq.rabbit;

import java.io.Serializable;

public class MessageTest implements Serializable {

    private int uid;
    private int type;
    private int score;
    private String context;

    public MessageTest() {
    }

    public MessageTest(int uid, int type, int score, String context) {
        this.uid = uid;
        this.type = type;
        this.score = score;
        this.context = context;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
