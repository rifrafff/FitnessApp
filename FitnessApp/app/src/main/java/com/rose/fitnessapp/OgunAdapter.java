package com.rose.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OgunAdapter extends RecyclerView.Adapter<OgunAdapter.MyViewHolder> {

    Context context1;
    ArrayList<Ogun> list1;

    public OgunAdapter(Context context1, ArrayList<Ogun> list1) {
        this.context1 = context1;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Ogun ogun =list1.get(position);
        holder.ad.setText(ogun.getYemekAdd());
        holder.bas.setText(ogun.getOgun());
        holder.top.setText(ogun.getToplam1());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ad,bas,top;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ad=itemView.findViewById(R.id.txtAd);
            bas=itemView.findViewById(R.id.txtBaslik);
            top=itemView.findViewById(R.id.txtToplam);
        }
    }
}
