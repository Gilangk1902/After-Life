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

import com.afterlife.DataClass.Funeral;
import com.afterlife.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FuneralsAdapter extends RecyclerView.Adapter<FuneralsAdapter.ViewHolder> {
    ArrayList<Funeral> funeralsData = new ArrayList<Funeral>();
    private Context context;

    public FuneralsAdapter(Context context, ArrayList<Funeral> funeralsData) {
        this.funeralsData = funeralsData;
        this.context = context;
    }


    @NonNull
    @Override
    public FuneralsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.funeral_card_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuneralsAdapter.ViewHolder holder, int position) {
        holder.name.setText(funeralsData.get(position).getName());
        holder.rating.setText(String.valueOf(funeralsData.get(position).getRating()));
        holder.location.setText(funeralsData.get(position).getLocation());
        holder.religion.setText(funeralsData.get(position).getReligion());

        holder.religionIcon.setImageResource(getIcon(funeralsData.get(position).getReligion()));

        holder.feature1.setText(funeralsData.get(position).getFeature(0));
        holder.feature2.setText(funeralsData.get(position).getFeature(1));
        holder.feature3.setText(funeralsData.get(position).getFeature(2));
        holder.feature4.setText(funeralsData.get(position).getFeature(3));

        Glide.with(context).load(funeralsData.get(position).getUrl()).into(holder.image);

        ShowFeature(holder, funeralsData.get(position).getFeature(0),
                funeralsData.get(position).getFeature(1),
                funeralsData.get(position).getFeature(2),
                funeralsData.get(position).getFeature(3));
    }

    @Override
    public int getItemCount() {
        return funeralsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, rating, location, religion;
        private TextView feature1, feature2, feature3, feature4;
        private ImageView image, religionIcon;
        private LinearLayout feature1_LinearLayout, feature2_LinearLayout, feature3_LinearLayout, feature4_LinearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);
            religion = itemView.findViewById(R.id.religion_TextView);
            image = itemView.findViewById(R.id.Image);
            religionIcon = itemView.findViewById(R.id.religion_icon);

            feature1 = itemView.findViewById(R.id.feature1_TextView);
            feature2 = itemView.findViewById(R.id.feature2_TextView);
            feature3 = itemView.findViewById(R.id.feature3_TextView);
            feature4 = itemView.findViewById(R.id.feature4_TextView);

            feature1_LinearLayout = itemView.findViewById(R.id.feature1_LinearLayout);
            feature2_LinearLayout = itemView.findViewById(R.id.feature2_LinearLayout);
            feature3_LinearLayout = itemView.findViewById(R.id.feature3_LinearLayout);
            feature4_LinearLayout = itemView.findViewById(R.id.feature4_LinearLayout);
        }
    }

    private int getIcon(String religion){
        if(religion.equals("Chatolic Christian")){
            return R.drawable.heavy_latin_cross;
        }
        else if (religion.equals("All Religion")){
            return R.drawable.ic_star;
        }
        return R.drawable.ic_star;
    }

    private void ShowFeature(FuneralsAdapter.ViewHolder holder, String feature1, String feature2, String feature3, String feature4){
        if(feature1.equals("")){
            holder.feature1_LinearLayout.setVisibility(View.GONE);
        }
        if (feature2.equals("")){
            holder.feature2_LinearLayout.setVisibility(View.GONE);
        }
        if (feature3.equals("")){
            holder.feature3_LinearLayout.setVisibility(View.GONE);
        }
        if (feature4.equals("")){
            holder.feature4_LinearLayout.setVisibility(View.GONE);
        }
    }
}
