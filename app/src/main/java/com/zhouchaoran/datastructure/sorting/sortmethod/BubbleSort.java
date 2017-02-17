package com.zhouchaoran.datastructure.sorting.sortmethod;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc:
 */

public class BubbleSort extends BaseSort {
    @Override
    public void sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i -1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    swap(arrays, j, j + 1);
                }
            }
        }
    }
}
