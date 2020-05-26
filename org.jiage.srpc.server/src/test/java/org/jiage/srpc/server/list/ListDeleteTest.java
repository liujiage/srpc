package org.jiage.srpc.server.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeleteTest {


    @Test
    public void delete(){
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        list.remove(0);

        list.stream().forEach(v->System.out.println(v));
    }
}
