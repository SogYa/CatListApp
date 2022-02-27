package com.example.catlistapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cat")
public class Cat {

    public void setId(long id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "cat_name")
    private String name;
    @ColumnInfo(name = "cat_age")
    private String age;
    @ColumnInfo(name = "cat_photo_url")
    private String imageUri;


    public Cat( String name, String age, String imageUri) {

        this.name = name;
        this.age = age;
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
