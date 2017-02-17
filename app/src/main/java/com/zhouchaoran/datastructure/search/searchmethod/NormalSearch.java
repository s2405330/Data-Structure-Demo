package com.zhouchaoran.datastructure.search.searchmethod;

import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc: <p>
 * 顺序查找的优点
 * 　算法简单，且对表的结构无任何要求，无论是用向量还是用链表来存放结点，也无论结点之间是否按关键字有序，它都同样适用。
 * <p>
 * 顺序查找的缺点
 * 　　查找效率低，因此，当n较大时不宜采用顺序查找。
 */

public class NormalSearch extends BaseSearch {


    public NormalSearch(int[] arrays) {
        super(arrays);
    }

    public NormalSearch(List<Integer> datas) {
        super(datas);
    }

    @Override
    public int search(int x) {
        times = 0;
        int i;
        for (i = 0; i < arrays.length; i++) {
            times++;
            if (x == arrays[i]) {
                break;
            }
        }
        if (i == arrays.length) {
            return -1;
        }
        return i;
    }
}
