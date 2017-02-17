package com.zhouchaoran.datastructure.linearstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhouchaoran.datastructure.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransLinearActivity extends AppCompatActivity {

    @BindView(R.id.btn_enter_seqeunce)
    Button mBtnEnterSeqeunce;
    @BindView(R.id.btn_enter_link)
    Button mBtnEnterLink;
    @BindView(R.id.btn_enter_link_circular)
    Button mBtnEnterLinkCircular;
    @BindView(R.id.btn_enter_link_double)
    Button mBtnEnterLinkDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_linear);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_enter_seqeunce, R.id.btn_enter_link, R.id.btn_enter_link_circular, R.id.btn_enter_link_double})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_enter_seqeunce:
                startActivity("sequence");
                break;
            case R.id.btn_enter_link:
                startActivity("link");
                break;
            case R.id.btn_enter_link_circular:
                startActivity("circularlink");
                break;
            case R.id.btn_enter_link_double:
                startActivity("doublelink");
                break;
        }
    }

    private void startActivity(String type) {
        Intent intent = new Intent(TransLinearActivity.this, LinearListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("typeoflist", type);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
