package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.afterlife.DataClass.Address;
import com.afterlife.R;

import java.util.ArrayList;

public class AddressSpinnerAdapter extends ArrayAdapter<Address> {
    private LayoutInflater layoutInflater;

    public AddressSpinnerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Address> objects) {
        super(context, resource, objects);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = layoutInflater.inflate(R.layout.countries_spinner_layout, null, true);
        Address address = getItem(position);

        TextView name = rowView.findViewById(R.id.nameCountry_TextView);
        name.setText(address.getName() + address.getAddressTitle());
        return rowView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.countries_spinner_layout, parent, false);
        }
        Address address = getItem(position);
        TextView name = convertView.findViewById(R.id.nameCountry_TextView);
        name.setText(address.getName() + address.getAddressTitle());
        return convertView;
    }
}
