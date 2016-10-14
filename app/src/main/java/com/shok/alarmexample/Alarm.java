package com.shok.alarmexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Ashok M on 14/10/16.
 */

public class Alarm {
    // Request code for pending intent
    private final int PENDING_INTENT_REQUEST_CODE = 100;

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    /**
     * initialize Alarm Manager
     */
    public void initializeAlarmManager(Context context) {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, PENDING_INTENT_REQUEST_CODE, intent, 0);
    }

    /**
     * Start alarm at specified time
     */
    public void setAlarm(Context context) {
        if (alarmManager == null) {
            initializeAlarmManager(context);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 2);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    /**
     * Start alarm at specified time and repeat it after some interval
     */
    public void setRepeatingAlarm(Context context) {
        if (alarmManager == null) {
            initializeAlarmManager(context);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 2);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }


    /**
     * set inexact repeating alarm
     */
    public void setInExactRepeatingAlarm(Context context) {
        if (alarmManager == null) {
            initializeAlarmManager(context);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 2);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000*60*2, pendingIntent);
    }

    /**
     * Stop alarm
     */
    public void stopAlarm(Context context) {
        if (alarmManager == null) {
            initializeAlarmManager(context);
        }
        alarmManager.cancel(pendingIntent);
    }
}
