package com.afterlife;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.afterlife.Adapters.CountrySpinnerAdapter;
import com.afterlife.Adapters.DeceasedSpinnerAdapter;
import com.afterlife.Adapters.FuneralsAdapter;
import com.afterlife.Adapters.PromoAdapter;
import com.afterlife.DataClass.Deceased;
import com.afterlife.DataClass.Funeral;
import com.afterlife.DataClass.Promo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context context;
    public HomePageFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView funeralRecyclerView;
    RecyclerView promoRecyclerView;
    LinearLayoutManager funeral_linearLayoutManager;
    LinearLayoutManager promo_linearLayoutManager;
    FuneralsAdapter funeralAdapter;
    PromoAdapter promoAdapter;

    ArrayList<Funeral> funeralsDataSource = new ArrayList<Funeral>();
    ArrayList<Promo> promosDataSource = new ArrayList<Promo>();
    ArrayList<Deceased> deceasedDataSource = new ArrayList<Deceased>();
    List<String> countries = new ArrayList<String>();

    Spinner spinner;
    Spinner deceased_spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataInit();

        funeralRecyclerView = (RecyclerView) view.findViewById(R.id.funeral_RecyclerView);
        funeralAdapter = new FuneralsAdapter(getContext(), funeralsDataSource);
        funeral_linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        funeralRecyclerView.setLayoutManager(funeral_linearLayoutManager);
        funeralRecyclerView.setAdapter(funeralAdapter);

        promoRecyclerView = (RecyclerView) view.findViewById(R.id.promo_recyclerview);
        promoAdapter = new PromoAdapter(getContext(), promosDataSource);
        promo_linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        promoRecyclerView.setLayoutManager(promo_linearLayoutManager);
        promoRecyclerView.setAdapter(promoAdapter);

        deceased_spinner = view.findViewById(R.id.deceased_spinner);
        DeceasedSpinnerAdapter deceasedSpinnerAdapter = new DeceasedSpinnerAdapter(getContext(), R.layout.deceased_spinner_layout, deceasedDataSource);
        deceased_spinner.setAdapter(deceasedSpinnerAdapter);

        spinner = (Spinner) view.findViewById(R.id.countrySpinner);
        CountrySpinnerAdapter spinnerAdapter = new CountrySpinnerAdapter(getContext(), R.layout.countries_spinner_layout, countries);
        spinner.setAdapter(spinnerAdapter);
    }

    private void DataInit() {
        funeralsDataSource.add(new Funeral("Funeral Home Osis Lestari", 4.5f, "Tangerang, Banten", "Chatolic Christian", "Mortuarium",
                "Crematorium", "Columbarium", "Memorial Wall", "https://placekitten.com/300/300"));
        funeralsDataSource.add(new Funeral("Selapajang Jaya Public Cemetery", 4.3f, "Tangerang, Banten", "All Religion", "Public burial complex",
                "", "", "", "https://res.cloudinary.com/demo/image/upload/s--1tQspuaM--/c_imagga_crop/kitten.jpg"));

        countries.add("Jakarta Selatan");
        countries.add("Tangerang Selatan");

        ArrayList<String> features1 = new ArrayList<>();
        features1.add("Funeral procession according to religion");
        features1.add("Custom tombstone");
        features1.add("Consumption for 100 pax");
        features1.add("Standard wreath of condolences");
        features1.add("Standard transportation to funeral homes or cemetery");
        promosDataSource.add(new Promo("Standard", 15000000, features1, true));

        ArrayList<String> features2 = new ArrayList<>();
        features2.add("Funeral procession according to religion");
        features2.add("Custom tombstone and decoration");
        features2.add("Consumption for 250 pax");
        features2.add("Large wreath of condolences");
        features2.add("VIP transportation to funeral homes or cemetery");
        features2.add("Include tents and chair for guest");
        promosDataSource.add(new Promo("VIP", 25000000, features2, true));

        deceasedDataSource.add(new Deceased("Christian Aiden Wijaya", 123,
                new GregorianCalendar(1995, Calendar.DECEMBER, 20).getTime(),
                new GregorianCalendar(2023, Calendar.MARCH, 31).getTime(), "Male", "Chatolic Christian"));

        deceasedDataSource.add(new Deceased("Gilang Kurniawan", 124,
                new GregorianCalendar(2003, Calendar.FEBRUARY, 19).getTime(),
                new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), "Male", "Islam"));
    }
}