package org.jiage.srpc.server.string;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class StringSplitTest {

    @Test
    public void split(){
        String s = "86511698";
        StringBuffer ss = new StringBuffer(s.length() *2);
        for(char c : s.toCharArray()){
            ss.append(",").append(c);
        }
        System.out.println(ss);
    }
}
