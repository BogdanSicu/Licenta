package com.example.doza_de_sanatate.Notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.doza_de_sanatate.MainActivity;
import com.example.doza_de_sanatate.R;

public class NotificationWorkout extends BroadcastReceiver {

    private static final String channel_ID = "workout_channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        int notifcationID = intent.getIntExtra("notificationID", 0);
        String message = "Get up, it's the time for your workout";

        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
          context, 0, mainIntent, 0
        );

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.O){
            CharSequence channel_name = "My notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(channel_ID,
                    channel_name, importance);

            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channel_ID)
                    .setSmallIcon(R.drawable.icon_menu_workout)
                    .setContentTitle("Workout Time")
                    .setContentText(message)
                    .setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

            notificationManager.notify(notifcationID, builder.build());
        }
    }
}
