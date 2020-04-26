package com.example.a3634project.Adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.R;
import com.example.a3634project.waterListItem;

import java.util.ArrayList;

public class WaterAdapter extends RecyclerView.Adapter <WaterAdapter.ViewHolder> {

    // code adapted from Coding In Flow
    // RecyclerView + CardView - Part 4 - On Item Click Interface - Android Studio Tutorial 2017, video recording, Coding in Flow, <https://www.youtube.com/watch?v=bhhs4bwYyhc&t=99s>
private ArrayList<waterListItem> mWaterListItems;
private RecyclerViewClickListener mListener;

    public interface RecyclerViewClickListener {
    void onClick (View view, int position);
    }

    public WaterAdapter(ArrayList<waterListItem> waterListItems, RecyclerViewClickListener listener){
        this.mWaterListItems = waterListItems;
        this.mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView mWaterImage;
    public TextView mWaterName;
    private RecyclerViewClickListener mListener;

    public ViewHolder (View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        mListener = listener;
        itemView.setOnClickListener(this);
        mWaterImage = itemView.findViewById(R.id.waterImage);
        mWaterName = itemView.findViewById(R.id.waterName);
    }
    @Override
            public void onClick(View v){
            mListener.onClick(v, getAdapterPosition());
        };
    }


    @NonNull
    @Override
    public WaterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.water_list, parent, false);
        ViewHolder waterVH = new ViewHolder(v, mListener);
        return waterVH;
    }

    @Override
    public void onBindViewHolder(@NonNull WaterAdapter.ViewHolder holder, int position) {
    waterListItem water = mWaterListItems.get(position);
    holder.mWaterImage.setImageResource(water.getmWaterImage());
    holder.mWaterName.setText(water.getmWaterName());
    }

    @Override
    public int getItemCount() {
        return mWaterListItems.size();
    }
}
