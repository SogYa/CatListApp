package com.example.catlistapp.screen.listScreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.catlistapp.datalayer.DataBaseControl;
import com.example.catlistapp.model.Cat;

import java.util.List;

public class MainFragmentVM extends ViewModel {
    private LiveData<List<Cat>> mutableLiveData;

    public MainFragmentVM() {
    mutableLiveData =  new MutableLiveData<>();
    }

    public void updateList(){
        mutableLiveData = DataBaseControl.getInstance().getDataBase().getAll();

    }

    public LiveData<List<Cat>> getMutableLiveData() {
        return mutableLiveData;
    }
}