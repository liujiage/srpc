package org.jiage.srpc.server.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

public class TimestampTest {

    @Test
    public void testSqlTime() throws Exception{
        Timestamp s = new Timestamp(System.currentTimeMillis());
        System.out.println(s.getTime());
        Thread.sleep(1000);
        Timestamp s2 = new Timestamp(System.currentTimeMillis());
        System.out.println(s2.getTime());
        System.out.println(s2.getTime() > s.getTime());
        System.out.println("before: "+s.before(s) + " after: "+s2.after(s) );
    }


    @Test
    public void test(){
        Calendar c1 = Calendar.getInstance();
        int hour = c1.get(Calendar.HOUR);
        int hour2 = c1.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        System.out.println(hour2);
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("GMT")).get(Calendar.HOUR_OF_DAY));
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00")).get(Calendar.HOUR_OF_DAY));
        System.out.println(accessLimit());
    }

    private static boolean accessLimit(){
        int start = 14;
        int end = 16;
        int current = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00")).get(Calendar.HOUR_OF_DAY);
        return (current >= start && current <= end);
    }
}
