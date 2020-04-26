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
            // 9 fun facts about fruit and vegetables to teach your kids 2018, JuicePlus, viewed 22 April 2020, <https://www.juiceplus.com/at/en/juice-plus-experience/magazine.read.html/en/2018/3/9-fun-facts-about-fruit-and-vegetables-to-teach-your-kids.html>
            "Did you know that strawberries are not actually berries since they hold their seeds outside?",
            "Did you know that a pomegranate can hold up to 1000 seeds?",
            "Did you know that not all oranges are orange?",
            //facts adapted from: https://www.befitandfine.com/facts-of-fruits/
            // Nanda S n.d, Fruits facts: amazing facts of fruits you probably did not know, Be Fit and Fine, viewed 22 April 2020, <https://www.befitandfine.com/facts-of-fruits/>
            "Did you know that apples, peaches and raspberries are all members of the rose group?",
            "Did you know that square watermelons are grown by Japanese farmers for easier stack and store?",
            "Did you know that there are 7000 different kinds of apples grown around the globe?",
            "Did you know that purple and blue fruits help enhance memory?",
            "Did you know that red-coloured fruits keep your heart strong?",
            "Did you know that yellow-colored fruits prevent you from getting sick?"
    };

    // generate random quotes from the Array above
    Random random = new Random();
    int fruitsFacts1 = random.nextInt(fruitsFacts.length);
    String fruitsFactsDisplay = fruitsFacts[fruitsFacts1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fruits);

        // ArrayList of fruits to load into fruitsImage and fruitsName
        ArrayList<FruitListItem> fruitsList = new ArrayList<>();
        //apple image source: pxhere.com
        // Hazelwood S 2018, Apples, pxhere, viewed 22 April 2020, <https://pxhere.com/en/photo/1453957>
        fruitsList.add(new FruitListItem(R.drawable.apple1, "Apple"));
        //avocado image source: unsplash.com, credit to www.quotecatalog.com
        // Thought catalog n.d, Avocado, unsplash, viewed 22 April 2020, <https://unsplash.com/photos/EMX1eJ1BcgU>
        fruitsList.add(new FruitListItem(R.drawable.avocado1, "Avocado"));
        //banana image source: unsplash.com
        // Dorner M 2016, Banana, unsplash, viewed 22 April 2020, <https://unsplash.com/photos/sf_1ZDA1YFw>
        fruitsList.add(new FruitListItem(R.drawable.banana1, "Banana"));
        //blueberry pixabay.com
        // Comfreak 2018, Blueberry, pixabay, viewed 22 April 2020, <https://pixabay.com/photos/blueberry-black-berry-moll-berry-3460423/>
        fruitsList.add(new FruitListItem(R.drawable.blueberry1, "Blueberry"));
        //kiwi unsplash.com
        // Vyas A 2019, Sliced kiwi on white surface, viewed 22 April 2020, <https://unsplash.com/photos/0islNC8XGlY>
        fruitsList.add(new FruitListItem(R.drawable.kiwi1, "Kiwi"));
        //lemon pexels.com
        // Fotios L 2018, Close-up photography of sliced lemon, Pexels, viewed 22 April 2020, <https://www.pexels.com/photo/close-up-photography-of-sliced-lemon-1002543/>
        fruitsList.add(new FruitListItem(R.drawable.lemon1, "Lemon"));
        //mango unsplash.com
        // Hotchicksing 2018, Tray of mango photo, Unsplash, viewed 26 April 2020, <https://unsplash.com/photos/Dyc95dKuGp4>
        fruitsList.add(new FruitListItem(R.drawable.mango2, "Mango"));
        //orange unsplash.com
        // Mu M 2019, Orange fruit photo, Unsplash, viewed 26 April 2020, <https://unsplash.com/photos/U1iYwZ8Dx7k>
        fruitsList.add(new FruitListItem(R.drawable.orange2, "Orange"));
        //passionfruit healthline.com
        // Butler N 2016, How to eat passionfruit: 5 easy steps, Healthline, viewed 26 April 2020, <https://www.healthline.com/health/food-nutrition/how-to-eat-passion-fruit#1>
        fruitsList.add(new FruitListItem(R.drawable.passionfruit1, "Passionfruit"));
        //peach unsplash.com
        // Hunt L 2018, Crate of reed fruit photo, Unsplash, viewed 26 April 2020, <https://unsplash.com/photos/O3TlS547j7k>
        fruitsList.add(new FruitListItem(R.drawable.peach2, "Peach"));
        //pear pexels.com
        // Onojeghuo C 2016, 3 pear fruits, Unsplashed, viewed 22 April 2020, <https://www.pexels.com/photo/3-pear-fruits-175767/>
        fruitsList.add(new FruitListItem(R.drawable.pear1, "Pear"));
        //pineapple pexels.com
        // Koppens Y 2018, Photography of Pinapples, Pexels, viewed 22 April 2020, <https://www.pexels.com/photo/photography-of-pineapple-915017/>
        fruitsList.add(new FruitListItem(R.drawable.pineapple1, "Pineapple"));
        //papaya unsplash.com
        // Cardenas D 2018, Sliced papaya fruits on brown surface photo, Unsplash, viewed 22 April 2020, <https://unsplash.com/photos/BIj5FAFQ_rk>
        fruitsList.add(new FruitListItem(R.drawable.papaya1, "Papaya"));
        //plum pixabay.com
        // Ponce_photography 2016, Plum fruit food, Pixabay, viewed 22 April 2020, <https://pixabay.com/photos/plum-fruit-food-healthy-fresh-1430343/>
        fruitsList.add(new FruitListItem(R.drawable.plum1, "Plum"));
        //raspberry pxhere.com
        // Raspberry 2017, Pxhere, viewed 22 April 2020, <https://pxhere.com/en/photo/571914>
        fruitsList.add(new FruitListItem(R.drawable.raspberry1, "Raspberry"));
        //rockmelon dreamstime.com
        // Rockmelon, Dreamstime, viewed 22 April 2020, <https://thumbs.dreamstime.com/b/half-ripe-organic-cantaloupe-melon-muskmelon-mushmelon-rockmelon-straw-napkin-background-selective-focus-117663734.jpg>
        fruitsList.add(new FruitListItem(R.drawable.rockmelon1, "Rockmelon"));
        //strawberry pexels.com
        // Koppens Y 2018, Macro photography of strawberry, Pexels, viewed 22 April 2020, <https://www.pexels.com/photo/macro-photography-of-strawberry-934066/>
        fruitsList.add(new FruitListItem(R.drawable.strawberry1, "Strawberry"));
        //watermelon pexels.com
        // Hughes E 2020, Flat lay photogrophy of slices of red watermelon, Pexels, viewed 22 April 2020, <https://www.pexels.com/photo/flat-lay-photography-of-slices-of-red-watermelon-3513238/>
        fruitsList.add(new FruitListItem(R.drawable.watermelon1, "Watermelon"));

        mRecyclerView = findViewById(R.id.recyclerViewFruits);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FruitsAdapter(fruitsList);
        //code adapted from Aws RH on youtube
        //RecyclerView + CardView with GridLayout Android Studio Tutorial 2018, video recording, Aws RH, <https://www.youtube.com/watch?v=SD2t75T5RdY&t=1586s>
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mFruitFacts = findViewById(R.id.fruitsFacts);
        mFruitFacts.setText(fruitsFactsDisplay);


    }
}
