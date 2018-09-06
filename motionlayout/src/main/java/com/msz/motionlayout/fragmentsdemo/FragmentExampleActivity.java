package com.msz.motionlayout.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.msz.motionlayout.R;

public class FragmentExampleActivity extends AppCompatActivity implements MotionLayout.TransitionListener {
    private float lastProgress = 0f;
    private float last = 0f;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            fragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        MotionLayout motionLayout = findViewById(R.id.motionLayout);
        motionLayout.setTransitionListener(this);
    }

    @Override
    public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
        if (v - lastProgress > 0) {
            boolean atEnd = (Math.abs(1f - v) < 0.2f);
            if (atEnd && fragment instanceof MainFragment) {
                fragment = SecondFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.show, 0)
                        .replace(R.id.container, fragment)
                        .commit();
            }
        } else {
            boolean atStart = (v < 0.8f);
            if (atStart && fragment instanceof SecondFragment) {
                fragment = MainFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(0, R.animator.hide)
                        .replace(R.id.container, fragment)
                        .commit();
            }
        }
        lastProgress = v;
    }

    @Override
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {

    }
}
