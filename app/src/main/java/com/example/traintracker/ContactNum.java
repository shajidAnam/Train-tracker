package com.example.traintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ContactNum extends AppCompatActivity {
    private PDFView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_num);
        contact=findViewById(R.id.ContactPdfID);
        contact.fromAsset("contact.pdf").load();
    }
}
