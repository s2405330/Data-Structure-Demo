package com.zhouchaoran.datastructure.stackandqueue.queue;

import java.util.Arrays;

/**
 * Created by zhouchaoran on 2017/2/8.
 *
 * @desc:为充分利用向量空间，克服"假上溢"现象的方法是：将向量空间想象为一个首尾相接的圆环，并称这种向量为循环向量。 循环队列中，由于入队时尾指针向前追赶头指针；出队时头指针向前追赶尾指针，造成队空和队满时头尾指针均相等。
 * 因此，无法通过条件front==rear来判别队列是"空"还是"满"。
 * <p>
 * 解决这个问题的方法至少有三种：
 * ① 另设一布尔变量以区别队列的空和满；
 * ② 少用一个元素的空间。约定入队前，测试尾指针在循环意义下加1后是否等于头指针，若相等则认为队满（注意：rear所指的单元始终为空）；
 * ③使用一个计数器记录队列中元素的总数（即队列长度）。
 */

public class CircularQueue extends BaseQueue {
    private int[] datas;
    private int length;

    private static final int VOLUME = 5;//设置队列容量为0
    //    private static final int MAX_VOLUME = 10;//最大队列容量为5
    private int front, rear;

    public CircularQueue() {
        initQueue();
    }

    @Override
    protected void initQueue() {
        datas = new int[VOLUME];
        length = 0;
    }

    @Override
    protected boolean queueEmpty() {
        return front == rear;
    }

    @Override
    protected boolean queueFull() {
        return front != rear && ((front % VOLUME) == (rear % VOLUME));
    }

//    private void extendsSize() {
//        length = length + 1;
//        datas = Arrays.copyOf(datas, length);
////        System.arraycopy(datas, );
//    }
//
//    private void cutSize() {
//        length = length - 1;
//        int newDatas[] = new int[length];
//        System.arraycopy(datas, 0, newDatas, 0, length);
//        datas = newDatas;
//    }

    @Override
    protected void enQueue(int x) {
        if (queueFull()) {
            //假上溢
            /*
            由于入队和出队操作中，头尾指针只增加不减小，致使被删元素的空间永远无法重新利用。
            当队列中实际的元素个数远远小于向量空间的规模时，也可能由于尾指针已超越向量空间的上界而不能做入队操作。
            该现象称为"假上溢"现象。
            避免方式参考循环队列。
             */
            return;
        }

        //extendsSize();
        int temp = rear % VOLUME;
        datas[temp] = x;
        rear++;
        length++;
    }

    @Override
    protected int deQueue() {
        if (queueEmpty()) {
            return -99999;
        }
        int temp = front % VOLUME;
        int value = datas[temp];
        front++;
        length--;
//        cutSize();
        return value;
    }

    @Override
    protected int queueFront() {
        if (queueEmpty()) {
            return -999999;
        }
        return datas[front];
    }

    @Override
    public String toString() {
        int[] arrayCopy = new int[length];
        if (queueEmpty()) {
            return "";
        }
        int m = 0;
        for (int i = front; i < rear; i++) {
            arrayCopy[m] = datas[i % VOLUME];
            m++;
        }

        return "SequenceQueue{" +
                "datas=" + Arrays.toString(arrayCopy) +
                '}';
    }
}
