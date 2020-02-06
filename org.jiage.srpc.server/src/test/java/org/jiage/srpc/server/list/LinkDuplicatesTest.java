package org.jiage.srpc.server.list;

import org.junit.Test;

public class LinkDuplicatesTest {


    @Test
    public void test2(){
        ListNode head = new ListNode(1,new ListNode(1,new ListNode
                (2, new ListNode(3,null))));
        head = duplicatesNode(head);
        ListNode.printNode(head);
    }

    public static ListNode duplicatesNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode current = head.next;
        //compare head and head.next (current)
        while(current != null && current.value == head.value) current = current.next;
        head.next = duplicatesNode(current);
        return head;
    }

}
