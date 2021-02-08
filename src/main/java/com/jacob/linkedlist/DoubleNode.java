package com.jacob.linkedlist;

public class DoubleNode {

        protected int no;
        private String name;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(){}

        public DoubleNode(int no, String name) {
            this.no=no;
            this.name=name;
        }

        @Override
        public String toString() {
            return "DoubleNode{" +
                    "no=" + no +
                    ", name='" + name + "}" + '\'';
        }





}
