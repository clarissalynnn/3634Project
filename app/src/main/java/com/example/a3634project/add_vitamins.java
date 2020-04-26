package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634project.Adapters.VitaminsAdapter;
//import com.example.a3634project.Database.FoodIntakeInputDao;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class add_vitamins extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView mVitaminsFacts;

    String [] vitaminsFacts ={
            // facts adapted from https://www.multivitaminguide.org/infographic/20-fun-facts-about-vitamins.html
            // Infographic: 20 fun facts about vitamins n.d, viewed 22 April 2020, <https://www.multivitaminguide.org/infographic/20-fun-facts-about-vitamins.html>
            "Did you know that Vitamin A is the first vitamin ever discovered?",
            "Did you know that the original name of Omega 3 and 6 fatty acids is Vitamin F?",
            "Did you know that Vitamin B helps your body produce energy?",
            "Did you know that a lack of Vitamin A can create night blindness?",
            "Did you know that kiwis and strawberries have twice the amount of vitamin C as oranges?"
    };
    Random random = new Random();
    int randomVitFacts = random.nextInt(vitaminsFacts.length);
    String randomVitFacts1 = vitaminsFacts[randomVitFacts];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vitamins);
        //saveBtn = findViewById(R.id.saveVitaminInputBtn);

        // list of vitamins adapted from: https://www.comvita.com/blog-article/10-essential-vitamins-your-body-needs/4100544
        // 10 esential vitamins your body needs n.d, Comvita, viewed 22 April 2020, <https://www.comvita.com/blog-article/10-essential-vitamins-your-body-needs/4100544>
        ArrayList<vitaminsListItem> vitaminsList = new ArrayList<>();
        vitaminsList.add(new vitaminsListItem(R.drawable.c, "Vitamin C", 0));
        vitaminsList.add(new vitaminsListItem(R.drawable.c, "Vitamin C",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.a, "Vitamin A",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.d, "Vitamin D",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.iron, "Iron",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.omega3, "Omega 3",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.coq10, "Co-Q 10",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.potassium, "Potassium",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.magnesium, "Magnesium",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.calcium, "Calcium",0));
        vitaminsList.add(new vitaminsListItem(R.drawable.b12, "Vitamin B12",0));


        mRecyclerView = findViewById(R.id.recyclerViewVitamins);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new VitaminsAdapter(vitaminsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mVitaminsFacts = findViewById(R.id.vitaminsFacts);
        mVitaminsFacts.setText(randomVitFacts1);
       // saveBtn.setOnClickListener(VitaminsAdapter.getmOnClickListener());


    }
}
