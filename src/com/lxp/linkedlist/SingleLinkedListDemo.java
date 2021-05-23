package com.lxp.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode head = new HeroNode(0, "");
        SingleLinkedList singleLinkedList = new SingleLinkedList(head);
        singleLinkedList.addNodeByOrder(new HeroNode(1, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(2, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(3, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(7, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(9, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(8, "呼保义"));
        singleLinkedList.addNodeByOrder(new HeroNode(7, "呼保义"));
        singleLinkedList.showLinkedList();
        singleLinkedList.updateNode(new HeroNode(17, "无名"));
        singleLinkedList.showLinkedList();
        singleLinkedList.deleteNode(new HeroNode(3,""));
        singleLinkedList.showLinkedList();
        int length = singleLinkedList.getLength();
        System.out.println(length);
        HeroNode lastIndexNode = singleLinkedList.getLastIndexNode(4);
        System.out.println(lastIndexNode);
    }
}

class SingleLinkedList{
    private HeroNode head;

    public SingleLinkedList(HeroNode head){
        this.head = head;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void showLinkedList(){
        if(isEmpty()){
            System.out.println("链表为空");
        }
        HeroNode item = head;
        System.out.println("链表内容：");
        while(true){
            System.out.println(item);
            if(item.getNext()==null){
                break;
            }
            item = item.getNext();
        }
    }

    public void addNode(HeroNode heroNode){
        if(isEmpty()){
            System.out.println("链表为空");
        }
        HeroNode item = head;
        while(true){
            if(item.getNext()==null){
                item.setNext(heroNode);
                break;
            }
            item = item.getNext();
        }
    }

    public void addNodeByOrder(HeroNode heroNode){
        if(isEmpty()){
            System.out.println("链表为空");
        }
        HeroNode item = head;
        while(true){
            //next下一个，item当前
            HeroNode next = item.getNext();
            //直到最后一个节点，都找不到比新增的小的而且下一个节点比传入的大
            if(next == null){
                item.setNext(heroNode);
                break;
            //当前节点比新增的小
            }else if(heroNode.getNo()>item.getNo()){
                //下一个节点比传入的大
                if(next.getNo()>heroNode.getNo()){
                    item.setNext(heroNode);
                    heroNode.setNext(next);
                    break;
                //下一个节点与新增的相等
                }else if(next.getNo()==heroNode.getNo()){
                    System.out.println("添加失败，编号已存在");
                    break;
                }
            }
            item = next;
        }
    }

    public void updateNode(HeroNode heroNode){
        if(head.getNext() == null){
            System.out.println("链表为空，未找到修改的NODE");
        }
        HeroNode item = head;//当前
        while(true){
            HeroNode next = item.getNext();//下一个
            if(next ==null){
                System.out.println("未找到修改的NODE");
                break;
            }else if(next.getNo()==heroNode.getNo()){
                item.setNext(heroNode);
                heroNode.setNext(next.getNext());
                break;
            }
            item = next;
        }
    }

    public void deleteNode(HeroNode heroNode){
        if(head.getNext() == null){
            System.out.println("链表为空，未找到修改的NODE");
        }
        HeroNode item = head;//当前
        while(true){
            HeroNode next = item.getNext();//下一个
            if(next == null){
                System.out.println("未找到删除的NODE");
                break;
            }else if(next.getNo() == heroNode.getNo()){
                item.setNext(next.getNext());
                break;
            }
            item = item.getNext();
        }
    }
    //获取链表有效个数（不包括头结点）
    public int getLength(){
        int length = 0;
        HeroNode item = head;
        while(item.getNext()!=null){
            length++;
            item = item.getNext();
        }
        return length;
    }

    //获取倒数第n个节点，从下标0开始
    public HeroNode getLastIndexNode(int n){
        int length = this.getLength();
        int i = length - n;//如果是>=1，则可以找到，否则找不到
        if(head.getNext() == null || i<1){
            return null;
        }
        HeroNode heroNode = head.getNext();
        for(;i>1;i--){
            heroNode = heroNode.getNext();
        }
        return heroNode;
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode next;

    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
