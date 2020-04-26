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

public class ExtendedIngredientsAdapter extends RecyclerView.Adapter<ExtendedIngredientsAdapter.EIViewHolder>  {
    private List<ExtendedIngredient> extendedIngredientsList;

    public ExtendedIngredientsAdapter(List<ExtendedIngredient> extendedIngredientsList){
        this.extendedIngredientsList = extendedIngredientsList;
    }
    @NonNull
    @Override
    public ExtendedIngredientsAdapter.EIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.extended_ingredients_row, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExtendedIngredientsAdapter.EIViewHolder holder, int position) {
        ExtendedIngredient extendedIngredient = extendedIngredientsList.get(position);
        String ingredient = extendedIngredient.getName() +" "+extendedIngredient.getAmount()+ " "+ extendedIngredient.getOriginalString();
        holder.extendedIngredients.setText(ingredient);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EIViewHolder extends RecyclerView.ViewHolder {
        TextView extendedIngredients;
        public EIViewHolder(@NonNull View itemView) {
            super(itemView);
            extendedIngredients = itemView.findViewById(R.id.extendedIngredient);
        }
    }

    public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredientList) {
        extendedIngredientList.clear();
        extendedIngredientList.addAll(extendedIngredientList);
        notifyDataSetChanged();
    }
}
