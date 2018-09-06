package com.msz.motionlayout.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msz.motionlayout.R;

public class ItemFragment extends Fragment {
    private CustomAdapter.CustomAdapterViewHolder myHolder;
    private TextView txtName;
    private TextView txtTitle;
    private View view;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_layout, container, false);
        txtName = view.findViewById(R.id.txtName);
        txtTitle = view.findViewById(R.id.txtTitle);
        return view;
    }

    public void update(CustomAdapter.CustomAdapterViewHolder holder) {
        myHolder = holder;
        if (txtName != null) {
            txtName.setText(myHolder.txtName.getText());
        }
        if (txtTitle != null) {
            txtTitle.setText(myHolder.txtTitle.getText());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (myHolder != null) {
            update(myHolder);
        }
    }
}
