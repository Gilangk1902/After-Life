package com.afterlife;

import static android.Manifest.permission.READ_MEDIA_IMAGES;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Deceased;
import com.afterlife.DataClass.User;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddDeceasedActivity extends AppCompatActivity {

    Deceased new_deceased;
    String name, date_of_death, getDate_of_birth, gender, religion, image;
    int SIN;
    //Context context = getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deceased);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ReplaceFragment(new AddDeceasedFragment_step1());

        new_deceased = new Deceased(null, 0, null, null,null,null);
        FragmentHandler();

        ActivityCompat
                .requestPermissions(this,
                    new String[]{
                        READ_MEDIA_IMAGES, WRITE_EXTERNAL_STORAGE
                    },
                    PackageManager.PERMISSION_GRANTED);
    }

    public void buttonCreateImageFIle() throws IOException {
        StorageManager storageManager = (StorageManager) getSystemService(STORAGE_SERVICE);
        StorageVolume storageVolume = storageManager.getStorageVolumes().get(0);
        File fileInput = new File(storageVolume.getDirectory().getPath()+"/Download/mr_cat.jpeg");
        Bitmap bitmapInputImage = BitmapFactory.decodeFile(fileInput.getPath());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapInputImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesArray = byteArrayOutputStream.toByteArray();


        File fileOutput = new File(storageVolume.getDirectory().getPath() + "/Download/output4.jpeg");
        FileOutputStream fileOutputStream =  new FileOutputStream(fileOutput);
        fileOutputStream.write(bytesArray);
        fileOutputStream.close();

        image = storageVolume.getDirectory().getPath() + "/Download/output4.jpeg";
    }

    int reqCode = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == reqCode && resultCode == Activity.RESULT_OK){
            if(data == null){return;}
            Uri uri = data.getData();
            //Toast.makeText(this, uri.getPath(), Toast.LENGTH_SHORT).show();
        }
    }
    public void OpenFileChooser(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, reqCode);
    }

    private void FragmentHandler(){
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        Fragment fragInstance = fragmentManager2.findFragmentById(R.id.frame_layout);

        if(fragInstance instanceof  AddDeceasedFragment_step3){

        }
    }

    public void ReplaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.addDeceased_frameLayout, fragment);
        fragmentTransaction.commit();
    }

    public void Step1_Complete(String name, int SIN, String gender, String religion){
//        new_deceased.setName(name);
//        new_deceased.setSIN(SIN);
//        new_deceased.setGender(gender);
//        new_deceased.setReligion(religion);
//        new_deceased.setDate_of_birth();
    }

    public void Step2_Complete(String name, int SIN, int number){

    }

    public void Step3_Complete(){
        DataBase.deceasedData.add(new_deceased);
    }
}