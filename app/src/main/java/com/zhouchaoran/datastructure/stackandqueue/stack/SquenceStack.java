package com.zhouchaoran.datastructure.stackandqueue.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhouchaoran on 2017/2/7.
 *
 * @desc: ①顺序栈中元素用向量存放
 * ②栈底位置是固定不变的，可设置在向量两端的任意一个端点
 * ③栈顶位置是随着进栈和退栈操作而变化的，用一个整型量top（通常称top为栈顶指针）来指示当前栈顶位置
 */

public class SquenceStack implements BaseStack {

    //设置为动态改变容量
    private static final int CAPABILITIES = 0;//设置栈容量为0
    private static final int MAX_VOLUME = 5;//最大栈容量为5
    private int size;
    private int top;
    private int[] datas;

    public SquenceStack() {
        initStack();
    }

    public SquenceStack(int size) {
        initStack();
        this.size = size;
    }

    private void extendsSize() {
        size = size + 1;
        datas = Arrays.copyOf(datas, size);
    }

    private void cutSize() {
        size = size - 1;
        int newDatas[] = new int[size];
        System.arraycopy(datas, 0, newDatas, 0, size);
        datas = newDatas;
    }

    @Override
    public void initStack() {
        datas = new int[]{};
        top = 0;
        size = CAPABILITIES;
    }

    public int size() {
        return top;
    }

    @Override
    public boolean stackEmpty() {
        return size == 0;
    }

    @Override
    public boolean stackFull() {
        return size >= MAX_VOLUME;
    }

    @Override
    public void push(int x) {
        if (stackFull()) {
            return;
        }
        extendsSize();
        datas[top] = x;
        top++;
    }

    @Override
    public int pop() {
        if (stackEmpty()) {
            return -1;
        }
        int value = datas[--top];
        cutSize();
        return value;
    }

    @Override
    public int stackTop() {
        return datas[top];
    }

    @Override
    public String toString() {
        return "SquenceStack{" +
                "datas=" + Arrays.toString(datas) +
                '}';
    }
}
