package com.jacob.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

//        int[] numb = {4,5,3,6,2,5,1};
        int[] numb = new int[80000];

        for (int i = 0; i < 80000; i++) {
            numb[i] = (int) (Math.random() * 10000000);
        }
        long start = System.currentTimeMillis();
        int minIndex = 0;
        //先假设最小的是第0个，让它去打擂台
        int min = numb[0];
//        System.out.println(Arrays.toString(numb));
//        //打擂台,第一轮
//        for (int i = 0; i < numb.length - 1; i++) {
//            if (numb[i + 1] < min){
//                minIndex = i + 1;
//                min = numb[i + 1];
//            }
//        }
//        numb[minIndex] = numb[0];
//        numb[0] = min;
//        System.out.println(Arrays.toString(numb));
//        //打擂台,第二轮
//        minIndex = 1;
//        min = numb[1];
//        for (int i = 0; i < numb.length - 2; i++) {
//            if (numb[i + 2] < min){
//                minIndex = i + 2;
//                min = numb[i + 2];
//            }
//        }
//        numb[minIndex] = numb[1];
//        numb[1] = min;

        for (int j = 0; j < numb.length - 1; j++){
            minIndex = j;
            min = numb[j];
            for (int i = 1; i < numb.length - j; i++) {
                if (numb[i + j] < min){
                    minIndex = i + j;
                    min = numb[i + j];
                }
            }
            if (minIndex != j){
                numb[minIndex] = numb[j];
                numb[j] = min;
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(numb));


    }

}
