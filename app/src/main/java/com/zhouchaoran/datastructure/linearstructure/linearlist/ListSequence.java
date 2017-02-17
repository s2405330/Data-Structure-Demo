package com.zhouchaoran.datastructure.linearstructure.linearlist;

import com.zhouchaoran.datastructure.linearstructure.linearlist.BaseLinearList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/5.
 *
 * @desc: 顺序表
 * <p>
 * 即把线性表的结点按逻辑次序依次存放在一组地址连续的存储单元里的方法。
 * <p>
 * 顺序表是用向量实现的线性表，向量的下标可以看作结点的相对地址。因此顺序表的的特点是逻辑上相邻的结点其物理位置亦相邻。
 * <p>
 * 用向量这种顺序存储的数组类型存储线性表的元素外，顺序表还应该用一个变量来表示线性表的长度属性，因此用结构类型来定义顺序表类型。
 * 存放线性表结点的向量空间的大小ListSize应仔细选值，使其既能满足表结点的数目动态增加的需求，又不致于预先定义过大而浪费存储空间。
 * 由于C语言中向量的下标从0开始，所以若L是SeqList类型的顺序表，则线性表的开始结点a1和终端结点an分别存储在L．data[0]和L．Data[L．length-1]中。
 * 若L是SeqList类型的指针变量，则a1和an分别存储在L-＞data[0]和L-＞data[L-＞length-1]中。
 */

public class ListSequence implements BaseLinearList {


    private int listSize = 100;//额  由于显示的问题  java是默认为0  所以不方便看长度  这里特意改成自增的  但是水平有限改不了换了实现方式
    private int[] datas = new int[listSize];
    private int length = 0; // 线性表长度
    private List mList = new ArrayList();

    public ListSequence() {
        initList();
    }

    @Override
    public void initList() {
        length = 0;
    }

    @Override
    public int listLength() {
        return length;
    }

    @Override
    public int getNode(int i) {

        if (i < 0 || i > length - 1) {
            throw new IllegalArgumentException("传入了错误的参数");
        }
        return datas[i];
    }

    @Override
    public int locateNode(int integer) {
        return Arrays.binarySearch(datas, integer);
    }

    @Override
    public void insertList(int integer, int i) {
        if (i > listSize) {
            throw new RuntimeException("表空间溢出 表空间：" + listSize + "所选择的i=" + i);
        }
        if (i > length || i < 0) {
            throw new IllegalArgumentException("传入的i=" + i + "超出数组最大长度length=" + length);
        }
//        addLength();
        for (int j = length - 1; j >= i; j--) {
            datas[j + 1] = datas[j];
        }
        datas[i] = integer;
        length += 1;
    }

//    private void addLength() {
//        Arrays.copyOf(datas, length + 1);
//        length += 1;
//    }
//
//    private void deleteLength() {
//        Arrays.copyOf(datas, length - 1);
//        length -= 1;
//    }

    @Override
    public void deleteList(int i) {
        if (i > listSize) {
            throw new RuntimeException("表空间溢出 表空间：" + listSize + "所选择的i=" + i);
        }
        if (i > length || i < 0) {
            throw new IllegalArgumentException("传入的i=" + i + "超出数组最大长度");
        }
        for (int j = i; j < length - 1; j++) {
            datas[j] = datas[j+1];
        }
        length -= 1;
//        deleteLength();
    }

    public boolean deleteListByElement(int integer) {
        int index = locateNode(integer);
        if (index == -1) {
            return false;
        } else {
            deleteList(index);
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ListSequence{" + "datas=");
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                builder.append(datas[i]);
            } else {
                builder.append(datas[i] + ", ");
            }
        }
        return builder.toString() + "}";
    }
}
