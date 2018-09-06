package com.msz.motionlayout.utils;

import android.content.Context;
import android.support.constraint.motion.MotionLayout;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

public class CollapsibleToolbar extends MotionLayout implements AppBarLayout.OnOffsetChangedListener {
    public CollapsibleToolbar(Context context) {
        super(context);
    }

    public CollapsibleToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CollapsibleToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        setProgress(-(float) i / (float) (appBarLayout.getTotalScrollRange()));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((AppBarLayout) getParent()).addOnOffsetChangedListener(this);
    }
}
