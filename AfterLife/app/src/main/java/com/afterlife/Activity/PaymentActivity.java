package com.afterlife.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.afterlife.Fragment.CartFragment;
import com.afterlife.Fragment.HomePageFragment;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;

public class PaymentActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        fragmentManager = getSupportFragmentManager();
        Fragment cartFragment = CartFragment.newInstance("", "");
        FragmentUtils.ReplaceFragment(fragmentManager, cartFragment, R.id.Payment_FrameLayout);
    }

}