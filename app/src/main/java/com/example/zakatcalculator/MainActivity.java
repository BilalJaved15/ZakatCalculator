package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.DoubleSummaryStatistics;

public class MainActivity extends AppCompatActivity {

    public int threshold = 80933;
    public Button calculate;
    public TextView cashInHand;
    public TextView cashForHajj;
    public TextView cashGivenLoan;
    public TextView cashForInvestment;
    public TextView liabilitiesBorrowed;
    public TextView liabilitiesWages;
    public TextView liabilitiesTaxes;
    public TextView gold;
    public TextView silver;
    public TextView stockValue;
    public TextView totalNetWorth;
    public TextView payableZakat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calculate);
        cashInHand = findViewById(R.id.cash_in_hand_text);
        cashForHajj = findViewById(R.id.cash_for_hajj_text);
        cashGivenLoan = findViewById(R.id.cash_given_loans_text);
        cashForInvestment = findViewById(R.id.cash_for_investment_text);
        liabilitiesBorrowed = findViewById(R.id.liabilities_borrow_text);
        liabilitiesWages = findViewById(R.id.liabilities_wages_text);
        liabilitiesTaxes = findViewById(R.id.liabilities_taxes_text);
        gold = findViewById(R.id.gold_text);
        silver = findViewById(R.id.silver_text);
        stockValue = findViewById(R.id.stock_value_text);
        totalNetWorth = findViewById(R.id.net_worth_value);
        payableZakat = findViewById(R.id.payable_zakat_value);
    }

    public Double getTotalNetWorth(){
        Double networth = 0.0;
        if (!cashInHand.getText().toString().equals(""))
            networth += Double.parseDouble(cashInHand.getText().toString());
        if (!cashForHajj.getText().toString().equals(""))
            networth += Double.parseDouble(cashForHajj.getText().toString());
        if (!cashGivenLoan.getText().toString().equals(""))
            networth += Double.parseDouble(cashGivenLoan.getText().toString());
        if (!cashForInvestment.getText().toString().equals(""))
            networth += Double.parseDouble(cashForInvestment.getText().toString());
        if (!liabilitiesBorrowed.getText().toString().equals(""))
            networth -= Double.parseDouble(liabilitiesBorrowed.getText().toString());
        if (!liabilitiesWages.getText().toString().equals(""))
            networth -= Double.parseDouble(liabilitiesWages.getText().toString());
        if (!liabilitiesTaxes.getText().toString().equals(""))
            networth -= Double.parseDouble(liabilitiesTaxes.getText().toString());
        if (!gold.getText().toString().equals(""))
            networth += Double.parseDouble(gold.getText().toString());
        if (!silver.getText().toString().equals(""))
            networth += Double.parseDouble(silver.getText().toString());
        if (!stockValue.getText().toString().equals(""))
            networth += Double.parseDouble(stockValue.getText().toString());
        return networth;
    }

    public void calculateZakat(View view) {
        Double netWorth = getTotalNetWorth();
        totalNetWorth.setText("Rs. " + netWorth.toString());
        if (netWorth >= threshold){
            payableZakat.setText("Rs. " + Double.valueOf(netWorth * (2.5/100)).toString());
        } else{
            payableZakat.setText("Rs. 0");
        }
    }
}