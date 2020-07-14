package org.jiage.srpc.server.string;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class StringContainTest {

    @Test
    public void test(){
        String[] strs = {"+966","+99"};
        String str = "+99";
        System.out.println(isContain(strs,str));

    }

    public static boolean isContain(String[] strs, String str){
        if(strs == null || strs.length == 0 || str == null || str.length() == 0)
            return false;
        for(String s : strs)
            if(s.equals(str))
                return true;
        return false;
    }
}
