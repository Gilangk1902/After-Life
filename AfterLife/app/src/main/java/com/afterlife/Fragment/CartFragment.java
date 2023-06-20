package com.afterlife.Fragment;

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

import com.afterlife.Activity.MainActivity;
import com.afterlife.Adapters.CartAdapter;
import com.afterlife.Adapters.DeceasedSpinnerAdapter;
import com.afterlife.Adapters.FuneralsAdapter;
import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Session;
import com.afterlife.R;

public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Spinner deceasedSpinner;
    private RecyclerView cartRecyclerView;
    private DeceasedSpinnerAdapter deceasedSpinnerAdapter;
    private LinearLayoutManager cartLinearLayoutManager;
    private CartAdapter cartAdapter;
    private Button back_Button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitViews(view);
        InitAdapters();
        Listeners();
    }

    public void Listeners(){
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InitViews(View view){
        deceasedSpinner = view.findViewById(R.id.deceased_spinner_cart);
        cartRecyclerView = (RecyclerView) view.findViewById(R.id.cart_RecyclerView);
        back_Button = view.findViewById(R.id.back_button_cart);
    }

    private void InitAdapters(){
        deceasedSpinnerAdapter = new DeceasedSpinnerAdapter(getContext(),
                R.layout.deceased_spinner_layout, DataBase.deceasedData);
        deceasedSpinner.setAdapter(deceasedSpinnerAdapter);

        cartLinearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);

        cartAdapter = new CartAdapter(getContext(), Session.getUser().getCart());
        SetRecyclerView(cartRecyclerView, cartLinearLayoutManager, cartAdapter);
    }
    private void SetRecyclerView(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager,
                                 RecyclerView.Adapter adapter){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}