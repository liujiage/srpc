package org.jiage.srpc.server.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ThreadDepTest {

    public static void main(String args[]) throws Exception{
        ThreadMultipleTest process = new ThreadMultipleTest();
        List<Integer> userIds = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        Executor executor = ThreadMultipleTest.executor;
        CompletableFuture future1 =  CompletableFuture.supplyAsync(()->process.getFollowerCount(userIds),executor);
        CompletableFuture future2 =  CompletableFuture.supplyAsync(()->process.getFollowingCount(userIds),executor);
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(()->{
            String result = "result1";
            System.out.println("call c1 "+result);
            return "result1";
        });
        CompletableFuture<String> c2 = c1.thenComposeAsync(result->CompletableFuture.supplyAsync(()->{
            String return2 = result + " result2";
            System.out.println("call c2 "+return2);
            return return2;
        }));
        CompletableFuture all = CompletableFuture.allOf(future1,future2,c2);
        all.get();

    }
}
