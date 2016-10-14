package com.shok.alarmexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    private Alarm alarm;

    private Button startAlarmButton;
    private Button stopAlarmButton;
    private Button startRepeatingAlarmButton;
    private Button startInExactRepeatingAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        intializeViewsAndSetClickListeners();
    }

    private void intializeViewsAndSetClickListeners() {
        alarm = new Alarm();

        startAlarmButton = (Button) findViewById(R.id.start_alarm_button);
        stopAlarmButton = (Button) findViewById(R.id.stop_alarm_button);
        startRepeatingAlarmButton = (Button) findViewById(R.id.start_repeating_alarm_button);
        startInExactRepeatingAlarmButton = (Button) findViewById(R.id.start_inexact_alarm);
        startAlarmButton.setOnClickListener(this);
        stopAlarmButton.setOnClickListener(this);
        startRepeatingAlarmButton.setOnClickListener(this);
        startInExactRepeatingAlarmButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_alarm_button:
                alarm.setAlarm(AlarmActivity.this);
                break;
            case R.id.stop_alarm_button:
                alarm.stopAlarm(AlarmActivity.this);
                break;
            case R.id.start_repeating_alarm_button:
                alarm.setRepeatingAlarm(AlarmActivity.this);
                break;
            case R.id.start_inexact_alarm:
                alarm.setInExactRepeatingAlarm(AlarmActivity.this);
                break;
        }
    }




}
