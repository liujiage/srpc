package org.jiage.srpc.server.list;

import org.junit.Test;

public class LinkDeleteTest {


    @Test
    public void test2(){
        ListNode head = new ListNode(1,new ListNode(2,new ListNode
                (3,new ListNode(4,new ListNode(5,null)))));
        deleteNode(head.next.next);
        ListNode.printNode(head);
    }

    @Test
    public void test3(){
        ListNode head = new ListNode(4,new ListNode(1,new ListNode
                (3,new ListNode(4,new ListNode(4,null)))));
        head = removeNodeByValue(head,4);
        ListNode.printNode(head);
    }

    public static void deleteNode(ListNode node){
        node.value = node.next.value;
        node.next = node.next.next;
    }
    public static ListNode removeNodeByValue(ListNode head,int value){
        ListNode cur = head;
        while (cur != null) {
            //first do not care the first node. it is from second node to compare value
            // and change node next link.
            if (cur.next != null && cur.next.value == value) {
                cur.next = cur.next.next; //if find a equal node then change the next link
            } else {
                cur = cur.next; //if not found a equal node then move to next node
            }
        }
        //to check and process first node
        return (head != null && head.value == value) ? head.next : head;
    }
}
