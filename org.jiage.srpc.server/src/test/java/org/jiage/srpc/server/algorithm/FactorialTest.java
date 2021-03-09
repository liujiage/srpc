package org.jiage.srpc.server.algorithm;

import org.junit.Test;

public class FactorialTest {

    @Test
    public void test(){
        System.out.println(factorial(4));
        System.out.println(factorial2(4));
    }
    /**
     *  Calculate n!
        1) n=3 * (n-1)
              2) n=2 * (n-1)
                   3) n=1 * (n-1)
                        4)n=0 return 1
                   3) n=1 * 1
              2) n=2 * 1
        1) n=3 * 2
    **/
    public static int factorial(int n){
        return (n <= 0) ?  1 : n * factorial(n - 1);
    }
    public static int factorial2(int n){
        int  s = 1;
        for(int i = 1; i<=n; i++)
            s = s * i;
        return s;
    }
}
