package org.jiage.srpc.server.thread;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ThreadMultipleTest  {
    public final static Executor executor = Executors.newFixedThreadPool(Math.min(Runtime.getRuntime().availableProcessors(), 100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
            });

    public static void main(String args[]) throws Exception{
        ThreadMultipleTest test = new ThreadMultipleTest();
        //test.updateUserStatsAsynchronous(new ArrayList<String>(Arrays.asList("1","2","3","4")),1);
        //test.updateUserStats(new ArrayList<String>(Arrays.asList("1","2","3","4")),1);
        CompletableFuture future1 =  CompletableFuture.supplyAsync(()-> new ThreadMultipleTest().
                getErrorTest(new ArrayList<Integer>(Arrays.asList(1,2,3,4))),executor);
        System.out.println((Integer)future1.get());

    }

    public void updateUserStats(List<String> users, int requesterId) throws Exception {
        if(users == null || users.size() == 0) return ;
        final List<Integer> userIds = users.stream().map(Integer::getInteger).collect(Collectors.toList());
        ThreadMultipleTest process = new ThreadMultipleTest();
        long processTimes = System.currentTimeMillis();
        System.out.println("start process tasks thread id: "+Thread.currentThread().getId());
        process.getFollowerCount(userIds);
        process.getFollowingCount(userIds);
        process.getFriendCount(userIds);
        process.getFollowingIdsJustForAll(requesterId);
        process.getListHostGuardianStatusWithProfileV2(userIds);
        process.getAllPrivilegeDetails(userIds);
        process.getProfile(userIds);
        process.getReplayCounts(userIds);
        System.out.println("all processes tasks finished thread id: "+Thread.currentThread().getId());
        System.out.println("Spend all processes times: "+(System.currentTimeMillis() - processTimes));
    }

    public void updateUserStatsAsynchronous(List<String> users, int requesterId) throws Exception {
        if(users == null || users.size() == 0) return ;
        final List<Integer> userIds = users.stream().map(Integer::getInteger).collect(Collectors.toList());
        ThreadMultipleTest process = new ThreadMultipleTest();
        long processTimes = System.currentTimeMillis();
        System.out.println("start process tasks thread id: "+Thread.currentThread().getId());
        CompletableFuture future1 =  CompletableFuture.supplyAsync(()->process.getFollowerCount(userIds),executor);
        CompletableFuture future2 =  CompletableFuture.supplyAsync(()->process.getFollowingCount(userIds),executor);
        CompletableFuture future3 =  CompletableFuture.supplyAsync(()->process.getFriendCount(userIds),executor);
        CompletableFuture future4 =  CompletableFuture.supplyAsync(()->process.getFollowingIdsJustForAll(requesterId),executor);
        CompletableFuture future5 =  CompletableFuture.supplyAsync(()->process.getListHostGuardianStatusWithProfileV2(userIds),executor);
        CompletableFuture future6 =  CompletableFuture.supplyAsync(()->process.getAllPrivilegeDetails(userIds),executor);
        CompletableFuture future7 =  CompletableFuture.supplyAsync(()->process.getProfile(userIds),executor);
        CompletableFuture future8 =  CompletableFuture.supplyAsync(()->process.getReplayCounts(userIds),executor);
        CompletableFuture futrues= CompletableFuture.allOf(future1,future2,future3,future4,future5,future6,future7,future8);
        futrues.get();
        System.out.println(future1.get());
        System.out.println("all processes tasks finished thread id: "+Thread.currentThread().getId());
        System.out.println("Spend all processes times: "+(System.currentTimeMillis() - processTimes));
    }


    public Integer getErrorTest(List<Integer> ids) {
        System.out.println("getErrorTest thread id: "+Thread.currentThread().getId());
        return null;
    }

    public Map<Integer, Integer> getFollowerCount(List<Integer> ids) {
        Map res = new HashMap<>();
        res.put(1,1);
        ThreadSleep(1000);
        System.out.println("getFollowerCount thread id: "+Thread.currentThread().getId());
        return res;
    }

    public Map<Integer, Integer> getFollowingCount(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,1);
        ThreadSleep(1000);
        System.out.println("getFollowingCount thread id: "+Thread.currentThread().getId());
        return res;
    }

    public Map<Integer, Integer> getFriendCount(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,1);
        System.out.println("getFriendCount");
        return res;
    }

    public List<Integer> getFollowingIdsJustForAll(Integer id){
        List res = new ArrayList(Arrays.asList(1,2,3,4));
        System.out.println("getFollowingIdsJustForAll");
        return res;
    }

    public Map<Integer, String> getListHostGuardianStatusWithProfileV2(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,"1");
        System.out.println("getListHostGuardianStatusWithProfileV2");
        return res;
    }

    public Map<Integer, String> getAllPrivilegeDetails(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,"1");
        System.out.println("getAllPrivilegeDetails");
        return res;
    }

    public Map<Integer, String> getProfile(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,"1");
        System.out.println("getProfile");
        return res;
    }

    public Map<Integer, Integer> getReplayCounts(List<Integer> ids){
        Map res = new HashMap<>();
        res.put(1,1);
        System.out.println("getReplayCounts");
        return res;
    }

    public static void ThreadSleep(final long millis){
        try {
            Thread.currentThread().sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
