package com.zhouchaoran.datastructure.sorting.sortmethod;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc: by 算法导论
 * 在线性时间内的排序
 * for i = 0 to k          O(k)
 * do C[i] = 0
 * for j = 0 to n             O(n)
 * do C[A[j]] = C[A[j]] + 1
 * for i = 2 to k              O(k)
 * do C[i] = C[i] + C[i-1]
 * for j = n down to 1         O(n)
 * do B[C[A[j]]] = A[j]
 * C[A[j]] = C[A[j]] - 1
 * <p>
 * C[i] 用来记录某些数值出现的频率 所以最开始初始化了.....
 * <p>
 * 梨子：
 * A = 4,1,3,4,3   由于数组里面所有的值都是1-4之间的  所以C数组里只有4个值 长度为4最开始均设置为0
 * <p>
 * 总共时间是O(k+n)所以k比较小的时候O(n)比较好
 * 处理字节长度为1 这个就比较好 要是32位 k就会非常大 并且数组也很浪费空间
 */
public class CountSort extends BaseSort {

    private int[] arrCount;
    private int[] backArrays;

    @Override
    public void sort(int[] arrays) {
        if (arrays.length <= 0) {
            throw new RuntimeException("array is empty");
        }
        int k = getRange(arrays);
        arrCount = new int[k + 1];
        backArrays = new int[arrays.length];
        if (k <= 0) {
            throw new RuntimeException("arrays range is wrong");
        }
        //初始化计数器数组
        for (int i = 0; i < k; i++) {
            arrCount[i] = 0;
        }
        //计数
        for (int i = 0; i < arrays.length; i++) {
            arrCount[arrays[i]]++;
        }
        //将计数器数组所有的值相加
        for (int i = 1; i <= k; i++) {
            arrCount[i] += arrCount[i - 1];
        }
        for (int i = arrays.length - 1; i >= 0; i--) {
            backArrays[arrCount[arrays[i]] - 1] = arrays[i];
            arrCount[arrays[i]]--;
        }
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = backArrays[i];
        }
    }

    private void changeArrays(int[] arrays) {
        arrays = new int[5];
        arrays[0] = 4;
        arrays[1] = 1;
        arrays[2] = 3;
        arrays[3] = 4;
        arrays[4] = 3;
    }

    public int getRange(int[] arrays) {
        int range = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (range < arrays[i]) {
                range = arrays[i];
            }
        }
        return range;
    }
}
