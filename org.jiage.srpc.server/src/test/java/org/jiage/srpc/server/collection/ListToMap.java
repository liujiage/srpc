package org.jiage.srpc.server.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Ignore
public class ListToMap {


    @Test
    public void toChange(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,null,5));
        Map<Integer,Integer> map = list.stream().filter(v->v !=null).
                collect(java.util.stream.Collectors.toMap
                        (Integer::intValue,Integer::intValue));
        System.out.println(map);
    }
}
