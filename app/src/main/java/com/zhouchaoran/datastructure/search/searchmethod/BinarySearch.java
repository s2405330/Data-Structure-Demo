package com.zhouchaoran.datastructure.search.searchmethod;

import com.zhouchaoran.datastructure.sorting.sortmethod.MergeSort;

import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc: <p>
 * 二分查找又称折半查找，它是一种效率较高的查找方法。
 * 　二分查找要求：线性表是有序表，即表中结点按关键字有序，并且要用向量作为表的存储结构。不妨设有序表是递增有序的。
 * <p>
 * 虽然二分查找的效率高，但是要将表按关键字排序。而排序本身是一种很费时的运算。既使采用高效率的排序方法也要花费O(nlgn)的时间。
 * 　二分查找只适用顺序存储结构。为保持表的有序性，在顺序结构里插入和删除都必须移动大量的结点。因此，二分查找特别适用于那种一经建立就很少改动、而又经常需要查找的线性表。
 * 　对那些查找少而又经常需要改动的线性表，可采用链表作存储结构，进行顺序查找。链表上无法实现二分查找。
 *
 * 二分查找在查找失败时所需比较的关键字个数不超过判定树的深度，在最坏情况下查找成功的比较次数也不超过判定树的深度。即为：
 *          lg(n+1)-1
 *
 * 　二分查找的最坏性能和平均性能相当接近。
 *          lg(n+1)
 */

public class BinarySearch extends BaseSearch {

    public BinarySearch(int[] arrays) {
        super(arrays);
    }

    public BinarySearch(List<Integer> datas) {
        super(datas);
    }

    private void sort() {
        MergeSort sort = new MergeSort();
        sort.sort(arrays);
    }

    @Override
    public int search(int x) {
        times = 0;
        sort();//先排序

//        Arrays.binarySearch()

        int low = 0, high = arrays.length - 1;
        while (low <= high) {
            times++;
            int mid = (low + high) >>> 1;
            int temp = arrays[mid];
            if (temp > x) {
                high = mid - 1;
            } else if (temp < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
