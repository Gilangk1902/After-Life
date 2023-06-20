package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.Cart;
import com.afterlife.R;
import com.bumptech.glide.Glide;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private Context context;
    private Cart cart;
    public CartAdapter(Context context, Cart cart){
        this.context = context;
        this.cart = cart;
    }
    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcart_card_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        if(getItemCount() > 0){
            Glide.with(context)
                    .load(cart.getPurchasable(position).getUrl())
                    .into(holder.item_image);
            holder.itemcart_price_TextView
                    .setText("Rp. " + String.valueOf(cart.getPurchasable(position).getPrice() * cart.getQuantity(position)));
            holder.itemcart_name_TextView
                    .setText(cart.getPurchasable(position).getName());
            holder.itemcart_count_TextView
                    .setText(String.valueOf(cart.getQuantity(position)));
        }
    }


    @Override
    public int getItemCount() {
        if(cart!=null){
            return cart.getPurchaseables().size();
        }
        else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView item_image;
        private TextView itemcart_name_TextView, itemcart_price_TextView,
            itemcart_count_TextView;
        private Button min_Button, plus_Buton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.itemcart_ImageView);
            itemcart_name_TextView = itemView.findViewById(R.id.itemcart_name_TextView);
            itemcart_price_TextView = itemView.findViewById(R.id.itemcart_price_TextView);
            itemcart_count_TextView = itemView.findViewById(R.id.itemcart_count_TextView);
            min_Button = itemView.findViewById(R.id.min_Button);
            min_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateDecrementCount();
                }
            });
            plus_Buton = itemView.findViewById(R.id.plus_Button);
            plus_Buton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateIncrementCount();
                }
            });
        }

        protected void updateIncrementCount(){
            cart.incrementQuantity(getAdapterPosition());
            notifyItemChanged(getAdapterPosition());
        }

        protected void updateDecrementCount(){
            cart.decrementQuantity(getAdapterPosition());
            notifyItemChanged(getAdapterPosition());
        }
    }
}
