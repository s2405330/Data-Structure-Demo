package com.zhouchaoran.datastructure.linearstructure;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhouchaoran.datastructure.BaseActivity;
import com.zhouchaoran.datastructure.R;
import com.zhouchaoran.datastructure.linearstructure.linearlist.BaseLinearList;
import com.zhouchaoran.datastructure.linearstructure.linearlist.CircularLinkList;
import com.zhouchaoran.datastructure.linearstructure.linearlist.DoubleLinkList;
import com.zhouchaoran.datastructure.linearstructure.linearlist.LinkList;
import com.zhouchaoran.datastructure.linearstructure.linearlist.ListSequence;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouchaoran on 2017/2/6.
 *
 * @desc:
 */

public class LinearListActivity extends BaseActivity {
    @BindView(R.id.btn_add_element)
    Button mBtnAddElement;
    @BindView(R.id.btn_delete_element)
    Button mBtnDeleteElement;
    @BindView(R.id.edittext_input_num_linear_activity)
    EditText mEdittextInput;
    @BindView(R.id.textview_output_linearlist_activity)
    TextView mTextviewOutput;
    @BindView(R.id.textview_output_linearlist_length_activity)
    TextView mTextviewOutputLength;

    BaseLinearList mList;
    Random mRandom;

    @Override
    protected int setLayoutId() {
        return R.layout.layout_linearlist_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        String type = getIntent().getExtras().getString("typeoflist", "sequence");
        initListByType(type);
        mRandom = new Random();
    }

    private void initListByType(String type) {
        switch (type){
            case "sequence":
                mList = new ListSequence();
                break;
            case "link":
                mList = new LinkList();
                break;
            case "circularlink":
                mList = new CircularLinkList();
                break;
            case "doublelink":
                mList = new DoubleLinkList();
                break;
            default:
                break;
        }
    }

    @Override
    protected void initEvent() {
//        mBtnAddElement.setOnClickListener(this);
//        mBtnDeleteElement.setOnClickListener(this);
    }

    @OnClick({R.id.btn_add_element, R.id.btn_delete_element})
    public void onClick(View view) {
        if (TextUtils.isEmpty(mEdittextInput.getText().toString())) {
            Toast.makeText(this, "你还没输入一个值", Toast.LENGTH_SHORT).show();
            return;
        }
        int index = Integer.valueOf(mEdittextInput.getText().toString().trim());
        switch (view.getId()) {
            case R.id.btn_add_element:
                int element = mRandom.nextInt(100);
                    mList.insertList(element, index);
//                try {
//                } catch (Exception e) {
//                    Toast.makeText(this, "index不对", Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.btn_delete_element:
                try {
                    mList.deleteList(index);
                } catch (Exception e) {
                    Toast.makeText(this, "index不对", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        mTextviewOutput.setText(mList.toString());
        mTextviewOutputLength.setText(mList.listLength() + "");
    }
}
