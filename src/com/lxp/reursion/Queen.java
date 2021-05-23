package com.lxp.reursion;

public class Queen {
    static int[] arr = new int[8];
    static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    public static  void check(int n){
        if(n == 8){
            showArr();
            return;
        }
        for (int i = 0;i<8;i++){
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    public static boolean judge(int n){
        for (int i = 0;i<n;i++){
            if(arr[i]==arr[n] || Math.abs(n-i)== Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }

    public static void showArr(){
        for (int i : arr) {
            System.out.printf(i+" ");
        }
        System.out.println();
        count++;
    }
}


