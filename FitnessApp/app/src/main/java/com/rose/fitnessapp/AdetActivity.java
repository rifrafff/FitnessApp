package com.rose.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdetActivity extends AppCompatActivity {
    TextView yemekAd,kalori,adet,toplamm,ogunnn;
    Button artır,azalt,kaydet;
    int quantity;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ogunler");
        setContentView(R.layout.activity_adet);
        yemekAd=findViewById(R.id.foodName);
        kalori=findViewById(R.id.foodCal);
        adet=findViewById(R.id.quantity);
        artır=findViewById(R.id.addquantity);
        azalt=findViewById(R.id.subquantity);
        toplamm=findViewById(R.id.toplam);
        kaydet=findViewById(R.id.kaydet);
        ogunnn=findViewById(R.id.ogunn);


        Intent intent = getIntent();
        String yemekAdii = intent.getStringExtra("yemekAdi");
        String kalorii = intent.getStringExtra("kalori");
        String baslik = intent.getStringExtra("title");

        yemekAd.setText(yemekAdii);
        kalori.setText(kalorii);
        ogunnn.setText(baslik);


        artır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cal = kalori.getText().toString();
                int basePrice = Integer.parseInt(cal);
                quantity++;
                displayQuantity();
                int fooddPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(fooddPrice);
                toplamm.setText(setnewPrice);

            }
        });

        azalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cal = kalori.getText().toString();
                int basePrice = Integer.parseInt(cal);
                if (quantity == 0) {
                    Toast.makeText(AdetActivity.this, "Adet 0 dan Fazla Olmalı", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int fooddPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(fooddPrice);
                    toplamm.setText(setnewPrice);
                }
            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity == 0){
                    Toast.makeText(AdetActivity.this, "Adet 0 dan Fazla Olmalı", Toast.LENGTH_SHORT).show();
                }
                else{
                    String toplam2 =toplamm.getText().toString();
                    Ogun ogun =new Ogun(baslik,toplam2,yemekAdii,"");
                    myRef.push().setValue(ogun);
                    startActivity(new Intent(AdetActivity.this,SonucActivity.class));
                }
            }
        });


    }
    private void displayQuantity() {
        adet.setText(String.valueOf(quantity));
    }
}