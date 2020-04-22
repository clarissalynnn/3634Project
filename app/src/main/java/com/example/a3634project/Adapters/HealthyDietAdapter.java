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

import com.example.a3634project.HealthyDietDetailActivity;
import com.example.a3634project.Models.HealthyDiet;
import com.example.a3634project.R;

import java.util.ArrayList;

public class HealthyDietAdapter extends RecyclerView.Adapter<HealthyDietAdapter.ViewHolder> {
    private ArrayList<HealthyDiet> healthyDietList;
    private RecyclerViewClickListener mListener;

    /*private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HealthyDiet diet = (HealthyDiet) v.getTag();
            Context context = v.getContext();
            Intent intent = new Intent(context, HealthyDietDetailActivity.class);
            intent.putExtra("ARG_ITEM_ID", diet.getDietType());
            context.startActivity(intent);
        }
    };*/

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public HealthyDietAdapter(ArrayList<HealthyDiet> healthyDietList, RecyclerViewClickListener listener){
        this.healthyDietList = healthyDietList;
        this.mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mDietTitle;
        private RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            mDietTitle = itemView.findViewById(R.id.dietTitleTv);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public HealthyDietAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.healthy_diet_list, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealthyDiet healthyDiet = healthyDietList.get(position);
        holder.mDietTitle.setText(healthyDiet.getDietType());
    }

    @Override
    public int getItemCount() {
        return healthyDietList.size();
    }


}
