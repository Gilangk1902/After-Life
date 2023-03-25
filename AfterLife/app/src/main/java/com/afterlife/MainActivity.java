package com.afterlife;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.countrySpinner);
        countries.add("Jakarta Selatan");
        countries.add("Tangerang Selatan");

        CountrySpinnerAdapter adapter = new CountrySpinnerAdapter(this, R.layout.countries_spinner_layout, countries);
        spinner.setAdapter(adapter);
    }
}