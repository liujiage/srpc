package org.jiage.srpc.api.message.vo;

import java.io.Serializable;

public class ResponseVO implements Serializable {

    private Object data;

    public ResponseVO(){

    }

    public ResponseVO(Object data){
       this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
