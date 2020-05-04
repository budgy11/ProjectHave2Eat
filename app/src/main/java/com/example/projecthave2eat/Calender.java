package com.example.projecthave2eat;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.calendarview.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calender extends AppCompatActivity {

    CalendarView calender;
    TextView date_view;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calender = (CalendarView)
                findViewById(R.id.calender);
        date_view = (TextView)
                findViewById(R.id.date_view);


        calender
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override


                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {


                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;


                                date_view.setText(Date);
                            }
                        });
    }
}

