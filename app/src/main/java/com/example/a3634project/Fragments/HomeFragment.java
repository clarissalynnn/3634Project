package com.example.a3634project.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634project.Adapters.HomeAdapter;
import com.example.a3634project.Adapters.TopicAdapter;
import com.example.a3634project.Database.UserDao;
import com.example.a3634project.Database.UserDatabase;
import com.example.a3634project.R;
import com.example.a3634project.Models.User;
import com.example.a3634project.SaveSharedPreference;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.add_food;
import com.example.a3634project.add_fruits;
import com.example.a3634project.add_vitamins;
import com.example.a3634project.add_water;
import com.example.a3634project.homeListItem;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private User user;
    private UserDao userDao;
    private UserDatabase database;


    public HomeFragment() {
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = v.findViewById(R.id.homeRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        //code adapted from Aws RH on youtube
        //RecyclerView + CardView with GridLayout Android Studio Tutorial 2018, video recording, Aws RH, <https://www.youtube.com/watch?v=SD2t75T5RdY&t=1586s>
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        TextView greetings = v.findViewById(R.id.greetingsTv);
        greetings.setText(setGreetings() + " " + user.getFirst_name() + "!");

        // Switch to respective activities when cardviews are pressed.
        HomeAdapter.RecyclerViewClickListener listener = new HomeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (position) {
                    case 0:
                    launchAddWaterActivity();
                    break;

                    case 1:
                        launchAddVitaminsActivity();
                        break;

                    case 2:
                        launchAddFruitsActivity();
                        break;

                    case 3:
                        launchAddFoodActivity();
                        break;
                }
            }


        };
        mAdapter = new HomeAdapter(homeListItem.getList(), listener);
        mRecyclerView.setAdapter(mAdapter);
        return v;

    }

    // launch add water activity
    private void launchAddWaterActivity(){
        Intent intent = new Intent(getActivity(), add_water.class);
        startActivity(intent);
}

    // launch add vitamins activity
    private void launchAddVitaminsActivity(){
        Intent intent = new Intent(getActivity(), add_vitamins.class);
        startActivity(intent);
}

    //launch add fruits activity
    private void launchAddFruitsActivity(){
        Intent intent = new Intent(getActivity(), add_fruits.class);
        startActivity(intent);
}

    //launch add food activity
    private void launchAddFoodActivity(){
        Intent intent = new Intent(getActivity(), add_food.class);
        startActivity(intent);
}

    public String setGreetings() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        String greetings = "";
        if (timeOfDay >= 0 && timeOfDay < 12) {
            greetings = "Good Morning";
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            greetings = "Good Afternoon";
        } else if (timeOfDay >= 16 && timeOfDay < 24) {
            greetings = "Good Evening";
        }
        return greetings;
    }

}

