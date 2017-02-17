package com.zhouchaoran.datastructure.tree.binarytree;

import com.zhouchaoran.datastructure.tree.BaseTree;

/**
 * Created by zhouchaoran on 2017/2/10.
 *
 * @desc: 线索二叉树
 * n个结点的二叉链表中含有n+1个空指针域。利用二叉链表中的空指针域，存放指向结点在某种遍历次序下的前趋和后继结点的指针（这种附加的指针称为"线索"）。
 * 这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(ThreadedBinaryTree)。根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种。
 * 注意：
 * 线索链表解决了二叉链表找左、右孩子困难的问题，出现了无法直接找到该结点在某种遍历序列中的前趋和后继结点的问题。
 */

public class ThreadedBinaryTree implements BaseTree {

    private Node topNode;


    @Override
    public void addElement(int x) {
        //原文是通过前序遍历构造 感觉那个没什么卵用  这里改成同treeset
        Node newInstance = new Node(x, null, null);
        if (topNode == null) {
            //空树
            topNode = newInstance;
            return;
        }
        addElementBySort(topNode, newInstance);

    }

    private void addElementBySort(Node node, Node newInstance) {
        if (newInstance.data > node.data) {
            if (node.rightNode == null) {
                node.rightNode = newInstance;
            } else {
                addElementBySort(node.rightNode, newInstance);
            }
        } else {
            /**这里对相同数据的元素进行插入（与treeset不同）*/
            if (node.leftNode == null) {
                node.leftNode = newInstance;
            } else {
                addElementBySort(node.leftNode, newInstance);
            }
        }
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

        public Node leftNode, rightNode;
        protected int data;
        public int leftTag, rightTag;

        public Node(int data, Node leftNode, Node rightNode) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
        }

        public Node(int data, Node leftNode, Node rightNode, int leftTag, int rightTag) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
            this.leftTag = leftTag;
            this.rightTag = rightTag;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
