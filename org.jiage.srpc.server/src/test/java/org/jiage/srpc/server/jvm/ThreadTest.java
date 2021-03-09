package org.jiage.srpc.server.jvm;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void test(){
        ThreadGroup tg = new ThreadGroup("test-mythread");
        for(int i=0; i<10 ;i++){
            Thread t = new Thread(tg,new MyThread());
            t.setDaemon(true);
            t.start();
        }
    }


}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("run test thread name is " +
                Thread.currentThread().getName() + " group name is "+
                Thread.currentThread().getThreadGroup().getName());
    }
}
