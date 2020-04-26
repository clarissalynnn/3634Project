package com.example.a3634project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a3634project.Adapters.ExpandableListAdapter;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.AutocompleteIngredientsResponse;
import com.example.a3634project.SpoonacularAPI.CaloricBreakdown;
import com.example.a3634project.SpoonacularAPI.Ingredient;
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
    private String resutltName;
    private String enterSearchIngMeasurement;
    private List<Nutrient> nutrientsList = new ArrayList<>();
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    TextView headerData;
    TextView headerTitle;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_ingredient_data);
        inputSearchIngName = getIntent().getStringExtra("INGREDIENT_NAME");
        if(getIntent().getStringExtra("AMOUNT")!=null){
            enterSearchIngAmt = Integer.parseInt(getIntent().getStringExtra("AMOUNT"));}
        enterSearchIngMeasurement = getIntent().getStringExtra("MEASUREMENT");
        headerTitle = findViewById(R.id.nutrientTitle);
        headerData = findViewById(R.id.nutrientInput);

        new GetIngredientIDTask().execute();



    }

    /*
     * Preparing the list data. Referenced from: https://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding list header names into the array to be set
        listDataHeader.add("General Nutrient Data");
        listDataHeader.add("Minerals Data");
        listDataHeader.add("Vitamins Data");

        // Adding child data
        List<String> generalNutrients = new ArrayList<String>();
        List<String> minerals = new ArrayList<String>();
        List<String> vitamins = new ArrayList<String>();

        //Loop to add all nutritional information received into the 3 categories
        for(int i = 0;i <nutrientsList.size();i++) {
            if (nutrientsList.get(i).getTitle().contains("Fat") || nutrientsList.get(i).getTitle().contains("Carb") || nutrientsList.get(i).getTitle().contains("Sugar") ||
                    nutrientsList.get(i).getTitle().contains("Cholesterol") || nutrientsList.get(i).getTitle().contains("Protein") || nutrientsList.get(i).getTitle().contains("Fibre")) {
                generalNutrients.add(nutrientsList.get(i).getTitle() + ": " + nutrientsList.get(i).getAmount() + nutrientsList.get(i).getUnit() + "\n\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");
            } else if (nutrientsList.get(i).getTitle().contains("Vitamin") || nutrientsList.get(i).getTitle().contains("Folate")) {
                vitamins.add(nutrientsList.get(i).getTitle() + ": " + nutrientsList.get(i).getAmount() + nutrientsList.get(i).getUnit() + "\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");}
            else { {minerals.add(nutrientsList.get(i).getTitle()+": "+nutrientsList.get(i).getAmount()+nutrientsList.get(i).getUnit()+"\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");}
            }

        }

        //Sets the header/category name and data withing the general nutrient, mineral and vitamin data as a data child for each header.
        listDataChild.put(listDataHeader.get(0), generalNutrients); // Header, Child data
        listDataChild.put(listDataHeader.get(1), minerals);
        listDataChild.put(listDataHeader.get(2), vitamins);

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
                Call<ArrayList<AutocompleteIngredientsResponse>> ingredientsResponseCall = service.getAutocompleteIngredientsSearch(inputSearchIngName,1,true);
                Response<ArrayList<AutocompleteIngredientsResponse>> ingredientsResponse = ingredientsResponseCall.execute();

                //Gets the ID of the food name that the user entered
                foodID = ingredientsResponse.body().get(0).getId();
                return resutltName;
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
                Call<IngredientsResponse> ingredientsResponseCall = service.getFoodInformation(foodID,enterSearchIngAmt,enterSearchIngMeasurement);
                Response<IngredientsResponse> ingredientsResponse = ingredientsResponseCall.execute();
                nutrientsList = ingredientsResponse.body().getNutrition().getNutrients();
                resutltName = ingredientsResponse.body().getName();
                return String.valueOf(foodID);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String recipe) {
            // get the listview
            expListView = (ExpandableListView) findViewById(R.id.lvExp);

            // preparing list data
            prepareListData();

            listAdapter = new ExpandableListAdapter(ShowIngredientData.this, listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);
            headerTitle.setText("Input: " + inputSearchIngName + "\n" + "Result Name: " + resutltName);
            headerData.setText("Amount: " +enterSearchIngAmt+ " " + enterSearchIngMeasurement);
        }

    }
}