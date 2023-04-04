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
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextView login_Here;
    private Button register_Button;

    private EditText name_EditText;
    private TextView name_ErrorMsg;
    private EditText email_EditText;
    private TextView email_ErrorMsg;
    private EditText password_EditText;
    private TextView password_ErrorMsg;
    private EditText confPassword_EditText;
    private TextView confPassword_ErrorMsg;
    private TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        InitViews();

        login_Here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CustomValidator.NameValidator(name_EditText, name_ErrorMsg) &&
                CustomValidator.EmailValidator(email_EditText, email_ErrorMsg) &&
                CustomValidator.PasswordValidator(password_EditText, password_ErrorMsg) &&
                CustomValidator.PasswordValidator(confPassword_EditText, confPassword_ErrorMsg) &&
                CustomValidator.CompareValidator(confPassword_EditText, password_EditText, confPassword_ErrorMsg)){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void InitViews(){
        login_Here = findViewById(R.id.login_TextView_Link);
        register_Button = findViewById(R.id.register_Button);
        name_EditText = findViewById(R.id.name_EditText);
        name_ErrorMsg = findViewById(R.id.name_ErrorMsg);
        email_EditText = findViewById(R.id.email_EditText_register);
        email_ErrorMsg = findViewById(R.id.email_ErrorMsg_register);
        password_EditText = findViewById(R.id.password_EditText);
        password_ErrorMsg = findViewById(R.id.password_ErrorMSG);
        confPassword_EditText = findViewById(R.id.confirmpassword_EditText);
        confPassword_ErrorMsg = findViewById(R.id.confirmPassword_ErrorMsg);
    }
}