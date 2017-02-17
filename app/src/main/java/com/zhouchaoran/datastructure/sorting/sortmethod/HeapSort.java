package com.zhouchaoran.datastructure.sorting.sortmethod;

/**
 * Created by zhouchaoran on 2017/2/17.
 *
 * @desc: n个元素的序列{k1，k2，…,kn}当且仅当满足下列关系之一时，称之为堆。
 * <p>
 * 情形1：ki <= k2i 且ki <= k2i+1 （最小化堆或小顶堆）
 * <p>
 * 情形2：ki >= k2i 且ki >= k2i+1 （最大化堆或大顶堆）
 * <p>
 * 其中i=1,2,…,n/2向下取整;
 * <p>
 * 堆的存储
 * 一般用数组来表示堆，若根结点存在序号0处，
 * i结点的父结点下标就为(i-1)/2。
 * i结点的左右子结点下标分别为2*i+1和2*i+2。
 */

public class HeapSort extends BaseSort {

    private int[] array;

    private int parentIndex(int i) {
        return (i - 1) >>> 1;
    }

    private int leftIndex(int i) {
        return (i + 1) << 1;
    }

    private int rightIndex(int i) {
        return (i + 2) << 1;
    }

    @Override
    public void sort(int[] arrays) {
        buildHeap(arrays);
    }

    private void buildHeap(int[] arrays) {
        for (int i = 0; i < arrays.length; i++){
//            if ()
        }
    }

}
