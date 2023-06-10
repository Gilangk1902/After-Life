package com.afterlife.OtherScripts;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;

public class CustomValidator {
    public static Boolean NameValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }

    public static Boolean EmailValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else if(!editText.getText().toString().contains("@")){
            errorMessage.setText("does not contains @");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else if(!editText.getText().toString().endsWith(".com")){
            errorMessage.setText("does not end with .com");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else{
            errorMessage.setText("");
            errorMessage.setTextColor(Color.RED);
            return true;
        }
    }

    public static Boolean PasswordValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }

    public static Boolean CompareValidator(EditText editText1, EditText editText2, TextView errorMessage){
        if(!editText1.getText().toString().equals(editText2.getText().toString())){
            errorMessage.setText("The password don't match");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }

    public static Boolean EmptyValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
            errorMessage.setTextColor(Color.RED);
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }
}
