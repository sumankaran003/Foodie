package in.karan.suman.foodka.Helper;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import in.karan.suman.foodka.R;

/**
 * Created by Suman on 13-Feb-18.
 */

public class NotificationHelper extends ContextWrapper{

    private static final String FOODIE_CHANNEL_ID="in.karan.suman.foodka.FOODIE";
    private static final String FOODIE_CHANNEL_NAME="Foodie";


    private NotificationManager manager;


    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            createChannel();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel foodieChannel=new NotificationChannel(FOODIE_CHANNEL_ID,
                FOODIE_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);

        foodieChannel.enableLights(false);
        foodieChannel.enableVibration(true);
        foodieChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(foodieChannel);





    }

    public NotificationManager getManager() {
        if(manager==null)
            manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public android.app.Notification.Builder getFoodieChannelNotification(String title, String body, PendingIntent contentIntent, Uri soundUri)
    {
        return new android.app.Notification.Builder(getApplicationContext(),FOODIE_CHANNEL_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(soundUri)
                .setAutoCancel(false);
    }
    @TargetApi(Build.VERSION_CODES.O)
    public android.app.Notification.Builder getFoodieChannelNotification(String title, String body,  Uri soundUri)
    {
        return new android.app.Notification.Builder(getApplicationContext(),FOODIE_CHANNEL_ID)

                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(soundUri)
                .setAutoCancel(false);
    }
}
