package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.R;

public class CoffinsAdapter extends RecyclerView.Adapter<CoffinsAdapter.ViewHolder> {
    private Context context;
    public CoffinsAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public CoffinsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.accesories_card_layout,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffinsAdapter.ViewHolder holder, int position) {
        // set value of holders
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        // initialize the fucking card component
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
