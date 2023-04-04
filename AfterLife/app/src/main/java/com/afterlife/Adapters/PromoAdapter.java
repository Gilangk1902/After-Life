package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.Promo;
import com.afterlife.R;

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
        holder.item1.setText(promosData.get(position).getFeature(0));
        holder.item2.setText(promosData.get(position).getFeature(1));
        holder.item3.setText(promosData.get(position).getFeature(2));
        holder.item4.setText(promosData.get(position).getFeature(3));
        holder.item5.setText(promosData.get(position).getFeature(4));
        holder.item6.setText(promosData.get(position).getFeature(5));

        ShowItem(holder, promosData.get(position).getFeature(0), promosData.get(position).getFeature(1), promosData.get(position).getFeature(2),
                promosData.get(position).getFeature(3), promosData.get(position).getFeature(4), promosData.get(position).getFeature(5));
    }

    @Override
    public int getItemCount() {
        return promosData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, price, item1, item2, item3, item4, item5, item6;
        private LinearLayout item1_LinearLayout, item2_LinearLayout,item3_LinearLayout,
                item4_LinearLayout, item5_LinearLayout, item6_LinearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.promo_name_textview);
            price = itemView.findViewById(R.id.promo_price_textview);
            item1 = itemView.findViewById(R.id.items_1_TextView);
            item2 = itemView.findViewById(R.id.items_2_TextView);
            item3 = itemView.findViewById(R.id.items_3_TextView);
            item4 = itemView.findViewById(R.id.items_4_TextView);
            item5 = itemView.findViewById(R.id.items_5_TextView);
            item6 = itemView.findViewById(R.id.items_6_TextView);

            item1_LinearLayout = itemView.findViewById(R.id.items_1);
            item2_LinearLayout = itemView.findViewById(R.id.items_2);
            item3_LinearLayout = itemView.findViewById(R.id.items_3);
            item4_LinearLayout = itemView.findViewById(R.id.items_4);
            item5_LinearLayout = itemView.findViewById(R.id.items_5);
            item6_LinearLayout = itemView.findViewById(R.id.items_6);
        }
    }

    private void ShowItem(PromoAdapter.ViewHolder holder, String item1, String item2, String item3, String item4, String item5, String item6){
        if(item1 == ""){
            holder.item1_LinearLayout.setVisibility(View.GONE);
        }
        else if(item2 == ""){
            holder.item2_LinearLayout.setVisibility(View.GONE);
        }
        else if(item3 == ""){
            holder.item3_LinearLayout.setVisibility(View.GONE);
        }
        else if(item4 == ""){
            holder.item4_LinearLayout.setVisibility(View.GONE);
        }
        else if(item4 == ""){
            holder.item4_LinearLayout.setVisibility(View.GONE);
        }
        else if(item5 == ""){
            holder.item5_LinearLayout.setVisibility(View.GONE);
        }
        else if(item6 == ""){
            holder.item6_LinearLayout.setVisibility(View.GONE);
        }
    }
}
