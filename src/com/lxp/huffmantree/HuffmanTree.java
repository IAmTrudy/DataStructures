package com.lxp.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node creat = creat(arr);
        creat.preOrder();

    }
    public static Node creat(int[] arr){
        List<Node> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new Node(i));
        }
        Collections.sort(list);

        while (list.size() > 1) {
            Node leftNode = list.remove(0);
            Node rightNode = list.remove(0);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            list.add(parent);
            Collections.sort(list);
            System.out.println(list);
        }
        return list.get(0);
    }
}
class Node implements Comparable<Node>{
    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    int value;
    Node left;
    Node right;

    public void preOrder(){
        if (this != null) {
            System.out.printf("%d\t",this.value);
        }
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}