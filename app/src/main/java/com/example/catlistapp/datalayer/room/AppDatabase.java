package com.example.catlistapp.datalayer.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.catlistapp.model.Cat;

@Database(entities = {Cat.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CatDao catDao();
}
