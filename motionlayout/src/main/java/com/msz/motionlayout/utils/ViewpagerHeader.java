package com.msz.motionlayout.utils;

import android.content.Context;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class ViewpagerHeader extends MotionLayout implements ViewPager.OnPageChangeListener {
    public ViewpagerHeader(Context context) {
        super(context);
    }

    public ViewpagerHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewpagerHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        int numPages = 3;
        setProgress((i + v) / (numPages - 1));
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
