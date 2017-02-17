package com.zhouchaoran.datastructure.stackandqueue.stack;

/**
 * Created by zhouchaoran on 2017/2/8.
 *
 * @desc: 链栈是没有附加头结点的运算受限的单链表。栈顶指针就是链表的头指针。
 */

public class LinkStack implements BaseStack {

    private static final int MAX_VOLUME = 5;
    private int size = 0;

    private Node topNode;//栈顶元素
    private Node firstNode;//为了遍历设置的底端元素
    private Node tempNode;//为了方便遍历提供的临时变量

    public LinkStack() {
        initStack();
    }

    @Override
    public void initStack() {
        topNode = null;
    }

    @Override
    public boolean stackEmpty() {
        if (topNode == null){
            return true;
        }
        return false;
    }

    /**
     * 链栈中的结点是动态分配的，所以可以不考虑上溢，无须定义StackFull运算。
     * @return
     */
    @Override
    public boolean stackFull() {
        return false;
    }

    @Override
    public void push(int x) {
        Node node = new Node(x, topNode);
        if (stackEmpty()){
            firstNode = node;
        }
        topNode = node;
    }

    @Override
    public int pop() {
        if (stackEmpty()){
            return -9999;
        }
        Node returnNode = topNode;
        topNode = topNode.next;
        return returnNode.data;
    }

    @Override
    public int stackTop() {
        if (stackEmpty()){
            return -9999;
        }
        return topNode.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LinkStack{" + "topNode=");
        tempNode = topNode;
        while (tempNode != null){
            builder.append(tempNode.data+",");
            tempNode = tempNode.next;
        }
        return builder.toString() + "}";
    }

    /**
     * 定义一个节点
     */
    private class Node {
        public Node next;
        protected int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
