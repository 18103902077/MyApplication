package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ZhiHuCalendarActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialCalendarView calendarView;
    private Toolbar tool_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu_calendar);
        initView();
    }

    private static final String TAG = "tag";
    private void initView() {
        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        calendarView.setOnClickListener(this);

        tool_bar.setTitle("选择日期");
        setSupportActionBar(tool_bar);

        Calendar calendar= Calendar.getInstance();
        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(2013, 4, 3))
                .setMaximumDate(CalendarDay.from(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                String dateSS = df.format(date.getDate()).toString();

                Log.d(TAG, "onDateSelected: "+   df.format( date.getDate()).toString());

                Intent intent = new Intent();
                intent.setAction("com.myapplication.date");

                intent.putExtra("date",dateSS);
                LocalBroadcastManager.getInstance(ZhiHuCalendarActivity.this).sendBroadcast(intent);
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.calendarView:
                break;
        }
    }
}
