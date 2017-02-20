package com.zhouchaoran.datastructure.sorting.sortmethod;

import com.zhouchaoran.datastructure.logmodule.common.logger.Log;

import java.util.Arrays;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc:
 */

public class SelectorSort extends BaseSort {


    public void sort() {
//        do
//            swapped = false
//        for i = 1 to indexOfLastUnsortedElement
//        if leftElement > rightElement
//        swap(leftElement, rightElement)
//        swapped = true; swapCounter++
//        while swapped


    }

    @Override
    public void sort(int[] arrays) {
        if (arrays == null || arrays.length <= 0) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arrays[j] > arrays[i]) {
                    swap(arrays, i, j);
                }
            }
            Log.d("selectsort", Arrays.toString(arrays));
        }
    }
}
