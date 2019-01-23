package com.example.week3daily2homeassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private MyBroadcastReceiverListener listener;

    public MyBroadcastReceiver(MyBroadcastReceiverListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.onReceive(context, intent);
    }
}
