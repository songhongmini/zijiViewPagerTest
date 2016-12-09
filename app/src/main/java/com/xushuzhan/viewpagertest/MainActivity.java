package com.xushuzhan.viewpagertest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LayoutInflater mLayoutInflater;
    View pageOne;
    View pageTwo;
    View pageThree;
    List<View> mViews;
    Adapter mAdatpter;
    ViewPager mViewPager;

    View button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //讲三个布局文件转换成我们能看见的View
        mLayoutInflater = getLayoutInflater();
        pageOne = mLayoutInflater.inflate(R.layout.page_1,null);
        pageTwo = mLayoutInflater.inflate(R.layout.page_2,null);
        pageThree = mLayoutInflater.inflate(R.layout.page_3,null);

        //将三个View加入集合中
        mViews =  new ArrayList<>();
        mViews.add(pageOne);
        mViews.add(pageTwo);
        mViews.add(pageThree);

        //初始化适配器，传入要显示的view
        mAdatpter = new Adapter(mViews);

        //初始化ViewPager
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        //给ViewPager设置Adapter
        mViewPager.setAdapter(mAdatpter);


        button = findViewById(R.id.to_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        });

        button = findViewById(R.id.to_Third_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ThirdActivity.class));

            }
        });

    }

}
