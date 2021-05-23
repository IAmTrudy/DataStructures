package com.lxp.queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(2);
        circleArrayQueue.addData(1);
        circleArrayQueue.addData(2);
        circleArrayQueue.showQueue();
    }
}


class CircleArrayQueue{

    //
    private int maxSize;
    private int[] queue;
    private int front;//当前队列的第一个元素
    private int rear;//最后一个元素的后一个下标

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        front = 0;//当前队列的第一个元素
        rear = 0;//最后一个元素的后一个下标
    }

    //rear%maxSize就相当于，环形结构
    public boolean isFull(){
        return (rear != front) && (rear % maxSize == front);
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void addData(int data){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        queue[rear%maxSize] = data;
        rear++;
    }

    public int getData(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return queue[front++%maxSize];
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