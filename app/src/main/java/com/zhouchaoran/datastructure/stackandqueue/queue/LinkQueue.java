package com.zhouchaoran.datastructure.stackandqueue.queue;

/**
 * Created by zhouchaoran on 2017/2/8.
 *
 * @desc: 和链栈类似，无须考虑判队满的运算及上溢。
 * 在出队算法中，一般只需修改队头指针。但当原队中只有一个结点时，该结点既是队头也是队尾，故删去此结点时亦需修改尾指针，且删去此结点后队列变空。
 * 以上讨论的是无头结点链队列的基本运算。和单链表类似，为了简化边界条件的处理，在队头结点前也可附加一个头结点，增加头结点的链队列的基本运算
 */

public class LinkQueue extends BaseQueue {

    private Node frontNode, rearNode;

    @Override
    protected void initQueue() {
        frontNode = rearNode = null;
    }

    @Override
    protected boolean queueEmpty() {
        return frontNode == null && rearNode == null;
    }

    @Override
    protected boolean queueFull() {
        /**跟链表一样无法判断*/
        return false;
    }

    @Override
    protected void enQueue(int x) {
        Node node = new Node(x);
        if (queueEmpty()) {
            frontNode = rearNode = node;
        } else {
            rearNode.next = node;
            rearNode = node;
        }
    }

    @Override
    protected int deQueue() {
        if (queueEmpty()) {
            return -999999;
        }
        int value = frontNode.data;

        if (frontNode == rearNode) {
            initQueue();
        } else {
            frontNode = frontNode.next;
        }

        return value;
    }

    @Override
    protected int queueFront() {
        if (queueEmpty()) {
            return -99999;
        }
        return frontNode.data;
    }

    @Override
    public String toString() {
        if (queueEmpty()) {
            return "";
        }
        Node tempNode = frontNode;
        StringBuilder builder = new StringBuilder("LinkQueue{" + "frontNode=");
        do {
            builder.append(tempNode.data + ",");
            tempNode = tempNode.next;
        } while (tempNode != null);
        return builder + "";
    }

    private class Node {
        protected int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
