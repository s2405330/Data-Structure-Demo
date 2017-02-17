package com.zhouchaoran.datastructure.tree;

/**
 * Created by zhouchaoran on 2017/2/9.
 *
 * @desc:
 * 树形结构是一类重要的非线性结构。树形结构是结点之间有分支，并具有层次关系的结构。它非常类似于自然界中的树。
 * 树结构在客观世界中是大量存在的，例如家谱、行政组织机构都可用树形象地表示。
 * 树在计算机领域中也有着广泛的应用，例如在编译程序中，用树来表示源程序的语法结构；
 * 在数据库系统中，可用树来组织信息；在分析算法的行为时，可用树来描述其执行过程。
 *
 * 树的递归定义：
 * 树(Tree)是n(n≥0)个结点的有限集T，T为空时称为空树，否则它满足如下两个条件：
 * (1)有且仅有一个特定的称为根(Root)的结点；
 * (2)其余的结点可分为m(m≥0)个互不相交的子集Tl，T2，…，Tm，其中每个子集本身又是一棵树，并称其为根的子树(SubTree)。
 *
 * 注意：
 * 　树的递归定义刻画了树的固有特性：一棵非空树是由若干棵子树构成的，而子树又可由若干棵更小的子树构成。
 *
 *
 * 4.树结构的基本术语
 * （1）	结点的度(Degree)
 * 　树中的一个结点拥有的子树数称为该结点的度(Degree)。
 * 　一棵树的度是指该树中结点的最大度数。
 * 　度为零的结点称为叶子(Leaf)或终端结点。
 * 　度不为零的结点称分支结点或非终端结点。
 * 　除根结点之外的分支结点统称为内部结点。
 * 　根结点又称为开始结点。
 *
 * （2）	孩子(Child)和双亲(Parents)
 * 　树中某个结点的子树之根称为该结点的孩子(Child)或儿子，相应地，该结点称为孩子的双亲(Parents)或父亲。
 * 　同一个双亲的孩子称为兄弟(Sibling)。
 *
 * （3）祖先(Ancestor)和子孙(Descendant)
 * ①路径（path）
 * 　若树中存在一个结点序列k1，k2，…，ki，使得ki是ki+1的双亲(1≤i<j)，则称该结点序列是从kl到kj的一条路径(Path)或道路。
 * 　路径的长度指路径所经过的边(即连接两个结点的线段)的数目，等于j-1。
 * 注意：
 * 　若一个结点序列是路径，则在树的树形图表示中，该结点序列"自上而下"地通过路径上的每条边。
 * 　从树的根结点到树中其余结点均存在一条惟一的路径。
 *
 * ②祖先(Ancestor)和子孙(Descendant)
 * 　若树中结点k到ks存在一条路径，则称k是ks的祖先(Ancestor)，ks是k的子孙(Descendant)。
 * 　一个结点的祖先是从根结点到该结点路径上所经过的所有结点，而一个结点的子孙则是以该结点为根的子树中的所有结点。
 * 约定：
 * 　结点k的祖先和子孙不包含结点k本身。
 *
 * （4）结点的层数(Level)和树的高度（Height）
 * 　结点的层数(Level)从根起算：
 * 根的层数为1
 * 其余结点的层数等于其双亲结点的层数加1。
 * 　双亲在同一层的结点互为堂兄弟。
 * 　树中结点的最大层数称为树的高度(Height)或深度(Depth)。
 * 注意，
 * 　很多文献中将树根的层数定义为0。
 *
 * （5）有序树(OrderedTree)和无序树(UnoderedTree)
 * 　若将树中每个结点的各子树看成是从左到右有次序的(即不能互换)，则称该树为有序树(OrderedTree)；否则称为无序树(UnoderedTree)。
 * 注意：
 * 　若不特别指明，一般讨论的树都是有序树。
 *
 * （6）森林(Forest)
 * 　森林(Forest)是m(m≥0)棵互不相交的树的集合。
 * 　树和森林的概念相近。删去一棵树的根，就得到一个森林；反之，加上一个结点作树根，森林就变为一棵树。
 *
 * 5.树形结构的逻辑特征
 * 　树形结构的逻辑特征可用树中结点之间的父子关系来描述：
 * （1）	树中任一结点都可以有零个或多个直接后继(即孩子)结点，但至多只能有一个直接前趋(即双亲)结点。
 * （2）	树中只有根结点无前趋，它是开始结点；叶结点无后继，它们是终端结点。
 * （3）	祖先与子孙的关系是对父子关系的延拓，它定义了树中结点之间的纵向次序。
 * （4） 有序树中，同一组兄弟结点从左到右有长幼之分。
 * 对这一关系加以延拓，规定若k1和k2是兄弟，且k1在k2的左边，则kl的任一子孙都在k2的任一子孙的左边，那么就定义了树中结点之间的横向次序。
 *
 */

public interface BaseTree {

    void addElement(int x);

    boolean deleteElement(int x);

    String preOrder();

    String inOrder();

    String postOrder();

}
