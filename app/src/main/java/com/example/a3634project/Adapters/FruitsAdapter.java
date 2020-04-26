package com.example.a3634project.Adapters;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.FruitListItem;
import com.example.a3634project.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FruitsAdapter extends RecyclerView.Adapter <FruitsAdapter.fruitsViewHolder> {
private ArrayList<FruitListItem> mFruitsList;

    public static class fruitsViewHolder extends RecyclerView.ViewHolder{
        public ImageView mFruitImage;
        public TextView mFruitName;
        public CheckBox mCheckBox;


        public fruitsViewHolder (@NonNull View itemView){
            super(itemView);
            mFruitImage = itemView.findViewById(R.id.fruitImage);
            mFruitName = itemView.findViewById(R.id.fruitsName);
            mCheckBox = itemView.findViewById(R.id.fruitsCheck);

            // code adapted from https://stackoverflow.com/questions/8386832/android-checkbox-listener
            mCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(((CompoundButton) v).isChecked()){
                    mFruitName.setTextColor(Color.GREEN);
                    } else {
                    mFruitName.setTextColor(Color.RED);
                    }
                }
            });

        }

    }

    public FruitsAdapter (ArrayList<FruitListItem> fruitsList){
        mFruitsList = fruitsList;
    }
    @NonNull
    @Override
    public fruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruits_list, parent,false);
        fruitsViewHolder fViewHolder = new fruitsViewHolder(v);
        return fViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull fruitsViewHolder holder, int position) {
        FruitListItem fruits = mFruitsList.get(position);
        holder.mFruitImage.setImageResource(fruits.getmFruitImage());
        holder.mFruitName.setText(fruits.getmFruitName());
    }

    @Override
    public int getItemCount() {
        return mFruitsList.size();
    }
}
