package com.jacob.linkedlist;

public class BoyNode {

    public int no;
    public BoyNode next;

    public BoyNode(){}

    public BoyNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}
