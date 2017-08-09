package com.example.dell.eight808;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablelayout;
private ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        ArrayList<Fragment> listf=new ArrayList<>();
        Aragment a=new Aragment();
        BFragemnt b=new BFragemnt();
        listf.add(a);
        listf.add(b);


        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),listf,list);
        tablelayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(adapter);
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablelayout = (TabLayout) findViewById(R.id.tablelayout);
    }
}
