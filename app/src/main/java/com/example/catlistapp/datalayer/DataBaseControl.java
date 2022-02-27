package com.example.catlistapp.datalayer;

import androidx.room.Room;

import com.example.catlistapp.app.App;
import com.example.catlistapp.datalayer.room.AppDatabase;
import com.example.catlistapp.datalayer.room.CatDao;

public class DataBaseControl {
    private static DataBaseControl DBControl = new DataBaseControl();

    public static DataBaseControl getInstance() {
        return DBControl;
    }

    public synchronized CatDao getDataBase(){
        AppDatabase database = Room.databaseBuilder(App.getAppContext(),
                AppDatabase.class,"cat-base")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        return database.catDao();
    }



}
