package com.jacob.queue02;

import java.util.Scanner;

public class ArrarQueue {
    //用数组模拟队列
    public static void main(String[] args) {
        ArrarQueue arrarQueue = new ArrarQueue(3);

        boolean loop=true;
        char pick=' ';

        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("a--add");
            System.out.println("g--get");
            System.out.println("s--showHead");
            System.out.println("o--showAll");
            System.out.println("e--exit");
            System.out.print("输入选择：");
            pick=scanner.next().charAt(0);
            switch (pick){
                case 'a':
                    System.out.print("输入一个数：");
                    try {
                        arrarQueue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(arrarQueue.getHeadQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrarQueue.showHeadQueue();
                    break;
                case 'o':
                    arrarQueue.showQueue();
                    break;
                case 'e':
                    loop=false;
                    break;
            }
        }

    }

    private int maxSize;
    //队列头标记，头元素的前一个位置
    private int front;
    //队列尾标记，最后一个元素的位置
    private int rear;
    //数组队列
    private int[] queue;
    //初始化队列大小
    public ArrarQueue(int maxSize){
        this.maxSize=maxSize;
        front=-1;
        rear=-1;
        queue=new int[maxSize];
    }

    public boolean isFull(){
        if (rear==(maxSize-1)){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (front == rear){
            return true;
        }
        return false;
    }

    //添加数据
    public void addQueue(int data){
        //判断队列是否是满的
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        //rear是-1，先要加1
        rear++;
        queue[rear]=data;
    }

    //取出数据
    public int getHeadQueue(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列无数据");
        }
        front++;
        return queue[front];
    }

    //查看队列所有的数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列无数据");
            return;
        }
        for (int i = 0; i < queue.length; i++) {
            System.out.println("queue["+i+"]="+queue[i]);
        }
    }

    //查看队列的头数据
    public void showHeadQueue(){
        if (isEmpty()){
            System.out.println("队列无数据");
            return;
        }
        int head=front+1;
        System.out.println("头："+queue[head]);
    }
}
