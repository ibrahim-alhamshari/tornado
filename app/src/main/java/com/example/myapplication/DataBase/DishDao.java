package com.example.myapplication.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DishDao {

    @Query("SELECT * FROM dish")
    List<Dish> getAllTasks();

    @Insert
    void insertTask(Dish... dish);
}
