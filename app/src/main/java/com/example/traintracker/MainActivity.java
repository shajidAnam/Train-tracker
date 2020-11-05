package com.example.traintracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button ticketBuybtn,schedulebtn,mapbtn,noticebtn,trackingbtn,contactbtn;
    public static final String ACTION_SMS_SENT = "com.example.android.apis.os.SMS_SENT_ACTION";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ticketBuybtn=findViewById(R.id.buyTicketBtnID);
        schedulebtn=findViewById(R.id.ScheduleBtnID);
        mapbtn=findViewById(R.id.stationMapBtnID);
        noticebtn=findViewById(R.id.NoticeBoardBtnID);
        trackingbtn=findViewById(R.id.LiveTrackingBtnID);
        contactbtn=findViewById(R.id.ContactBtnID);

        broadcastingSMS br = new broadcastingSMS(){
            @Override
            public void onReceive(Context context, Intent intent) {
                String message = null;
                boolean error = true;
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        message = "Message sent!";
                        error = false;
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        message = "Error: check balance or sms setting";
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        message = "Error: No Sim card available.";
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        message = "Error: Null PDU.";
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        message = "Error: Radio off.";
                        break;
                }
                Toast.makeText(context,message,Toast.LENGTH_LONG).show();

            };
        };
        registerReceiver(br,new IntentFilter(ACTION_SMS_SENT));




        ticketBuybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TicketBuy.class);
                startActivity(intent);

            }
        });


        schedulebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TrainSchedule.class);
                startActivity(intent);

            }
        });

        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Information");
                builder.setMessage("Coming soon.....");
                builder.setPositiveButton("close",null);
                AlertDialog dialog=builder.create();
                dialog=builder.show();

            }
        });

        noticebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Information");
                builder.setMessage("Coming soon.....");
                builder.setPositiveButton("close",null);
                AlertDialog dialog=builder.create();
                dialog=builder.show();
//                Intent intent = new Intent(MainActivity.this,broadcastingSMS.class);
//                startActivity(intent);
            }
        });

        trackingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,trackingLive.class);
                startActivity(intent);
            }
        });

        contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContactNum.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
