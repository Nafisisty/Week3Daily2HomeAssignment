package com.example.week3daily2homeassignment;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Animal> animalArrayList;

    public RecyclerViewAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Animal animal = animalArrayList.get(position);

        if(animal != null){
            viewHolder.setItemAnimal(animal);

            viewHolder.animalNameTextView.setText(animal.getAnimalName());
            viewHolder.animalTypeTextView.setText(animal.getAnimalType());
            viewHolder.animalSoundTextView.setText(animal.getAnimalSound());

            Glide.with(viewHolder.imageView)
                    .load("" + animal.getAnimalImage())
                    .into(viewHolder.imageView);

        }

    }

    @Override
    public int getItemCount() {
        return animalArrayList != null ? animalArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView animalNameTextView, animalTypeTextView, animalSoundTextView;
        public RelativeLayout viewBackground, viewForeground;
        public Animal itemAnimal;

        public void setItemAnimal(Animal itemAnimal) {
            this.itemAnimal = itemAnimal;
        }

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.animalImageViewId);
            animalNameTextView = itemView.findViewById(R.id.animalNameTextViewId);
            animalTypeTextView = itemView.findViewById(R.id.animalTypeTextViewId);
            animalSoundTextView = itemView.findViewById(R.id.animalSoundTextViewId);

            viewBackground = itemView.findViewById(R.id.viewBackgroundId);
            viewForeground = itemView.findViewById(R.id.viewForegroundId);

        }
    }
}
