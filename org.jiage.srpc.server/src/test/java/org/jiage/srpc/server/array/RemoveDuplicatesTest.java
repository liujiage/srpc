package org.jiage.srpc.server.array;

import org.junit.Test;

public class RemoveDuplicatesTest {

    @Test
    public void test(){
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
        for(int i=0;i <arr.length; i++) System.out.print(arr[i]);
    }


    public static int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i =1; i<nums.length; i++)
            if(nums[i-1] != nums[i])
                nums[++n] = nums[i];
        return ++n;
    }


    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
