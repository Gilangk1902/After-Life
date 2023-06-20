package com.afterlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afterlife.DataClass.Funeral;
import com.afterlife.DataClass.Session;
import com.bumptech.glide.Glide;

public class DetailPageActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView price, name, rating, sold;
    private Button button;
    private Funeral funeral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        Intent intent = getIntent();

        InitViews();

        funeral = (Funeral)intent.getSerializableExtra("funeral");

        BindData(funeral);
        Listeners();
    }

    private void BindData(Funeral funeral){
        Glide.with(this)
                .load(funeral.getUrl())
                .into(imageView);

        name.setText(funeral.getName());
        price.setText("Rp. " + String.valueOf(funeral.getPrice()));
        rating.setText(String.valueOf(funeral.getRating()));
        sold.setText("Sold " + String.valueOf(funeral.getSold()));
    }
    private void InitViews(){
        imageView = findViewById(R.id.image_detail_ImageView);
        price = findViewById(R.id.price_detail_TextView);
        name = findViewById(R.id.name_detail_TextView);
        rating = findViewById(R.id.rating_detailPage);
        sold = findViewById(R.id.sold_detail_TextView);
        button = findViewById(R.id.order_Button);
    }

    private void Listeners(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getUser().getCart().addItem(funeral);
            }
        });
    }

}