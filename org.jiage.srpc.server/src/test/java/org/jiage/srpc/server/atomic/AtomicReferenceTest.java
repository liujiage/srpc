package org.jiage.srpc.server.atomic;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

@Ignore
public class AtomicReferenceTest {

    private static final AtomicReference<AtomicReferenceTest> INSTANCE = new AtomicReference<AtomicReferenceTest>();

    public AtomicReferenceTest() {
    }

    @Test
    public void singletonTest() throws Exception{
        for (int i = 0; i < 10; i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getId() + "-" + AtomicReferenceTest.getInstance());
            }).start();
        Thread.currentThread().join(1000);
    }

    public static AtomicReferenceTest getInstance() {
        for (; ; ) {
            AtomicReferenceTest singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new AtomicReferenceTest();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

}
