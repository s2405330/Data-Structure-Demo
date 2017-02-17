package com.zhouchaoran.datastructure.tree.forestandtree;

import com.zhouchaoran.datastructure.tree.BaseTree;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc: 树  存储结构  双亲链表表示法
 * <p>
 * 双亲链表表示法利用树中每个结点的双亲唯一性，在存储结点信息的同时，
 * 为每个结点附设一个指向其双亲的指针parent，惟一地表示任何-棵树。
 */

public class Tree implements BaseTree {

    //top结点没有父节点
    private Node topNode;

    @Override
    public void addElement(int x) {

    }

    @Override
    public boolean deleteElement(int x) {
        return false;
    }

    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String inOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    private class Node {
        protected int data;
        public Node parentNode;

        public Node(int data, Node parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
