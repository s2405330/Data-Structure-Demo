package com.zhouchaoran.datastructure.string;

/**
 * Created by zhouchaoran on 2017/2/9.
 *
 * @desc:串（又称字符串）是一种特殊的线性表，它的每个结点仅由一个字符组成。
 *
 * 串（String）是零个或多个字符组成的有限序列。一般记为
 * S="a1a2……an"
 * 　其中
 * 　①S是串名
 * 　②双引号括起的字符序列是串值；
 * 　　  将串值括起来的双引号本身不属于串,它的作用是避免串与常数或与标识符混淆。
 * 【例】"123"是数字字符串，它不同于整常数123
 * 【例】"xl"是长度为2的字符串，而xl通常表示一个标识符。
 * 　③ai（1≤i≤n）可以是字母、数字或其它字符；
 * 　④串中所包含的字符个数称为该串的长度。
 */

public class DataString {

    private int length;
    private char[] datas;
    String mString;

    public DataString() {
        init();
    }

    public DataString(char[] datas) {
        init();
        this.datas = datas;
    }

    public void init(){
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public DataString copyDataString(DataString dataString){
        DataString copyString = new DataString();

        return copyString;
    }
}
