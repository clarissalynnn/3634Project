package com.example.a3634project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a3634project.Adapters.ExpandableListAdapter;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.AutocompleteIngredientsResponse;
import com.example.a3634project.SpoonacularAPI.IngredientsResponse;
import com.example.a3634project.SpoonacularAPI.Nutrient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowIngredientData extends AppCompatActivity {
    private String inputSearchIngName;
    private int enterSearchIngAmt;
    private int foodID;
    private String enterSearchIngMeasurement;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    TextView headerData;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_ingredient_data);
        inputSearchIngName = getIntent().getStringExtra("INGREDIENT_NAME");
        String amt = getIntent().getStringExtra("AMOUNT");
        String measurment = getIntent().getStringExtra("MEASUREMENT");
        String header = inputSearchIngName + " , " + amt +" "+ measurment;
        System.out.println(header);
        headerData =findViewById(R.id.nutrientTitle);
        headerData.setText(header);
        //new GetIngredientIDTask().doInBackground();
        new GetIngredientIDTask().execute();

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("General Nutrient Data");
        listDataHeader.add("Minerals Data");
        listDataHeader.add("Vitamins Data");
        listDataHeader.add("Caloric Breakdown");

        // Adding child data
        List<String> generalNutrients = new ArrayList<String>();
        generalNutrients.add("Calorie: 0");
        generalNutrients.add("Fat: ");
        generalNutrients.add("Saturated Fat: ");
        generalNutrients.add("Carbohydrates: ");
        generalNutrients.add("Sugar");
        generalNutrients.add("Cholesterol");
        generalNutrients.add("Protein");
        generalNutrients.add("Fibre");

        List<String> minerals = new ArrayList<String>();
        minerals.add("Sodium");
        minerals.add("Manganese");
        minerals.add("Copper");
        minerals.add("Potassium");
        minerals.add("Magnesium");
        minerals.add("Iron");

        List<String> vitamins = new ArrayList<String>();
        vitamins.add("Vitamin C");
        vitamins.add("Vitamin B6");
        vitamins.add("Folate");
        vitamins.add("Vitamin B3");
        vitamins.add("Vitamin B5");
        vitamins.add("Vitamin B1");
        vitamins.add("Vitamin A");

        List<String> calBreakdown = new ArrayList<String>();
        calBreakdown.add("% of daily protein requirement");
        calBreakdown.add("% of daily fat requirement");
        calBreakdown.add("% of daily carbohydrates requirement");


        listDataChild.put(listDataHeader.get(0), generalNutrients); // Header, Child data
        listDataChild.put(listDataHeader.get(1), minerals);
        listDataChild.put(listDataHeader.get(2), vitamins);
        listDataChild.put(listDataHeader.get(3),calBreakdown);
    }

    private class GetIngredientIDTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIService service = retrofit.create(APIService.class);
                Call<AutocompleteIngredientsResponse> ingredientsResponseCall = service.getAutocompleteIngredientsSearch("Pineapple",1,true);
                Response<AutocompleteIngredientsResponse> ingredientsResponse = ingredientsResponseCall.execute();
                foodID = ingredientsResponse.body().getId();
                String foodIDString = String.valueOf(foodID);
                System.out.println("JOOOOOOOOOOOOOOO"+ foodIDString);
                return foodIDString;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String recipe) {
            new GetIngredientDataTask().execute();
        }
    }
    private class GetIngredientDataTask extends AsyncTask <Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                System.out.println("Ingredietns data methid id input is : "  + foodID);
                Call<IngredientsResponse> ingredientsResponseCall = service.getFoodInformation(foodID,enterSearchIngAmt,enterSearchIngMeasurement);
                Response<IngredientsResponse> ingredientsResponse = ingredientsResponseCall.execute();
                List<Nutrient> nutrientsList = ingredientsResponse.body().getNutrition().getNutrients();
                System.out.println(nutrientsList.get(0).getTitle());
                System.out.println(nutrientsList.get(1).getTitle());
                foodID = ingredientsResponse.body().getId();
                System.out.println("JOOOOOOOOOOOOOOO"+ foodID);
                return String.valueOf(foodID);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String recipe) {
            TextView title = findViewById(R.id.recipeTitleTv);
            title.setText(recipe);
        }
    }
}