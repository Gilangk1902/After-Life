package com.afterlife.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OthersAdapter extends RecyclerView.Adapter<OthersAdapter.ViewHolder> {
    @NonNull
    @Override
    public OthersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OthersAdapter.ViewHolder holder, int position) {
        //set value of said component holder
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Initialize card component
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
