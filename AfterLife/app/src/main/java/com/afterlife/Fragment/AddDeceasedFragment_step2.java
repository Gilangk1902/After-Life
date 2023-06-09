package com.afterlife.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.afterlife.Activity.AddDeceasedActivity;
import com.afterlife.OtherScripts.CustomValidator;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDeceasedFragment_step2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDeceasedFragment_step2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AddDeceasedFragment_step2() {
        // Required empty public constructor
    }

    public static AddDeceasedFragment_step2 newInstance(String param1, String param2) {
        AddDeceasedFragment_step2 fragment = new AddDeceasedFragment_step2();
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
        return inflater.inflate(R.layout.fragment_add_deceased_step2, container, false);
    }

    ImageButton prev_button;
    EditText family_name, family_SIN, family_phoneNumber;
    TextView  familyname_error_msg;
    Spinner family_status;
    Button next_button;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InitViews(view);
        Listeners();
    }

    private void InitViews(View view){
        prev_button =  view.findViewById(R.id.back_button_step2);
        next_button = view.findViewById(R.id.next_button_2);
        family_name = view.findViewById(R.id.Family_name_editText);
        family_SIN = view.findViewById(R.id.family_SIN_editText);
        family_phoneNumber = view.findViewById(R.id.family_phone_editText);
        family_status = view.findViewById(R.id.family_status_spinner);
        familyname_error_msg = view.findViewById(R.id.Fname_error_msg);
    }

    private void Listeners(){
        prev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDeceasedActivity deceasedActivity = (AddDeceasedActivity) getActivity();
                FragmentUtils.ReplaceFragment(deceasedActivity.GetFragmentManager(),
                        new AddDeceasedFragment_step1(), R.id.addDeceased_frameLayout);
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CustomValidator.NameValidator(family_phoneNumber, familyname_error_msg)){
                    AddDeceasedActivity deceasedActivity = (AddDeceasedActivity) getActivity();
                    //TODO
                    FragmentUtils.ReplaceFragment(deceasedActivity.GetFragmentManager(),
                            new AddDeceasedFragment_step3(), R.id.addDeceased_frameLayout);
                }
            }
        });
    }
}