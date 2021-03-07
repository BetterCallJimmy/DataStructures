package com.jacob.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

//        int[] numb = {7,2,9,4,1};
        int[] numb = new int[800000];

        for (int i = 0; i < 800000; i++) {
            numb[i] = (int) (Math.random() * 10000000);
        }
        //insertVal是要和有序部分比较的值
        int insertVal = numb[1];
        //insertVal的索引的前一个，即1-1=0
        int insertIndex = 0;
        /*
        //第一轮，第1个和第0个比较
        while (insertIndex > -1 && numb[insertIndex] > insertVal){
            numb[insertIndex + 1] = numb[insertIndex];
            numb[insertIndex] = insertVal;
            insertIndex--;
        }
        System.out.println(Arrays.toString(numb));
        //第二轮，第2个先和第1个比较，发现无需交换，不进入while
        insertVal = numb[2];
        insertIndex = 1;
        while (insertIndex > -1 && numb[insertIndex] > insertVal){
            numb[insertIndex + 1] = numb[insertIndex];
            numb[insertIndex] = insertVal;
            insertIndex--;
        }
        System.out.println(Arrays.toString(numb));
        //第三轮，第3个（4）和第2个比较，9 比 4大 交换，7 比 4大 交换，2 比 4小 退出while
        insertVal = numb[3];
        insertIndex = 2;
        while (insertIndex > -1 && numb[insertIndex] > insertVal){
            numb[insertIndex + 1] = numb[insertIndex];
            numb[insertIndex] = insertVal;
            insertIndex--;
        }
        */
        long start = System.currentTimeMillis();
        for (int i = 1; i < numb.length; i++) {
            insertVal = numb[i];
            insertIndex = i - 1;
            while (insertIndex > -1 && numb[insertIndex] > insertVal){
                numb[insertIndex + 1] = numb[insertIndex];
                numb[insertIndex] = insertVal;
                insertIndex--;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(numb));
    }

}
