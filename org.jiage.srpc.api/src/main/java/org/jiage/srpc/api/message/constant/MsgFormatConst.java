package org.jiage.srpc.api.message.constant;

public enum MsgFormatConst {
    STRING("string",1),JSON_JACKSON("json_jackson",2),MESSAGE_PACK("message_pack",2);
    public static final int STRING_VALUE = 1;
    public static final int JSON_JACKSON_VALUE = 2;
    public static final int MESSAGE_PACK_VALUE = 3;

    private String name;
    private int value;

    private MsgFormatConst(String name, int value){
       this.name = name;
       this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }

}
