package com.example.dell.expensetracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date date = new Date();

        SharedPreferences pref = getSharedPreferences("BUFFER",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int d=0;
        if(pref.contains("date"))
            d= pref.getInt("date",0);
        if(date.getDate()==1&&d!=1) {
            SharedPreferences budgetPref = getSharedPreferences("BUDGET",MODE_PRIVATE);
            SharedPreferences.Editor budgetEditor = budgetPref.edit();
            if(budgetPref.contains("Transportation"))
              budgetEditor.putInt("Transportation",0);
            if(budgetPref.contains("Entertainment"))
              budgetEditor.putInt("Entertainment",0);
            if(budgetPref.contains("Groceries"))
              budgetEditor.putInt("Groceries",0);
            if(budgetPref.contains("Food"))
                budgetEditor.putInt("Food",0);
            if(budgetPref.contains("Utilities"))
                budgetEditor.putInt("Utilities",0);
            budgetEditor.commit();

            SharedPreferences expensePref = getSharedPreferences("EXPENSE",MODE_PRIVATE);
            SharedPreferences.Editor expenseEditor = expensePref.edit();
            if(expensePref.contains("Transportation"))
              expenseEditor.putInt("Transportation",0);
            if(expensePref.contains("Entertainment"))
              expenseEditor.putInt("Entertainment",0);
            if(expensePref.contains("Groceries"))
              expenseEditor.putInt("Groceries",0);
            if(expensePref.contains("Food"))
                expenseEditor.putInt("Food",0);
            if(expensePref.contains("Utilities"))
                expenseEditor.putInt("Utilities",0);
            expenseEditor.commit();
            Toast.makeText(getApplicationContext(),"Cleared budget and expenses", Toast.LENGTH_LONG).show();
        }
        editor.putInt("date",date.getDate());
        editor.commit();
        CalendarView calendar = (CalendarView)findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Date today = new Date();
                if ((today.getYear()+1900)==year && today.getMonth()==month && dayOfMonth<=today.getDate())
                {
                    Intent gotoExpenseActivity = new Intent();
                gotoExpenseActivity.setClass(getApplicationContext(), ExpenseActivity.class);
                startActivity(gotoExpenseActivity);
                }
                else
                    Toast.makeText(getApplicationContext(),"Selected date can't be reached", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void enterBudget(View v)
    {
        Intent gotoBudgetActivity = new Intent();
        gotoBudgetActivity.setClass(this,BudgetActivity.class);
        startActivity(gotoBudgetActivity);
    }

    public void viewExpense(View v)
    {
        Intent gotoViewActivity = new Intent();
        gotoViewActivity.setClass(this,ViewActivity.class);
        startActivity(gotoViewActivity);
    }

}
