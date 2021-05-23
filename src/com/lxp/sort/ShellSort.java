package com.lxp.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        sortMove(arr);
        showArr(arr);
    }

    public static void showArr(int[] arr){
        for (int i : arr){
            System.out.printf("%d,",i);
        }
        System.out.println();
    }

    //交换法
    public static void sort(int[] arr){
        int temp;
        //分组
        for (int group = arr.length/2;group>0;group = group/2){
            //遍历每个组
            for (int i = group;i< arr.length;i++){
                //遍历组内元素
                for (int j = i-group;j>=0;j = j-group){
                    if (arr[j+group]<arr[j]){
                        temp = arr[j+group];
                        arr[j+group] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    //移动法
    public static void sortMove(int[] arr){
        int temp;
        //分组
        for (int group = arr.length/2;group>0;group = group/2){
            //遍历分组后的每个元素，从各组第二个元素开始
            for (int i = group;i< arr.length;i++){
                int j = i;//当前要插入的元素的下标
                temp = arr[j];//当前要插入的元素的值
                if (arr[j]<arr[j - group]){//判断是否需要移动
                    //需要移动则找到位置
                    while (j-group>=0 && temp <arr[j - group]){
                        arr[j] = arr[j - group];
                        j = j-group;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
