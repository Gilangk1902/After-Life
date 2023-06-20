package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.Accessory;
import com.afterlife.DataClass.Coffin;
import com.afterlife.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class OtherAppliancesAdapter extends RecyclerView.Adapter<OtherAppliancesAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Accessory> other_appliances = new ArrayList<>();
    public OtherAppliancesAdapter(Context context, ArrayList<Accessory> other_appliances){
        this.context = context;
        this.other_appliances = other_appliances;
    }

    @NonNull
    @Override
    public OtherAppliancesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.accesories_card_layout,
                parent, false);
        return new OtherAppliancesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherAppliancesAdapter.ViewHolder holder, int position) {
        holder.name.setText(other_appliances.get(position).getName());
        holder.location.setText(other_appliances.get(position).getLocation());
        Glide.with(context)
                .load(other_appliances.get(position).getUrl())
                .into(holder.image);
        holder.rating.setText(String.valueOf(other_appliances.get(position).getRating()));
        holder.price.setText("Rp " + String.valueOf(other_appliances.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        if(other_appliances!=null){
            return other_appliances.size();
        }
        else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        // initialize the fucking card component
        private ImageView image;
        private TextView name, price, rating, location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.Image);
            name = itemView.findViewById(R.id.Name);
            price = itemView.findViewById(R.id.Price);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);
        }
    }
}
