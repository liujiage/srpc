package org.jiage.srpc.server.stack;

import org.junit.Test;

public class RecursiveTest {


    @Test
    public void test1() throws Exception{
        //RecursiveTest.recursion_display(3);
        long result = RecursiveTest.factorial(3);
        System.out.println("result: "+result);
        RecursiveTest.recursion_display(3);
    }

    public static void recursion_display(int n) {
        int temp=n;
        System.out.println("in stack:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("out stack:" + temp);
    }

    public static long factorial(int n) throws Exception{
        System.out.println("in stack: "+n);
        if (n < 0)
            throw new Exception("error!");
        else if (n == 1 || n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
