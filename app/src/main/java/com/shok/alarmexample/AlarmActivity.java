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

    // Request code for pending intent
    private final int PENDING_INTENT_REQUEST_CODE = 100;

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    private Button startAlarmButton;
    private Button stopAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        intializeViewsAndSetClickListeners();
    }

    private void intializeViewsAndSetClickListeners() {
        startAlarmButton = (Button) findViewById(R.id.start_alarm_button);
        stopAlarmButton = (Button) findViewById(R.id.stop_alarm_button);
        startAlarmButton.setOnClickListener(this);
        stopAlarmButton.setOnClickListener(this);
    }
    /**
     * initialize Alarm Manager
     */
    private void initializeAlarmManager() {
        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, PENDING_INTENT_REQUEST_CODE, intent, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_alarm_button:
                setAlarm();
                break;
            case R.id.stop_alarm_button:
                stopAlarm();
                break;
        }
    }

    /**
     * Start alarm at specified time
     */
    private void setAlarm() {
        if (alarmManager == null) {
            initializeAlarmManager();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 2);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    /**
     * Start alarm at specified time and repeat it after some interval
     */
    private void setRepeatingAlarm() {

    }


    private void setInExactRepeatingAlarm() {

    }

    /**
     * Stop alarm
     */
    private void stopAlarm() {
        if (alarmManager == null) {
           initializeAlarmManager();
        }
        alarmManager.cancel(pendingIntent);
     }


}
