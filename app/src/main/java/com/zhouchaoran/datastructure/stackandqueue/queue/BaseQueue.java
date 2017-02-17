package com.zhouchaoran.datastructure.stackandqueue.queue;

import com.zhouchaoran.datastructure.stackandqueue.stack.BaseStack;

/**
 * Created by zhouchaoran on 2017/2/8.
 *
 * @desc:
 * （1）InitQueue（Q）
 *　置空队。构造一个空队列Q。
 *
 *（2）QueueEmpty（Q）
 *　判队空。若队列Q为空，则返回真值，否则返回假值。
 *
 *（3） QueueFull（Q）
 *　判队满。若队列Q为满，则返回真值，否则返回假值。
 *注意：
 *　此操作只适用于队列的顺序存储结构。
 *
 *（4） EnQueue（Q，x）
 *　若队列Q非满，则将元素x插入Q的队尾。此操作简称入队。
 *
 *（5） DeQueue（Q）
 *　若队列Q非空，则删去Q的队头元素，并返回该元素。此操作简称出队。
 *
 *（6） QueueFront（Q）
 *　若队列Q非空，则返回队头元素，但不改变队列Q的状态。
 */

public abstract class BaseQueue implements BaseStack {

    protected abstract void initQueue();

    protected abstract boolean queueEmpty();

    protected abstract boolean queueFull();

    protected abstract void enQueue(int x);

    protected abstract int deQueue();

    protected abstract int queueFront();

    @Override
    public void initStack() {
        initQueue();
    }

    @Override
    public boolean stackEmpty() {
        return queueEmpty();
    }

    @Override
    public boolean stackFull() {
        return queueFull();
    }

    @Override
    public void push(int x) {
        enQueue(x);
    }

    @Override
    public int pop() {
        return deQueue();
    }

    @Override
    public int stackTop() {
        return queueFront();
    }


}
