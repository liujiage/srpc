package org.jiage.srpc.server.type;

import org.junit.Test;

public class TypeTest {

    public String v;


    @Test
    public void intTest(){
        long startTime = System.currentTimeMillis();
        int i =  (int)(startTime/1000);
        System.out.println("change after "+i+ " change before "+startTime);
    }

    @Test
    public void  removeStr(){
        String s = "001133003310";
        s = s.replaceFirst("^0*","");
        System.out.println(s);
        TypeTest t = new TypeTest();
        process(t );
        System.out.println(t.v);
    }

    @Test
    public void doubleTest(){
        double v =   Double.parseDouble("1.5");
        int exp = 100;
        System.out.println((int)(v * exp));
    }

    public static void process(TypeTest s){
        s.v = "22222";
    }

}


