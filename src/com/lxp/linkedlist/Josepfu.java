package com.lxp.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        BoyNode first = new BoyNode(0, "一号");
        JosepfuCircle josepfuCircle = new JosepfuCircle(first);
        josepfuCircle.addNode(new BoyNode(1, "二号"));
        josepfuCircle.addNode(new BoyNode(2, "三号"));
        josepfuCircle.addNode(new BoyNode(3, "四号"));
        josepfuCircle.addNode(new BoyNode(4, "五号"));
        josepfuCircle.showList();
        josepfuCircle.makeJosepfu(2,0);


    }
}

class JosepfuCircle{
    private BoyNode first;
    private BoyNode last;
    private BoyNode helper;

    public JosepfuCircle(BoyNode first) {
        first.setNext(first);
        this.last = first;
        this.first = first;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void addNode(BoyNode boyNode){
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }
        last.setNext(boyNode);
        boyNode.setNext(first);
        last = boyNode;
    }

    public void showList(){
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        BoyNode item = first;
        while (true) {
            System.out.println(item);

            if (item == last) {
                break;
            }
            item = item.getNext();
        }
    }

    //约瑟夫问题解决
    public void makeJosepfu(int step,int from){
        helper = last;
        //从第几个开始
        for (int j = 0;j<from;j++){
            helper = helper.getNext();
            first = first.getNext();
        }
        //只剩最后一个元素
        while (helper != first){
            for (int i = 0;i<step-1;i++){
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println("出列:"+first);
            //先将first指向下一个，再删除原来的first，将helper的 下一个指到现在的first上
            first= first.getNext();
            helper.setNext(first);
        }
        //最后一个
        System.out.println("出列:"+first);
    }

}

class BoyNode{
    private int no;
    private String name;
    private BoyNode next;

    public BoyNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}
