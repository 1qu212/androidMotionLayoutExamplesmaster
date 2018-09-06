package com.msz.motionlayout.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.motion.MotionLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.msz.motionlayout.R;

public class ViewPagerActivity extends AppCompatActivity {
    private MotionLayout motionLayout;
    private ViewPagerAdapter adapter;
    private ViewPager pager;
    private TabLayout tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = R.layout.motion_16_viewpager;
        setContentView(layout);
        motionLayout = findViewById(R.id.motionLayout);
        boolean doShowPaths = getIntent().getBooleanExtra("showPaths", false);
        motionLayout.setShowPaths(doShowPaths);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addPage("Page 1", R.layout.motion_16_viewpager_page1);
        adapter.addPage("Page 2", R.layout.motion_16_viewpager_page2);
        adapter.addPage("Page 3", R.layout.motion_16_viewpager_page3);
        pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);
        if (motionLayout != null) {
            pager.addOnPageChangeListener((ViewPager.OnPageChangeListener) motionLayout);
        }
    }
}
