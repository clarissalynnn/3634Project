package com.example.a3634project.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634project.LoginActivity;
import com.example.a3634project.Models.User;
import com.example.a3634project.R;
import com.example.a3634project.RecipeActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private User user;
    Button mLogOut;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        //new GetRecipeTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        user = (User) getActivity().getIntent().getSerializableExtra("User");
        TextView mName = v.findViewById(R.id.nameTv);
        TextView mEmail = v.findViewById(R.id.emailTv);

        mName.setText(user.getFirst_name() + " " + user.getLast_name());
        mEmail.setText(user.getEmail());

         mLogOut = v.findViewById(R.id.logOutBt);
     mLogOut.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return v;
    }

}
