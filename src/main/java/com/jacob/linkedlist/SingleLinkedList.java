package com.jacob.linkedlist;
import com.jacob.linkedlist.HeroNode;
public class SingleLinkedList {

    //头节点
    private HeroNode headNode= new HeroNode(0,"");

    //当不考虑编号时，尾插法
    //节点的next不为空时，看下一个节点的next是否为空，直到next为空

    public void add(HeroNode heroNode){
//        if (headNode.next == null){
//            headNode.next=heroNode;
//        }else {
//            HeroNode temp=headNode;
//            while (temp.next!=null){
//
//                temp = temp.next;
//            }
//            temp.next = heroNode;
//        }

            HeroNode temp=headNode;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = heroNode;

    }

    public void show(){
        if (headNode.next == null){
            System.out.println("空链表");
        }else {
            HeroNode temp = headNode.next;
            while (temp != null){
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode aa = new HeroNode(1, "aa");
        HeroNode bb = new HeroNode(2, "bb");
        HeroNode cc = new HeroNode(3, "cc");

        singleLinkedList.add(aa);
        singleLinkedList.add(bb);
        singleLinkedList.add(cc);

        singleLinkedList.show();
    }


}
