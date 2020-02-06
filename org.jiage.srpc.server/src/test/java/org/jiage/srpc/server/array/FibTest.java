package org.jiage.srpc.server.array;

import org.junit.Test;

public class FibTest {

    @Test
    public void test2(){
        "str".toLowerCase();
        System.out.println("fib: "+fib(10));
    }

    public static int fib(int n){
        if(n <=1)
            return n;
        return fib(n-1) + fib(n-2);
    }
}
