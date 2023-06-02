package com.afterlife.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddressCardAdapter extends RecyclerView.Adapter<AddressCardAdapter.ViewHolder>{
    @NonNull
    @Override
    public AddressCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressCardAdapter.ViewHolder holder, int position) {
        //TODO : Bind Data
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //TODO : Initialize component
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
