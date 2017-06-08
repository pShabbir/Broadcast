package com.example.sh.broadcast;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Shabbir Hussain on 6/8/2017.
 */

public class MyService extends IntentService {

    public static boolean IsRunning = false;
    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        Log.d("Debug","It happens here");

        while (IsRunning){
            Intent intentBroad=new Intent();
            intent.setAction("com.example.Broadcast");
            intent.putExtra("msg","Hello from service");
            sendBroadcast(intentBroad);

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
