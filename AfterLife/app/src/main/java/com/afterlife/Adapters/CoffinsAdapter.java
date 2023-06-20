package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.Coffin;
import com.afterlife.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CoffinsAdapter extends RecyclerView.Adapter<CoffinsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Coffin> coffins = new ArrayList<>();
    public CoffinsAdapter(Context context, ArrayList<Coffin> coffins){
        this.context = context;
        this.coffins = coffins;
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
        holder.name.setText(coffins.get(position).getName());
        holder.location.setText(coffins.get(position).getLocation());
        Glide.with(context)
                .load(coffins.get(position).getUrl())
                .into(holder.image);
        holder.rating.setText(String.valueOf(coffins.get(position).getRating()));
        holder.price.setText("Rp " + String.valueOf(coffins.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        if(coffins!=null){
            return coffins.size();
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
