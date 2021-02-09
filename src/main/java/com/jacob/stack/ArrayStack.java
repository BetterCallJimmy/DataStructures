package com.jacob.stack;

public class ArrayStack {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public boolean full(){
        return top >= maxSize;
    }

    public boolean empty(){
        if (top == -1){
            return true;
        }else {
            return false;
        }
    }

    public void push(int val){
        if (this.full()){
            System.out.println("栈满");
        }else {
            top++;
            stack[top] = val;
        }
    }

    public int pop(){
        if (this.empty()){
//            System.out.println("栈空");
            throw new RuntimeException("栈空");
        }else {
            int val;
            val = stack[top];
            top--;
            return val;
        }
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);

        for (int i = 0; i < 7; i++) {
            System.out.println(stack.pop());
        }
        stack.push(49);
        System.out.println(stack.pop());
    }

}
