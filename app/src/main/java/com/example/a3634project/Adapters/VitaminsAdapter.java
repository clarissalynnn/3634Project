package com.example.a3634project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.a3634project.Database.FoodIntakeInputDao;
import com.example.a3634project.Database.FoodIntakeInputDatabase;
import com.example.a3634project.Database.UserDatabase;
import com.example.a3634project.Models.User;
import com.example.a3634project.Models.UserIntakeInput;
import com.example.a3634project.R;
import com.example.a3634project.vitaminsListItem;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VitaminsAdapter extends RecyclerView.Adapter<VitaminsAdapter.vitaminsViewHolder>{
    public static ArrayList<vitaminsListItem> mVitaminsList;
    public static ArrayList<String> userVitInput;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
     static Date date = Calendar.getInstance().getTime();
      static FoodIntakeInputDao foodIntakeInputDao;
      public static vitaminsListItem vitamins1;
    static DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {/*
            for(int i=0;i<mVitaminsList.size();i++){
                if(mVitaminsList.get(i).getmIntakeInput()>0){
                    userVitInput.add(mVitaminsList.get(i).getmVitaminsName() + ": "+ mVitaminsList.get(i).getmIntakeInput()+ " tablets");
                }
            }
            String strDate = dateFormat.format(date);
            // UserIntakeInput mUserIntakeInput = new UserIntakeInput(userVitInput,1,strDate);
            for(int i = 0; i<userVitInput.size();i++){
                System.out.println(userVitInput.get(i));
            }
            System.out.println(strDate);*/
          //  vitaminsListItem vitamins =mVitaminsList.get(0);
           // System.out.println(mVitaminsList.get(0).getmVitaminsName() + " " + vitamins.getmIntakeInput());
        }
    };

    public static View.OnClickListener getmOnClickListener() {
        return mOnClickListener;
    }

    public static ArrayList<vitaminsListItem> getmVitaminsList() {
        return mVitaminsList;
    }

    public static ArrayList<String> getUserVitInput() {
        return userVitInput;
    }

    public static class vitaminsViewHolder extends RecyclerView.ViewHolder {
        public ImageView mVitaminsImage;
        public TextView mVitaminsName;
        public ImageView mPlusImage;
        public ImageView mMinusImage;
        public TextView mIntakeInput;
        Button mSaveButton;
        User user;
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
                    if(intake>-1){
                    intake++;
                    mIntakeInput.setText(Integer.toString(intake));

                    }
                }
            });

            mMinusImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(intake>0){
                        intake--;
                        mIntakeInput.setText(Integer.toString(intake));
                }

            }});

/*            mSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0;i<mVitaminsList.size();i++){
                        if(mVitaminsList.get(i).getmIntakeInput()>0){
                            userVitInput.add(mVitaminsList.get(i).getmVitaminsName() + ": "+ mVitaminsList.get(i).getmIntakeInput()+ " tablets");
                        }
                    }
                    String strDate = dateFormat.format(date);
                   // UserIntakeInput mUserIntakeInput = new UserIntakeInput(userVitInput,1,strDate);
                    for(int i = 0; i<userVitInput.size();i++){
                        System.out.println(userVitInput.get(i));
                    }
                    System.out.println(strDate);

                }
            });*/
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
    holder.mIntakeInput.setText(String.valueOf(vitamins.getmIntakeInput()));
    mVitaminsList = new ArrayList<>();
    mVitaminsList.add(vitamins);
    }

    @Override
    public int getItemCount() {
        return mVitaminsList.size();
    }
}
