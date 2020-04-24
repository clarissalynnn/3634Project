package com.example.a3634project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.R;
import com.example.a3634project.vitaminsListItem;

import java.util.ArrayList;

public class VitaminsAdapter extends RecyclerView.Adapter<VitaminsAdapter.vitaminsViewHolder>{
    private ArrayList<vitaminsListItem> mVitaminsList;


    public static class vitaminsViewHolder extends RecyclerView.ViewHolder {
        public ImageView mVitaminsImage;
        public TextView mVitaminsName;
        public ImageView mPlusImage;
        public ImageView mMinusImage;
        public TextView mIntakeInput;
        int intake = 0;


        public vitaminsViewHolder(View itemView) {
            super(itemView);
            mVitaminsImage = itemView.findViewById(R.id.vitaminsImage);
            mVitaminsName = itemView.findViewById(R.id.vitaminsName);
            mPlusImage = itemView.findViewById(R.id.plusIntakeVits);
            mMinusImage = itemView.findViewById(R.id.minusIntakeVits);
            mIntakeInput = itemView.findViewById(R.id.vitaminsIntake);

            mPlusImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intake++;
                    mIntakeInput.setText(Integer.toString(intake));
                }
            });

            mMinusImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intake--;
                    mIntakeInput.setText(Integer.toString(intake));
                }

            });
        }
    }

    public VitaminsAdapter(ArrayList<vitaminsListItem> vitaminsList){
            mVitaminsList = vitaminsList;
    }

    @NonNull
    @Override
    public vitaminsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vitamins_list, parent, false);
        vitaminsViewHolder vVH = new vitaminsViewHolder(v);
        return vVH;

    }

    @Override
    public void onBindViewHolder(@NonNull vitaminsViewHolder holder, int position) {
    vitaminsListItem vitamins =mVitaminsList.get(position);
    holder.mVitaminsImage.setImageResource(vitamins.getmVitaminsImage());
    holder.mVitaminsName.setText(vitamins.getmVitaminsName());
    }

    @Override
    public int getItemCount() {
        return mVitaminsList.size();
    }
}
