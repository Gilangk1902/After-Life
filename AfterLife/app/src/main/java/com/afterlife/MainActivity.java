package com.afterlife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

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
}