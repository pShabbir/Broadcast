package com.example.sh.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Shabbir Hussain on 6/7/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle b=intent.getExtras();

        if(intent.getAction().equalsIgnoreCase("com.example.Broadcast"));
        {
                String msg = b.getString("msg");
                Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
        }
    }
}
