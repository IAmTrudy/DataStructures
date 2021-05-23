package com.lxp.reursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;


        for (int i = 0;i<map.length-1;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0;i<map.length-1;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        boolean way = getWay(map, 1, 1);

        for (int[] rows : map) {
            for (int item : rows) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    public static boolean getWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }
        if (map[i][j] == 0){
            map[i][j] = 2;
            if (getWay(map,i+1,j)){
            }else if(getWay(map,i,j+1)){
            }else if(getWay(map,i-1,j)){
            }else if(getWay(map,i,j-1)){
            }else{
                map[i][j] = 3;
            }
        }
        return false;
    }
}
