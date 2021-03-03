package com.jacob.linkedlist;

public class DoubleLinkedList {
    //头节点
    private DoubleNode headNode= new DoubleNode(0,"");

    public void add(DoubleNode doubleNode){
        DoubleNode temp = headNode;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = doubleNode;
        doubleNode.pre = temp;
    }

    public void show(){
        if (headNode.next == null){
            System.out.println("空链表");
        }else {
            DoubleNode temp = headNode.next;
            while (temp != null){
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public void delete(int val){
        if (headNode.next == null){
            System.out.println("空链表,删除失败");
        }else {
            DoubleNode temp = headNode.next;
            while (temp != null){
                if (temp.no == val){
                    temp.pre.next = temp.next;
                    //如果删除的是最后一个节点，则temp.next==null
                    if (temp.next != null){
                        temp.next.pre = temp.pre;
                    }
                }
                temp = temp.next;
            }
        }
    }
    //升序添加
    public void addByOrder(DoubleNode doubleNode){
        DoubleNode cur = headNode.next;
        if (cur == null){
            doubleNode.pre = headNode;
            headNode.next = doubleNode;
        }else {
            while (cur != null){
                if (cur.no >= doubleNode.no){
                    cur.pre.next = doubleNode;
                    doubleNode.pre = cur.pre;
                    doubleNode.next = cur;
                    cur.pre = doubleNode;
                    break;
                }
                if (cur.next != null){
                    cur = cur.next;
                }else {
                    cur.next = doubleNode;
                    doubleNode.pre = cur;
                    break;
                }
            }

        }
    }



    public static void main(String[] args) {
//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(new DoubleNode(1,"aa"));
//        doubleLinkedList.add(new DoubleNode(2,"bb"));
//        doubleLinkedList.add(new DoubleNode(3,"cc"));
//        doubleLinkedList.add(new DoubleNode(4,"dd"));
//
//        doubleLinkedList.show();
//        System.out.println("---------------------------");
//        doubleLinkedList.delete(3);
//        doubleLinkedList.show();
//        System.out.println("---------------------------");
//        doubleLinkedList.delete(4);
//        doubleLinkedList.show();


        DoubleLinkedList orderList = new DoubleLinkedList();
        orderList.addByOrder(new DoubleNode(1,"aa"));
        orderList.addByOrder(new DoubleNode(99,"bb"));
        orderList.addByOrder(new DoubleNode(7,"cc"));
        orderList.addByOrder(new DoubleNode(4,"dd"));
        orderList.addByOrder(new DoubleNode(77,"bb"));
        orderList.addByOrder(new DoubleNode(3,"cc"));
        orderList.addByOrder(new DoubleNode(55,"dd"));
        System.out.println("----------------------------");
        orderList.show();
    }
}
