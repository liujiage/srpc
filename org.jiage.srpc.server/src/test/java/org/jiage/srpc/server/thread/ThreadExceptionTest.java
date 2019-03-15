package org.jiage.srpc.server.thread;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

@Ignore
public class ThreadExceptionTest {

    //you can use handle
    @Test
    public void exceptionallyTest() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("error for test");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    //you can use handle
    @Test
    public void whenCompleteTest() {
        String result = CompletableFuture.supplyAsync(() -> {
            //first process
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 2) {
                throw new RuntimeException("error for test");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            //second process
            System.out.println("s: "+s);
            System.out.println("t: "+t);
        }).exceptionally(e -> {
            //if between first or second error process
            System.out.println("e:" +e);
            return "hello world";
        }).join();
        System.out.println(result);
    }

    //dual with error or success
    @Test
    public void handleTest() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 2) {
                throw new RuntimeException("error for test");
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }






}
