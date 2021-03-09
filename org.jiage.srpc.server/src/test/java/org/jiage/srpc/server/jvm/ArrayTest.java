package org.jiage.srpc.server.jvm;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    public void test() {
        String[] s = new String[]{"a", "b", "c"};
        Integer[] i = new Integer[]{1, 2, 3};
        System.out.println(s.length);
        System.out.println(Array.getLength(s));
        Arrays.stream(s).forEach(v->{System.out.print(v);});
        Array.set(s,2,"d");
        System.out.println();
        System.out.println(s.length);
        Arrays.stream(s).forEach(v->{System.out.print(v);});
        s[0] = "r";
        System.out.println();
        Arrays.stream(s).forEach(v->{System.out.print(v);});
    }


}
