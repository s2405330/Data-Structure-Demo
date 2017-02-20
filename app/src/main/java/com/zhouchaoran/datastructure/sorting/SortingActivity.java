package com.zhouchaoran.datastructure.sorting;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.zhouchaoran.datastructure.BaseActivity;
import com.zhouchaoran.datastructure.R;
import com.zhouchaoran.datastructure.logmodule.common.logger.Log;
import com.zhouchaoran.datastructure.logmodule.common.logger.LogFragment;
import com.zhouchaoran.datastructure.logmodule.common.logger.LogWrapper;
import com.zhouchaoran.datastructure.logmodule.common.logger.MessageOnlyLogFilter;
import com.zhouchaoran.datastructure.sorting.sortmethod.BaseSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.BubbleSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.CountSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.InsertSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.MergeSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.QuickSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.RedixSort;
import com.zhouchaoran.datastructure.sorting.sortmethod.SelectorSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouchaoran on 2017/2/4.
 *
 * @desc:
 */
public class SortingActivity extends BaseActivity implements View.OnClickListener {
//public class SortingActivity extends Activity implements View.OnClickListener {

    private TextView mTextviewBeforeSort;
    private TextView mTextviewAfterSort;
    private Button mBtnSort, mBtnSortMethod, mBtnInit;
    private BaseSort mSort;
    private int[] mArrays;
    private List<String> mSortMethods;
    private boolean isShowLog = false;


//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(setLayoutId());
//        initView();
//        initEvent();
//        initData();
//    }

    @Override
    protected int setLayoutId() {
        return R.layout.layout_sorting_activity;
    }

    @Override
    protected void initView() {
        mTextviewAfterSort = (TextView) findViewById(R.id.textview_after_sort);
        mTextviewBeforeSort = (TextView) findViewById(R.id.textview_before_sort);
        mBtnSort = (Button) findViewById(R.id.btn_sort);
        mBtnSortMethod = (Button) findViewById(R.id.btn_selector_method);
        mBtnInit = (Button) findViewById(R.id.btn_init_data);
    }

    @Override
    protected void initData() {
        mArrays = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27};
        mTextviewBeforeSort.setText(Arrays.toString(mArrays));
        mTextviewAfterSort.setVisibility(View.GONE);
        initMethodName();
    }

    private void initMethodName() {
        mSortMethods = new ArrayList<>();
        mSortMethods.add("选择");
        mSortMethods.add("冒泡");
        mSortMethods.add("insert");
        mSortMethods.add("merge");
        mSortMethods.add("快速");
        mSortMethods.add("count");
        mSortMethods.add("redix");
    }

    @Override
    protected void initEvent() {
        mBtnSort.setOnClickListener(this);
        mBtnSortMethod.setOnClickListener(this);
        mBtnInit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sort:
                if (mSort == null) {
                    Toast.makeText(this, "你还没有选择排序方法", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSort.sort(mArrays);
                mTextviewAfterSort.setText(Arrays.toString(mArrays));
                if (mTextviewAfterSort.getVisibility() == View.GONE) {
                    mTextviewAfterSort.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_init_data:
                initData();
                Log.i(TAG, "init");
                break;
            case R.id.btn_selector_method:
                final PopupWindow popupWindow = new PopupWindow();
                View view = View.inflate(SortingActivity.this, R.layout.popup_choose_method_layout, null);
                ListView listView = (ListView) view.findViewById(R.id.listview_popupwindow);
                listView.setAdapter(new ArrayAdapter<String>(SortingActivity.this, android.R.layout.simple_list_item_1, mSortMethods));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mBtnSortMethod.setText(mSortMethods.get(position));
                        initSortMethod(position);
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setContentView(view);
                popupWindow.setWidth(500);
                popupWindow.setHeight(1000);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(false);
                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_sort, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem logItem = menu.findItem(R.id.activity_menu_sort_shoulog);
        logItem.setTitle(isShowLog ? "隐藏日志" : "显示日志");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_menu_sort_shoulog:
                isShowLog = !isShowLog;
                ViewAnimator output = (ViewAnimator) findViewById(R.id.viewanimator_log_fragment);
                if (isShowLog) {
                    output.setVisibility(View.VISIBLE);
                } else {
                    output.setVisibility(View.GONE);
                }
                output.setDisplayedChild(0);
                supportInvalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initSortMethod(int position) {
        switch (position) {
            case 0:
                mSort = new SelectorSort();
                break;
            case 1:
                mSort = new BubbleSort();
                break;
            case 2:
                mSort = new InsertSort();
                break;
            case 3:
                mSort = new MergeSort();
                break;
            case 4:
                mSort = new QuickSort();
                break;
            case 5:
                mSort = new CountSort();
                break;
            case 6:
                mSort = new RedixSort();
                break;
            default:
                break;
        }
    }

    @Override
    public void initializeLogging() {
        // Wraps Android's native log framework.
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
                .findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        Log.i(TAG, "Ready");
    }
}
