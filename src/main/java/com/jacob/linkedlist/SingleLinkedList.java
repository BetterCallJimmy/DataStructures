package com.jacob.linkedlist;
import com.jacob.linkedlist.HeroNode;

import java.util.Stack;

public class SingleLinkedList {

    //头节点
    private HeroNode headNode= new HeroNode(0,"");

    //当不考虑编号时，尾插法
    //节点的next不为空时，看下一个节点的next是否为空，直到next为空

    public void add(HeroNode heroNode){
            HeroNode temp = headNode;
            while (temp.next != null){
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
    //合并两个有序的链表，返回1个有效的链表
    public static SingleLinkedList mergeTwoLists(SingleLinkedList l1,SingleLinkedList l2) {
        SingleLinkedList dum = new SingleLinkedList();
        HeroNode cur = dum.headNode;
        while(l1.headNode.next != null && l2.headNode.next  != null) {
            if(l1.headNode.next.no < l2.headNode.next.no) {
                cur.next = l1.headNode.next;
                l1.headNode.next = l1.headNode.next.next;
            }
            else {
                cur.next = l2.headNode.next;
                l2.headNode.next = l2.headNode.next.next;
            }
            cur = cur.next;
        }
        cur.next = l1.headNode.next != null ? l1.headNode.next : l2.headNode.next;
        return dum;
    }

    //合并两个有序的链表，返回1个有效的链表
    public static SingleLinkedList merge2List(SingleLinkedList l1,SingleLinkedList l2){
        if (l1.headNode.next == null){
            return l2;
        }
        if (l2.headNode.next == null){
            return l1;
        }
        SingleLinkedList ltLink;
        SingleLinkedList gtLink;
        if (l1.headNode.next.no <= l2.headNode.next.no){
            ltLink=l1;
            gtLink=l2;
        }else {
            ltLink=l2;
            gtLink=l1;
        }
        HeroNode gtCurr = gtLink.headNode.next;
        HeroNode ltCurr = ltLink.headNode.next;
        HeroNode temp;

        while (gtCurr != null){
            temp = gtCurr.next;
            while (ltCurr != null){
                if (ltCurr.next == null){
                    gtCurr.next = ltCurr.next;
                    ltCurr.next = gtCurr;
                    break;
                }

                if (ltCurr.next.no >= gtCurr.no){
                    gtCurr.next = ltCurr.next;
                    ltCurr.next = gtCurr;
                    break;
                }
                ltCurr = ltCurr.next;
            }

            gtCurr = temp;
        }

        return ltLink;
    }

    //链表反转
    public SingleLinkedList reverse(){
        if (headNode.next == null){
            System.out.println("空链表");
            return null;
        }
        if (headNode.next.next == null){
            return this;
        }
        SingleLinkedList reversed = new SingleLinkedList();

        //原链表第1个节点
        HeroNode cur = headNode.next;
        //要移动的那个节点的下一个节点，辅助遍历原链表
        HeroNode next = null;
        while (cur != null){
            //要先保存好原链表当前节点的下一个节点
            next = cur.next;
            //头插法
            cur.next = reversed.headNode.next;
            reversed.headNode.next = cur;
            //当前节点后移
            cur = next;
        }
        return reversed;
    }

    //逆序打印链表,不修改原来的链表
    public static void reversePrint(SingleLinkedList l1){

        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode cur = l1.headNode.next;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
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
        System.out.println("-------------------------");
//        singleLinkedList.reverse().show();
        SingleLinkedList.reversePrint(singleLinkedList);
        System.out.println("-------------------------");
        singleLinkedList.show();


//        SingleLinkedList lt = new SingleLinkedList();
//        for (int i = 0; i < 200000; i++) {
//            lt.add(new HeroNode(i,"a"));
//        }
//
//        SingleLinkedList gt = new SingleLinkedList();
//        for (int i = 0; i < 150000; i++) {
//            gt.add(new HeroNode(i-77777,"a"));
//        }
//
//        long s1 = System.currentTimeMillis();
//        SingleLinkedList mergedList = SingleLinkedList.merge2List(lt, gt);
//        long e1 = System.currentTimeMillis();
////        mergedList.show();
//        System.out.println("-------------------------");
//        long s2 = System.currentTimeMillis();
//        SingleLinkedList singleLinkedList = SingleLinkedList.mergeTwoLists(lt, gt);
//        long e2 = System.currentTimeMillis();
//        singleLinkedList.show();
//        System.out.println(e1-s1);
//        System.out.println(e2-s2p);//9
    }


}
