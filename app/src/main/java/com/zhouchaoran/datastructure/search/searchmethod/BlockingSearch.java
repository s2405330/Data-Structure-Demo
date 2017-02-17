package com.zhouchaoran.datastructure.search.searchmethod;

import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc:分块查找(Blocking Search)又称索引顺序查找。它是一种性能介于顺序查找和二分查找之间的查找方法。
 *
 *
 */

public class BlockingSearch extends BaseSearch {



    public BlockingSearch(int[] arrays) {
        super(arrays);
    }

    public BlockingSearch(List<Integer> datas) {
        super(datas);
    }

    @Override
    public int search(int x) {
        return -1;
    }
}
