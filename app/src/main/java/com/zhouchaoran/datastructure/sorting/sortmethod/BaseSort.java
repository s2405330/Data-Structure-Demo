package com.zhouchaoran.datastructure.sorting.sortmethod;

import android.util.Log;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc: 额  算法导论说了很多很猛的东西 不知道记录在哪  就先记录在这里了
 * <p>
 * 存在t>0使得n->t时候 0<=n的平方<=O(n的三次方) 则记做2nd的平方=n的三次方
 * 也可以这么写：2n2∈O(n3)
 * <p>
 * 渐进关系：
 * 宏：一个在公式中的设定用来代替一些功能
 * 比如上面的O就是一个宏 可以理解为C的宏
 * f(n) = n3+O(n2)
 * 上面这个式子中存在h(n)∈O(n2) 使得f(n) = n3+h(n)成立
 * n2+O(n) = O(n2)
 * 意思就是对于任意的f(n)∈O(n)
 * 存在h(n)∈O(n)使得上式相等
 * O  类似  <=
 * Ω  类似  >=
 * θ  类似  =
 * o  相当于 <
 * ω  相当于 >
 * <p>
 * 递归关系：
 * 代换法：大多数情况有效，主要思想
 *      1.猜答案
 *      2.通过数学归纳法验证
 *      3.求出系数
 * e.g.
 * T(n) = 4T(n/2)+n   猜测θ(n^2)
 * T(1) = θ(1)
 * 假设猜测答案是θ(n^3)
 * 那么assume: T(k)<=ck^3 k<n的时候
 * 则  T(n) = 4T(n/2)+n
 *          <=4c(n/2)^3 + n
 *          =1/2(cn^3)+n
 *          <=cn^3 (c>1时候)
 *
 *
 * by 算法导论
 * 稳定性：比如
 *
 */

public abstract class BaseSort {

    public abstract void sort(int[] arrays);

    protected void swap(int[] arrays, int leftIndex, int rightIndex) {
        Log.d("swap", "交换的元素的角标是" + leftIndex + "和" + rightIndex);
        int temp;
        temp = arrays[leftIndex];
        arrays[leftIndex] = arrays[rightIndex];
        arrays[rightIndex] = temp;
    }

}
