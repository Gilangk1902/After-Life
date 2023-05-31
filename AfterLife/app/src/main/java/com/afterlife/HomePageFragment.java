package com.afterlife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afterlife.Adapters.CoffinsAdapter;
import com.afterlife.Adapters.CountrySpinnerAdapter;
import com.afterlife.Adapters.DeceasedSpinnerAdapter;
import com.afterlife.Adapters.FuneralsAdapter;
import com.afterlife.Adapters.OtherAppliancesAdapter;
import com.afterlife.Adapters.PromoAdapter;
import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Session;

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

    RecyclerView funeralRecyclerView, promoRecyclerView, coffinRecyclerView,
            otherAppliancesRecyclerView;
    LinearLayoutManager funeralLinearLayoutManager, promoLinearLayoutManager, coffinLinearLayoutManager,
            otherAppliancesLinearLayoutManager;
    FuneralsAdapter funeralAdapter;
    PromoAdapter promoAdapter;
    CoffinsAdapter coffinsAdapter;
    OtherAppliancesAdapter otherAppliancesAdapter;

    TextView name_welcome;

    Spinner spinner;
    Spinner deceased_spinner;

    Button addmore_btn;

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

        InitViews(view);
        AddSession();
        Listeners();
    }

    private void InitViews(View view){
        funeralLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        promoLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        coffinLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        otherAppliancesLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        funeralRecyclerView = (RecyclerView) view.findViewById(R.id.funeral_RecyclerView);
        funeralAdapter = new FuneralsAdapter(getContext(), DataBase.funeralsData);
        SetRecyclerView(funeralRecyclerView, funeralLinearLayoutManager,funeralAdapter);

        promoRecyclerView = (RecyclerView) view.findViewById(R.id.promo_recyclerview);
        promoAdapter = new PromoAdapter(getContext(), DataBase.promosData);
        SetRecyclerView(promoRecyclerView, promoLinearLayoutManager,promoAdapter);

        coffinRecyclerView = (RecyclerView) view.findViewById(R.id.coffin_RecyclerView);
        coffinsAdapter = new CoffinsAdapter(getContext(), DataBase.coffinsData);
        SetRecyclerView(coffinRecyclerView, coffinLinearLayoutManager,coffinsAdapter);

        otherAppliancesRecyclerView = (RecyclerView) view.findViewById(R.id.other_recyclerView);
        otherAppliancesAdapter = new OtherAppliancesAdapter(getContext(), DataBase.otherAppliancesData);
        SetRecyclerView(otherAppliancesRecyclerView, otherAppliancesLinearLayoutManager, otherAppliancesAdapter);

        deceased_spinner = view.findViewById(R.id.deceased_spinner);
        DeceasedSpinnerAdapter deceasedSpinnerAdapter = new DeceasedSpinnerAdapter(getContext(), R.layout.deceased_spinner_layout, DataBase.deceasedData);
        deceased_spinner.setAdapter(deceasedSpinnerAdapter);

        name_welcome = view.findViewById(R.id.name_welcome);

        spinner = (Spinner) view.findViewById(R.id.countrySpinner);
        CountrySpinnerAdapter spinnerAdapter = new CountrySpinnerAdapter(getContext(), R.layout.countries_spinner_layout, DataBase.cities);
        spinner.setAdapter(spinnerAdapter);

        addmore_btn = (Button) view.findViewById(R.id.addMore_Btn);
    }

    private void SetRecyclerView(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager,
                                 RecyclerView.Adapter adapter){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void Listeners(){
        addmore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Session.user == null){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "You need to Login First", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getActivity() ,AddDeceasedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void AddSession(){
        if(Session.user != null){
            name_welcome.setText(Session.user.getName());
        }
        else{
            name_welcome.setText("Guest");
        }
    }
}