package com.msz.motionlayout;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemosAdapter extends RecyclerView.Adapter {
    private Demo[] demos;

    public DemosAdapter(Demo[] demos) {
        this.demos = demos;
    }

    static class Demo {
        private String title;
        private String description;
        private int layout = 0;
        private Class activity = DemoActivity.class;

        public Demo(String title, String description, int layout) {
            this.title = title;
            this.description = description;
            this.layout = layout;
        }

        public Demo(String title, String description, Class activity) {
            this.title = title;
            this.description = description;
            this.activity = activity;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getLayout() {
            return layout;
        }

        public void setLayout(int layout) {
            this.layout = layout;
        }

        public Class getActivity() {
            return activity;
        }

        public void setActivity(Class activity) {
            this.activity = activity;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ConstraintLayout row = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.title.setText(demos[i].getTitle());
        holder.description.setText(demos[i].getDescription());
        holder.layoutFileId = demos[i].getLayout();
        holder.activity = demos[i].getActivity();
    }

    @Override
    public int getItemCount() {
        return demos.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private int layoutFileId = 0;
        private Class activity;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) itemView.getContext()).start(activity, layoutFileId);
                }
            });
        }
    }
}
