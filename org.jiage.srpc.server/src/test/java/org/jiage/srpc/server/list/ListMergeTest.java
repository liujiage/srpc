package org.jiage.srpc.server.list;

import org.junit.Test;

/***
 input
 A 1,2,4
 B 0,3,4

 calculate
 1 compare 0
 0->merge(1,3)
 ---->1 compare 3
 ---->1->merge(2,3)
 --------->2 compare 3
 --------->2->merge(3,4)
 ------------->3 compare 4
 ------------->3->merge(4,4)
 ---------------->4 compare 4
 <-------------------Return
 <----------------4->4
 <-------------3->4
 <---------2->3
 <-----1->2
 <0->1

 output
 0->1->2->3->4->4
 */
public class ListMergeTest {

    @Test
    public void test2(){
        ListNode a = new ListNode(1,new ListNode(2,new ListNode
                (4,null)));
        ListNode b = new ListNode(0,new ListNode(3,new ListNode
                (4,null)));
        ListNode c = mergeTwoLists(a,b);
        ListNode.printNode(c);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value < l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            System.out.println("l1 "+l1.value+ " l2 "+ l2.value);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            System.out.println("l1 "+l1.value+ " l2 "+ l2.value);
            return l2;
        }
    }
}
