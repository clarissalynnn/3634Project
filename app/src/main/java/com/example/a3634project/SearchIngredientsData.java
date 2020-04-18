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
    private int enterSearchIngAmt;
    private EditText amt;
    private String enterSearchIngMeasurement;
    private Button button;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchIngredientsDataActivity(inputSearchIngName, enterSearchIngAmt, enterSearchIngMeasurement);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ingredients_data);

        inputSearchIngName= String.valueOf(findViewById(R.id.inputSearchIngNameTV));
        amt = findViewById(R.id.enterSearchIngAmtTV);
        String sAmt = amt.getText().toString();
        if(!"".equals(sAmt)){
            enterSearchIngAmt = Integer.parseInt(sAmt);
        }

        enterSearchIngMeasurement = String.valueOf(findViewById(R.id.enterSearchIngMeasurement));
        button = findViewById(R.id.searchIngButton);
        button.setOnClickListener(mOnClickListener);




    }
    private void launchIngredientsDataActivity(String name,int amount,  String measurement){
        Intent intent = new Intent(this,ShowIngredientData.class);
        intent.putExtra("INGREDIENT_NAME", name);
        intent.putExtra("AMOUNT", amount);
        intent.putExtra("MEASUREMENT", measurement);
        startActivity(intent);
    }
}
