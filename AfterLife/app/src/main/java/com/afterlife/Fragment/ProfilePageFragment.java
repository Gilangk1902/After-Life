package com.afterlife.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afterlife.Activity.EditProfileActivity;
import com.afterlife.Activity.MainActivity;
import com.afterlife.Adapters.AddressCardAdapter;
import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Session;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;
import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilePageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfilePageFragment() {
        // Required empty public constructor
    }
    public static ProfilePageFragment newInstance(String param1, String param2) {
        ProfilePageFragment fragment = new ProfilePageFragment();
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
        return inflater.inflate(R.layout.fragment_profile_page, container, false);
    }

    private TextView name_TextView, email_TextView;
    private ImageView profilePicture;
    private RecyclerView address_RecyclerView;
    private AddressCardAdapter addressCardAdapter;
    private LinearLayoutManager addresses_LinearLayoutManager;
    private Button logOut_Button, editProfile_Button;
    private FragmentManager fragmentManager;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InitViews(view);
        Listeners();
        fragmentManager = getActivity().getSupportFragmentManager();

        if(Session.getUser() != null){
            BindData();
        }
    }

    private void Listeners(){
        logOut_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session.Logout();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        editProfile_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BindData(){
        name_TextView.setText(Session.getUser().getName());
        email_TextView.setText(Session.getUser().getEmail());
        Glide.with(getContext() )
                .load(Session.getUser().getProfilePic())
                .into(profilePicture);
        InitRecyclerView();
    }

    private void InitRecyclerView(){
        addressCardAdapter = new AddressCardAdapter(getContext(), Session.getUser().getAddresses());
        address_RecyclerView.setAdapter(addressCardAdapter);
        addresses_LinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        SetRecyclerView(address_RecyclerView, addresses_LinearLayoutManager, addressCardAdapter);
    }

    private void SetRecyclerView(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager,
                                 RecyclerView.Adapter adapter){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void InitViews(View view){
        name_TextView = view.findViewById(R.id.profile_name_TextView);
        email_TextView = view.findViewById(R.id.profile_email_TextView);
        profilePicture = view.findViewById(R.id.profile_picture);
        address_RecyclerView = view.findViewById(R.id.addressList_RecyclerView);
        logOut_Button = view.findViewById(R.id.logout_Button);
        editProfile_Button = view.findViewById(R.id.editProfile_Button);
    }
}