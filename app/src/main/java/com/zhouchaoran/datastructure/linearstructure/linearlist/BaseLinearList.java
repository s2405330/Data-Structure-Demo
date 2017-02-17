package com.zhouchaoran.datastructure.linearstructure.linearlist;

/**
 * Created by zhouchaoran on 2017/2/5.
 *
 * @desc:所有线性表的鸡肋
 *
 * 在计算机中用一组地址连续的存储单元依次存储线性表的各个数据元素,称作线性表的顺序存储结构.　

 * 顺序存储结构是存储结构类型中的一种，该结构是把逻辑上相邻的节点存储在物理位置上相邻的存储单元中，结点之间的逻辑关系由存储单元的邻接关系来体现。
 * 由此得到的存储结构为顺序存储结构，通常顺序存储结构是借助于计算机程序设计语言（例如c/c++）的数组来描述的。
 *
 * 顺序存储结构的主要优点是节省存储空间，因为分配给数据的存储单元全用存放结点的数据（不考虑c/c++语言中数组需指定大小的情况），
 * 结点之间的逻辑关系没有占用额外的存储空间。采用这种方法时，可实现对结点的随机存取，即每一个结点对应一个序号，由该序号可以直接计算出来结点的存储地址。
 * 但顺序存储方法的主要缺点是不便于修改，对结点的插入、删除运算时，可能要移动一系列的结点。
 *
 * 优点：
 * 随机存取表中元素。缺点：插入和删除操作需要移动元素。
 *
 * 公有方法
 * 1． InitList（L）
 * 　构造一个空的线性表L，即表的初始化。
 * 2．	ListLength（L）
 * 　求线性表L中的结点个数，即求表长。
 * 3．	GetNode（L，i）
 * 　取线性表L中的第i个结点，这里要求1≤i≤ListLength（L）
 * 4．	LocateNode（L，x）
 * 　在L中查找值为x 的结点，并返回该结点在L中的位置。若L中有多个结点的值和x 相同，则返回首次找到的结点位置；若L中没有结点的值为x ，则返回一个特殊值表示查找失败。
 * 5．	InsertList（L，x，i）
 * 　在线性表L的第i个位置上插入一个值为x 的新结点，使得原编号为i，i+1，…，n的结点变为编号为i+1，i+2，…，n+1的结点。这里1≤i≤n+1，而n是原表L的长度。插入后，表L的长度加1。
 * 6．	DeleteList（L，i）
 * 　删除线性表L的第i个结点，使得原编号为i+1，i+2，…，n的结点变成编号为i，i+1，…，n-1的结点。这里1≤i≤n，而n是原表L的长度。删除后表L的长度减1。
 */

public interface BaseLinearList {
    void initList();

    int listLength();

    int getNode(int i);

    int locateNode(int t);

    void insertList(int t, int i);

    void deleteList(int i);

//    String toString();
}
