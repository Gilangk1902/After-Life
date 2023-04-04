package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.afterlife.DataClass.Deceased;
import com.afterlife.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kotlin.contracts.Returns;

public class DeceasedSpinnerAdapter extends ArrayAdapter<Deceased> {

    LayoutInflater layoutInflater;
    public DeceasedSpinnerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Deceased> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = layoutInflater.inflate(R.layout.deceased_spinner_layout, null, true);
        Deceased decease = getItem(position);

        TextView name = rowView.findViewById(R.id.name_deceased_spinner);
        TextView date = rowView.findViewById(R.id.date_deceased_spinner);
        ImageView icon = rowView.findViewById(R.id.religion_icon_spinner);

        name.setText(decease.getName());

        Date death_date = decease.getDate_of_death();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(dateFormat.format(death_date));


        icon.setImageResource(getIcon(decease.getReligion()));

        return rowView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.deceased_spinner_layout, parent,false);
        }
        Deceased decease = getItem(position);

        TextView name = convertView.findViewById(R.id.name_deceased_spinner);
        TextView date = convertView.findViewById(R.id.date_deceased_spinner);
        ImageView icon = convertView.findViewById(R.id.religion_icon_spinner);

        name.setText(decease.getName());
        Date death_date = decease.getDate_of_death();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(dateFormat.format(death_date));


        icon.setImageResource(getIcon(decease.getReligion()));

        return convertView;
    }

    private int getIcon(String religion){
        if(religion.equals("Islam")){
            return R.drawable.islamic;
        }
        else if(religion.equals("Chatolic Christian")){
            return  R.drawable.heavy_latin_cross;
        }
        return R.drawable.ic_star;
    }
}
