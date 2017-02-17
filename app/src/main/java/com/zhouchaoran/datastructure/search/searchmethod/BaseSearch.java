package com.zhouchaoran.datastructure.search.searchmethod;

import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc:
 */

public abstract class BaseSearch {

    protected int[] arrays;

    public BaseSearch(int[] arrays) {
        this.arrays = arrays;
    }

    public BaseSearch(List<Integer> datas) {
        this.arrays = new int[datas.size()];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = datas.get(i);
        }
    }

    public int times = 0;

    public abstract int search(int x);

}
