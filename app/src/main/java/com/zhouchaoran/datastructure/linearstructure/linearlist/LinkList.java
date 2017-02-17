package com.zhouchaoran.datastructure.linearstructure.linearlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/6.
 *
 * @desc: 单链表
 * <p>
 * ┌──┬──┬──┬──┐
 * │data │next │
 * └──┴──┴──┴──┘
 * 　data域--存放结点值的数据域
 * 　next域--存放结点的直接后继的地址（位置）的指针域（链域）
 * 注意：
 * 　 ①链表通过每个结点的链域将线性表的n个结点按其逻辑顺序链接在一起的。
 * 　②每个结点只有一个链域的链表称为单链表（Single Linked List）。
 */
public class LinkList implements BaseLinearList {

    private int listSize = 100;
    private int length = 0;

    private Node currentNode, tempNode;
    private Node firstNode;//头结点

    private List mList = new LinkedList();

    public LinkList() {
        initList();
    }

    @Override
    public void initList() {
        this.firstNode = null;
        length = 0;
    }

    @Override
    public int listLength() {
        return length;
    }

    @Override
    public int getNode(int i) {
        //getNodeByIndex
        if (i >= length) {
            throw new IndexOutOfBoundsException("输入的角标越界i=" + i + "长度length=" + length);
        }
        tempNode = firstNode;
        int index = 0;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            index++;
            if (index == i) {
                break;
            }
        }
        return tempNode.data;
    }

//    public int getNodeByValue(int value) {
//        int index = 0;
//        tempNode = firstNode;
//        while (value != tempNode.data){
//            if ()
//        }
//        return 0;
//    }

    @Override
    public int locateNode(int t) {
        int index = -1;
        if (length == 0) {
            return index;
        }
        tempNode = firstNode;
        while (t != tempNode.data) {
            tempNode = tempNode.nextNode;
            if (tempNode == null) {
                break;
            }
            index++;
        }
        return index;
    }

    @Override
    public void insertList(int t, int i) {
        addFirst(t);
//        addLast(t);
    }

    @Override
    public void deleteList(int i) {

    }

    /**
     * 头插法
     *
     * @param data
     */
    public void addFirst(int data) {
        Node node = new Node(data);
        node.nextNode = this.firstNode;
        this.firstNode = node;
        length++;
    }

    /**
     * 尾插法
     *
     * @param data
     */
    public void addLast(int data) {
        Node node = new Node(data);
        if (firstNode == null) {
            firstNode = node;
            currentNode = firstNode;
        } else {
            currentNode.nextNode = node;
            currentNode = currentNode.nextNode;
        }
        length++;
    }

    /**
     * 内部节点
     */
    private class Node {
        protected int data;//数据域
        public Node nextNode;//指针域 指向下一个节点

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LinkList:{" + "datas=");
        tempNode = firstNode;
        while (tempNode != null) {
            builder.append(tempNode.data + ",");
            tempNode = tempNode.nextNode;
        }
        return builder.toString() + "}";
    }

}
