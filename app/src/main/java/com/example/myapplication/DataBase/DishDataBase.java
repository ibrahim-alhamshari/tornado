package com.example.myapplication.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Dish.class} , version = 2)
public abstract class DishDataBase extends RoomDatabase {

    public abstract DishDao taskDAO();
}