package com.zhouchaoran.datastructure.sorting.sortmethod;

/**
 * Created by zhouchaoran on 2017/2/4.
 * <p>
 * 基本思想：将待排序的无序数列看成是一个仅含有一个元素的有序数列和一个无序数列，将无序数列中的元素逐次插入到有序数列中，从而获得最终的有序数列。
 * <p>
 * 　　算法流程：
 * <p>
 * 　　1）初始时， a[0]自成一个有序区， 无序区为a[1, ... , n-1], 令i=1;
 * <p>
 * 　　2）将a[i]并入当前的有序区a[0, ... , i-1];
 * <p>
 * 　　3）i++并重复2）直到i=n-1, 排序完成。
 * <p>
 * 　　时间复杂度：O(n^2)。
 *
 * @desc: by 算法导论（麻省理工）
 * <p>
 * worst case
 * T(n) = 最大运行次数
 * average case
 * T(n) = 期望时间
 *
 * T(n) = Σ（j=2 -> n） (θ（j）) = θ(n的平方)
 */
public class InsertSort extends BaseSort {
    @Override
    public void sort(int[] arrays) {
        /**
         *
         mark first element as sorted
         for each unsorted element
         'extract' the element
         for i = lastSortedIndex to 0
         if currentSortedElement > extractedElement
         move sorted element to the right by 1
         else: insert extracted element
         */

        for (int i = 2; i < arrays.length; i++) {
            insertSwap(arrays, i);
        }

        /**
         * 网上的解答
         *
         for(int i=1; i<arrays.length; i++)
         for(int j=i-1; j>=0 && arrays[j]>arrays[j+1]; j--)
         swap(arrays, j, j+1);
         */
    }

    /**
     * 递归
     *
     * @param arrays
     * @param i
     */
    private void insertSwap(int[] arrays, int i) {
        if (i >= 1 && arrays[i] < arrays[i - 1]) {
            swap(arrays, i - 1, i);
            insertSwap(arrays, i - 1);
        } else {
            return;
        }
    }
}
