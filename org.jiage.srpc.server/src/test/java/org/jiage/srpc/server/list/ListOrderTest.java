package org.jiage.srpc.server.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListOrderTest {



    @Test
    public void testOrder(){
        List<TestOrder> list = new ArrayList<>();
        list.add(new TestOrder(11111111L,1113,1));
        list.add(new TestOrder(11111112L,1113,2));
        list.add(new TestOrder(11111113L,1113,3));
        list  = list.stream().sorted(Comparator.comparingInt(TestOrder::getNumbers).reversed().
                thenComparingLong(TestOrder::getCreateTime)).collect(Collectors.toList());
        list.stream().forEach(TestOrder::print);
    }

    @Test
    public void testCopy(){
        List<TestOrder> list = new ArrayList<>();
        list.add(new TestOrder(11111111L,1113,1));
        list.add(new TestOrder(11111112L,1113,2));
        list.add(new TestOrder(11111113L,1113,3));
        list = this.settingValue(list);
        list.stream().forEach(TestOrder::print);
        System.out.println(list.toString());

    }

    public List<TestOrder> settingValue(List<TestOrder> list){
        list.get(0).setNumbers(9999);
        list = list.stream().filter(v->v.getId()==0).collect(Collectors.toList());
        System.out.println(list.toString());
        return list;
    }


    @Test
    public void testListCopy(){
        List<TestOrder> list = new ArrayList<>();
        list.add(new TestOrder(11111111L,1113,1));
        list.add(new TestOrder(11111112L,1113,2));
        list.add(new TestOrder(11111113L,1113,3));
        TestList t = new TestList(list);
        settingListValue(t);
        System.out.println(t.getList());
        System.out.println(list);
    }

    public void settingListValue(TestList testList){
        testList.setList(new ArrayList<>());
    }


}
class TestList{
    private  List<TestOrder> list;

    public TestList(List<TestOrder> list) {
        this.list = list;
    }

    public List<TestOrder> getList() {
        return list;
    }

    public void setList(List<TestOrder> list) {
        this.list = list;
    }
}
class TestOrder{

    public void print(){
        System.out.println(id+"-"+createTime+"-"+numbers);
    }

    public TestOrder(long createTime, int numbers, int id) {
        this.createTime = createTime;
        this.numbers = numbers;
        this.id = id;
    }

    private long createTime;
    private int numbers;
    private int id;


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
