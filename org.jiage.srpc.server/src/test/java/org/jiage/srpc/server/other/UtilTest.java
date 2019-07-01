package org.jiage.srpc.server.other;

public class UtilTest {

    //get int from one object
    public int getInt(Object obj){
        try {
            return obj == null ? 0 : (Integer) obj;
        }catch(Exception e){
            /*Do noting*/
        }
        return 0;
    }

    public static void main(String args[]){
        Integer i=1;
        System.out.println(new UtilTest().getInt(1L));
    }
}
