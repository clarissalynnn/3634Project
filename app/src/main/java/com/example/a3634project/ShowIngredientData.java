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
    private CaloricBreakdown caloricBreakdown;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    TextView headerData;
    TextView headerTitle;
    private String header;
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

        //new GetIngredientIDTask().doInBackground();
        new GetIngredientIDTask().execute();



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
        /*generalNutrients.add("Calorie: 0");
        generalNutrients.add("Fat: ");
        generalNutrients.add("Saturated Fat: ");
        generalNutrients.add("Carbohydrates: ");
        generalNutrients.add("Sugar");
        generalNutrients.add("Cholesterol");
        generalNutrients.add("Protein");
        generalNutrients.add("Fibre");*/

        List<String> minerals = new ArrayList<String>();
/*        minerals.add("Sodium");
        minerals.add("Manganese");
        minerals.add("Copper");
        minerals.add("Potassium");
        minerals.add("Magnesium");
        minerals.add("Iron");*/

        List<String> vitamins = new ArrayList<String>();
      /*  vitamins.add("Vitamin C");
        vitamins.add("Vitamin B6");
        vitamins.add("Folate");
        vitamins.add("Vitamin B3");
        vitamins.add("Vitamin B5");
        vitamins.add("Vitamin B1");
        vitamins.add("Vitamin A");*/
        System.out.println(nutrientsList.size());
        for(int i = 0;i <nutrientsList.size();i++) {
            if (nutrientsList.get(i).getTitle().contains("Fat") || nutrientsList.get(i).getTitle().contains("Carb") || nutrientsList.get(i).getTitle().contains("Sugar") ||
                    nutrientsList.get(i).getTitle().contains("cholesterol") || nutrientsList.get(i).getTitle().contains("protein") || nutrientsList.get(i).getTitle().contains("fibre")) {
                generalNutrients.add(nutrientsList.get(i).getTitle() + ": " + nutrientsList.get(i).getAmount() + nutrientsList.get(i).getUnit() + "\n\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");
            } else if (nutrientsList.get(i).getTitle().contains("Vitamin") || nutrientsList.get(i).getTitle().contains("Folate")) {
                vitamins.add(nutrientsList.get(i).getTitle() + ": " + nutrientsList.get(i).getAmount() + nutrientsList.get(i).getUnit() + "\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");}
            else { {minerals.add(nutrientsList.get(i).getTitle()+": "+nutrientsList.get(i).getAmount()+nutrientsList.get(i).getUnit()+"\n" + nutrientsList.get(i).getPercentOfDailyNeeds() + " % of daily needs");}
            }

        }
        List<String> calBreakdown = new ArrayList<String>();
        calBreakdown.add(caloricBreakdown.getPercentProtein() +"% of daily protein requirement");
        calBreakdown.add(caloricBreakdown.getPercentFat()+ "% of daily fat requirement");
        calBreakdown.add(caloricBreakdown.getPercentCarbs()+"% of daily carbohydrates requirement");


        listDataChild.put(listDataHeader.get(0), generalNutrients); // Header, Child data
        listDataChild.put(listDataHeader.get(1), minerals);
        listDataChild.put(listDataHeader.get(2), vitamins);
        //listDataChild.put(listDataHeader.get(3),calBreakdown);
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
                foodID = ingredientsResponse.body().get(0).getId();
                System.out.println("JOOOOOOOOOOOOOOO"+ resutltName);
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
                System.out.println("Ingredietns data methid id input is : "  + foodID + enterSearchIngMeasurement+enterSearchIngAmt);
                Call<IngredientsResponse> ingredientsResponseCall = service.getFoodInformation(foodID,enterSearchIngAmt,enterSearchIngMeasurement);
                Response<IngredientsResponse> ingredientsResponse = ingredientsResponseCall.execute();
                nutrientsList = ingredientsResponse.body().getNutrition().getNutrients();
                resutltName = ingredientsResponse.body().getName();
                caloricBreakdown = ingredientsResponse.body().getNutrition().getCaloricBreakdown();


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
            headerTitle.setText("Input: " + inputSearchIngName+ "\n Result Name: " + resutltName);
            headerData.setText("Amount: " +enterSearchIngAmt+ " "+enterSearchIngMeasurement);
        }

    }
}