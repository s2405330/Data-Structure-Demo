package com.zhouchaoran.datastructure.linearstructure.linearlist;

import java.util.LinkedList;

/**
 * Created by zhouchaoran on 2017/2/7.
 *
 * @desc: 双链表由头指针head惟一确定的。
 * 带头结点的双链表的某些运算变得方便。
 * 将头结点和尾结点链接起来，为双（向）循环链表。
 */
public class DoubleLinkList implements BaseLinearList {

    private int length;
    private Node tempBefore, tempNext;
    private Node firstNode, lastNode;//头结点
    private Node tempNode;
    private LinkedList mLinkedList;

    public DoubleLinkList() {
        initList();
    }

    @Override
    public void initList() {
        firstNode = null;
        length = 0;
    }

    @Override
    public int listLength() {
        return length;
    }

    @Override
    public int getNode(int i) {
        return 0;
    }

    @Override
    public int locateNode(int t) {
        return 0;
    }

    @Override
    public void insertList(int t, int i) {
        //addFirst(t);
//addLast(t);
        if (i > length || i < 0) {
            return;
        }
        Node node = getTruthNode(t);
        Node addNode = new Node(node, null, t);
        firstNode = addNode;
        if (length == 0){
            lastNode = addNode;
        } else if (node == null){
            lastNode = addNode;
        } else {
            addNode.next = node.next;
        }
        length++;
    }

    private Node getTruthNode(int i) {
        int index = 0;
        tempNode = firstNode;
        while (tempNode != null && index != i) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    @Override
    public void deleteList(int i) {

    }

    public void addFirst(int data) {
        Node f = firstNode;
        Node node = new Node(null, f, data);
        firstNode = node;
        if (f == null) {
            //list为空 第一次添加
//            tempNext =
            lastNode = node;
        } else {
            //list不为空
            f.prior = node;
        }
        length++;
    }

    public void addLast(int data) {
        Node f = lastNode;
        Node node = new Node(f, null, data);
        lastNode = node;
        if (f == null) {
            firstNode = node;
        } else {
            f.next = node;
        }
        length++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("DoubleLinkList:{" + "datas=");
        tempNode = firstNode;
        while (tempNode != null) {
            builder.append(tempNode.data + ",");
            tempNode = tempNode.next;
        }
        return builder.toString() + "}";
    }

    private class Node {
        public Node prior, next;
        public int data;

        public Node(Node prior, Node next, int data) {
            this.prior = prior;
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }
}
