package org.jiage.srpc.server.string;

import org.junit.Test;

public class StringIndexTest {
    @Test
    public void test2(){
       System.out.print(strIndex("afdedfdddff","ddd"));
    }
    public static int strIndex(String str,String s){
        return str.indexOf(s);
    }


    @Test
    public void test3(){
        String key = "3.3.180107";
        String version = "4.3.180107";
        System.out.println(versionCheck(key,version));
        System.out.println(key.compareTo(version) <=0);
    }


    //add web
    private boolean versionCheck( String startVersion, String compareVersion) {
        //add web version check
        if ( compareVersion == null) {
            return false;
        }

        if (startVersion.compareTo(compareVersion) <= 0) {
            return false;
        }

        return true;
    }
}
