package org.jiage.srpc.server.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {
    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private static Map userSet = new ConcurrentHashMap<Integer,Integer>();
    public static void main(String[] args) throws Exception{
        userSet.put(1,1);
        userSet.put(2,2);
        /*service.schedule(new Thread() {
            @Override
            public void run() {
                System.out.println("push current userIds: "+new ArrayList<Integer>(userSet.keySet()));
            }
            ;
        }, 1, TimeUnit.SECONDS);*/
        service.scheduleAtFixedRate(new Thread() {
            @Override
            public void run() {
                if(userSet == null || userSet.size() ==0) return;
                List userIds = new ArrayList<Integer>(userSet.keySet());
                System.out.println("push current userIds: "+userIds);
                userIds.stream().forEach(id->{
                    userSet.remove(id);
                });
            }
            ;
        }, 0,5, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Thread() {
            @Override
            public void run() {
                userSet.put(1,1);
            }
            ;
        }, 0,5, TimeUnit.SECONDS);
        //userSet.put(3,3);
        Thread.currentThread().join();
    }
}
