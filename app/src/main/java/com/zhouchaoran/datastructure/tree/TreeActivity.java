package com.zhouchaoran.datastructure.tree;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.zhouchaoran.datastructure.BaseActivity;
import com.zhouchaoran.datastructure.R;
import com.zhouchaoran.datastructure.tree.binarytree.BinaryTree;
import com.zhouchaoran.datastructure.tree.binarytree.ThreadedBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouchaoran on 2017/2/9.
 *
 * @desc:
 */
public class TreeActivity extends BaseActivity {

    @BindView(R.id.spinner_tree_activity)
    Spinner mSpinner;
    @BindView(R.id.btn_add_element)
    Button mBtnAddElement;
    @BindView(R.id.btn_delete_element)
    Button mBtnDeleteElement;
    @BindView(R.id.btn_order_element)
    Button mBtnOrderElement;
    @BindView(R.id.textview_output_preorder)
    TextView mTextviewOutputPreorder;
    @BindView(R.id.textview_output_inorder)
    TextView mTextviewOutputInorder;
    @BindView(R.id.textview_output_postorder)
    TextView mTextviewOutputPostorder;

    private BaseTree mTree;
    private List<String> mStringList = new ArrayList<>();
    private Random mRandom;

    @Override
    protected int setLayoutId() {
        return R.layout.layout_tree_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Override
    protected void initData() {
        mStringList.add("BinaryTree");
        mStringList.add("ThreadedBinaryTree");
        mSpinner.setAdapter(new ArrayAdapter<String>(TreeActivity.this, android.R.layout.simple_list_item_1, mStringList));
    }

    @Override
    protected void initEvent() {
        mRandom = new Random();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mTree = new BinaryTree();
                        break;
                    case 1:
                        mTree = new ThreadedBinaryTree();
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mTree = new BinaryTree();
            }
        });
    }

    @OnClick({R.id.btn_add_element, R.id.btn_delete_element, R.id.btn_order_element})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_element:
                mTree.addElement(mRandom.nextInt(100));
                break;
            case R.id.btn_delete_element:
                break;
            case R.id.btn_order_element:
                mTextviewOutputPreorder.setText(mTree.preOrder());
                mTextviewOutputInorder.setText(mTree.inOrder());
                mTextviewOutputPostorder.setText(mTree.postOrder());
                break;
        }
    }
}
