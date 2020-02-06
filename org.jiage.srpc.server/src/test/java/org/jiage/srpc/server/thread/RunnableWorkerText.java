package org.jiage.srpc.server.thread;

public class RunnableWorkerText implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("test");
        }
    }
}
