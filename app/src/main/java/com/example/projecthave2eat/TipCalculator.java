package com.example.projecthave2eat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class TipCalculator extends AppCompatActivity {
    EditText ed_bill;
    TextView tv_tip,total_output,tip_output;
    Button b_calculate,b_tip_minus,b_tip_plus;
    int tipPercent = 0;
    double bill = 100.00;
    double tipOutput;
    double totalOutput=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        ed_bill=findViewById(R.id.ed_bill);
        tv_tip=findViewById(R.id.tv_tip);
        total_output=findViewById(R.id.total_output);
        tip_output=findViewById(R.id.tip_output);
        b_calculate=findViewById(R.id.b_calculate);
        b_tip_minus=findViewById(R.id.b_tip_minus);
        b_tip_plus=findViewById(R.id.b_tip_plus);

        b_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String billString = ed_bill.getText().toString();
                if(!billString.equals("")){
                    bill = Double.valueOf(billString);
                    bill = bill*100;
                    bill = Math.round(bill);
                    bill = bill / 100;

                    ed_bill.setText(String.format(Locale.getDefault(),"%.2f",bill));

                    tipOutput = (bill * tipPercent)/100;
                    tipOutput = tipOutput*100;
                    tipOutput = Math.round(tipOutput);
                    tipOutput = tipOutput / 100;

                    tip_output.setText(String.format(Locale.getDefault(),"%.2f",tipOutput));

                    totalOutput = bill + totalOutput;
                    total_output.setText(String.format(Locale.getDefault(),"%.2f",totalOutput));

                }

            }
        });
        b_tip_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tipPercent > 0){
                    tipPercent--;
                    tv_tip.setText(tipPercent+"%");
                }

            }
        });
        b_tip_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tipPercent++;
                    tv_tip.setText(tipPercent+"%");


            }
        });





    }
}
