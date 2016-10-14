package com.shok.alarmexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlarmActivity extends AppCompatActivity {

    // Request code for pending intent
    private final int PENDING_INTENT_REQUEST_CODE = 100;

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    /**
     * initialize Alarm Manager
     */
    private void initializeAlarmManager() {
        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, PENDING_INTENT_REQUEST_CODE, intent, 0);
    }

    /**
     * Start alarm at specified time
     */
    private void setExactAlarm() {
        
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

    }


}
