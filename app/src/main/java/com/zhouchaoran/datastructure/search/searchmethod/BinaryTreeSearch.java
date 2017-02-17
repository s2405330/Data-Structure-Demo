package com.zhouchaoran.datastructure.search.searchmethod;

import com.zhouchaoran.datastructure.tree.binarytree.BinaryTree;

import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc: 当用线性表作为表的组织形式时，可以有三种查找法。
 * 其中以二分查找效率最高。但由于二分查找要求表中结点按关键字有序，且不能用链表作存储结构，
 * 因此，当表的插入或删除操作频繁时，为维护表的有序性，势必要移动表中很多结点。
 * 这种由移动结点引起的额外时间开销，就会抵消二分查找的优点。也就是说，二分查找只适用于静态查找表。
 * 若要对动态查找表进行高效率的查找，可采用下面介绍的几种特殊的二叉树或树作为表的组织形式。
 * 不妨将它们统称为树表。下面将分别讨论在这些树表上进行查找和修改操作的方法。
 * <p>
 * ①若它的左子树非空，则左子树上所有结点的值均小于根结点的值；
 * ②若它的右子树非空，则右子树上所有结点的值均大于根结点的值；
 * ③左、右子树本身又各是一棵二叉排序树。
 * 　　上述性质简称二叉排序树性质(BST性质)，故二叉排序树实际上是满足BST性质的二叉树。
 */

public class BinaryTreeSearch extends BaseSearch {

    private BinaryTree mBinaryTree;

    public BinaryTreeSearch(int[] arrays) {
        super(arrays);
        init(this.arrays);
    }


    public BinaryTreeSearch(List<Integer> datas) {
        super(datas);
        init(this.arrays);
    }

    private void init(int[] arrays) {
        mBinaryTree = new BinaryTree();
        for (int i = 0; i < arrays.length; i++) {
            mBinaryTree.addElement(arrays[i]);
        }
    }

    @Override
    public int search(int x) {
        return 0;
    }
}
