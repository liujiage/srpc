package org.jiage.srpc.server.date;

import org.junit.Test;

import java.sql.Timestamp;

public class TimestampTest {

    @Test
    public void testSqlTime() throws Exception{
        Timestamp s = new Timestamp(System.currentTimeMillis());
        System.out.println(s.getTime());
        Thread.sleep(1000);
        Timestamp s2 = new Timestamp(System.currentTimeMillis());
        System.out.println(s2.getTime());
        System.out.println(s2.getTime() > s.getTime());
    }
}
