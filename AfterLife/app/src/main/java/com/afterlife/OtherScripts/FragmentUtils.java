package com.afterlife.OtherScripts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.afterlife.R;

public class FragmentUtils {
    public static void ReplaceFragment(FragmentManager fragmentManager, Fragment fragment, int layout){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layout, fragment);
        fragmentTransaction.commit();
    }
}
