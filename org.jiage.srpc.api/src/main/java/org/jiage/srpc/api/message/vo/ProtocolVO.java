package org.jiage.srpc.api.message.vo;

import org.jiage.srpc.api.message.constant.MsgFormatConst;
import org.jiage.srpc.api.message.constant.ProtocolConst;
import java.io.Serializable;

public class ProtocolVO implements Serializable {

    private int bufferStart = ProtocolConst.BUFFER_START;
    private int size;
    private int format= MsgFormatConst.STRING.getValue();
    private byte[] message;

    public ProtocolVO(){

    }

    public ProtocolVO(byte[] message){
       this(message.length,message);
    }

    public ProtocolVO(int size, byte[] message) {
       this(size, MsgFormatConst.STRING.getValue(),message);
    }

    public ProtocolVO(int size,int format, byte[] message) {
        this.size = size;
        this.format = format;
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

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }
}
