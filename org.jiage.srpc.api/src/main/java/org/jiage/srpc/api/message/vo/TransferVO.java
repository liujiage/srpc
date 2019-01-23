package org.jiage.srpc.api.message.vo;

import java.io.Serializable;

public class TransferVO implements Serializable {

    private ProtocolVO protocol;
    private String host;
    private int port;

    public TransferVO(){

    }

    public TransferVO(String host){
        this(host,0,null);
    }

    public TransferVO(int port){
        this(null,port,null);
    }

    public TransferVO(String host,int port){
        this(host,port,null);
    }

    public TransferVO(String host, int port, ProtocolVO protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
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

    public ProtocolVO getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolVO protocol) {
        this.protocol = protocol;
    }
}
