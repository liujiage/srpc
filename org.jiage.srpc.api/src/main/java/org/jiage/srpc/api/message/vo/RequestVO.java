package org.jiage.srpc.api.message.vo;

import java.io.Serializable;

public class RequestVO implements Serializable {

    public RequestVO(String data) {
        this.data = data;
    }

    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
