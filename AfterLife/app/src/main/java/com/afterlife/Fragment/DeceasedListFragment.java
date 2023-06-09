package com.afterlife.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afterlife.Adapters.DeceasedCardAdapter;
import com.afterlife.DataClass.DataBase;
import com.afterlife.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeceasedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeceasedListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeceasedListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeceasedListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeceasedListFragment newInstance(String param1, String param2) {
        DeceasedListFragment fragment = new DeceasedListFragment();
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

    private RecyclerView deceasedRecyclerView;
    private LinearLayoutManager deceasedLayoutManager;
    private DeceasedCardAdapter deceasedCardAdapter;

    private ImageView imageView;
    private TextView deceasedName, liveSpan, pendingMessage;
    private LinearLayout pendingBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deceased_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitViews(view);
        BindData(view);
    }

    private void InitViews(View view){
        deceasedRecyclerView = view.findViewById(R.id.deceased_card_RecyclerView);
        deceasedCardAdapter = new DeceasedCardAdapter(getContext(), DataBase.deceasedData);
        deceasedLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        SetRecyclerView(deceasedRecyclerView, deceasedLayoutManager, deceasedCardAdapter);
    }
    private void BindData(View view){
        SetRecyclerView(deceasedRecyclerView, deceasedLayoutManager, deceasedCardAdapter);
    }

    private void SetRecyclerView(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager,
                                 RecyclerView.Adapter adapter){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}