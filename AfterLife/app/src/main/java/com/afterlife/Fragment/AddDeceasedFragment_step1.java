package com.afterlife.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.afterlife.Activity.AddDeceasedActivity;
import com.afterlife.Activity.MainActivity;
import com.afterlife.DataClass.DataBase;
import com.afterlife.OtherScripts.CustomValidator;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AddDeceasedFragment_step1 extends Fragment {
    private static String ARG_PARAM1 = "param1";
    private static String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public AddDeceasedFragment_step1() {

    }
    public static AddDeceasedFragment_step1 newInstance(String param1, String param2) {
        AddDeceasedFragment_step1 fragment = new AddDeceasedFragment_step1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    Spinner day, month, year, hour, minute, gender, religion;
    EditText name, SIN;
    TextView name_error_msg, SIN_error_msg;
    Button next_btn;
    ImageButton prev_btn;

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
        return inflater.inflate(R.layout.fragment_add_deceased_step1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InitViews(view);
        Listeners();
    }

    private void Listeners(){
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CustomValidator.NameValidator(name, name_error_msg) && CustomValidator.NameValidator(SIN, SIN_error_msg)){
                    AddDeceasedActivity deceasedActivity = (AddDeceasedActivity)getActivity();

                    Calendar birth = Calendar.getInstance();
                    birth.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day.getSelectedItem().toString()));
                    birth.set(Calendar.MONTH, month.getSelectedItemPosition());
                    birth.set(Calendar.YEAR, Integer.valueOf(year.getSelectedItem().toString()));

                    Calendar death = Calendar.getInstance();

                    deceasedActivity.GetDeceased()
                                    .set_step1(name.getText().toString(),
                                            Integer.valueOf(SIN.getText().toString()),
                                            birth, death,
                                            gender.getSelectedItem().toString(),
                                            religion.getSelectedItem().toString());

                    FragmentUtils.ReplaceFragment(deceasedActivity.GetFragmentManager(),
                            new AddDeceasedFragment_step2(), R.id.addDeceased_frameLayout);
                }
            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayAdapter<Integer> MakeAdapter(ArrayList<Integer>  list){
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        return  adapter;
    }

    private void InitViews(View view){
        day = view.findViewById(R.id.day_spinner_addDeceased);
        year = view.findViewById(R.id.year_spinnner_addDeceased);
        month = view.findViewById(R.id.month_spinner_addDeceased);
        hour = view.findViewById(R.id.hour_spinner_addDeceased);
        minute = view.findViewById(R.id.minute_spinner_addDeceased);

        day.setAdapter(MakeAdapter(DataBase.dayList));
        year.setAdapter(MakeAdapter(DataBase.yearList));
        hour.setAdapter(MakeAdapter(DataBase.hourList));
        minute.setAdapter(MakeAdapter(DataBase.minuteList));
        ArrayAdapter<String> string_Adapter =
                new ArrayAdapter<String>(getActivity(),
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        DataBase.monthList);
        month.setAdapter(string_Adapter);

        next_btn = view.findViewById(R.id.next_button_addDeceased);
        prev_btn = view.findViewById(R.id.back_button);

        gender = view.findViewById(R.id.gender_spinner_addDeceased);
        religion = view.findViewById(R.id.religion_spinner_addDeceased);

        name = view.findViewById(R.id.name_deceased_editText);
        name_error_msg = view.findViewById(R.id.name_error_msg);
        SIN = view.findViewById(R.id.SIN_deceased_editText);
        SIN_error_msg = view.findViewById(R.id.SIN_error_msg);
    }
}