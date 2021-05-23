package com.lxp.sort;

public class InsertSort {
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
        int temp;//将要进行插入的值
        int tempIndex;
        for (int i = 1;i<arr.length;i++){
            temp = arr[i];//赋值给temp
            tempIndex = i-1;//下标指向前一个数
            //如果前一个数比将要插入的数大，那么将前一个数后移
            while(tempIndex>=0 && temp<arr[tempIndex]){
                arr[tempIndex+1] = arr[tempIndex];
                tempIndex--;
            }
            arr[tempIndex+1] = temp;
        }

    }
}
