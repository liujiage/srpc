package org.jiage.srpc.server.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {


    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(new A());
        list.add(new B());
        System.out.println(list);
        // 1 level deep copy
        ArrayList list2 = new ArrayList(list); //(ArrayList)list.clone();
        System.out.println(list == list2);
        System.out.println(list.get(0) == list2.get(0));
    }

}

class A {

}
class B {

}