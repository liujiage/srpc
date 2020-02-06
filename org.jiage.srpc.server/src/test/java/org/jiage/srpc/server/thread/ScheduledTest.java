package org.jiage.srpc.server.thread;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    //private static ScheduledExecutorService service = new ScheduledThreadPoolExecutorExt(2, 2);

    private static Map userSet = new ConcurrentHashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {
        userSet.put(1, 1);
        for (int i = 0; i < 10; i++)
            service.scheduleAtFixedRate(new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(this.getId());
                        userSet.put(1, 1);
                        Thread.currentThread().sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 5, TimeUnit.SECONDS);
        //userSet.put(3,3);
        Thread.currentThread().join();
    }
}
