package com.msz.motionlayout.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msz.motionlayout.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.motion_22_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<User> users = new ArrayList<>();
        users.add(new User("Paul", "Mr"));
        users.add(new User("Jane", "Miss"));
        users.add(new User("John", "Dr"));
        users.add(new User("Amy", "Mrs"));
        users.add(new User("Paul", "Mr"));
        users.add(new User("Jane", "Miss"));
        users.add(new User("John", "Dr"));
        users.add(new User("Amy", "Mrs"));
        users.add(new User("Paul", "Mr"));
        users.add(new User("Jane", "Miss"));
        users.add(new User("John", "Dr"));
        users.add(new User("Amy", "Mrs"));
        users.add(new User("Paul", "Mr"));
        users.add(new User("Jane", "Miss"));
        users.add(new User("John", "Dr"));
        users.add(new User("Amy", "Mrs"));
        CustomAdapter customAdapter = new CustomAdapter(users);
        recyclerView.setAdapter(customAdapter);
        super.onViewCreated(view, savedInstanceState);
    }
}
