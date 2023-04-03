package com.afterlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {
    ArrayList<Promo> promosData = new ArrayList<Promo>();
    private Context context;

    public PromoAdapter(Context context, ArrayList<Promo> promosData) {
        this.promosData = promosData;
        this.context = context;
    }

    @NonNull
    @Override
    public PromoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.promo_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.ViewHolder holder, int position) {
        holder.name.setText(promosData.get(position).getName());
        holder.price.setText("Rp. " + String.valueOf(promosData.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return promosData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.promo_name_textview);
            price = itemView.findViewById(R.id.promo_price_textview);
        }
    }
}
