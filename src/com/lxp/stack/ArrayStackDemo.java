package com.lxp.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.showStack();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        arrayStack.push(10);
        arrayStack.showStack();
        int pop = arrayStack.pop();
        System.out.println(pop);

    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top;

    public ArrayStack(int maxSize){
        stack = new int[maxSize];
        this.maxSize = maxSize;
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int num){
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("栈空");
        }
        return stack[top--];
    }

    public void showStack(){
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }
}