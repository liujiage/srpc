package org.jiage.srpc.server.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PriorityQuequeTest {


    public int flag = 0;

    @Test
    public void test2(){
        int[] a = {45,36,18,53,72,30,48,93,15,35};
        minHeap(a);
        System.out.println("");
        maxHeap(a);
    }

    @Test
    public void test3(){
        arrayCopyTest();
    }

    public static void maxHeap(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        heap.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        while(!heap.isEmpty())
            System.out.println(heap.poll());
    }

    public static void minHeap(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        while(!heap.isEmpty())
            System.out.println(heap.poll());
    }

    public static void arrayCopyTest(){
        Object[] elementData = {1};
        PriorityQuequeTest obj = new PriorityQuequeTest();
        System.out.println("obj"+obj);
        elementData[0] = obj;
        System.out.println("element data1"+elementData[0]);
        Object[] elementData2 = new Object[elementData.length + 1];
        System.arraycopy(elementData,0,elementData2,0,elementData.length);
        //System.out.println(elementData2.length);
        for(Object o: elementData2)
            System.out.println("element data2"+o);
        obj.flag =1;
        System.out.println( ((PriorityQuequeTest)elementData2[0]).flag);
        System.out.println( ((PriorityQuequeTest)elementData[0]).flag);
        System.out.println( obj.flag);
    }
}
