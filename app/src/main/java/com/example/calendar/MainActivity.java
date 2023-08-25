package com.example.calendar;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        calendarView = findViewById(R.id.calenderView);
        calendar= Calendar.getInstance();

        setDate(1,1,2023);
        getDate();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view ,int year ,int month ,int dayOfMonth) {
                Toast.makeText(MainActivity.this,dayOfMonth+"/"+(month+1)%10+"/"+year,Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yy",Locale.getDefault());
        calendar.getTimeInMillis();
        String selected_date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this,selected_date,Toast.LENGTH_LONG).show();

    }

    public void setDate (int day,int month,int year){
        calendar.set(calendar.YEAR,year);
        calendar.set(calendar.MONTH,month);
        calendar.set(calendar.DAY_OF_MONTH,day);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);
    }
}