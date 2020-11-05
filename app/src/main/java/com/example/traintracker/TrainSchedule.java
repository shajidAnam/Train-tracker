package com.example.traintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class TrainSchedule extends AppCompatActivity {
    private PDFView trainSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_schedule);
        trainSchedule=findViewById(R.id.TrainScheduleID);
        trainSchedule.fromAsset("intercitySchedule.pdf").load();
    }
}
