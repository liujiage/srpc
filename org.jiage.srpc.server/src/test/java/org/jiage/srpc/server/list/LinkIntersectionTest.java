package org.jiage.srpc.server.list;

import org.junit.Test;

/***
 1,2,3,4,5
 9,4,0 ;

 4,5,9,4,0
 1,2,3,4,5

 1 compare 9
 2 compare 4
 3 compare 0
 4 compare 1.   B is null then b = a head
 5 compare 2.
 9 compare 3.   A is null then a = b head
 4 compare 4   found it.

 1,2,3,4,5
 9,7,0 ;

 4,5,9,7,0 ;
 1,2,3,4,5

 1 compare 9
 2 compare 7
 3 compare 0
 4 compare 1  B is null then b = a head
 5 compare 2,
 9 compare 3, A is null then a = b head
 7 compare 4,
 0 compare 5 not found both equal null this is exit .
 */
public class LinkIntersectionTest {

    @Test
    public void test2(){
        ListNode a = new ListNode(1,new ListNode(2,new ListNode
                (3,new ListNode(4,new ListNode(5,null)))));
        ListNode b = new ListNode(9,new ListNode(4,new ListNode
                (0,null)));
        a = intersection(a,b);
        System.out.println("a intersection b is "+a == null ? "not found!" : a.value);
    }

    //compare value of node
    public static ListNode intersection(ListNode headA,ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode listA = headA, listB = headB;
        while (listA != null && listB != null) {
            if (listA.value == listB.value) return listA; //to compare a and b
            listA = listA.next;   //change to a next one
            listB = listB.next;   //change to b next one
            // to compare a and b again but can be both equal null
            if (listA  == null && listB == null) return null; //if both equal null then not found exit
            if (listA.value == listB.value) return listA; //to compare a and b again
            if (listA == null) listA = headB;  //change a to b
            if (listB == null) listB = headA;  //change b to a
        }
        return listA;
    }
    //compare node
    public static ListNode intersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a != null && b != null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
            if(a == b) return a;
            if(a == null) a = headB;
            if(b == null) b = headA;
        }
        return a;

    }
}
