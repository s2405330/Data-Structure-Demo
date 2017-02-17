package com.zhouchaoran.datastructure.search;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.zhouchaoran.datastructure.BaseActivity;
import com.zhouchaoran.datastructure.R;
import com.zhouchaoran.datastructure.search.searchmethod.BaseSearch;
import com.zhouchaoran.datastructure.search.searchmethod.BinarySearch;
import com.zhouchaoran.datastructure.search.searchmethod.BinaryTreeSearch;
import com.zhouchaoran.datastructure.search.searchmethod.NormalSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouchaoran on 2017/2/13.
 *
 * @desc:
 */
public class SearchActivity extends BaseActivity {
    @BindView(R.id.textview_before_search)
    TextView mTextviewBeforeSearch;
    @BindView(R.id.textview_after_search)
    TextView mTextviewAfterSearch;
    @BindView(R.id.spinner_search_method)
    Spinner mSpinnerSearchMethod;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    @BindView(R.id.edittext_search_num)
    EditText mEdittextSearchNum;
    @BindView(R.id.textview_search_times)
    TextView mTextviewSearchTimes;

    private BaseSearch mSearch;
    private Random mRandom;
    private List<String> mStrings = new ArrayList<>();
    private List<Integer> mData = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        return R.layout.layout_searcher_actvity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        mRandom = new Random();
        for (int i = 0; i < 10; i++) {
            mData.add(mRandom.nextInt(100));
        }

        mStrings.add("顺序查找");
        mStrings.add("二分查找");
        mStrings.add("分块查找");
        mStrings.add("儿叉排序树");
        mStrings.add("B-树");
        mStrings.add("散列码");
        mSpinnerSearchMethod.setAdapter(new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_list_item_1, mStrings));
        mTextviewBeforeSearch.setText(mData.toString());
    }

    @Override
    protected void initEvent() {
        mSpinnerSearchMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mSearch = new NormalSearch(mData);
                        break;
                    case 1:
                        mSearch = new BinarySearch(mData);
                        break;
                    case 2:
                        break;
                    case 3:
                        mSearch = new BinaryTreeSearch(mData);
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mSearch = new NormalSearch(mData);
            }
        });

    }

    @OnClick({R.id.btn_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                int result = mSearch.search(Integer.parseInt(mEdittextSearchNum.getText().toString().trim()));
                mTextviewAfterSearch.setText(result == -1 ? "不存在这个数" : "这个数的位置是" + result);
                mTextviewSearchTimes.setText("搜索的次数是:" + mSearch.times);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
