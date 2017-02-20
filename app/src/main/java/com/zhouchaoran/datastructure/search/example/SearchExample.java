package com.zhouchaoran.datastructure.search.example;

/**
 * Created by zhouchaoran on 2017/2/20.
 *
 * @desc: by 算法导论
 */

public class SearchExample {
    /**
     * 有n个元素在array中
     * 要寻找到第k小的elements （all of rank k）
     * 原始方案 就是遍历如果用堆排序 或者归并排序 时间复杂度就事O(nlogn)
     * <p>
     * k = 1 minimum 最小元素
     * k = n maximum 最大元素
     * k = (n-1)>>>2 中值
     * 我们更多的希望是有线性的算法：
     * 1.线性的分治算法（Randomized divided conquer 随机选择方法）：
     * Random-select(A,p,q,i)
     * i是A[p->q]中最小的数的序列
     * <p>
     * 算法：
     * if p = q then return A[p]
     * r = RandomPartition(A,p,q)
     * k = r-p+1 //k = rank(A[r]) in A[p->q]
     * if(i = k) then return A[r]
     * if(i < k) then return Random-select(A,p,r-1)
     * if(i > k) then return Random-select(A,r+1,q)
     */

    public static int randomSelect(int[] arr, int p, int q, int i) {
        if (arr == null && arr.length < 0) {
            return -99999;
        }

        if (p == q){
            return arr[p];
        }

        int r = randomPartition(arr, p, q);

        return 0;
    }

    private static int randomPartition(int[] arr, int p, int q) {
        return 0;
    }
}
