package org.jiage.srpc.server.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    public void  test(){
        Integer[] data = new Integer[]{1,2,3,4,5,6};
        insertionSort(data);
        Arrays.stream(data).forEach(System.out::print);

    }

    public static void insertionSort(Integer[] data){
        int n = data.length;
        for(int i=1; i<n; i++){
            int current = data[i];
            //from current index to do inner loops compare between current and before item of data
            int j = i;
            //to find which one is bigger than current item
            while(j >0 && data[j-1] < current){
                data[j] = data[j-1];
                j--;
            }
            if(j != i) {
                data[j] = current;
            }
        }
    }
}
