package com.lxp.bst;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(7);
        BinarySortTree binarySortTree = new BinarySortTree(root);
        Node node1 = new Node(3);
        Node node2 = new Node(10);
        Node node3 = new Node(12);
        Node node4 = new Node(5);
        Node node5 = new Node(1);
        Node node6 = new Node(9);
        Node node7 = new Node(2);

        binarySortTree.add(node1);
        binarySortTree.add(node2);
        binarySortTree.add(node3);
        binarySortTree.add(node4);
        binarySortTree.add(node5);
        binarySortTree.add(node6);
        binarySortTree.add(node7);
        binarySortTree.midOrder();
        binarySortTree.del(1);
        binarySortTree.midOrder();
    }
}
class BinarySortTree{
    Node root;

    public void del(int value){
        if (root == null) {
            System.out.println("二叉排序树为空");
            return;
        } else if (root.getNode(value) != null && root.getParent(value) != null
                && root.getNode(value).left == null && root.getNode(value).right == null) {
            //删除叶子节点
            if (root.getParent(value).left == root.getNode(value)) {
                root.getParent(value).left = null;
            }else {
                root.getParent(value).right = null;
            }
        } else if (root.left == null && root.right == null && root.getNode(value).value == root.value) {
            //删除根节点且只有根节点一个节点
            root = null;
        } else if (root.getNode(value) != null && root.getParent(value) != null
                && ((root.getNode(value).left != null && root.getNode(value).right == null)
                || (root.getNode(value).left == null && root.getNode(value).right != null))) {
            if (root.getParent(value).left != null && root.getNode(value).left!=null) {
                root.getParent(value).left = root.getNode(value).left;
            }else if (root.getParent(value).left != null && root.getNode(value).right!=null) {
                root.getParent(value).left = root.getNode(value).right;
            }else if (root.getParent(value).right != null && root.getNode(value).left!=null) {
                root.getParent(value).right = root.getNode(value).left;
            }else if (root.getParent(value).right != null && root.getNode(value).right!=null) {
                root.getParent(value).right = root.getNode(value).right;
            }
        }
    }

    public Node getParent(int value){
        if (root == null) {
            System.out.println("二叉排序树为空");
            return null;
        }else {
            return root.getParent(value);
        }
    }

    public Node getNode(int value){
        if (root == null) {
            System.out.println("二叉排序树为空");
            return null;
        }else {
            return root.getNode(value);
        }
    }

    public void midOrder(){
        root.midOrder();
    }

    public void add(Node node){
        root.addNode(node);
    }

    public BinarySortTree(Node root){
        this.root = root;
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public void del(Node node){
        //删除叶子节点，无子节点的节点

    }

    public Node getParent(int value){
        if (this == null) {
            return null;
        }else {
            if (this.value > value) {
                if (this.left != null) {
                    if (this.left.value == value) {
                        return this;
                    }else {
                        return this.left.getParent(value);
                    }
                }
            }else {
                if (this.right != null) {
                    if (this.right.value == value) {
                        return  this;
                    }else {
                        return this.right.getParent(value);
                    }
                }
            }
        }
        return null;
    }

    public Node getNode(int value){
        if (this == null) {
            return null;
        }else {
            if (this.value == value) {
                return this;
            } else if (this.value > value) {
                if (this.left != null) {
                    return this.left.getNode(value);
                }
            }else {
                if (this.right != null) {
                    return this.right.getNode(value);
                }
            }
        }
        return null;
    }

    public void midOrder(){
        if (this == null) {
            System.out.println("二叉排序树为空");
        }
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void addNode(Node node){
        if (this == null) {
            System.out.println("二叉排序树为空");
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            }else {
                this.left.addNode(node);
            }
        }else {
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.addNode(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }
}