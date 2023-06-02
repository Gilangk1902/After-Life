package com.afterlife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Deceased;
import com.afterlife.OtherScripts.IconSet;
import com.afterlife.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DeceasedCardAdapter extends RecyclerView.Adapter<DeceasedCardAdapter.ViewHolder> {
    private ArrayList<Deceased> deceasedList = new ArrayList<>();
    private Context context;

    public DeceasedCardAdapter(Context context, ArrayList<Deceased> list){
        this.context = context;
        this.deceasedList = list;
    }

    @NonNull
    @Override
    public DeceasedCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.deceased_card_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeceasedCardAdapter.ViewHolder holder, int position) {
        holder.icon.setImageResource(IconSet
                .setReligionIcon(deceasedList.get(position).getReligion().toString()));
        holder.deceasedName.setText(deceasedList.get(position).getName());
        holder.pendingMessage.setText(deceasedList.get(position).getDoc());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        holder.liveSpan.setText(dateFormat.format(deceasedList.get(position).getDate_of_birth())
                + " - " + dateFormat.format(deceasedList.get(position).getDate_of_death()));
        holder.pendingMessage.setText(deceasedList.get(position).getDoc());
    }

    @Override
    public int getItemCount() {
        return deceasedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //TODO : initialize the views component
        private ImageView icon;
        private TextView deceasedName, liveSpan, pendingMessage;
        private LinearLayout pendingBox;
        public ViewHolder(@NonNull View view) {
            super(view);
            icon = view.findViewById(R.id.deceased_card_icon);
            deceasedName = view.findViewById(R.id.deceasedName_TextView);
            liveSpan = view.findViewById(R.id.liveSpan_TextView);
            pendingMessage = view.findViewById(R.id.pending_TextView);
            pendingBox = view.findViewById(R.id.deceasedPending_LinearLayout);
        }
    }
}
