package com.jacob.sort;

public class BubbleSort {

    public static void main(String[] args) {
//        int[] numbs = {2,8,5,6,1,4};

        int[] numbs = new int[80000];

        for (int i = 0; i < 80000; i++) {
            numbs[i] = (int) (Math.random() * 10000);
        }

        int m = numbs.length;
        int flag = 1;

        long start = System.currentTimeMillis();

        while (m > 0 && flag == 1){
            flag = 0;
            for (int i = 0; i < m - 1; i++) {
                int temp;
                if (numbs[i] > numbs[i + 1]){
                    //如果发生了交换，则flag置1，还要继续排
                    flag = 1;
                    temp = numbs[i + 1];
                    numbs[i + 1] = numbs[i];
                    numbs[i] = temp;
                }
//                for (int numb : numbs) {
//                    System.out.print(numb + "  ");
//                }
//                System.out.println();
            }
//            System.out.println("----------------");
            m--;
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}
