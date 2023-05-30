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

public class AksamActivity extends AppCompatActivity {
    RecyclerView recyc;
    DatabaseReference database;
    OglenAdapter oglenAdapter;
    ArrayList<Yemekler> list;
    TextView title1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksam);
        recyc=findViewById(R.id.recycAksam);
        database= FirebaseDatabase.getInstance().getReference("Yemekler");
        recyc.setHasFixedSize(true);
        recyc.setLayoutManager(new LinearLayoutManager(this));
        title1=findViewById(R.id.ogunadi2);

        list = new ArrayList<>();
        oglenAdapter = new OglenAdapter(this,list);
        recyc.setAdapter(oglenAdapter);
        Query aksam=database.orderByChild("kisi_key").limitToLast(10);
        aksam.addListenerForSingleValueEvent(new ValueEventListener() {
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
        String titleValue1 = title1.getText().toString();
        oglenAdapter.setOnItemClickListener(new OglenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Yemekler yemekler) {
                Intent intent = new Intent(AksamActivity.this, AdetActivity.class);
                intent.putExtra("yemekAdi", yemekler.getYemekAdi());
                intent.putExtra("kalori", yemekler.getKalori());
                intent.putExtra("title",titleValue1);
                startActivity(intent);
            }
        });


    }
}