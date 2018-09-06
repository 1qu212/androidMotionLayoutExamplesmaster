package com.msz.motionlayout.fragmentsdemo;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msz.motionlayout.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    private List<User> userList;

    public CustomAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new CustomAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final CustomAdapterViewHolder holder = (CustomAdapterViewHolder) viewHolder;
        holder.txtName.setText(userList.get(i).getName());
        holder.txtTitle.setText(userList.get(i).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parent = (View) v.getParent().getParent().getParent().getParent();
                if (parent instanceof MotionLayout) {
                    Rect offsetViewBounds = new Rect();
                    v.getDrawingRect(offsetViewBounds);
                    ((MotionLayout) parent).offsetDescendantRectToMyCoords(v, offsetViewBounds);
                    FragmentTransaction transaction = ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                    ItemFragment itemFragment = ItemFragment.newInstance();
                    itemFragment.update(holder);
//                    transaction.replace(R.id.main, itemFragment);
                    transaction.replace(R.id.container, itemFragment);
                    transaction.commit();
                    ((MotionLayout) parent).transitionToEnd();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class CustomAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtTitle;

        public CustomAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
