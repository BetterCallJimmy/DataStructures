package com.jacob.queue02;

import java.util.Scanner;

class CircleQueue {


    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);

        boolean loop = true;
        char pick = ' ';

        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.print("a--add-");
            System.out.print("f--showF-");
            System.out.print("r--showR-");
            System.out.print("d--deletF-");
            System.out.print("o--showAll-");
            System.out.print("e--exit");
            System.out.print("输入选择：");
            pick = scanner.next().charAt(0);
            switch (pick) {
                case 'a':
                    System.out.print("输入一个数：");
                    try {
                        circleQueue.enQueue(scanner.nextInt());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'f':
                    try {
                        System.out.println(circleQueue.Front());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'r':
                    System.out.println(circleQueue.Rear());
                    break;
                case 'd':
                    circleQueue.deQueue();
                    break;
                case 'o':
                    circleQueue.showAll();
                    break;
                case 'e':
                    loop = false;
                    break;
            }
        }
    }
        private int front;
        private int rear;
        private int maxSize;
        private int[] MyCircularQueue;

    public CircleQueue(int k) {
        MyCircularQueue = new int[k+1];
        front=0;
        rear=0;
        maxSize=k+1;
    }

    public void showAll(){
        for (int i : MyCircularQueue) {
            System.out.println(i);
        }
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        MyCircularQueue[rear]=value;
        rear=(rear+1)%maxSize;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        MyCircularQueue[front]=0;
        front=(front+1+maxSize)%maxSize;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        int value = MyCircularQueue[front];
        //front = (front+1)%maxSize;
        return value;
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int index = (rear-1+maxSize)%maxSize;
        return MyCircularQueue[index];
    }

    public boolean isEmpty() {
        if(front == rear){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if((rear+1)%maxSize == front){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */