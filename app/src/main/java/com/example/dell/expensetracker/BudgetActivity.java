package com.example.dell.expensetracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BudgetActivity extends AppCompatActivity {

    EditText transportation, entertainment, groceries,food,utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        int def_transportation=0,def_entertainment=0,def_groceries=0,def_food=0,def_utilities=0;
        SharedPreferences pref = getSharedPreferences("BUDGET",MODE_PRIVATE);
        if(pref.contains("Transportation"))
            def_transportation=pref.getInt("Transportation",0);
        if(pref.contains("Entertainment"))
            def_entertainment=pref.getInt("Entertainment",0);
        if(pref.contains("Groceries"))
            def_groceries=pref.getInt("Groceries",0);
        if(pref.contains("Food"))
            def_food=pref.getInt("Food",0);
        if(pref.contains("Utilities"))
            def_utilities=pref.getInt("Utilities",0);

        transportation = (EditText) findViewById(R.id.editText_transport);
        entertainment = (EditText) findViewById(R.id.editText_entertainment);
        groceries = (EditText) findViewById(R.id.editText_groceries);
        food = (EditText) findViewById(R.id.editText_food);
        utilities = (EditText) findViewById(R.id.editText_utilities);

        transportation.setText(def_transportation+"");
        entertainment.setText(def_entertainment+"");
        groceries.setText(def_groceries+"");
        food.setText(def_food+"");
        utilities.setText(def_utilities+"");
    }

    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void submit(View v) {
        Toast.makeText(getApplicationContext(), "Saving budgets", Toast.LENGTH_SHORT).show();

        SharedPreferences preferences = getSharedPreferences("BUDGET", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int val_transportation=0,val_entertainment=0,val_groceries=0,val_food=0,val_utilities=0;
        if(isNumeric(transportation.getText().toString()))
            val_transportation=Integer.parseInt(transportation.getText().toString());
        if(isNumeric(entertainment.getText().toString()))
            val_entertainment=Integer.parseInt(entertainment.getText().toString());
        if(isNumeric(groceries.getText().toString()))
            val_groceries=Integer.parseInt(groceries.getText().toString());
        if(isNumeric(food.getText().toString()))
            val_food=Integer.parseInt(food.getText().toString());
        if(isNumeric(utilities.getText().toString()))
            val_utilities=Integer.parseInt(utilities.getText().toString());

        editor.putInt("Transportation",val_transportation);
        editor.putInt("Entertainment",val_entertainment);
        editor.putInt("Groceries",val_groceries);
        editor.putInt("Food",val_food);
        editor.putInt("Utilities",val_utilities);

        editor.commit();
        Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}

