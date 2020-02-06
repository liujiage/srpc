package org.jiage.srpc.server.sort;

import org.jiage.srpc.server.list.ListNode;
import org.junit.Test;

public class SortInsertTest {

    @Test
    public void test2(){
       int[] arr = {5,3,4,1,2};
       for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
       System.out.println("\n\r------------");
        insertSort(arr);
       for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
    }

    public static void insertSort(int[] arr){
        for(int i=1; i<arr.length; i++){ //compare set, per one time choose one
            int temp = arr[i]; //to same temporary variable
            int j = i-1; //the last change index
            for(;j >=0 && arr[j] > temp; j--){ //move data and find the change index
               arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    public ListNode insertSortLinked(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode next = cur.next;
            pre = helper;
            while(pre.next!=null && pre.next.value<=cur.value)
            {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }


}
