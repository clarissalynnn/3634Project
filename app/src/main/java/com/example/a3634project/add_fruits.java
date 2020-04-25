package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import com.example.a3634project.Adapters.FruitsAdapter;
import java.util.ArrayList;
import java.util.Random;

public class add_fruits extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    public TextView mFruitFacts;

    String[] fruitsFacts = {
            //facts adapted from: https://www.juiceplus.com/at/en/juice-plus-experience/magazine.read.html/en/2018/3/9-fun-facts-about-fruit-and-vegetables-to-teach-your-kids.html
            "Did you know that strawberries are not actually berries since they hold their seeds outside?",
            "Did you know that a pomegranate can hold up to 1000 seeds?",
            "Did you know that not all oranges are orange?",
            //facts adapted from: https://www.befitandfine.com/facts-of-fruits/
            "Did you know that apples, peaches and raspberries are all members of the rose group?",
            "Did you know that square watermelons are grown by Japanese farmers for easier stack and store?",
            "Did you know that there are 7000 different kinds of apples grown around the globe?",
            "Did you know that purple and blue fruits help enhance memory?",
            "Did you know that red-coloured fruits keep your heart strong?",
            "Did you know that yellow-colored fruits prevent you from getting sick?"
    };

    // generate ranodm quotes from the Array above
    Random random = new Random();
    int fruitsFacts1 = random.nextInt(fruitsFacts.length);
    String fruitsFactsDisplay = fruitsFacts[fruitsFacts1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fruits);

        // ArrayList of fruits to load into fruitsImage and fruitsName
        ArrayList<FruitListItem> fruitsList = new ArrayList<>();
        //apple image source: pexels.com
        fruitsList.add(new FruitListItem(R.drawable.apple1, "Apple"));
        //avocado image source: unsplash.com
        fruitsList.add(new FruitListItem(R.drawable.avocado1, "Avocado"));
        //banana image source: unsplash.com
        fruitsList.add(new FruitListItem(R.drawable.banana1, "Banana"));
        //blueberry pixabay.com
        fruitsList.add(new FruitListItem(R.drawable.blueberry1, "Blueberry"));
        //kiwi unsplash.com
        fruitsList.add(new FruitListItem(R.drawable.kiwi1, "Kiwi"));
        //lemon pexels.com
        fruitsList.add(new FruitListItem(R.drawable.lemon1, "Lemon"));
        //mango best-wallpaper.net
        fruitsList.add(new FruitListItem(R.drawable.mango1, "Mango"));
        //orange pxleyes.com
        fruitsList.add(new FruitListItem(R.drawable.orange1, "Orange"));
        //passionfruit healthline.com
        fruitsList.add(new FruitListItem(R.drawable.passionfruit1, "Passionfruit"));
        //peach cookinglight.com
        fruitsList.add(new FruitListItem(R.drawable.peach1, "Peach"));
        //pear pexels.com
        fruitsList.add(new FruitListItem(R.drawable.pear1, "Pear"));
        //pineapple pexels.com
        fruitsList.add(new FruitListItem(R.drawable.pineapple1, "Pineapple"));
        //papaya unsplash.com
        fruitsList.add(new FruitListItem(R.drawable.papaya1, "Papaya"));
        //plum pixabay.com
        fruitsList.add(new FruitListItem(R.drawable.plum1, "Plum"));
        //raspberry pxhere.com
        fruitsList.add(new FruitListItem(R.drawable.raspberry1, "Raspberry"));
        //rockmelon dreamstime.com
        fruitsList.add(new FruitListItem(R.drawable.rockmelon1, "Rockmelon"));
        //strawberry pexels.com
        fruitsList.add(new FruitListItem(R.drawable.strawberry1, "Strawberry"));
        //watermelon pexels.com
        fruitsList.add(new FruitListItem(R.drawable.watermelon1, "Watermelon"));

        mRecyclerView = findViewById(R.id.recyclerViewFruits);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FruitsAdapter(fruitsList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mFruitFacts = findViewById(R.id.fruitsFacts);
        mFruitFacts.setText(fruitsFactsDisplay);


    }
}
