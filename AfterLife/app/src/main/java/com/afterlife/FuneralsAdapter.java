package com.afterlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FuneralsAdapter extends RecyclerView.Adapter<FuneralsAdapter.ViewHolder> {
    ArrayList<Funeral> funeralsData = new ArrayList<Funeral>();
    private Context context;

    public FuneralsAdapter(Context context, ArrayList<Funeral> funeralsData) {
        this.funeralsData = funeralsData;
        this.context = context;
    }


    @NonNull
    @Override
    public FuneralsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.funeral_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuneralsAdapter.ViewHolder holder, int position) {
        holder.name.setText(funeralsData.get(position).getName());
        holder.rating.setText(String.valueOf(funeralsData.get(position).getRating()));
        holder.location.setText(funeralsData.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return funeralsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, rating, location, religion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);
            religion = itemView.findViewById(R.id.religion);
        }
    }
}
