package org.jiage.srpc.server.list;

import org.junit.Test;

public class LinkMiddleTest {

    @Test
    public void test2() {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode
                (3,new ListNode(4,new ListNode(5,null)))));

        ListNode head2 = new ListNode(1,new ListNode(2,null));
        head2 = LinkMiddleTest.middleNode(head2);
        ListNode.printNode(head2);
     }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; //step 1
            fast = fast.next.next; //step 2
            //System.out.println("slow: "+slow.value+ " fast: "+fast.value);
        }
        return slow;
    }
}
