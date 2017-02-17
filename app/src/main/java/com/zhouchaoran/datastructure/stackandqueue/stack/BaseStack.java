package com.zhouchaoran.datastructure.stackandqueue.stack;

/**
 * Created by zhouchaoran on 2017/2/7.
 *
 * @desc:
 * （1）InitStack（S）
 * 　构造一个空栈S。
 * （2）StackEmpty（S）
 * 　判栈空。若S为空栈，则返回TRUE，否则返回FALSE。
 * （3）StackFull（S）
 * 　判栈满。若S为满栈，则返回TRUE，否则返回FALSE。
 * 注意：
 * 　    该运算只适用于栈的顺序存储结构。
 * （4）Push（S，x）
 * 　进栈。若栈S不满，则将元素x插入S的栈顶。
 * （5）Pop（S）
 * 　退栈。若栈S非空，则将S的栈顶元素删去，并返回该元素。
 * （6）StackTop（S）
 * 　取栈顶元素。若栈S非空，则返回栈顶元素，但不改变栈的状态。
 */

public interface BaseStack {

    void initStack();

    boolean stackEmpty();

    boolean stackFull();

    void push(int x);

    int pop();

    int stackTop();

}
