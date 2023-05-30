package com.rose.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    CardView sabah,ogle,aksam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Yemekler");
        setContentView(R.layout.activity_home);
        sabah=findViewById(R.id.cardvKahvalti);
        ogle=findViewById(R.id.cardvOglen);
        aksam=findViewById(R.id.cardvAksam);

        /*
        Yemekler yemek1 =new Yemekler("","Yulaf ezmesi","150");
        Yemekler yemek2 =new Yemekler("","Muzlu smoothie","200");
        Yemekler yemek3 =new Yemekler("","Tam buğday ekmeği ile haşlanmış yumurta","250");
        Yemekler yemek4 =new Yemekler("","Peynirli omlet","300");
        Yemekler yemek5 =new Yemekler("","Yaban mersinli yoğurt ","120");
        Yemekler yemek6 =new Yemekler("","Fırında patates kızartması ","180");
        Yemekler yemek7 =new Yemekler("","Elmalı tarçınlı yulaf kepeği","180");
        Yemekler yemek8 =new Yemekler("","Çilekli kahvaltı smoothie'si","220");
        Yemekler yemek9 =new Yemekler("","Avokado tostu","350");
        Yemekler yemek10 =new Yemekler("","Yoğurtlu meyve salatası","180");
        Yemekler yemek11 =new Yemekler("","Tavuk salatası ","350");
        Yemekler yemek12 =new Yemekler("","Mercimek çorbası","200");
        Yemekler yemek13 =new Yemekler("","Ton balıklı sandviç","400");
        Yemekler yemek14 =new Yemekler("","Izgara sebzelerle karışık salata","250");
        Yemekler yemek15 =new Yemekler("","Nohutlu bulgur pilavı ","350");
        Yemekler yemek16 =new Yemekler("","Sebzeli kuskus salatası","280");
        Yemekler yemek17 =new Yemekler("","Tavuklu makarna salatası ","400");
        Yemekler yemek18 =new Yemekler("","Mantarlı ve ıspanaklı omlet ","280");
        Yemekler yemek19 =new Yemekler("","Zeytinyağlı yeşil mercimek salatası ","320");
        Yemekler yemek20 =new Yemekler("","Hindi ızgara ","300");
        Yemekler yemek21 =new Yemekler("","Tavuklu sebzeli noodle ","400");
        Yemekler yemek22 =new Yemekler("","Somon füme ile ıspanak salatası ","350");
        Yemekler yemek23 =new Yemekler("","Kırmızı mercimek köftesi","300");
        Yemekler yemek24 =new Yemekler("","Izgara biftek","400");
        Yemekler yemek25 =new Yemekler("","Tavuk sote","350");
        Yemekler yemek26 =new Yemekler("","Zeytinyağlı taze fasulye","200");
        Yemekler yemek27 =new Yemekler("","Quinoa salatası ","320");
        Yemekler yemek28 =new Yemekler("","Balık fırında sebzelerle","380");
        Yemekler yemek29 =new Yemekler("","Patates püresi ile et sote ","450");
        Yemekler yemek30 =new Yemekler("","Mantar soslu makarna ","350");

        myRef.push().setValue(yemek1);
        myRef.push().setValue(yemek2);
        myRef.push().setValue(yemek3);
        myRef.push().setValue(yemek4);
        myRef.push().setValue(yemek5);
        myRef.push().setValue(yemek6);
        myRef.push().setValue(yemek7);
        myRef.push().setValue(yemek8);
        myRef.push().setValue(yemek9);
        myRef.push().setValue(yemek10);
        myRef.push().setValue(yemek11);
        myRef.push().setValue(yemek12);
        myRef.push().setValue(yemek13);
        myRef.push().setValue(yemek14);
        myRef.push().setValue(yemek15);
        myRef.push().setValue(yemek16);
        myRef.push().setValue(yemek17);
        myRef.push().setValue(yemek18);
        myRef.push().setValue(yemek19);
        myRef.push().setValue(yemek20);
        myRef.push().setValue(yemek21);
        myRef.push().setValue(yemek22);
        myRef.push().setValue(yemek23);
        myRef.push().setValue(yemek24);
        myRef.push().setValue(yemek25);
        myRef.push().setValue(yemek26);
        myRef.push().setValue(yemek27);
        myRef.push().setValue(yemek28);
        myRef.push().setValue(yemek29);
        myRef.push().setValue(yemek30); */





        sabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SabahActivity.class));
            }
        });
        ogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,OgleActivity.class));
            }
        });
        aksam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,AksamActivity.class));
            }
        });
    }
}