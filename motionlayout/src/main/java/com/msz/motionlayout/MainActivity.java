package com.msz.motionlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.msz.motionlayout.fragmentsdemo.FragmentExample2Activity;
import com.msz.motionlayout.fragmentsdemo.FragmentExampleActivity;
import com.msz.motionlayout.viewpagerdemo.ViewPagerActivity;
import com.msz.motionlayout.viewpagerdemo.ViewPagerActivity2;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Switch showPaths;
    private boolean doShowPaths = false;

    private DemosAdapter.Demo[] myDataset = {
            new DemosAdapter.Demo("Basic Example (1/2)", "Basic motion example using referenced ConstraintLayout files", R.layout.motion_01_basic),
            new DemosAdapter.Demo("Basic Example (2/2)", "Basic motion example using ConstraintSets defined in the MotionScene file", R.layout.motion_02_basic),
            new DemosAdapter.Demo("Custom Attribute", "Show color interpolation (custom attribute)", R.layout.motion_03_custom_attribute),
            new DemosAdapter.Demo("ImageFilterView (1/2)", "Show image cross-fade (using ML's ImageFilterView + custom attribute)", R.layout.motion_04_imagefilter),
            new DemosAdapter.Demo("ImageFilterView (2/2)", "Show image saturation transition (using ML's ImageFilterView + custom attribute)", R.layout.motion_05_imagefilter),
            new DemosAdapter.Demo("Keyframe Position (1/3)", "Use a simple keyframe to change the interpolated motion", R.layout.motion_06_keyframe),
            new DemosAdapter.Demo("Keyframe Interpolation (2/3)", "More complex keyframe, adding rotation interpolation", R.layout.motion_07_keyframe),
            new DemosAdapter.Demo("Keyframe Cycle (3/3)", "Basic example of using a keyframe cycle ", R.layout.motion_08_cycle),
            new DemosAdapter.Demo("CoordinatorLayout Example (1/3)", "Basic example of using MotionLayout instead of AppBarLayout", R.layout.motion_09_coordinatorlayout),
            new DemosAdapter.Demo("CoordinatorLayout Example (2/3)", "Slightly more complex example of MotionLayout replacing AppBarLayout, with multiple elements and parallax background", R.layout.motion_10_coordinatorlayout),
            new DemosAdapter.Demo("CoordinatorLayout Example (3/3)", "Another AppBarLayout replacement example", R.layout.motion_11_coordinatorlayout),
            new DemosAdapter.Demo("DrawerLayout Example (1/2)", "Basic DrawerLayout with MotionLayout", R.layout.motion_12_drawerlayout),
            new DemosAdapter.Demo("DrawerLayout Example (2/2)", "Advanced DrawerLayout with MotionLayout", R.layout.motion_13_drawerlayout),
            new DemosAdapter.Demo("Side Panel Example", "Side Panel, implemented with MotionLayout only", R.layout.motion_14_side_panel),
            new DemosAdapter.Demo("Parallax Example", "Parallax background. Drag the car.", R.layout.motion_15_parallax),
            new DemosAdapter.Demo("ViewPager Example", "Using MotionLayout with ViewPager", ViewPagerActivity.class),
            new DemosAdapter.Demo("ViewPager Lottie Example", "Using MotionLayout and Lottie with ViewPager", ViewPagerActivity2.class),
            new DemosAdapter.Demo("Complex Motion Example (1/4)", "Basic CoordinatorLayout-like behavior. Implemented with MotionLayout only, using a moving guideline. Note the view isn't resized. ", R.layout.motion_17_coordination),
            new DemosAdapter.Demo("Complex Motion Example (2/4)", "Advanced CoordinatorLayout-like behavior (adding a FAB). Implemented with MotionLayout only, using a moving guideline. Note the view isn't resized.", R.layout.motion_18_coordination),
            new DemosAdapter.Demo("Complex Motion Example (3/4)", "Advanced CoordinatorLayout-like behavior (adding a FAB). Implemented with MotionLayout only, using direct resizing of the view.", R.layout.motion_19_coordination),
            new DemosAdapter.Demo("Complex Motion Example (4/4)", "Advanced Synchronized reval motion + helper (bounce). Implemented with MotionLayout only.", R.layout.motion_20_reveal),
            new DemosAdapter.Demo("Fragment Transition Example (1/2)", "Example showing transitioning fragments within MotionLayout", FragmentExampleActivity.class),
            new DemosAdapter.Demo("Fragment Transition Example (2/2)", "Example showing transitioning fragments within MotionLayout", FragmentExample2Activity.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        showPaths = findViewById(R.id.showPaths);
        adapter = new DemosAdapter(myDataset);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        showPaths.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        doShowPaths = isChecked;
    }

    public void start(Class activity, int layoutFileId) {
        Intent intent = new Intent(this, activity);
        intent.putExtra("layout_file_id", layoutFileId);
        intent.putExtra("showPaths", doShowPaths);
        startActivity(intent);
    }
}
