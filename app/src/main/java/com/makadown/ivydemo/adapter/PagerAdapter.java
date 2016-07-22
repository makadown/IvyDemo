package com.makadown.ivydemo.adapter;

import android.support.v4.app.*;

import com.makadown.ivydemo.fragment.*;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentMaps tab1 = new TabFragmentMaps();
                return tab1;
            case 1:
                TabFragmentFlorerias tab2 = new TabFragmentFlorerias();
                return tab2;
            case 2:
                TabFragmentFlores tab3 = new TabFragmentFlores();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}