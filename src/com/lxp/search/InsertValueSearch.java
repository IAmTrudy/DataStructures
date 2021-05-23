package com.lxp.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int search = search(arr, 0, arr.length - 1, 6);
        System.out.println(search);
    }

    public static int search(int[] arr,int left,int right,int num){
        if (left>right || num<arr[0] || num>arr[arr.length-1]){
            return -1;
        }
        int mid = left+(num-arr[left])/(arr[right]-arr[left])*(right-left);
        if(arr[mid]==num){
            return mid;
        }else if(arr[mid]>num){
            return search(arr,left,mid-1,num);
        }else{
            return search(arr,mid+1,right,num);
        }
    }
}
