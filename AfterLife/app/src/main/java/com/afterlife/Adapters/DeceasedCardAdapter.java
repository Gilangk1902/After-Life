package com.afterlife.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeceasedCardAdapter extends RecyclerView.Adapter<DeceasedCardAdapter.ViewHolder> {

    @NonNull
    @Override
    public DeceasedCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO : return view holder
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DeceasedCardAdapter.ViewHolder holder, int position) {
        //TODO : Bind data
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //TODO : initialize the views component
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
