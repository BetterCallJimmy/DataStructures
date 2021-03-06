package com.jacob.recursion;

public class MiGong {

    public static boolean getWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                //如果此路未探过，则假设通,再探他的下右上左
                map[i][j] = 2;
                if (getWay(map,i+1,j)){//下
                    return true;
                }else if (getWay(map,i,j+1)){//右
                    return true;
                }else if (getWay(map,i-1,j)){//上
                    return true;
                }else if (getWay(map,i,j-1)){//左
                    return true;
                }else {//下右上左都不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                //此路不为0时，为1是墙，为2探过，为3则是此点下右上左都不通
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int j = 0; j < 7; j++) {
            map[0][j] = 1;
            map[7][j] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        map[6][4] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

        getWay(map,1,1);

        System.out.println("-------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
