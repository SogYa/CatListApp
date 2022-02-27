package com.example.catlistapp.datalayer.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.catlistapp.model.Cat;

import java.util.List;

@Dao
public interface CatDao {
    @Query("SELECT * FROM cat")
    LiveData<List<Cat>> getAll();

    @Insert
    void insert(Cat cat);

    @Delete
    void deleteCat(Cat cat);
 }
