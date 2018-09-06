package com.msz.motionlayout.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;

public class DrawerContent extends MotionLayout implements DrawerLayout.DrawerListener {
    public DrawerContent(Context context) {
        super(context);
    }

    public DrawerContent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawerContent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((DrawerLayout) getParent()).addDrawerListener(this);
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        setProgress(v);
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {

    }

    @Override
    public void onDrawerClosed(@NonNull View view) {

    }

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
