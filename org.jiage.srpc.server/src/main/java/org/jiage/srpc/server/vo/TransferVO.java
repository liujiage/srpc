package org.jiage.srpc.server.vo;

import java.io.Serializable;

public class TransferVO implements Serializable {

    private String host;
    private int port;

    public TransferVO(){

    }

    public TransferVO(String host){
        this(host,0);
    }

    public TransferVO(int port){
        this(null,port);
    }

    public TransferVO(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
