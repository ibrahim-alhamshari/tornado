package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DataBase.Dish;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

// 1- Create the class without extensions ..
// 6- Extend RecyclerView.Adapter - StudentAdapter.StudentViewHolder
public class Adapter extends RecyclerView.Adapter<Adapter.TaskViewHolder> {

    // 2- create the list the the adapter will use to bind data
    List<Dish> allTasks = new ArrayList<Dish>();

    public Adapter(List<Dish> allTasks) {
        this.allTasks = allTasks;
    }

    // 3- create the ViewHolder class (Wraps the data and the view)
    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView dichName;
        private TextView price;
        private TextView ingredients;

        public Dish dish;
        View itemView;

        // + setting the itemView value
        public TaskViewHolder(@NonNull View view) {
            super(view);
            this.itemView=view;
            dichName = view.findViewById(R.id.titleFragment);
            price = view.findViewById(R.id.bodyFragment);

            itemView.findViewById(R.id.seeMoreButtonInMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            System.out.println(getItemId() + "+++++++++++++++++++++");
            Intent intent = new Intent(view.getContext(), Details.class);
            intent.putExtra("dishName", dish.dishName);
            intent.putExtra("price", dish.price);
            intent.putExtra("ingredients", dish.ingradient);
            view.getContext().startActivity(intent);
            }
           }

            );
        }

    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        // 7- create the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_blank, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.dish = allTasks.get(position);
        String dishName = allTasks.get(position).dishName;
        String price = allTasks.get(position).price;
        String ingradient = allTasks.get(position).ingradient;


        holder.dichName.setText(dishName);
        holder.price.setText(price);
//    holder.ingredients.setText(ingradient);
    }

    @Override
    public int getItemCount() {
        return allTasks.size();
    }
}
