package com.zx.swipemenulistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zx.swipemenulistview.config.SwipeMenuConfig;
import com.zx.swipemenulistview.helper.SwipeMenu;
import com.zx.swipemenulistview.helper.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private SwipeMenuListView mListView;
    private MyAdapter myAdapter;
    private List<UserBean> mList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mContext = this;
        initData();
        initListView();
    }


    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new UserBean("用户" + i));
        }
    }

    private void initListView() {
        mListView = (SwipeMenuListView) findViewById(R.id.listView);
        // set creator
        mListView.setMenuCreator(SwipeMenuConfig.initCreator(mContext));
        myAdapter = new MyAdapter(mContext, mList);
        mListView.setAdapter(myAdapter);

        // 设置Item的侧滑选项的点击的监听器
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                UserBean userBean = mList.get(position);
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
                        mList.remove(position);
                        myAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
    }
}
