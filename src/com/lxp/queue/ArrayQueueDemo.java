package com.lxp.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(100);

        arrayQueue.addData(10);
        arrayQueue.addData(28);
        arrayQueue.showQueue();
        int data = arrayQueue.getData();
        System.out.println(data);
        data = arrayQueue.getData();
        System.out.println(data);


    }
}


class ArrayQueue{
    //
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return front == maxSize-1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void addData(int data){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        rear++;
        queue[rear] = data;
    }

    public int getData(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        front++;
        return queue[front];
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }else{
            for(int i=0;i<queue.length;i++){
                System.out.printf("%d---%d\n",i,queue[i]);
            }
        }
    }
}