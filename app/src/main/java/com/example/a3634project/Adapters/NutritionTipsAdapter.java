package com.example.a3634project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.Models.NutritionTips;
import com.example.a3634project.Models.Topic;
import com.example.a3634project.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NutritionTipsAdapter extends RecyclerView.Adapter<NutritionTipsAdapter.ViewHolder> {
    private ArrayList<NutritionTips> nutritionTipsList;

    public NutritionTipsAdapter(ArrayList<NutritionTips> nutritionTipsList){
        this.nutritionTipsList = nutritionTipsList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public TextView mTitle;
        public TextView mDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.nutritionIv);
            mTitle = itemView.findViewById(R.id.nutritionTitleTv);
            mDescription = itemView.findViewById(R.id.nutritionDescriptionTv);
        }
    }

    @NonNull
    @Override
    public NutritionTipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutrition_tips_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionTipsAdapter.ViewHolder holder, int position) {
        NutritionTips nutritionTips = nutritionTipsList.get(position);
        holder.mTitle.setText(nutritionTips.getTitle());
        Picasso.get().load(nutritionTips.getImage()).into(holder.mImage);
        holder.mDescription.setText(nutritionTips.getDescription());
    }

    @Override
    public int getItemCount() {
        return nutritionTipsList.size();
    }
}
