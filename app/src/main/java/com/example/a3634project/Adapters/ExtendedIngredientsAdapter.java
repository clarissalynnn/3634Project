package com.example.a3634project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.R;
import com.example.a3634project.SpoonacularAPI.ExtendedIngredient;
import com.example.a3634project.SpoonacularAPI.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ExtendedIngredientsAdapter extends RecyclerView.Adapter<ExtendedIngredientsAdapter.ViewHolder>  {
    private List<ExtendedIngredient> extendedIngredientsList;

    public ExtendedIngredientsAdapter(List<ExtendedIngredient> extendedIngredientsList){
        this.extendedIngredientsList = extendedIngredientsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView extendedIngredients;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            extendedIngredients = itemView.findViewById(R.id.extendedIngredientItem);
        }
    }

    @NonNull
    @Override
    public ExtendedIngredientsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.extended_ingredients_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtendedIngredientsAdapter.ViewHolder holder, int position) {
        ExtendedIngredient extendedIngredient = extendedIngredientsList.get(position);
        String ingredient = extendedIngredient.getName() + " " + extendedIngredient.getAmount()+ " " + extendedIngredient.getOriginalString();
        holder.extendedIngredients.setText(ingredient);
    }

    @Override
    public int getItemCount() {
        return extendedIngredientsList.size();
    }

    public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredientList) {
        extendedIngredientList.clear();
        extendedIngredientList.addAll(extendedIngredientList);
        notifyDataSetChanged();
    }
}
