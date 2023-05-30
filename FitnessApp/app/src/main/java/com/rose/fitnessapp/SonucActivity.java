package com.rose.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SonucActivity extends AppCompatActivity {
    RecyclerView recycc;
    DatabaseReference database;
    OgunAdapter ogunAdapter;
    ArrayList<Ogun> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        recycc=findViewById(R.id.sonuc);
        database= FirebaseDatabase.getInstance().getReference("Ogunler");
        recycc.setHasFixedSize(true);
        recycc.setLayoutManager(new LinearLayoutManager(this));

        list1 = new ArrayList<>();
        ogunAdapter =new OgunAdapter(this,list1);
        recycc.setAdapter(ogunAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                    Ogun ogun= dataSnapshot.getValue(Ogun.class);
                    list1.add(ogun);
                }
                ogunAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}