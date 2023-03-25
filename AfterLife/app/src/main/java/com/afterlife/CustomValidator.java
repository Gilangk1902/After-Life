package com.afterlife;

import android.widget.EditText;
import android.widget.TextView;

public class CustomValidator {
    public static Boolean NameValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
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
            return false;
        }
        else if(!editText.getText().toString().contains("@")){
            errorMessage.setText("does not contains @");
            return false;
        }
        else if(!editText.getText().toString().endsWith(".com")){
            errorMessage.setText("does not end with .com");
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }

    public static Boolean PasswordValidator(EditText editText, TextView errorMessage){
        if(editText.getText().toString().length() == 0){
            errorMessage.setText("Empty");
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
            return false;
        }
        else{
            errorMessage.setText("");
            return true;
        }
    }


}
