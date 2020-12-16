package ua.nure.moviegallery.date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtil.getConnectivityStatus(context) != NetworkUtil.TYPE_NOT_CONNECTED) {

        }
    }
}
