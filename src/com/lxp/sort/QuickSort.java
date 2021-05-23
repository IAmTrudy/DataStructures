package com.lxp.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2,5,15,-5};
        sort(arr,0,arr.length-1);
        showArr(arr);
    }

    public static void showArr(int[] arr){
        for (int i : arr){
            System.out.printf("%d,",i);
        }
        System.out.println();
    }

    public static void sort(int[] arr,int low,int high){
        if (low == high){
            return;
        }
        int temp = arr[low];
        int l = low;
        int h = high;
        while(low<high){
            while(low<high && arr[high]>temp){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low]<temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        if(low == high){
            low--;
            high++;
        }
        if (l<low){
            sort(arr,l,low);
        }
        if (high<h){
            sort(arr,high,h);
        }
    }
}

