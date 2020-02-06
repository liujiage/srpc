package org.jiage.srpc.server.list;

import org.junit.Test;

public class LinkReverseTest {

    @Test
    public void test2() {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode
                (3,new ListNode(4,null))));
        head = reverse(head);
        ListNode.printNode(head);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next; //create a new node for move node,
            // must be created a new node to move current node to next node.
            curr.next = prev;
            prev = curr; //move first node
            curr = temp; //move second node
        }
        head = prev;
        return head;
    }

    public ListNode reverseStack(ListNode head) {
        // case1: empty list
        if (head == null) return head;
        // case2: only one element list
        if (head.next == null) return head;
        // case3: reverse from the rest after head
        ListNode newHead = reverseStack(head.next);
        // reverse between head and head->next
        head.next.next = head;
        // unlink list from the rest
        head.next = null;
        return newHead;
    }




}

