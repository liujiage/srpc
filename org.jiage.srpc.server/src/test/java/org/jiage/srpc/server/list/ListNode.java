package org.jiage.srpc.server.list;

public class ListNode {

    public int value;
    public ListNode next;
    public ListNode(){}
    public ListNode(int value,ListNode next){
        this.value = value;
        this.next = next;
    }

    public ListNode(int value){
        this.value = value;
    }

    public static void printNode(ListNode node){
        StringBuffer s = new StringBuffer();
        while(node != null){
            s.append(node.value).append("->");
            node = node.next;
        }
        System.out.println(s.toString());
    }
}
