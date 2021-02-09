package com.xzq.listnode;

public class ListNode {

    public Object obj;
    public ListNode next;

    public ListNode(Object obj) {
        this.obj = obj;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(Object obj, ListNode next) {
        this.obj = obj;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "obj=" + obj +
                ", next=" + next +
                '}';
    }
}
