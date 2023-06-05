package com.afterlife.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.afterlife.DataClass.Session;
import com.afterlife.Fragment.DeceasedListFragment;
import com.afterlife.Fragment.HomePageFragment;
import com.afterlife.Fragment.ProfilePageFragment;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideActionBar();

        fragmentManager = getSupportFragmentManager();
        FragmentUtils.ReplaceFragment(fragmentManager, new HomePageFragment(), R.id.frame_layout);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        BottomNavigationView_Handler();
        BottomNav_itemSelected_changer();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        BottomNav_itemSelected_changer();
    }

    private void BottomNavigationView_Handler(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home_Nav){
                    FragmentUtils.ReplaceFragment(fragmentManager, new HomePageFragment(), R.id.frame_layout);
                }
                else if(item.getItemId() == R.id.transaction_Nav){
                    if(Session.getUser() == null){
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "You need to Login First", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        FragmentUtils.ReplaceFragment(fragmentManager, new DeceasedListFragment(), R.id.frame_layout);
                    }
                }
                else if(item.getItemId() == R.id.profile_Nav){
                    if(Session.getUser() == null){
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "You need to Login First", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        FragmentUtils.ReplaceFragment(fragmentManager, new ProfilePageFragment(), R.id.frame_layout);
                    }
                }
                return true;
            }
        });
    }

    private void HideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void BottomNav_itemSelected_changer(){
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        Fragment fragInstance = fragmentManager2.findFragmentById(R.id.frame_layout);

        if(fragInstance instanceof  HomePageFragment){
            bottomNavigationView.setSelectedItemId(R.id.home_Nav);
        }
    }
}