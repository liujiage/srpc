package org.jiage.srpc.server;

import org.junit.Test;

public class interview {


    @Test
    public void test() {
        System.out.println(gcd(3,9));
    }

    /**
     * gcd
     * 6,9 = 3
     */
    public static int gcd(int x, int y) {
        int min = x > y ? y : x;
        int res = 0;
        for (int i = min; i>= 1; i--)
            if (x % i == 0 && y % i == 0){
                 res = i;
                 break;
            }
        return res;
    }

}
