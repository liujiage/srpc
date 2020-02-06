package org.jiage.srpc.server.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadTest2 {



    public static void main(String args[]){
        ExecutorService executorService = new ThreadPoolExecutor(20,20,0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5000),new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r){
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                String prefix = "thread-face-";
                thread.setName(prefix.concat(String.valueOf(System.currentTimeMillis())));
                return thread;
            }
        });
        IntStream.range(0, 20).parallel().forEach(
                t -> {
                    RunnableWorkerText worker = new RunnableWorkerText();
                    executorService.execute(worker);
                }
        );
        executorService.shutdown();
    }


}
