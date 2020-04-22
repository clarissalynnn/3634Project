package com.example.a3634project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.SpoonacularAPI.Recipe;

public class SearchIngredientsData extends AppCompatActivity {
    private String inputSearchIngName;
    private String enterSearchIngAmt;
    private EditText amt;
    private String enterSearchIngMeasurement;
    private Button button;
    private EditText foodName ;
    private EditText foodAmt ;
    private Spinner measurement ;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inputSearchIngName = foodName.getText().toString();
            enterSearchIngAmt = foodAmt.getText().toString();
            int amt = Integer.parseInt(enterSearchIngAmt);
            enterSearchIngMeasurement = measurement.getSelectedItem().toString();
            launchIngredientsDataActivity(inputSearchIngName, enterSearchIngAmt, enterSearchIngMeasurement);
            System.out.println(inputSearchIngName);
            System.out.println(enterSearchIngAmt);
            System.out.println(enterSearchIngMeasurement);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ingredients_data);

        foodName = findViewById(R.id.inputSearchIngNameTV);
         foodAmt = findViewById(R.id.enterSearchIngAmtTV);
         measurement = findViewById(R.id.enterSearchIngMeasurement);

        System.out.println(inputSearchIngName + enterSearchIngMeasurement + enterSearchIngAmt);
        button = findViewById(R.id.searchIngButton);
        button.setOnClickListener(mOnClickListener);




    }
    private void launchIngredientsDataActivity(String name,String amount,  String measurement){
        Intent intent = new Intent(this,ShowIngredientData.class);
        intent.putExtra("INGREDIENT_NAME", name);
        intent.putExtra("AMOUNT", amount);
        intent.putExtra("MEASUREMENT", measurement);
        startActivity(intent);
    }
}
