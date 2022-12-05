package com.miu.web.huaWei;

/**
 * @author keying
 * @date 2022-08-16 11:25:13
 */
public class KuaiPai {
    public static void main(String[] args) {
      int[] arr = new int[]{23,22,33,12,10};
      int[] returnArr = QuickSort2(arr,0,arr.length-1);
      System.out.println(returnArr);
    }

    /*
快速排序算法
*/
    public static int[] QuickSort2(int[] arr, int left, int right) {

        //首先定义两个指针 和一个比较的基准值 这个基准值可以随意指定，不妨将数组的中间值指定为基准值

        int l = left;
        int r = right;

        int mid = arr[(left + right) / 2];
        int temp = 0;

        //第一步 首先按照mid值的大小 将数组分为两部分
        while (l < r) {//while循环的条件为 必须为左子针小于右子针

            //在while循环中  将小于Mid值放在mid左边 大于的放在右边
            while (arr[l] < mid) {
                //该循环的目的 依次在mid左边 找到小于mid的值，如大于 则跳出循环
                l++;
            }
            while (arr[r] > mid) {
                r--;
            }

            if (l >= r) {
                break;
            }

            //互换两个子针对应的元素
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;


            //这里需要判断 如果出现了左右两个子针对应的值都等于mid值的情况下 会出现死循环
            if (arr[l] == mid) {
                r--;
            }
            if (arr[r] == mid) {
                l++;
            }
        }

        if (r == l) {
            l++;
            r--;
        }

        //中间值的索引位置不会发生改变

        //向左递归  在这里排序时 不包括中间mid值
        if (left < r) {
            QuickSort2(arr, left, r);
        }
        //向右递归
        if (right > l) {

            QuickSort2(arr, l, right);
        }

        return arr;
    }
}