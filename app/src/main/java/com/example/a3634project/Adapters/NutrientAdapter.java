package com.example.a3634project.Adapters;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.NutrientData;
import com.example.a3634project.R;
import com.example.a3634project.ShowIngredientData;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.AutocompleteIngredientsResponse;
import com.example.a3634project.SpoonacularAPI.IngredientsResponse;
import com.example.a3634project.SpoonacularAPI.Nutrient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutrientAdapter extends RecyclerView.Adapter<NutrientAdapter.NutrientVH> {
    List<NutrientData> nutrientDataList;

    public NutrientAdapter(List<NutrientData> nutrientDataList){this.nutrientDataList= nutrientDataList;};

    @NonNull
    @Override
    public NutrientVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_data_row,parent,false);
        return new NutrientVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NutrientVH holder, int position) {
        NutrientData nutrientData = nutrientDataList.get(position);
        holder.nutrientName.setText(nutrientData.getName());
        holder.percentOfDailyNeeds.setText(nutrientData.getPercentOfDailyNeeds());
        boolean isExpanded = nutrientDataList.get(position).isExpanded();
        holder.ExpandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return nutrientDataList.size();
    }


     class NutrientVH extends RecyclerView.ViewHolder {
        TextView nutrientName, percentOfDailyNeeds;
        ConstraintLayout ExpandableLayout;
        public NutrientVH(@NonNull View itemView) {
            super(itemView);
            ExpandableLayout = itemView.findViewById(R.id.ExpandableLayout);
            nutrientName = itemView.findViewById(R.id.Nutrient);
            percentOfDailyNeeds = itemView.findViewById(R.id.percentofdailyNeeds);
            nutrientName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NutrientData nutrientData = nutrientDataList.get(getAdapterPosition());
                    nutrientData.setExpanded(!nutrientData.isExpanded());notifyItemChanged(getAdapterPosition());
            }
        });

        }

    }

}