package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634project.Database.UserDao;
import com.example.a3634project.Database.UserDatabase;
import com.example.a3634project.Models.User;

public class LoginActivity extends AppCompatActivity {

    private Button btLogin;
    private TextView btSignUp;
    private EditText edtEmail;
    private EditText edtPassword;
    private UserDatabase database;

    private UserDao userDao;
    private ProgressDialog progressDialog;
    //private SharedPreferences sharedpreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final  String value = "key";
    private String login;
    private User user_autologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
         login = sharedpreferences.getString(value, "pat");
        if (login != null) {
            //put your code if user is logged. For example, go to another activity
            System.out.println("hihihih1");
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
            //return;
        }*/
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Checking User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        database = Room.databaseBuilder(this, UserDatabase.class, "user-database.db")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();

        btLogin = findViewById(R.id.btLogin);
        btSignUp = findViewById(R.id.btConfirm);
        edtEmail = findViewById(R.id.emailInput);
        edtPassword = findViewById(R.id.passwordInput);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(edtEmail.getText().toString(), edtPassword.getText().toString());
                            if(user!=null){
                                /*SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString()*/
                                SaveSharedPreference.setPrefEmail(LoginActivity.this, user.getEmail());
                                SaveSharedPreference.setPrefPassword(LoginActivity.this, user.getPassword());
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                i.putExtra("User", user);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);
                } else {
                    Toast.makeText(LoginActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        //moveTaskToBack(true);
    }
}
