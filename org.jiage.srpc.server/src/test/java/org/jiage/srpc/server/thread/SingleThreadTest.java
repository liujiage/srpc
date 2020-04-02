package org.jiage.srpc.server.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadTest {


    public void Test(){
        ExecutorService service = Executors.newSingleThreadExecutor();
    }
}
