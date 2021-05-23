package com.lxp.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        sort(arr);
        showArr(arr);
    }

    public static void showArr(int[] arr){
        for (int i : arr){
            System.out.printf("%d,",i);
        }
        System.out.println();
    }

    public static void sort(int[] arr){
        int temp;
        for (int i = 0;i<arr.length-1;i++){
            temp = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[temp]>arr[j]){
                    temp = j;
                }
            }
            arr[i] = arr[i] + arr[temp];
            arr[temp] = arr[i] - arr[temp];
            arr[i] = arr[i] - arr[temp];
        }
    }
}
