package com.jacob.sort;

import java.util.Arrays;

public class ShellSOrt {

    public static void main(String[] args) {

//        int[] numb = {8,9,1,7,2,3,5,4,6,0};
        int[] numb = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            numb[i] = (int) (Math.random() * 1000000000);
        }
        //insertVal是要和有序部分比较的值
        int insertVal;
        //insertVal的索引的前一个，即1-1=0
        int insertIndex;
//        for (int i = 0; i < 5; i++) {
//            insertVal = numb[i + 5];
//            insertIndex = i;
//            while (i > insertIndex - 1 && insertVal < numb[i] ){
//                numb[i + 5] = numb[insertIndex];
//                numb[insertIndex] = insertVal;
//                insertIndex -= 5;
//            }
//        }
//        System.out.println(Arrays.toString(numb));
        long start = System.currentTimeMillis();
        for (int gap = numb.length/2; gap > 0; gap /= 2) {

            for (int i = gap; i < numb.length; i++) {
                insertVal = numb[i];
                insertIndex = i - gap;
                while (insertIndex >= 0 && numb[insertIndex] > insertVal){
                    numb[insertIndex + gap] = numb[insertIndex];
                    numb[insertIndex] = insertVal;
                    insertIndex -= gap;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        System.out.println(Arrays.toString(numb));

    }

}
