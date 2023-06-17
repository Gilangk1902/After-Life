package com.afterlife.DataBaseHandler;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserHandler {
    private static DatabaseReference databaseReference;

    public static DatabaseReference getUser(String id){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User")
                .child("Customer").child(id);

        return databaseReference;
    }

    public static void test_getName(TextView name_TextView){
        DatabaseReference user = getUser("CS001");
        name_TextView.setText("taeststat");
        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String value = snapshot.child("Name").getValue(String.class);
                    name_TextView.setText(value);
                }
                else{
                    name_TextView.setText("Guest");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //TODO : I dont know whats this for yet
            }
        });
    }
}
