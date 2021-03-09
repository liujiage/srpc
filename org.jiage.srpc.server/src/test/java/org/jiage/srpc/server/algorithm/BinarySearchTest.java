package org.jiage.srpc.server.algorithm;

import org.junit.Test;

public class BinarySearchTest {


    @Test
    public void test(){
        Integer[] data = new Integer[]{2,3,5,7,8,9,10,14,17,19,22,25,27,28,33,37};
        System.out.println(binarySearch(data, 22,0,data.length));
    }

    /***
     * binary search O(LogN)
     * @param data
     * @param target
     * @param lowIndex
     * @param highIndex
     * @return
     */
    public static boolean binarySearch(Integer[] data, int target, int lowIndex, int highIndex){
        if(lowIndex > highIndex)
            return false;
        int mid = (lowIndex + highIndex) / 2;
        if(target == data[mid])
            return true;
        return (target < data[mid]) ? binarySearch(data,target,lowIndex, mid - 1) :
                binarySearch(data,target,lowIndex + 1,highIndex);
    }

}
