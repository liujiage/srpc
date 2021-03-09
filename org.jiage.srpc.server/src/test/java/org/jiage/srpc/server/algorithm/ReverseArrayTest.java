package org.jiage.srpc.server.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class ReverseArrayTest {

    @Test
    public void test(){
        Integer[] data = new Integer[]{1,2,3,4,5,9};
        //reverseArray(data,0, data.length -1);
        reverseArray2(data);
        Arrays.stream(data).forEach(System.out::println);
        String[] data2 = new String[]{"1","2","3","4","5","9"};
        reverse(data2);
        Arrays.stream(data2).forEach(System.out::print);
    }

    /****
     * reverse array O(n)
     * @param data
     * @param lowIndex
     * @param highIndex
     */
    public static void reverseArray(Integer[] data, int lowIndex,int highIndex){
        if(lowIndex > highIndex)
            return ;
        int temp = data[lowIndex];
        data[lowIndex] = data[highIndex];
        data[highIndex] = temp;
        reverseArray(data, lowIndex + 1, highIndex -1);
    }

    public static void reverseArray2(Integer[] data){
        int low = 0, high = data.length -1;
        while(low < high){
            int temp  = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }

    public static <T> void reverse(T[] data){
        int low = 0, high = data.length -1;
        while(low < high){
            T temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
     }
}
