package com.zhouchaoran.datastructure;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc:
 */
public abstract class BaseActivity extends Activity {

    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setLayoutId());
        mContext = this;
        initView();
        initEvent();
        initData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initView();
        initEvent();
        initData();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

}
