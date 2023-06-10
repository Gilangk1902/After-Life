package com.afterlife.Activity;

import static android.Manifest.permission.READ_MEDIA_IMAGES;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;

import com.afterlife.Fragment.AddDeceasedFragment_step1;
import com.afterlife.DataClass.DataBase;
import com.afterlife.DataClass.Deceased;
import com.afterlife.OtherScripts.FragmentUtils;
import com.afterlife.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AddDeceasedActivity extends AppCompatActivity {

    private Deceased new_deceased;
    private FragmentManager fragmentManager;
    private String name, date_of_death, getDate_of_birth, gender, religion, image;
    private int SIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deceased);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fragmentManager = getSupportFragmentManager();
        FragmentUtils.ReplaceFragment(fragmentManager, new AddDeceasedFragment_step1(), R.id.addDeceased_frameLayout);

        new_deceased = new Deceased(null,null, 0, null, null,null,null, null);

        ActivityCompat
                .requestPermissions(this,
                    new String[]{
                        READ_MEDIA_IMAGES, WRITE_EXTERNAL_STORAGE
                    },
                    PackageManager.PERMISSION_GRANTED);
    }

    public void buttonCreateImageFIle(Uri uri) throws IOException {
        StorageManager storageManager = (StorageManager) getSystemService(STORAGE_SERVICE);
        StorageVolume storageVolume = storageManager.getStorageVolumes().get(0);

        InputStream inputStream = getContentResolver().openInputStream(uri);
        Bitmap bitmapInputImage = BitmapFactory.decodeStream(inputStream);

        if(bitmapInputImage!=null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapInputImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] bytesArray = byteArrayOutputStream.toByteArray();

            File directory = new File(storageVolume.getDirectory().getPath() + "/Download/afterlife_assets");
            if(!directory.exists()){
                directory.mkdirs();
            }
            File fileOutput = new File(directory, "Test.jpeg");
            FileOutputStream fileOutputStream =  new FileOutputStream(fileOutput);
            fileOutputStream.write(bytesArray);
            fileOutputStream.close();

            image = fileOutput.getPath();
        }
    }

    int reqCode = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == reqCode && resultCode == Activity.RESULT_OK){
            if(data != null){
                Uri uri = data.getData();
                if(uri != null){
                    try {
                        buttonCreateImageFIle(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void OpenFileChooser(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, reqCode);
    }

    public void Finish_Add(){
        DataBase.deceasedData.add(new_deceased);
    }
    public Deceased GetDeceased(){
        return this.new_deceased;
    }

    public FragmentManager GetFragmentManager(){
        return this.fragmentManager;
    }
}