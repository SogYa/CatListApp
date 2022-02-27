package com.example.catlistapp.screen.catScreen;

import android.app.Application;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bumptech.glide.Glide;
import com.example.catlistapp.R;
import com.example.catlistapp.datalayer.DataBaseControl;
import com.example.catlistapp.instruments.myCallBack;
import com.example.catlistapp.model.Cat;

public class NewCatVM extends AndroidViewModel {
    private String catUri;

    public NewCatVM(@NonNull Application application) {
        super(application);
    }

    public void addNewCat(String name, String age, myCallBack<Boolean> myCallBack) {
        try {
            if (!name.isEmpty() && !age.isEmpty()) {
                DataBaseControl.getInstance().getDataBase()
                        .insert(new Cat(
                                name,
                                age,
                                catUri));
                myCallBack.data(true);
            }
        } catch (NullPointerException e) {
            myCallBack.data(false);
            Toast.makeText(getApplication(), "Пустая фотограия", Toast.LENGTH_SHORT).show();
        }
    }

    public void setImage(ImageView imageView, String uriString) {
        catUri = uriString;
        Glide.with(getApplication().getApplicationContext())
                .load(uriString)
                .placeholder(R.mipmap.ic_cat_foreground)
                .into(imageView);
    }


}