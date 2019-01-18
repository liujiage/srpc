package org.jiage.srpc.server.vo;

import org.jiage.srpc.server.constant.ProtocolConstant;

import java.io.Serializable;

public class ProtocolVO implements Serializable {

    private int bufferStart = ProtocolConstant.BUFFER_START;
    private int size;
    private byte[] message;

    public ProtocolVO(){

    }

    public ProtocolVO(byte[] message){
       this(message.length,message);
    }

    public ProtocolVO(int size, byte[] message) {
        this.size = size;
        this.message = message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    public int getBufferStart() {
        return bufferStart;
    }

    public void setBufferStart(int bufferStart) {
        this.bufferStart = bufferStart;
    }
}
