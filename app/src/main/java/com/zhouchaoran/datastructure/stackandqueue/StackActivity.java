package com.zhouchaoran.datastructure.stackandqueue;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zhouchaoran.datastructure.BaseActivity;
import com.zhouchaoran.datastructure.R;
import com.zhouchaoran.datastructure.stackandqueue.queue.CircularQueue;
import com.zhouchaoran.datastructure.stackandqueue.queue.LinkQueue;
import com.zhouchaoran.datastructure.stackandqueue.queue.SequenceQueue;
import com.zhouchaoran.datastructure.stackandqueue.stack.BaseStack;
import com.zhouchaoran.datastructure.stackandqueue.stack.LinkStack;
import com.zhouchaoran.datastructure.stackandqueue.stack.SquenceStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouchaoran on 2017/2/7.
 *
 * @desc: 演示栈和队列
 */

public class StackActivity extends BaseActivity {
    @BindView(R.id.spinner_stack_activity)
    Spinner mSpinnerStack;
    @BindView(R.id.btn_push_element)
    Button mBtnPushElement;
    @BindView(R.id.btn_pop_element)
    Button mBtnPopElement;
    @BindView(R.id.textview_output_stack_activity)
    TextView mTextviewOutput;
    @BindView(R.id.textview_output_stack_length_activity)
    TextView mTextviewOutputLength;

    private BaseStack mStack;
    private List<String> mStringList = new ArrayList<>();
    private Random mRandom;

    @Override
    protected int setLayoutId() {
        return R.layout.layout_stack_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        mRandom = new Random();
        mStringList.add("SequenceStack");
        mStringList.add("LinkStack");
        mStringList.add("SequenceQueue");
        mStringList.add("LinkQueue");
        mStringList.add("CircularQueue");
        mSpinnerStack.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStringList));
    }

    @Override
    protected void initEvent() {
        mSpinnerStack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    mStack = new SquenceStack();
                } else if (position == 1) {
                    mStack = new LinkStack();
                } else if (position == 2){
                    mStack = new SequenceQueue();
                } else if (position == 3){
                    mStack = new LinkQueue();
                } else {
                    mStack = new CircularQueue();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mStack = new SquenceStack();
            }
        });
    }

    @OnClick({R.id.btn_push_element, R.id.btn_pop_element})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_push_element:
                int value = mRandom.nextInt(100);
                mStack.push(value);
                break;
            case R.id.btn_pop_element:
                int data = mStack.pop();
                Toast.makeText(this, "出站的值是" + data, Toast.LENGTH_SHORT).show();
                break;
        }
        mTextviewOutput.setText(mStack.toString());
//        mTextviewOutputLength.setText();
    }
}
