package com.afterlife;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afterlife.OtherScripts.CustomValidator;

public class LoginActivity extends AppCompatActivity {

    private TextView register_here;
    private Button login_Btn;
    private EditText username_EditText;
    private TextView username_ErrorMsg;
    private EditText password_EditText;
    private TextView password_ErrorMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        InitViews();

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
                if(CustomValidator.NameValidator(username_EditText, username_ErrorMsg) &&
                CustomValidator.PasswordValidator(password_EditText, password_ErrorMsg)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void InitViews(){
        register_here = findViewById(R.id.register_TextView_link);
        login_Btn = findViewById(R.id.Login_Button);
        username_EditText = findViewById(R.id.email_EditText_login);
        username_ErrorMsg = findViewById(R.id.email_ErrorMSG_login);
        password_EditText = findViewById(R.id.password_EditText_login);
        password_ErrorMsg = findViewById(R.id.password_ErrorMsg_login);
    }
}