package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.afterlife.R;

import java.util.List;

public class CountrySpinnerAdapter extends ArrayAdapter<String> {

    LayoutInflater layoutInflater;

    public CountrySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = layoutInflater.inflate(R.layout.countries_spinner_layout, null,true);
        String countries = getItem(position);
        TextView textView = (TextView)rowView.findViewById(R.id.nameCountry_TextView);
        textView.setText(countries.toString());
        return rowView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.countries_spinner_layout, parent,false);

        String countries = getItem(position);
        TextView textView = (TextView)convertView.findViewById(R.id.nameCountry_TextView);
        textView.setText(countries.toString());
        return convertView;
    }
}
