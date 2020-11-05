package com.example.traintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class trackingLive extends AppCompatActivity {
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_live);
        recyclerView=findViewById(R.id.recyclerviewID);
        String[] trainName=getResources().getStringArray(R.array.TrainName);
        Myadapter myadapter=new Myadapter(trackingLive.this,trainName);

        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
}
