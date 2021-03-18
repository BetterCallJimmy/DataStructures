package com.jacob.sort;

import java.util.Arrays;

public class QuickSort {


//    private static int[] numb = {4,5,3,6,2,5,8,1};
private static int[] numb = {9,5,3,6,2,5,8,1};
    private static void quickSort(int[] numb,int l,int r){
        /*
        int left = l;
        int right = r;
        int pivot = numb[(l + r) / 2];
        int temp;
        while (left < right){
            //把左半边比pivot大的找出来
            //左边的若小于pivot则向右一直找下一个,直到left递增到pivot
            while (numb[left] < pivot){
                left++;
            }
            //右半边同理
            while (numb[right] > pivot){
                right--;
            }
            //
            if (left == right){
                break;
            }
            temp = numb[right];
            numb[right] = numb[left];
            numb[left] = temp;

           if (numb[left] == pivot){
               right -= 1;
           }
           if (numb[right] == pivot){
               left += 1;
           }
        }
*/
    }
    private static void quicksort(int[] numb,int left,int right)
    {
        int i,j,t,pivot;
        if(left>right)
            return;

        pivot=numb[left]; //pivot中存的就是基准数
        i=left;
        j=right;
        while(i!=j)
        {
            //顺序很重要，要先从左向右边开始找
            while(numb[j]>=pivot && i<j)
                j--;
            //再找右边的
            while(numb[i]<=pivot && i<j)
                i++;
            //交换两个数在数组中的位置
            if(i<j)
            {
                t=numb[i];
                numb[i]=numb[j];
                numb[j]=t;
            }
        }
        //最终将基准数归位
        numb[left]=numb[i];
        numb[i]=pivot;

        quicksort(numb,left,i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(numb,i+1,right);//继续处理右边的 ，这里是一个递归的过程
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numb));
        quicksort(numb,0,numb.length - 1);
        System.out.println(Arrays.toString(numb));
    }
}
