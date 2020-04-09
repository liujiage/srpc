package org.jiage.srpc.server.other;

import org.junit.Test;

import java.math.BigDecimal;

public class UtilDataTest {


    @Test
    public void getData(){

        double percentage = BigDecimal.valueOf(5).divide(BigDecimal.valueOf(100)).doubleValue();
        System.out.println(percentage);
        int coins  =  (int) Math.ceil(88888 * (1 - percentage));
        System.out.println(coins);

    }
}
