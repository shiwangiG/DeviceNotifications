package com.example.devicenotifications;

import android.app.NotificationManager;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    NotificationManager mNotificationManager;


    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
    }

    //playing audio and vibration when user requests

    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
    r.play();

    //vibration

    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    long[] pattern = {100, 300, 300, 300};
    v.vibrate(pattern, -1);

}
