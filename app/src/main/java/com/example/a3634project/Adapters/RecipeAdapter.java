package com.example.a3634project.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.R;
import com.example.a3634project.RecipeDetailActivity;
import com.example.a3634project.SpoonacularAPI.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Recipe> recipeList;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Recipe recipe = (Recipe) v.getTag();
            Context context = v.getContext();
            Intent intent = new Intent(context, RecipeDetailActivity.class);
            intent.putExtra("RECIPE_ID", recipe.getId());
            context.startActivity(intent);
        }
    };

    public RecipeAdapter(ArrayList<Recipe> recipeList){
        this.recipeList = recipeList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.recipeIv);
            mName = itemView.findViewById(R.id.recipeTitleTv);
        }

    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        Picasso.get().load("https://spoonacular.com/recipeImages/" + recipe.getImage()).into(holder.mImage);
        holder.mName.setText(recipe.getTitle());
        holder.itemView.setTag(recipe);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setRecipes(List<Recipe> recipes) {
        recipeList.clear();
        recipeList.addAll(recipes);
        notifyDataSetChanged();
    }

}
