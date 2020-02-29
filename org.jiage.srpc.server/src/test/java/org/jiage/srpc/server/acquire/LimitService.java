package org.jiage.srpc.server.acquire;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class LimitService {

    private int limtCount = 100;// 限制最大访问的容量
    AtomicInteger atomicInteger = new AtomicInteger(0); // 每秒钟 实际请求的数量
    private long start = System.currentTimeMillis();// 获取当前系统时间
    private int interval = 10;// 间隔时间60秒

    public boolean acquire() {
        long newTime = System.currentTimeMillis();
        if (newTime > (start + interval)) {
            // 判断是否是一个周期
            start = newTime;
            atomicInteger.set(0); // 清理为0
            return true;
        }
        atomicInteger.incrementAndGet();// i++;
        return atomicInteger.get() <= limtCount;
    }

    static LimitService limitService = new LimitService();

    public static void main(String[] args) {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i < 10000; i++) {
            final int tempI = i;
            newCachedThreadPool.execute(new Runnable() {

                public void run() {
                    if (limitService.acquire()) {
                        System.out.println("你没有被限流,可以正常访问逻辑 i:" + tempI);
                    } else {
                        System.out.println("你已经被限流呢  i:" + tempI);
                    }
                }
            });
        }
    }

}
