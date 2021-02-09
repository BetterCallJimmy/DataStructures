package com.jacob.linkedlist;

public class CircleSingleLinkedList {

    private  BoyNode first;

    private  void addBoy(int numbers){
        if (numbers <= 0){
            return;
        }
        BoyNode cur = null;
        for (int i = 1; i <= numbers; i++) {
            //当生成第一个节点时，自身成环
            if (i == 1){
                first = new BoyNode(i);
                first.next = first;
                cur = first;
                continue;
            }
            cur.next = new BoyNode(i);
            cur.next.next = first;
            cur = cur.next;
        }
        System.out.println("添加完成");
    }

    public void show(){
        if (first == null){
            System.out.println("空");
        }
        BoyNode cur = first;
        //当只有一个节点时
        if (first.next == first){
            System.out.println(cur);
            return;
        }
        while (cur.next != first){

            System.out.println(cur);

            cur = cur.next;
            //当到cur是最后一个时，cur.next是first，需要打印，不然会跳出循环，导致最后一个不打印
            if (cur.next == first){
                System.out.println(cur);
                break;
            }
        }
    }

    /**
     *
     * @param n 有几个小孩
     * @param k 从第几个开始报数
     * @param m 数几下
     */
    public void josephu(int n ,int k , int m){
        this.addBoy(n);
        //开始报数的那个节点
        BoyNode from = first;
        //开始报数的节点的上一个节点
        BoyNode pre = first;

        for (int i = 0; i < k - 1; i++) {
            pre = from;
            from = from.next;
        }

        while (true){
            //找到要出链的那个节点，和初始from差不多
            for (int i = 0; i < m - 1; i++) {
                pre = from;
                from = from.next;
            }
            System.out.println(from);
            //移除那个节点
            pre.next = from.next;
            //从移除的下一个开始，找下一个要出链的节点
            from = from.next;
            //只剩最后一个，结束循环
            if (from == pre){
                System.out.println(from);
                break;
            }
        }
    }

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
//        list.addBoy(9);
//        list.show();
        list.josephu(5,1,2);

        list.josephu(195,1,2);
    }
}
