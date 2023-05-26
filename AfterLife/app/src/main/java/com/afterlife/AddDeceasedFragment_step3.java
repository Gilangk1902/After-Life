package com.afterlife;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDeceasedFragment_step3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDeceasedFragment_step3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddDeceasedFragment_step3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDeceasedFragment_step3.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDeceasedFragment_step3 newInstance(String param1, String param2) {
        AddDeceasedFragment_step3 fragment = new AddDeceasedFragment_step3();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_deceased_step3, container, false);
    }

    Button file_choose_button, finish_button;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        file_choose_button = view.findViewById(R.id.file_chooser_btn);
        finish_button = view.findViewById(R.id.finish_button);
        Listeners();
    }

    public void Listeners(){
        file_choose_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDeceasedActivity deceasedActivity = (AddDeceasedActivity)getActivity();
                deceasedActivity.OpenFileChooser();
            }
        });

        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDeceasedActivity deceasedActivity = (AddDeceasedActivity)getActivity();
                //TODO add image path to deceased data
                deceasedActivity.Finish_Add();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}