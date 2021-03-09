package org.jiage.srpc.server.generics;

import org.junit.Test;

public class PairTest {

    @Test
    public void test() {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        System.out.println("first " + pair.getFirst() + " second " + pair.getSecond());
        Pair<String, Integer> pair2 = new Pair<>("name", 2);
        System.out.println("first " + pair2.getFirst() + " second " + pair2.getSecond());
    }
}

class Pair<A, B> {
    A first;
    B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

}



