package com.jacob.search;

public class BinarySearch {
    /**
     *
     * @param numbs 递增的数组
     * @param left
     * @param right
     * @param target 要找的数
     * @return
     */
    public static int binarySearch(int[] numbs,int left,int right,int target){
        int mit = (left + right) / 2;
        int mitValue = numbs[mit];
        if (left > right){//退出递归条件
            return left;
        }
        if (target > mitValue){//向右递归
            return binarySearch(numbs,mit + 1,right,target);
        }else if (target < mitValue){//向左递归
            return binarySearch(numbs,left ,mit - 1,target);
        }else{//找到相等的
            return mit;
        }



    }

    public static void main(String[] args) {
        int[] numbs = {1,5,8,9,44,67};

        System.out.println(binarySearch(numbs, 0, numbs.length - 1, 10));
        System.out.println(binarySearch(numbs, 0, numbs.length - 1, 67));

    }

}
