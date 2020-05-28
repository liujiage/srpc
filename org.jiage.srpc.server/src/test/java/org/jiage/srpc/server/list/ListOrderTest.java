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
