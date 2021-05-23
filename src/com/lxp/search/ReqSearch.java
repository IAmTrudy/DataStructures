package com.lxp.search;

public class ReqSearch {
    public static void main(String[] args) {
        int[] arr = {1,98,2,545,16,44};
        int search = search(arr, 16);
        System.out.println(search);
    }

    public static int search(int[] arr,int num){
        for(int i = 0;i<arr.length-1;i++){
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
