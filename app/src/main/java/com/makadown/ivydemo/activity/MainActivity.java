package com.makadown.ivydemo.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.makadown.ivydemo.R;
import com.makadown.ivydemo.adapter.ViewPagerAdapter;
import com.makadown.ivydemo.fragment.TabFragmentFlorerias;
import com.makadown.ivydemo.fragment.TabFragmentFlores;
import com.makadown.ivydemo.fragment.TabFragmentMaps;

/**
 * proyecto basado en
 * http://www.tutorialsbuzz.com/2015/11/Android-Filter-RecyclerView-Using-SearchView-In-ToolBar.html
 * */

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.world);
        tabLayout.getTabAt(1).setIcon(R.drawable.business);
        tabLayout.getTabAt(2).setIcon(R.drawable.flower);

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.addTab(tabLayout.newTab().setIcon( R.drawable.world ));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.business));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.flower));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(new TabFragmentMaps(), "");
        adapter.addFragment(new TabFragmentFlorerias(), "");
        adapter.addFragment(new TabFragmentFlores(),  "");
        viewPager.setAdapter(adapter);

    }

}