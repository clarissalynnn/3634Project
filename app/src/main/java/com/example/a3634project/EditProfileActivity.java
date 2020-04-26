package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3634project.Database.UserDao;
import com.example.a3634project.Database.UserDatabase;
import com.example.a3634project.Models.User;

public class EditProfileActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtWeight;
    private EditText edtHeight;
    private EditText edtDiet;
    private Button btConfirm;

    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtName = findViewById(R.id.nameInput);
        edtLastName = findViewById(R.id.lastnameInput);
        edtEmail = findViewById(R.id.emailInput);
        edtPassword = findViewById(R.id.passwordInput);
        edtWeight = findViewById(R.id.weightInput);
        edtHeight = findViewById(R.id.heightInput);
        edtDiet = findViewById(R.id.dietInput);

        btConfirm = findViewById(R.id.btConfirm);

        userDao = Room.databaseBuilder(this, UserDatabase.class, "user-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty()) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(edtName.getText().toString(), edtLastName.getText().toString(),
                                    edtEmail.getText().toString(), edtPassword.getText().toString(), edtWeight.getText().toString(), edtHeight.getText().toString(), edtDiet.getText().toString());
                            userDao.update(user);
                            startActivity(new Intent(EditProfileActivity.this, LoginActivity.class));
                        }
                    }, 1000);

                } else {
                    Toast.makeText(EditProfileActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) ||
                TextUtils.isEmpty(edtPassword.getText().toString()) ||
                TextUtils.isEmpty(edtName.getText().toString()) ||
                TextUtils.isEmpty(edtLastName.getText().toString()) ||
                TextUtils.isEmpty(edtWeight.getText().toString()) ||
                TextUtils.isEmpty(edtHeight.getText().toString()) ||
                TextUtils.isEmpty(edtDiet.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
