package com.lxp.hashtab;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        hashTab.add(new Emp(0,"000"));
        hashTab.add(new Emp(1,"000"));
        hashTab.add(new Emp(2,"000"));
        hashTab.add(new Emp(3,"000"));
        hashTab.add(new Emp(4,"000"));
        hashTab.add(new Emp(5,"000"));
        hashTab.add(new Emp(6,"000"));
        hashTab.add(new Emp(7,"000"));
        hashTab.show();
        Emp emp = hashTab.find(8);
        System.out.println(emp);
        hashTab.del(0);
        hashTab.show();
    }
}
class HashTab{
    private EmpLinkedList[] empLinkedLists;

    public HashTab(int size) {
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0;i<size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void del(int id){
        int i = hashFun(id);
        empLinkedLists[i].delEmp(id);
    }

    public int hashFun(int id){
        return id%empLinkedLists.length;
    }

    public Emp find(int id){
        int i = hashFun(id);
        return empLinkedLists[i].findEmp(id);
    }

    public void add(Emp emp){
        int i = hashFun(emp.getId());
        empLinkedLists[i].addEmp(emp);
    }
    public void show(){
        for (int i = 0;i<empLinkedLists.length;i++){
            empLinkedLists[i].show();
        }
    }
}
class EmpLinkedList{
    private Emp head;

    public void delEmp(int id){
        if (head == null) {
            System.out.println("删除失败，未找到");
            return;
        }
        Emp item = head;
        if (item.getId() == id){
            head = item.getNext();
            System.out.println("删除成功");
            return;
        }
        while (true) {
            if (item.getNext() == null) {
                System.out.println("删除失败，未找到");
                return;
            }
            if (item.getNext().getId() == id) {
                item.setNext(item.getNext().getNext());
                System.out.println("删除成功");
                return;
            }
            item = item.getNext();
        }
    }

    public Emp findEmp(int id){
        if (head == null) {
            return null;
        }
        Emp item = head;
        while (true) {
            if (item.getId() == id) {
                return item;
            }
            if (item.getNext() == null) {
                return null;
            }
            item = item.getNext();
        }
    }

    public void addEmp(Emp emp){
        if (head == null) {
            head = emp;
        }else {
            Emp item = head;
            while (true) {
                if (item.getNext() == null) {
                    item.setNext(emp);
                    break;
                }
                item = item.getNext();
            }
        }
    }

    public void show(){
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.println("链表信息：");
        Emp emp = head;
        while (true) {
            System.out.printf("id=%d,name=%s\t",emp.getId(),emp.getName());
            if (emp.getNext() == null) {
                break;
            }
            emp = emp.getNext();
        }
        System.out.println();
    }

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

}

class Emp{
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
