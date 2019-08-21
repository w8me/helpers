package com.relucks.helpers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AppHelper {

    public static void reload(Context context, Class<?> startActivity) {
        Intent intent = new Intent(context, startActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static void restart(Context context, Class<?> activity) {
        Intent mStartActivity = new Intent(context, activity);
        mStartActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent mPendingIntent = PendingIntent.getActivity(context, 123456, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (mgr != null) {
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1, mPendingIntent);
            System.exit(10);
        }
    }
}
