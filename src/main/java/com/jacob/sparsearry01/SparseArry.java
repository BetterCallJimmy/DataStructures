package com.jacob.sparsearry01;

public class SparseArry {

    public static void main(String[] args) {
        //二维数组转换稀疏数组
        //11x11的棋盘，0表示空，1表示黑子，2表示蓝子
        int[][] chess = new int[11][11];
        chess[1][2]=1;
        chess[2][3]=2;

        for (int[] rows : chess) {
            for (int col : rows) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
        //确定二维数组中有几个有效数据
        int count=0;
        for (int[] rows : chess) {
            for (int col : rows) {
                if (col!=0){
                    count++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArry =new int[count+1][3];
        //稀疏数组的第一行
        sparseArry[0][0]=11;
        sparseArry[0][1]=11;
        sparseArry[0][2]=count;
        //打印稀疏数组
        for (int[] rows : sparseArry) {
            for (int col : rows) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
        //计数，当前是第几个有效值
        int flag=0;
        //遍历二维数组，确定有效数据的行列，值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j]!=0){
                    flag++;
                    sparseArry[flag][0]=i;
                    sparseArry[flag][1]=j;
                    sparseArry[flag][2]=chess[i][j];
                }
            }
        }
        System.out.println("------------------------------------------");
        //打印稀疏数组
        for (int[] rows : sparseArry) {
            for (int col : rows) {
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }

    }





}
