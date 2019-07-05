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

    @Test
    public void orderBy(){
        List<Value> list = new ArrayList<>();
        list.add(new Value(10,10));
        list.add(new Value(9,9));
        list.add(new Value(8,8));
        list.stream().forEach(v->System.out.println(v.id+" "+v.start));
    }

    @Test
    public void listSub(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,5,6,7,8,9));
        list.subList(5,2);
    }

}

class UserValue{

    public UserValue( ){
    }

    Value value;

    public UserValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

class Value{
    public Value(int id, long start) {
        this.id = id;
        this.start = start;
    }

    int id;
    long start;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }
}