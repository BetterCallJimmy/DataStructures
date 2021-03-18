package com.jacob.sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] numb = {7,3,5,9,1,7,6,4};

    private static void mergeSort(int[] numb,int left,int mid,int right){
        int l = left;
        int r = mid + 1;


    }


    private static void sort(int[] numb,int left,int mid, int right, int[] dum) {
        //左边有序部分的开始的索引
        int l = left;
        //右边有序部分的开始的索引
        int r = mid + 1;
        //临时数组
        int dumCur = 0;

        while (l <= mid && r <= right) {
            if (numb[l] < numb[r]) {
                dum[dumCur] = numb[l];
                l++;
            } else {
                dum[dumCur] = numb[r];
                r++;
            }
            dumCur++;
        }
        //左边部分都添加到了dum，这时把右边剩的都加入到dum
        while (r <= right) {
            dum[dumCur] = numb[r];
            r++;
            dumCur++;
        }

        while (l <= mid) {
            dum[dumCur] = numb[l];
            l++;
            dumCur++;
        }
    }

    public static void main(String[] args) {
        int[] numbs = {6,17,25,44,5,7,65,114};
            int[] dum = new int[numb.length];
            sort(numbs,0,3,numb.length - 1,dum);
        System.out.println(Arrays.toString(dum));
    }

}
