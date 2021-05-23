package com.lxp.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNodeT head = new HeroNodeT(0, "");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(head);
        doubleLinkedList.addNode(new HeroNodeT(1,"我是1"));
        doubleLinkedList.addNode(new HeroNodeT(2,"我是2"));
        doubleLinkedList.addNode(new HeroNodeT(3,"我是3"));
        doubleLinkedList.addNode(new HeroNodeT(4,"我是4"));
        doubleLinkedList.addNode(new HeroNodeT(5,"我是5"));
        doubleLinkedList.showDoubleLinkedList();
        doubleLinkedList.updateNode(new HeroNodeT(1,"我是2222"));
        doubleLinkedList.showDoubleLinkedList();
        doubleLinkedList.deleteNode(new HeroNodeT(3,""));
        doubleLinkedList.showDoubleLinkedList();

    }
}

class DoubleLinkedList{
    private HeroNodeT head;

    public DoubleLinkedList(HeroNodeT head) {
        this.head = head;
    }

    //顺序遍历数据
    public void showDoubleLinkedList(){
        if (head.getNext()==null){
            System.out.println("链表为空");
        }
        HeroNodeT item = head.getNext();
        System.out.println("链表：");
        while(item!=null){
            System.out.println(item);
            item = item.getNext();
        }
    }

    //倒序遍历数据
    public void showDoubleLinkedListByDesc(){
        if (head.getNext()==null){
            System.out.println("链表为空");
        }
        HeroNodeT last = head.getNext();
        while(last!=null){
            last = last.getNext();
        }
    }

    //增加node到最后
    public void addNode(HeroNodeT heroNodeT){
        HeroNodeT item = head;
        while (true){
            if (item.getNext()==null){
                heroNodeT.setPre(item);
                item.setNext(heroNodeT);
                break;
            }
            item = item.getNext();
        }
    }
    //修改
    public void updateNode(HeroNodeT heroNodeT){
        if(head.getNext() == null){
            System.out.println("链表为空，未找到修改的NODE");
        }
        HeroNodeT item = head;//当前
        while(true){
            HeroNodeT next = item.getNext();//下一个
            if(next ==null){
                System.out.println("未找到修改的NODE");
                break;
            }else if(next.getNo()==heroNodeT.getNo()){
                heroNodeT.setPre(item);
                heroNodeT.setNext(item.getNext().getNext());
                item.setNext(heroNodeT);
                break;
            }
            item = next;
        }
    }
    //删除
    public void deleteNode(HeroNodeT heroNodeT){
        if(head.getNext() == null){
            System.out.println("链表为空，未找到删除的NODE");
        }
        HeroNodeT item = head;
        while(true){
            if(item.getNext()==null){
                System.out.println("未找到删除的NODE");
                break;
            }else if(item.getNext().getNo()==heroNodeT.getNo()){
                //如果要删除的是最后一个(item.getNext())，那么此时item.getNext().getNext()就是null
                if(item.getNext().getNext()==null){
                    item.setNext(null);
                    break;
                }
                item.setNext(item.getNext().getNext());
                item.getNext().setPre(item);
                break;
            }
            item = item.getNext();
        }
    }
}

class HeroNodeT{
    private int no;
    private String name;
    private HeroNodeT pre;
    private HeroNodeT next;

    public HeroNodeT(int no, String name) {
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

    public HeroNodeT getPre() {
        return pre;
    }

    public void setPre(HeroNodeT pre) {
        this.pre = pre;
    }

    public HeroNodeT getNext() {
        return next;
    }

    public void setNext(HeroNodeT next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNodeT{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
