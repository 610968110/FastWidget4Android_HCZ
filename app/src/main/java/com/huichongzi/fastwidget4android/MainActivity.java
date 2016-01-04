package com.huichongzi.fastwidget4android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huichongzi.fastwidget4android.activity.BannerViewActivity;
import com.huichongzi.fastwidget4android.activity.DragGridViewActivity;
import com.huichongzi.fastwidget4android.activity.FolioListViewActivity;
import com.huichongzi.fastwidget4android.activity.RecycleScrollViewActivity;
import com.huichongzi.fastwidget4android.activity.RecycleScrollViewListActivity;
import com.huichongzi.fastwidget4android.activity.TestActivity;
import com.huichongzi.fastwidget4android.activity.WaveBallProgressActivity;
import com.huichongzi.fastwidget4android.utils.DisplayUtils;


public class MainActivity extends Activity {
    private static final String[] names = {"循环轮播BannerView", "可拖动排序的GridView", "翻转展示的ListView", "水晶球进度条", "可回收scrollview", "测试"};
    private static final Class[] clazzs = {BannerViewActivity.class, DragGridViewActivity.class, FolioListViewActivity.class, WaveBallProgressActivity.class, RecycleScrollViewActivity.class, TestActivity.class};

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return names.length;
            }
            @Override
            public Object getItem(int position) {
                return position;
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = new TextView(MainActivity.this);
                view.setText(names[position]);
                AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DisplayUtils.dip2px(MainActivity.this, 40));
                view.setLayoutParams(params);
                view.setGravity(Gravity.CENTER);
                return view;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position < clazzs.length){
                    Intent intent = new Intent(MainActivity.this, clazzs[position]);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}