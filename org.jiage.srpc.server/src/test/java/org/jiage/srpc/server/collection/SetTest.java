package org.jiage.srpc.server.collection;


import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Ignore
public class SetTest {


    @Test
    public void getSubSet(){
        Set<String> set = new HashSet<>();
        set.add("1111");
        set.add("2222");
        set.add("3333");
        if(set.size() > 2){
            set = set.stream().limit(2).collect(Collectors.toSet());
        }
        for(String s : set){
            System.out.println(s);
        }
    }

}
