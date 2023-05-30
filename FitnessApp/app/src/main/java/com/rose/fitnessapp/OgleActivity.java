package com.rose.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OgleActivity extends AppCompatActivity {
    RecyclerView recyc;
    DatabaseReference database;
    OglenAdapter oglenAdapter;
    ArrayList<Yemekler> list;
    TextView title2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogle);
        recyc=findViewById(R.id.recycOglen);
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ogle");
        recyc.setHasFixedSize(true);
        recyc.setLayoutManager(new LinearLayoutManager(this));
        title2=findViewById(R.id.ogunadi1);

        /*
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

        myRef.push().setValue(yemek11);
        myRef.push().setValue(yemek12);
        myRef.push().setValue(yemek13);
        myRef.push().setValue(yemek14);
        myRef.push().setValue(yemek15);
        myRef.push().setValue(yemek16);
        myRef.push().setValue(yemek17);
        myRef.push().setValue(yemek18);
        myRef.push().setValue(yemek19);
        myRef.push().setValue(yemek20); */
        

        list = new ArrayList<>();
        oglenAdapter = new OglenAdapter(this,list);
        recyc.setAdapter(oglenAdapter);
        Query ogle = myRef.orderByChild("kisi_key").limitToFirst(10);
        ogle.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                    Yemekler yemekler= dataSnapshot.getValue(Yemekler.class);
                    list.add(yemekler);
                }
                oglenAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        String titleValue2 = title2.getText().toString();
        oglenAdapter.setOnItemClickListener(new OglenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Yemekler yemekler) {
                Intent intent = new Intent(OgleActivity.this, AdetActivity.class);
                intent.putExtra("yemekAdi", yemekler.getYemekAdi());
                intent.putExtra("kalori", yemekler.getKalori());
                intent.putExtra("title",titleValue2);
                startActivity(intent);
            }
        });


    }
}