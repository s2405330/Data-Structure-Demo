package com.zhouchaoran.datastructure.sorting.sortmethod;

import java.util.Random;

/**
 * Created by zhouchaoran on 2017/2/4.
 * <p>
 * for each (unsorted) partition
 * set first element as pivot
 * storeIndex = pivotIndex + 1
 * for i = pivotIndex + 1 to rightmostIndex
 * if element[i] < element[pivot]
 * swap(i, storeIndex); storeIndex++
 * swap(pivot, storeIndex - 1
 *
 * @desc: by 算法导论
 * <p>
 * divide and conquer 分治算法
 * sort in place 原地排序 就是在原来的数据结构进行排序 而归并是在copy的数组中排序
 * 节省空间和时间 并且很实用
 * 方法：
 * 1.通过一个X 将数组分成两个子数组使得第一个数组里面所有的数据 <= x <= 另一个子数组中的所有元素
 * 2.递归处理每一个子数组
 * 3.合并在一起
 * 分析T(n) = worst-case-time
 * 也就是首先已经排好序了或者逆排序了
 * 或者选择的pivot一边有元素一边没有元素
 * 则T(n) = T(0) + T(n-1) + θ(n) = T(n-1) + θ(n) = θ(n^2) 因为等差数列通项
 * 用递归树解也一样
 * <p>
 * 平均时间好 但是速度跟插入一样快
 * 最优解：
 * 正好pivot在正中间的情况
 * T(n) = 2T(n/2) + θ(n) = θ(nlogn)
 * <p>
 * 题目1：
 * 假设有幸运 不幸运 幸运交替进行
 * 递归式：
 * L(n) = 2U(n/2) + θ(n) lucky
 * U(n) = L(n-1) + θ(n) unlucky
 * <p>
 * L(n) = 2(L(n/2 - 1) + θ(n)) + θ(n) = 2L(n/2 - 1) + θ(n) = θ(nlgn) lucky
 */
public class QuickSort extends BaseSort {
    @Override
    public void sort(int[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);
//        Arrays.sort();
    }

    /**
     * 这里面分割的是随机排序 pivot虽然是选取最优解 但是其实是选择了主元
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int randomPartition(int arr[], int left, int right) {
        int i = left, j = right;
        Random random = new Random();
        int pivot = arr[random.nextInt(arr.length - 1)];//最优
//        int pivot = arr[(left + right) >>> 1];//最优

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    private int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int pivot = arr[left];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    private void quickSort(int arr[], int left, int right) {
//        int index = partition(arr, left, right);
        int index = randomPartition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
}
