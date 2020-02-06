package org.jiage.srpc.server.thread;

public class DaemonThreadTest {


    public static void main(String args[]) throws Exception{
        Thread t = new Thread(()->{
            while(true){
                System.out.println(Thread.currentThread().getId()+ "action.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getId()+"exit");
    }
}
