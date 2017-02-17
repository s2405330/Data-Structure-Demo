package com.zhouchaoran.datastructure.tree.binarytree;

import com.zhouchaoran.datastructure.tree.BaseTree;

import java.util.TreeSet;

/**
 * Created by zhouchaoran on 2017/2/9.
 *
 * @desc: 二叉树
 * <p>
 * 二叉树(BinaryTree)是n(n≥0)个结点的有限集，它或者是空集(n=0)，或者由一个根结点及两棵互不相交的、分别称作这个根的左子树和右子树的二叉树组成。
 * <p>
 * 性质1 二叉树第i层上的结点数目最多为2i-1(i≥1)。
 * <p>
 * 性质2 深度为k的二叉树至多有2k-1个结点(k≥1)。
 * <p>
 * 性质3 在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点数为n2，则no=n2+1。
 * <p>
 * <p>
 * 一棵深度为k且有2k-1个结点的二又树称为满二叉树。
 * 满二叉树的特点：
 * 　（1）	每一层上的结点数都达到最大值。即对给定的高度，它是具有最多结点数的二叉树。
 * 　（2）	满二叉树中不存在度数为1的结点，每个分支结点均有两棵高度相同的子树，且树叶都在最下一层上。
 * <p>
 * 若一棵二叉树至多只有最下面的两层上结点的度数可以小于2，并且最下一层上的结点都集中在该层最左边的若干位置上，则此二叉树称为完全二叉树。
 * 特点：
 * （1）	满二叉树是完全二叉树，完全二叉树不一定是满二叉树。
 * （2）	在满二叉树的最下一层上，从最右边开始连续删去若干结点后得到的二叉树仍然是一棵完全二叉树。
 * （3）	在完全二叉树中，若某个结点没有左孩子，则它一定没有右孩子，即该结点必是叶结点。
 * <p>
 * 性质4  具有n个结点的完全二叉树的深度为
 * lg(n+1)或lg(n)+1
 * <p>
 * <p>
 * 对完全二叉树而言，顺序存储结构既简单又节省存储空间。
 * 一般的二叉树采用顺序存储结构时，虽然简单，但易造成存储空间的浪费。
 * 最坏的情况下，一个深度为k且只有k个结点的右单支树需要2k-1个结点的存储空间。
 * 在对顺序存储的二叉树做插入和删除结点操作时，要大量移动结点。
 * <p>
 * 存储方式：
 * 顺序存储结构：该方法是把二叉树的所有结点按照一定的线性次序存储到一片连续的存储单元中。结点在这个序列中的相互位置还能反映出结点之间的逻辑关系。
 * 链式存储结构：二叉树的每个结点最多有两个孩子。用链接方式存储二叉树时，每个结点除了存储结点本身的数据外，
 * 还应设置两个指针域lchild和rchild，分别指向该结点的左孩子和右孩子
 */

public class BinaryTree implements BaseTree {

    private Node topNode;
    private int length;
    TreeSet mTreeSet;
    private boolean isNeedDelete;
//    private Node

    public BinaryTree() {
        initTree();
    }

    private void initTree() {
        topNode = null;
        length = 0;
    }

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
        //额 实现了遍历 找到了自然就删掉了  （放屁 主要四自己不会实现）  实现了  感觉还是别扭
        isNeedDelete = true;
        if (findElement(x)){
            return true;
        }
        return false;
    }

    private boolean findElement(final int x) {
        final boolean[] isFindTemp = new boolean[1];
        preOrderWithCallback(new IOrderListener() {

            @Override
            public void onOrder(Node node) {
                if (node.data == x) {
                    isFindTemp[0] = true;
                    if (isNeedDelete){
                        deleteElementOperate(node);
                    }
                }
            }
        });
        return isFindTemp[0];
    }

    private void deleteElementOperate(Node node){
        //删除

    }

    @Override
    public String preOrder() {
        //左中右
        final StringBuilder stringBuilder = new StringBuilder("前序：{");
        preOrder(topNode, new IOrderListener() {
            @Override
            public void onOrder(Node node) {
                stringBuilder.append(node.data).append(",");
            }
        });
        return stringBuilder.toString() + "}";
    }

    private void preOrderWithCallback(IOrderListener listener) {
        preOrder(topNode, listener);
    }

    private void preOrder(Node node, IOrderListener listener) {
        if (node == null) {
            return;
        }
        preOrder(node.leftNode, listener);
        listener.onOrder(node);
        preOrder(node.rightNode, listener);
    }

    @Override
    public String inOrder() {
        //中左右
        final StringBuilder stringBuilder = new StringBuilder("中序：{");
        inOrder(topNode, new IOrderListener() {
            @Override
            public void onOrder(Node node) {
                stringBuilder.append(node.data + ",");
            }
        });
        return stringBuilder.toString() + "}";
    }

    private void inOrder(Node node, IOrderListener listener) {
        if (node == null) {
            return;
        }
        listener.onOrder(node);
        inOrder(node.leftNode, listener);
        inOrder(node.rightNode, listener);
    }

    @Override
    public String postOrder() {
        //左右中
        final StringBuilder stringBuilder = new StringBuilder("后序：{");
        postOrder(topNode, new IOrderListener() {
            @Override
            public void onOrder(Node node) {
                stringBuilder.append(node.data + ",");
            }
        });
        return stringBuilder.toString() + "}";
    }

    private void postOrder(Node node, IOrderListener listener) {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode, listener);
        postOrder(node.rightNode, listener);
        listener.onOrder(node);
    }

    private class Node {

        public Node leftNode, rightNode;
        protected int data;

        public Node(int data, Node leftNode, Node rightNode) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * 遍历每一个元素时候的回调
     */
    public interface IOrderListener {
        void onOrder(Node node);
    }
}
