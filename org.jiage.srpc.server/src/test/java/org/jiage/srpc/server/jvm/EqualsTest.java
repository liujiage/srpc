package org.jiage.srpc.server.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EqualsTest {

    /*
       All Object extends java.lang.Object and automatically in JVM
     */
    @Test
    public void test(){
        Personal a = new Personal(1,"name");
        Personal b = new Personal(1,"name");
        System.out.println("Object a == b "+(a == b));
        System.out.println("Object Override equals "+ a.equals(b));
        System.out.println("Object equals "+ a.equalsSuper(b));
        System.out.println("Object hashCode "+ a.hashCode() + " " + b.hashCode());
        List list = new ArrayList();
        list.add(a);
        System.out.println(list.contains(a));
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(1);
        Integer a3 = 1;
        Integer a4 = 1;
        System.out.println("new Integer a1 == a2 " + (a1 == a2));
        System.out.println("int a1 == a2 " + (a3 == a4));
        System.out.println("Integer equals: "+ a1.equals(a2));
        System.out.println("Integer hashCode: "+ a1.hashCode() + " " + a2.hashCode());
        String s1 = new String("sss");
        String s2 = new String("sss");
        System.out.println("String a == b "+(s1 == s2));
        System.out.println("String equals: "+ s1.equals(s2));
        System.out.println("String "+ ("sss" == "sss"));
    }
}

class Personal{
    int id = 1;
    String name = "name";

    Personal(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof  Personal){
            Personal p = (Personal)obj;
            if(p.id != this.id) return false;
            if(p.name != p.name) return false;
            return true;
        }
        return false;
    }

    public boolean equalsSuper(Object obj){
        return super.equals(obj);
    }
}