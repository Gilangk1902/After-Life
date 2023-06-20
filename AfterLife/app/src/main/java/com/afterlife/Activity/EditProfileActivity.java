package com.afterlife.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Session;
import com.afterlife.DataClass.User;
import com.afterlife.OtherScripts.CustomValidator;
import com.afterlife.R;

import org.w3c.dom.Text;

import java.util.Calendar;

public class EditProfileActivity extends AppCompatActivity {

    private EditText name, email, SIN;
    private Spinner day, month, year, gender, religion;
    private Button saveButton;
    private TextView errorMessage;
    private ArrayAdapter<Integer> dayAdapter;
    private ArrayAdapter<String> monthAdapter;
    private ArrayAdapter<Integer> yearAdapter;
    private ArrayAdapter<String> genderAdapter;
    private ArrayAdapter<String> religionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        InitViews();
        DataBind();
        Listeners();
    }

    private void Listeners(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = Session.getUser();
                if(isValid()){
                    ChangeUserAttributes(user);
                    Intent intent = new Intent(EditProfileActivity.this ,
                            MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void ChangeUserAttributes(User user){
        User newUser = new User(user.getId(),name.getText().toString(), email.getText().toString(),
                user.getPassword(), user.getProfilePic(), user.getAddresses(),
                SIN.getText().toString(), religion.getSelectedItem().toString(),
                gender.getSelectedItem().toString(), user.getDOB());
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setGender(newUser.getGender());
        user.setReligion(newUser.getReligion());
        user.setSIN(newUser.getSIN());
        //TODO : FINISH THIS
    }

    private boolean isValid(){
        //TODO : MAKE FUNCTION
        if(CustomValidator.EmptyValidator(name, errorMessage) &&
                CustomValidator.EmptyValidator(email, errorMessage)){
            return true;
        }
        return false;
    }

    private void InitViews(){
        dayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                DataBase.dayList);
        monthAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                DataBase.monthList);
        yearAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                DataBase.yearList);
        genderAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                DataBase.genderList);
        religionAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                DataBase.religionList);
        name = findViewById(R.id.name_EditText_EditProfile);
        email = findViewById(R.id.email_EditText_EditProfile);
        day = findViewById(R.id.day_spinner_EditProfile);
        day.setAdapter(dayAdapter);
        month = findViewById(R.id.month_spinner_EditProfile);
        month.setAdapter(monthAdapter);
        year = findViewById(R.id.year_spinnner_EditProfile);
        year.setAdapter(yearAdapter);
        gender = findViewById(R.id.gender_spinner_EditProfile);
        gender.setAdapter(genderAdapter);
        religion = findViewById(R.id.religion_spinner_EditProfile);
        religion.setAdapter(religionAdapter);
        SIN = findViewById(R.id.SIN_EditText_EditProfile);
        saveButton = findViewById(R.id.save_changes_Button);
        errorMessage = findViewById(R.id.edit_profile_ErrorMessage);
    }

    private void DataBind(){
        User user = Session.getUser();
        name.setText(user.getName());
        email.setText(user.getEmail());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getDOB());
        day.setSelection(dayAdapter.getPosition(calendar.get(Calendar.DAY_OF_MONTH)));
        month.setSelection(calendar.get(Calendar.MONTH)-1);
        year.setSelection(yearAdapter.getPosition(calendar.get(Calendar.YEAR)));
        gender.setSelection(genderAdapter.getPosition(user.getGender()));
        religion.setSelection(religionAdapter.getPosition(user.getReligion()));
        SIN.setText(user.getSIN());
    }
}