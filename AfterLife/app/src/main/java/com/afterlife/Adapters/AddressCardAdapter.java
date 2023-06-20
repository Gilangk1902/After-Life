package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.Address;
import com.afterlife.R;

import java.util.ArrayList;

public class AddressCardAdapter extends RecyclerView.Adapter<AddressCardAdapter.ViewHolder>{
    private ArrayList<Address> addresses = new ArrayList<>();
    private Context context;

    public AddressCardAdapter(Context context, ArrayList<Address> addresses) {
        this.addresses = addresses;
        this.context = context;
    }

    @NonNull
    @Override
    public AddressCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.address_card_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressCardAdapter.ViewHolder holder, int position) {
        //TODO : Bind Data
        if(getItemCount()>0){
            holder.address_title_TextView.setText(addresses.get(position).getAddressTitle());
            holder.username_address_TextView.setText(addresses.get(position).getName());
            holder.address_phoneNum_TextView.setText(addresses.get(position).getPhoneNumber());
            holder.address_description_TextView.setText(addresses.get(position).getAddressDescription());
        }
    }

    @Override
    public int getItemCount() {
        if(addresses!=null){
            return addresses.size();
        }
        else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView address_title_TextView, username_address_TextView,
                            address_phoneNum_TextView, address_description_TextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            address_title_TextView = itemView.findViewById(R.id.address_title_TextView);
            username_address_TextView = itemView.findViewById(R.id.user_name_address_TextView);
            address_phoneNum_TextView = itemView.findViewById(R.id.address_phoneNum_TextView);
            address_description_TextView = itemView.findViewById(R.id.address_description_TextView);
        }
    }
}
