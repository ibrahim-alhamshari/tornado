package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent= getIntent();
        String dishName = intent.getStringExtra("dishName");
        String price = intent.getStringExtra("price");
        String ingredients = intent.getStringExtra("ingredients");

        TextView textName= findViewById(R.id.dishNameOneDishPage);
        TextView textPrice = findViewById(R.id.priceInOnePage);
        TextView textIngred= findViewById(R.id.ingredientsInOnePage);

        textName.setText(dishName);
        textPrice.setText(price);
        textIngred.setText(ingredients);
    }
}