package com.example.sh.broadcast;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Shabbir Hussain on 6/7/2017.
 */

public class MyReceiver extends BroadcastReceiver {


    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {


        Bundle b = intent.getExtras();

        if (intent.getAction().equalsIgnoreCase("com.example.Broadcast")) ;
        {
            String msg = b.getString("msg");
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

            NewMessageNotification n=new NewMessageNotification();
            n.notify(context,msg,52);
        }
        if (intent.getAction().equalsIgnoreCase("android.provider.Telephony.SMS_RECEIVED")) {
            if (b != null) {

                final Object[] pdusObj = (Object[]) b.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdusObj.length];
                for (int i = 0; i < messages.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = b.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    }
                    // SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String senderNum = messages[i].getOriginatingAddress();
                    String message = messages[i].getMessageBody();//

                    Toast.makeText(context, senderNum+" : "+message, Toast.LENGTH_LONG).show();
                }
            }
        }


    }
}
