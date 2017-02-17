package com.zhouchaoran.datastructure.sorting.sortmethod;

/**
 * Created by zhouchaoran on 2017/2/4.
 * 归并排序
 * <p>
 * split each element into partitions of size 1
 * recursively merge adjancent partitions
 * for i = leftPartStartIndex to rightPartLastIndex inclusive
 * if leftPartHeadValue <= rightPartHeadValue
 * copy leftPartHeadValue
 * else: copy rightPartHeadValue; Increase InvIdx
 * copy elements back to original array
 * <p>
 * by 算法导论：
 * merge sort A[1...n]
 * 1. if n=1, done      耗费常熟时间θ（1）
 * 2. Recursively(递归的) sort
 * A[1...(n/2)] and A[((n/2)+1)...n]    耗费时间 2T(n/2)
 * 3. Merge 2 sorted list       耗费θ(n)
 *
 * 这种方法叫做递归树方法
 * T(n) = 2T(n/2) + cn + n(常量省略);
 * T(n) =                cn                     cn耗费时间
 *              T(n/2)       T(n/2)             cn耗费时间
 *           T(n/4)T(n/4)  T(n/4)T(n/4)
 *                  and so on....
 *       θ(1).............................      θ(n)因为这里面要执行合并运算
 *  首先就应该知道树的深度为lgn
 *  所以
 *  T(n) = cn*(lgn) + θ(n)(<-低阶项)
 *       = θ(nlgn)
 */
public class MergeSort extends BaseSort {
    @Override
    public void sort(int[] arrays) {
        int[] arrayCopy = new int[arrays.length];
        topDownMergeSort(arrays, arrayCopy, arrays.length);
    }

    private void topDownMergeSort(int[] array, int[] arrayCopy, int n) {
        /**
         * arraycopy(被复制的数组, 从第几个元素开始复制, 要复制到的数组, 从第几个元素开始粘贴, 一共需要复制的元素个数);
         */

        System.arraycopy(array, 0, arrayCopy, 0, n);
        topDownSplitMerge(arrayCopy, 0, n, array);
    }

    private void topDownSplitMerge(int[] arrayCopy, int beginIndex, int endIndex, int[] array) {
        if (endIndex - beginIndex < 2) {
            return;
        }
        int middleIndex = (endIndex + beginIndex) >>> 1;
        topDownSplitMerge(array, beginIndex, middleIndex, arrayCopy);
        topDownSplitMerge(array, middleIndex, endIndex, arrayCopy);
        topDownMerge(arrayCopy, beginIndex, middleIndex, endIndex, array);
    }

    private void topDownMerge(int[] array1, int beginIndex, int middleIndex, int endIndex, int[] array2) {
        int i = beginIndex;
        int j = middleIndex;
        for (int k = beginIndex; k < endIndex; k++) {
            if (i < middleIndex && (j >= endIndex || array1[i] <= array1[j])) {
                array2[k] = array1[i];
                i = i + 1;
            } else {
                array2[k] = array1[j];
                j = j + 1;
            }
        }
    }
}
