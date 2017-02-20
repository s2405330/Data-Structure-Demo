package com.zhouchaoran.datastructure;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.zhouchaoran.datastructure.logmodule.common.logger.Log;
import com.zhouchaoran.datastructure.logmodule.common.logger.LogWrapper;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc:
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected static String TAG = "BaseActivity";
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setLayoutId());
        TAG = this.getClass().getSimpleName();
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

    @Override
    protected void onStart() {
        super.onStart();
        initializeLogging();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

    /** Set up targets to receive log data */
    public void initializeLogging() {
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        // Wraps Android's native log framework
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        Log.i(TAG, "Ready");
    }

}
