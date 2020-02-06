package org.jiage.srpc.server.thread;

interface  RejectedExecutionHandlerExt {

    void rejectedExecution(Runnable r, ThreadPoolExecutorExt executor);

}
