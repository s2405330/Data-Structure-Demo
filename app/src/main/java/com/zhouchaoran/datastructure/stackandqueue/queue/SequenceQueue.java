package com.zhouchaoran.datastructure.stackandqueue.queue;

import java.util.Arrays;

/**
 * Created by zhouchaoran on 2017/2/8.
 *
 * @desc:
 */

public class SequenceQueue extends BaseQueue {

    private int[] datas;
    private int length;

    private static final int CAPABILITIES = 0;//设置队列容量为0
    private static final int MAX_VOLUME = 10;//最大队列容量为5
    private int front, rear;

    public SequenceQueue() {
        initQueue();
    }

    @Override
    protected void initQueue() {
        datas = new int[]{};
        length = 0;
    }

    @Override
    protected boolean queueEmpty() {
        return front == rear;
    }

    @Override
    protected boolean queueFull() {
        return rear == MAX_VOLUME-1;
    }

    private void extendsSize() {
        length = length + 1;
        datas = Arrays.copyOf(datas, length);
//        System.arraycopy(datas, );
    }

    private void cutSize() {
        length = length - 1;
        int newDatas[] = new int[length];
        System.arraycopy(datas, 0, newDatas, 0, length);
        datas = newDatas;
    }

    @Override
    protected void enQueue(int x) {
        if (queueFull()){
            //假上溢
            /*
            由于入队和出队操作中，头尾指针只增加不减小，致使被删元素的空间永远无法重新利用。
            当队列中实际的元素个数远远小于向量空间的规模时，也可能由于尾指针已超越向量空间的上界而不能做入队操作。
            该现象称为"假上溢"现象。
            避免方式参考循环队列。
             */
            return;
        }

        extendsSize();
        datas[rear++] = x;

    }

    @Override
    protected int deQueue() {
        if (queueEmpty()){
            return -99999;
        }
        int value = datas[front++];
//        cutSize();
        return value;
    }

    @Override
    protected int queueFront() {
        if (queueEmpty()){
            return -999999;
        }
        return datas[front];
    }

    @Override
    public String toString() {
        int[] arrayCopy = new int[rear-front];
        if (queueEmpty()){
            return "";
        }
        int m = 0;
        for (int i = front; i < rear; i++) {
            arrayCopy[m] = datas[i];
            m++;
        }

        return "SequenceQueue{" +
                "datas=" + Arrays.toString(arrayCopy) +
                '}';
    }
}
