package com.lxp.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(2, "2");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node4 = new HeroNode(4, "4");
        HeroNode node5 = new HeroNode(5, "5");
        BinaryTree binaryTree = new BinaryTree(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
//        HeroNode heroNode = binaryTree.preSearch(5);
        HeroNode heroNode = binaryTree.midSearch(5);
//        HeroNode heroNode = binaryTree.postSearch(5);
        System.out.println(heroNode);
//        binaryTree.preOrder();
//        binaryTree.midOrder();
//        binaryTree.postOrder();

        binaryTree.del(3);
        binaryTree.preOrder();

    }
}
class BinaryTree{
    private HeroNode root;

    public void del(int no){
        if (root != null && root.getNo() == no) {
            root = null;
            System.out.println("删除完毕");
            return;
        }
        root.delNode(no);
    }

    public HeroNode preSearch(int no){
        return root.preSearch(no);
    }

    public HeroNode midSearch(int no){
        return root.midSearch(no);
    }

    public HeroNode postSearch(int no){
        return root.postSearch(no);
    }

    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void midOrder(){
        if (this.root!=null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public void delNode(int no){
        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            System.out.println("删除成功");
            return;
        }
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            System.out.println("删除成功");
            return;
        }
        if (this.getLeft() != null) {
            this.getLeft().delNode(no);
        }
        if (this.getRight() != null) {
            this.getRight().delNode(no);
        }
    }

    public HeroNode preSearch(int no){
        if (this == null) {
            return null;
        }
        HeroNode heroNode = null;
        if (this.getNo() == no) {
            return this;
        }
        if (this.getLeft() != null) {
            heroNode = this.getLeft().preSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.getRight() != null) {
            heroNode = this.getRight().preSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        return heroNode;
    }

    public HeroNode midSearch(int no){
        if (this == null) {
            return null;
        }
        HeroNode heroNode = null;
        if (this.getLeft() != null) {
            heroNode = this.getLeft().midSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.getNo() == no) {
            return this;
        }
        if (this.getRight() != null) {
            heroNode = this.getRight().midSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        return null;
    }

    public HeroNode postSearch(int no){
        if (this == null) {
            return null;
        }
        HeroNode heroNode = null;
        if (this.getLeft() != null) {
            heroNode = this.getLeft().postSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.getRight() != null) {
            heroNode = this.getRight().postSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.getNo() == no) {
            return this;
        }
        return null;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null) {
            this.getLeft().preOrder();
        }
        if (this.right != null) {
            this.getRight().preOrder();
        }
    }

    public void midOrder(){
        if (this.left != null) {
            this.getLeft().midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.getRight().midOrder();
        }
    }
    public void postOrder(){
        if (this.left != null) {
            this.getLeft().postOrder();
        }
        if (this.right != null) {
            this.getRight().postOrder();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "HeroNode{" +
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
