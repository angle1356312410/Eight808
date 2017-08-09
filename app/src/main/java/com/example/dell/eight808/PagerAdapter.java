package com.example.dell.eight808;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dell.eight808.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/8/8.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> listf;
    private ArrayList<String> str=new ArrayList<String>();

    public PagerAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Fragment> listf, ArrayList<String> str) {
        super(fm);
        this.listf = listf;
        this.str = str;
        str.add("列表");
        str.add("添加");

    }

    @Override
    public Fragment getItem(int position) {
        return listf.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return  str.get(position);
    }

    @Override
    public int getCount() {
        return listf.size();
    }
}
