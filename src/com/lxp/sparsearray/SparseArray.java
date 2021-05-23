package com.lxp.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始二维数组");
        for (int[] rows : chessArr) {
            for (int data : rows) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //稀疏数组中的非0值总数
        int sum = 0;
        //稀疏数组行总数
        int row = 0;
        //稀疏数组列总数
        int col = 0;
        for (int[] rows : chessArr) {
            row++;
            for (int data : rows) {
                col++;
                if(data != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        System.out.println(row);
        System.out.println(col/row);

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = col/row;
        sparseArray[0][2] = sum;

        //记录到第几行了
        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col/row;j++){
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("对应的稀疏数组");
        for (int[] rows : sparseArray) {
            for (int data : rows) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组还原
        int[][] chessArr1 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1;i<=sparseArray[0][2];i++){
            chessArr1[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("还原的二维数组");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
