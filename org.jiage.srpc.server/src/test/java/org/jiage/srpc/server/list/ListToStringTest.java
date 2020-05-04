package org.jiage.srpc.server.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToStringTest {

    private List<String> list =new ArrayList<>();

    @Test
    public void listToStr() throws Exception{

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        String newStr = list.stream().map(v-> v.toString()).collect(Collectors.joining(","));
        System.out.println(newStr);
    }


    public List<String> getList() {
         return this.list;
    }

    @Test
    public void test(){
        ListToStringTest t = new ListToStringTest();
        List l = t.getList();
        l.add("test");

        for(String s : t.getList()){
            System.out.println(s);
        }
    }







}
