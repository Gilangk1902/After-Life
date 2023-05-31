package com.afterlife.OtherScripts;

import com.afterlife.R;

public class IconSet {
    public static int setReligionIcon(String religion){
        //TODO : FINISH this fucker
        if(religion.equals("islam"))
            return R.drawable.islamic;
        else if(religion.equals("christian"))
            return R.drawable.heavy_latin_cross;
        return R.drawable.islamic;
    }
}
