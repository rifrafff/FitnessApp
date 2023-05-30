package com.rose.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class SabahActivity extends AppCompatActivity {
    RecyclerView recyc;
    TextView title;
    DatabaseReference database;
    SabahAdapter sabahAdapter;
    ArrayList<Yemekler> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabah);
        recyc=findViewById(R.id.recycKahvalti);
        database= FirebaseDatabase.getInstance().getReference("Yemekler");
        recyc.setHasFixedSize(true);
        recyc.setLayoutManager(new LinearLayoutManager(this));
        title=findViewById(R.id.ogunadi);

        list = new ArrayList<>();
        sabahAdapter = new SabahAdapter(this,list);
        recyc.setAdapter(sabahAdapter);

        Query sabah=database.orderByChild("kisi_key").limitToFirst(10);
        sabah.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                    Yemekler yemekler= dataSnapshot.getValue(Yemekler.class);
                    list.add(yemekler);
                }
                sabahAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        String titleValue = title.getText().toString();
        sabahAdapter.setOnItemClickListener(new SabahAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Yemekler yemekler) {
                Intent intent = new Intent(SabahActivity.this, AdetActivity.class);
                intent.putExtra("yemekAdi", yemekler.getYemekAdi());
                intent.putExtra("kalori", yemekler.getKalori());
                intent.putExtra("title",titleValue);
                startActivity(intent);
            }
        });


    }
}