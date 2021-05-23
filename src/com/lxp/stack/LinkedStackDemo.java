package com.lxp.stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(new StackNode(0,0));
        linkedStack.push(new StackNode(1,1));
        linkedStack.push(new StackNode(2,2));
        linkedStack.push(new StackNode(3,3));
        linkedStack.push(new StackNode(4,4));
        linkedStack.showStack();
        int pop = linkedStack.pop();
        System.out.println(pop);
        linkedStack.showStack();
    }
}
class LinkedStack{
    private StackNode first;
    private StackNode last;

    public boolean isEmpty(){
        return first == null;
    }

    public void showStack(){
        int length = getLength();
        StackNode[] temp = new StackNode[length];
        temp[0] = first;
        for (int i = 1;i<length;i++){
            temp[i] = temp[i-1].getNext();
        }
        for (int i = length-1;i>=0;i--){
            System.out.println(temp[i]);
        }
    }

    public int getLength(){
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        StackNode item = first;
        while(true){
            length++;
            if (item.getNext() == null) {
                break;
            }
            item = item.getNext();
        }
        return length;
    }

    public void push(StackNode stackNode){
        if (isEmpty()) {
            first = stackNode;
            last = stackNode;
        }else{
            last.setNext(stackNode);
            last = stackNode;
        }
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("栈空");
        }
        StackNode item = first;
        int value;
        while(true){
            if (item == last) {
                last = null;
                first = null;
                value =  item.getValue();
                break;
            }else if(item.getNext() == last){
                item.setNext(null);
                value = last.getValue();
                last = item;
                break;
            }
            item = item.getNext();
        }
        return value;
    }

}

class StackNode{
    private int no;
    private int value;
    private StackNode next;

    public StackNode(int no,int value){
        this.no = no;
        this.value = value;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "no=" + no +
                ", value=" + value +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}