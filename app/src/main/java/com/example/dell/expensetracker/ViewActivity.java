package com.example.dell.expensetracker;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView BudgetTransportation,BudgetEntertainment,BudgetGroceries,BudgetFood,BudgetUtilities,BudgetTotal;
    TextView ExpenseTransportation,ExpenseEntertainment,ExpenseGroceries,ExpenseFood,ExpenseUtilities,ExpenseTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        int budget_transportation=0,budget_entertainment=0;
        int budget_groceries=0,budget_food=0,budget_utilities=0,budget_total=0;

        int expense_transportation=0,expense_entertainment=0,expense_groceries=0;
        int expense_food=0,expense_utilities=0,expense_total=0;

        BudgetTransportation = (TextView)findViewById(R.id.Budget_Transportation);
        BudgetEntertainment = (TextView)findViewById(R.id.Budget_Entertainment);
        BudgetGroceries = (TextView)findViewById(R.id.Budget_Groceries);
        BudgetFood = (TextView)findViewById(R.id.Budget_Food);
        BudgetUtilities = (TextView)findViewById(R.id.Budget_Utilities);
        BudgetTotal = (TextView)findViewById(R.id.Budget_Total);

        ExpenseTransportation = (TextView)findViewById(R.id.Expense_Transportation);
        ExpenseEntertainment = (TextView)findViewById(R.id.Expense_Entertainment);
        ExpenseGroceries = (TextView)findViewById(R.id.Expense_Groceries);
        ExpenseFood = (TextView)findViewById(R.id.Expense_Food);
        ExpenseUtilities = (TextView)findViewById(R.id.Expense_Utilities);
        ExpenseTotal = (TextView)findViewById(R.id.Expense_Total);

        SharedPreferences prefBudget = getSharedPreferences("BUDGET",MODE_PRIVATE);

        if(prefBudget.contains("Transportation"))
            budget_transportation=prefBudget.getInt("Transportation",0);
        if(prefBudget.contains("Entertainment"))
            budget_entertainment=prefBudget.getInt("Entertainment",0);
        if(prefBudget.contains("Groceries"))
            budget_groceries=prefBudget.getInt("Groceries",0);
        if(prefBudget.contains("Food"))
            budget_food=prefBudget.getInt("Food",0);
        if(prefBudget.contains("Utilities"))
            budget_utilities=prefBudget.getInt("Utilities",0);


        budget_total=budget_transportation+budget_entertainment+budget_groceries+budget_food+budget_utilities;

        BudgetTransportation.setText(budget_transportation+"");
        BudgetEntertainment.setText(budget_entertainment+"");
        BudgetGroceries.setText(budget_groceries+"");
        BudgetFood.setText(budget_food+"");
        BudgetUtilities.setText(budget_utilities+"");
        BudgetTotal.setText(budget_total+"");

        SharedPreferences prefExpense = getSharedPreferences("EXPENSE",MODE_PRIVATE);

        if(prefExpense.contains("Transportation"))
            expense_transportation=prefExpense.getInt("Transportation",0);
        if(prefBudget.contains("Entertainment"))
            expense_entertainment=prefExpense.getInt("Entertainment",0);
        if(prefBudget.contains("Groceries"))
            expense_groceries=prefExpense.getInt("Groceries",0);
        if(prefBudget.contains("Food"))
            expense_food=prefExpense.getInt("Food",0);
        if(prefBudget.contains("Utilities"))
            expense_utilities=prefExpense.getInt("Utilities",0);
        expense_total=expense_transportation+expense_entertainment+expense_groceries+expense_food+expense_utilities;

        ExpenseTransportation.setText(expense_transportation+"");
        ExpenseEntertainment.setText(expense_entertainment+"");
        ExpenseGroceries.setText(expense_groceries+"");
        ExpenseFood.setText(expense_food+"");
        ExpenseUtilities.setText(expense_utilities+"");
        ExpenseTotal.setText(expense_total+"");

        if(expense_transportation>budget_transportation)
            ExpenseTransportation.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseTransportation.setTextColor(Color.argb(255,0,255,0));

        if(expense_entertainment>budget_entertainment)
            ExpenseEntertainment.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseEntertainment.setTextColor(Color.argb(255,0,255,0));

        if(expense_groceries>budget_groceries)
            ExpenseGroceries.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseGroceries.setTextColor(Color.argb(255,0,255,0));

        if(expense_food>budget_food)
            ExpenseFood.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseFood.setTextColor(Color.argb(255,0,255,0));

        if(expense_utilities>budget_utilities)
            ExpenseUtilities.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseUtilities.setTextColor(Color.argb(255,0,255,0));

        if(expense_total>budget_total)
            ExpenseTotal.setTextColor(Color.argb(255,255,0,0));
        else
            ExpenseTotal.setTextColor(Color.argb(255,0,255,0));

    }
}
