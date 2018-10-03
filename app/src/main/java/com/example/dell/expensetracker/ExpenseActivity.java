package com.example.dell.expensetracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class ExpenseActivity extends AppCompatActivity {

    EditText transportation,entertainment,groceries,food,utilities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        transportation = (EditText)findViewById(R.id.editText_transport);
        entertainment = (EditText)findViewById(R.id.editText_entertainment);
        groceries = (EditText)findViewById(R.id.editText_groceries);
        food = (EditText)findViewById(R.id.editText_food);
        utilities = (EditText)findViewById(R.id.editText_utilities);
    }

    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void addExpense(View v)
    {
        Toast.makeText(getApplicationContext(),"Adding expense", Toast.LENGTH_SHORT).show();
        SharedPreferences preferences =  getSharedPreferences("EXPENSE", MODE_PRIVATE);
        int prev_transportation=0,prev_entertainment=0,prev_groceries=0,prev_food=0,prev_utilities=0;
        if(preferences.contains("Transportation"))
            prev_transportation=preferences.getInt("Transportation",0);
        if(preferences.contains("Entertainment"))
            prev_entertainment=preferences.getInt("Entertainment",0);
        if(preferences.contains("Groceries"))
            prev_groceries=preferences.getInt("Groceries",0);
        if(preferences.contains("Food"))
            prev_food=preferences.getInt("Food",0);
        if(preferences.contains("Utilities"))
            prev_utilities=preferences.getInt("Utilities",0);
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


        editor.putInt("Transportation",prev_transportation+val_transportation);
        editor.putInt("Entertainment",prev_entertainment+val_entertainment);
        editor.putInt("Groceries",prev_groceries+val_groceries);
        editor.putInt("Food",prev_food+val_food);
        editor.putInt("Utilities",prev_utilities+val_utilities);
        editor.commit();

        Toast.makeText(getApplicationContext(), "Expense added", Toast.LENGTH_SHORT).show();
    }
}
