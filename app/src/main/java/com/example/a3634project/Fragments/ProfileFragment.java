package com.example.a3634project.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634project.Database.UserDao;
import com.example.a3634project.Database.UserDatabase;
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
        TextView mName = v.findViewById(R.id.nameTv);
        TextView mEmail = v.findViewById(R.id.emailTv);

        mName.setText(user.getFirst_name() + " " + user.getLast_name());
        mEmail.setText(user.getEmail());

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

        return v;
    }

}
