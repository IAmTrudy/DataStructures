package com.lxp.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        sort(arr);
        showArr(arr);
    }

    public static void showArr(int[] arr){
        for (int i : arr){
            System.out.printf("%d,",i);
        }

    }

    public static void sort(int[] arr){
        int count = 0;
        int length = arr.length;
        int temp;
        boolean flag;
        for (int i = 0;i<length-1;i++){
            flag = true;
            for (int j = 0;j<length-1;j++){
                count++;
                if (arr[j]>arr[j+1]){
                    flag = false;
//                    temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
                    arr[j] = arr[j+1] + arr[j];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
            if (flag){
                System.out.println(count);
                return;
            }
        }
        System.out.println(count);
    }
}
