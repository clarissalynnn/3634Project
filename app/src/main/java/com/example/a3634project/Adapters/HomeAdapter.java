package com.example.a3634project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.R;
import com.example.a3634project.homeListItem;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    // code adapted from Coding In Flow
    // RecyclerView + CardView - Part 4 - On Item Click Interface - Android Studio Tutorial 2017, video recording, Coding in Flow, <https://www.youtube.com/watch?v=bhhs4bwYyhc&t=99s>
    // HomeAdapter used to load images and category names in the CardView layout of homeListItem which will then be loaded into the RecyclerView on the HomeFragment
    private ArrayList<homeListItem> homeListItems;

    private RecyclerViewClickListener mListener;

    public interface RecyclerViewClickListener {
        void onClick (View view, int position);
    }

    public HomeAdapter(ArrayList<homeListItem> homeListItems, RecyclerViewClickListener listener){
        this.homeListItems =homeListItems;
        this.mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView mHomeImages;
        public TextView mHomeNames;
        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener){
        super(itemView);
        mListener = listener;
        itemView.setOnClickListener(this);
        mHomeImages =itemView.findViewById(R.id.homeImages);
        mHomeNames = itemView.findViewById(R.id.homeNames);
        }

        public void onClick (View v){
            mListener.onClick(v, getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);
        ViewHolder homeVH = new ViewHolder(v, mListener);
        return homeVH;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        homeListItem hLItem = homeListItems.get(position);
        holder.mHomeImages.setImageResource(hLItem.getmHomeImages());
        holder.mHomeNames.setText(hLItem.getmHomeNames());
    }

    @Override
    public int getItemCount() {
        return homeListItems.size();
    }
}
