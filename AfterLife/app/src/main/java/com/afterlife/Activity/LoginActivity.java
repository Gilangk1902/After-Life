package com.afterlife.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Session;
import com.afterlife.DataClass.User;
import com.afterlife.OtherScripts.CustomValidator;
import com.afterlife.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextView register_here;
    private Button login_Btn;
    private EditText username_EditText;
    private TextView username_ErrorMsg;
    private EditText password_EditText;
    private TextView password_ErrorMsg;
    private TextInputLayout password_layout;
    private TextInputLayout username_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        InitViews();
        ClickListeners();
    }

    private void ClickListeners(){
        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userFound = false;
                boolean emailFound = false;
                User log_user = new User(null, null, null, null, null,
                        null, null, null, null);

                if(isValid()){
                    for(int i = 0; i< DataBase.userData.size(); i++){
                        if(DataBase.User_is_email_n_password_match(i, username_EditText, password_EditText)){
                            log_user = DataBase.userData.get(i);
                            userFound = true;
                            break;
                        }
                        else if(DataBase.User_email_is_found_but_password_dont_match(i, username_EditText, password_EditText)){
                            emailFound = true;
                            break;
                        }
                    }

                    if(userFound){
                        Session.Login(log_user);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if(emailFound){
                        password_ErrorMsg.setText("password incorrect");
                        password_ErrorMsg.setTextColor(Color.RED);
                    }
                    else if(!userFound){
                        username_ErrorMsg.setText("email not registered");
                        username_ErrorMsg.setTextColor(Color.RED);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private boolean isValid(){
        if(CustomValidator.NameValidator(username_EditText, username_ErrorMsg) &&
                CustomValidator.PasswordValidator(password_EditText, password_ErrorMsg)){
            return true;
        }
        else{
            return false;
        }
    }

    private void InitViews(){
        register_here = findViewById(R.id.register_TextView_link);
        login_Btn = findViewById(R.id.Login_Button);
        username_EditText = findViewById(R.id.email_EditText_login);
        username_ErrorMsg = findViewById(R.id.email_ErrorMSG_login);
        password_EditText = findViewById(R.id.password_EditText_login);
        password_ErrorMsg = findViewById(R.id.password_ErrorMsg_login);
        password_layout = findViewById(R.id.textInputLayout4);
        username_layout = findViewById(R.id.textInputLayout3);
    }
}