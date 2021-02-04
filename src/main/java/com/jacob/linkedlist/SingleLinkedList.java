package com.jacob.linkedlist;
import com.jacob.linkedlist.HeroNode;
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
        boolean find = false;
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

    public static void main(String[] args) {
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        HeroNode aa = new HeroNode(1, "aa");
//        HeroNode bb = new HeroNode(2, "bb");
//        HeroNode cc = new HeroNode(3, "cc");
//
//        singleLinkedList.add(aa);
//        singleLinkedList.add(bb);
//        singleLinkedList.add(cc);
//        singleLinkedList.show();
//        System.out.println("-------------------------");
//        singleLinkedList.reverse().show();

        SingleLinkedList lt = new SingleLinkedList();
        lt.add(new HeroNode(1,"a"));
        lt.add(new HeroNode(3,"a"));
        lt.add(new HeroNode(7,"a"));

        SingleLinkedList gt = new SingleLinkedList();
//        gt.add(new HeroNode(1,"a"));
        gt.add(new HeroNode(8,"a"));
        gt.add(new HeroNode(9,"a"));

        SingleLinkedList mergedList = SingleLinkedList.merge2List(lt, gt);
        mergedList.show();
    }


}
