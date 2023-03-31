package com.afterlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import com.afterlife.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView login;
    private Spinner spinner;
    List<String> countries = new ArrayList<String>();
    RecyclerView funeralRecyclerView;
    ArrayList<Funeral> funeralsDataSource = new ArrayList<Funeral>();
    LinearLayoutManager linearLayoutManager;
    FuneralsAdapter funeralAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        funeralRecyclerView = findViewById(R.id.funeral_RecyclerView);
        InitFunerals();

        spinner = (Spinner)findViewById(R.id.countrySpinner);

        countries.add("Jakarta Selatan");
        countries.add("Tangerang Selatan");

        CountrySpinnerAdapter adapter = new CountrySpinnerAdapter(this, R.layout.countries_spinner_layout, countries);
        spinner.setAdapter(adapter);

        BottomNavigationView_Handler();

    }

    private void InitFunerals(){
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        funeralAdapter = new FuneralsAdapter(MainActivity.this ,funeralsDataSource);

        funeralRecyclerView.setLayoutManager(linearLayoutManager);
        funeralRecyclerView.setAdapter(funeralAdapter);

        funeralsDataSource.add(new Funeral("Funeral Home Osis Lestari", 4.5f, "Tangerang, Banten", "Chatolic Christian", "Mortuarium",
                "Crematorium", "Columbarium", "Memorial Wall"));
        funeralsDataSource.add(new Funeral("Selapajang Jaya Public Cemetery", 4.3f, "Tangerang, Banten", "All Religion", "Mortuarium",
                "Crematorium", "Columbarium", "Memorial Wall"));

    }

    private void BottomNavigationView_Handler(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.profile_Nav){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

}