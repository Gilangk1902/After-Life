package com.afterlife;

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

import com.afterlife.OtherScripts.CustomValidator;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDeceasedFragment_step2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDeceasedFragment_step2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddDeceasedFragment_step2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDeceasedFragment_step2.
     */
    // TODO: Rename and change types and number of parameters
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
                deceasedActivity.ReplaceFragment(new AddDeceasedFragment_step1());
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CustomValidator.NameValidator(family_phoneNumber, familyname_error_msg)){
                    AddDeceasedActivity deceasedActivity = (AddDeceasedActivity) getActivity();
                    //TODO
                    deceasedActivity.ReplaceFragment(new AddDeceasedFragment_step3());
                }
            }
        });
    }
}