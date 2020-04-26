package com.example.a3634project.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634project.Database.UserDao;
import com.example.a3634project.Database.UserDatabase;
import com.example.a3634project.EditProfileActivity;
import com.example.a3634project.LoginActivity;
import com.example.a3634project.MainActivity;
import com.example.a3634project.Models.User;
import com.example.a3634project.R;
import com.example.a3634project.RecipeActivity;
import com.example.a3634project.SaveSharedPreference;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private User user;
    private UserDao userDao;
    private UserDatabase database;

    private TextView mName, mEmail, mWeight, mHeight, mBMI, mDiet;
    private ConstraintLayout bmiLayout;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        database = Room.databaseBuilder(getActivity(), UserDatabase.class, "user-database.db")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();
        user = userDao.getUser(SaveSharedPreference.getPrefEmail(getActivity()), SaveSharedPreference.getPrefPassword(getActivity()));
        //SaveSharedPreference.getPrefEmail(MainActivity.class, user.getEmail());

        //new GetRecipeTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //user = (User) getActivity().getIntent().getSerializableExtra("User");
        mName = v.findViewById(R.id.nameTv);
        mEmail = v.findViewById(R.id.emailTv);
        mWeight = v.findViewById(R.id.weightTv);
        mHeight = v.findViewById(R.id.heightTv);
        mBMI = v.findViewById(R.id.bmiTv);
        mDiet = v.findViewById(R.id.dietTv);
        bmiLayout = v.findViewById(R.id.bmiLayout);

        double bmi = calculateBMI(user.getWeight(), user.getHeight());
        String bmiStatus = getBMIStatus(bmi);

        mName.setText(user.getFirst_name() + " " + user.getLast_name());
        mEmail.setText(user.getEmail());
        mWeight.setText(user.getWeight());
        mHeight.setText(user.getHeight());
        mBMI.setText(String.valueOf(bmi) + " (" + bmiStatus + ")");
        mDiet.setText(user.getDiet());

        Button mLogOut = v.findViewById(R.id.logOutBt);
        mLogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearPrefEmail(getActivity());
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });

        Button mEditProfile = v.findViewById(R.id.editProfileBt);
        mEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    private double calculateBMI(String weight, String height) {
        double bmi;
        double mWeight = Double.valueOf(weight);
        double mHeight = Double.valueOf(height) / 100.0;
        bmi = Math.round((mWeight / (mHeight * mHeight)) * 100.0) / 100.0;
        return bmi;
    }

    private String getBMIStatus(double bmi) {
        String bmiStatus = "";
        if (bmi > 30) {
            bmiStatus = "Obese";
            bmiLayout.setBackgroundColor(Color.parseColor("#C34A4A"));
        } else if (bmi >= 25) {
            bmiStatus = "Overweight";
            bmiLayout.setBackgroundColor(Color.parseColor("#C3704A"));
        } else if (bmi >= 18.5) {
            bmiStatus = "Normal Weight";
            bmiLayout.setBackgroundColor(Color.parseColor("#8BC34A"));
        } else if (bmi >= 0) {
            bmiStatus = "Underweight";
            bmiLayout.setBackgroundColor(Color.parseColor("#C3B34A"));
        }
        return bmiStatus;
    }

}
