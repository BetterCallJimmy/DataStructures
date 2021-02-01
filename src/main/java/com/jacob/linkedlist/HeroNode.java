package com.jacob.linkedlist;

public class HeroNode {
    private int no;
    private String name;
    public HeroNode next;

    public HeroNode(){};

    public HeroNode(int no, String name) {
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + "}" + '\'';
    }


}
