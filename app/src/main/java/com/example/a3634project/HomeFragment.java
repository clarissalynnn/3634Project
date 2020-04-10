package com.example.a3634project;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private User user;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        user = (User) getActivity().getIntent().getSerializableExtra("User");
        mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        TextView greetings = v.findViewById(R.id.greetingsTv);
        greetings.setText(setGreetings() + " " + user.getFirst_name() + "!");

        TopicAdapter.RecyclerViewClickListener listener = new TopicAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        };

        mAdapter = new TopicAdapter(Topic.getTopics(), listener);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    public String setGreetings(){
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        String greetings = "";
        if(timeOfDay >= 0 && timeOfDay < 12){
            greetings = "Good Morning";
        } else if(timeOfDay >= 12 && timeOfDay < 16){
            greetings = "Good Afternoon";
        } else if(timeOfDay >= 16 && timeOfDay < 24){
            greetings = "Good Evening";
        }
        return greetings;
    }
}

