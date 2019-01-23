package org.jiage.srpc.server.constant;

import org.jiage.srpc.api.message.constant.MsgFormatConst;
import org.junit.Test;

public class ParseEnumTest {


    @Test
    public void parseTest(){
        System.out.println(MsgFormatConst.STRING.getName());
        System.out.println(MsgFormatConst.STRING.getValue());
    }

}
