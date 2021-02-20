package com.xzq.listnode;

public class Node {
    public int record;
    public Node nextNode;

    public Node(int record) {
        super();
        this.record = record;
    }

    @Override
    public String toString() {
        return "Node{" +
                "record=" + record +
                ", nextNode=" + nextNode +
                '}';
    }
}
