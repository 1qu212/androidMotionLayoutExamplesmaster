package com.msz.motionlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class DemoActivity extends AppCompatActivity {
    private MotionLayout motionLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getIntent().getIntExtra("layout_file_id", R.layout.motion_01_basic);
        setContentView(layout);
        if (layout == R.layout.motion_11_coordinatorlayout) {
            ImageView icon = findViewById(R.id.icon);
            icon.setClipToOutline(true);
        }
        motionLayout = findViewById(R.id.motionLayout);
        boolean doShowPaths = getIntent().getBooleanExtra("showPaths", false);
        motionLayout.setShowPaths(doShowPaths);
    }
}
