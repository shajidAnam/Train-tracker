package com.example.traintracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicketBuy extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private  String number= "*131"+Uri.encode("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_buy);

        textView=findViewById(R.id.OnlineTicketBuyTxtview);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        button=findViewById(R.id.buyTicketSMSid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TicketBuy.this);
                builder.setTitle("Alert");
                builder.setMessage("Do you have Banglalink or Grameenphone sim card?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+number));
                        if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(TicketBuy.this, "Give Permission to Access PhoneCall", Toast.LENGTH_LONG).show();
                            CallRequest();
                        }

                        else
                        {
                            startActivity(intent);
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TicketBuy.this,"You must need a Grameenphone sim or Banglalink sim to buy ticket",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setIcon(R.drawable.ic_warning_black_24dp);
                AlertDialog dialog=builder.create();
                dialog=builder.show();
            }
        });
    }
    private void CallRequest(){
        ActivityCompat.requestPermissions(TicketBuy.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
