package com.rose.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class OglenAdapter extends RecyclerView.Adapter<OglenAdapter.MyViewHolder> {

    Context context;
    ArrayList<Yemekler> list;
    OnItemClickListener clickListener; // Tıklama olayı dinleyicisi

    public OglenAdapter(Context context, ArrayList<Yemekler> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Yemekler yemekler =list.get(position);
        holder.yemekAdi.setText(yemekler.getYemekAdi());
        holder.kalori.setText(yemekler.getKalori());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onItemClick(yemekler);
                }
            }
        });
    }



    public interface OnItemClickListener {
        void onItemClick(Yemekler yemekler);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView yemekAdi, kalori;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            yemekAdi = itemView.findViewById(R.id.txtAd);
            kalori = itemView.findViewById(R.id.txtKal);
        }
    }
}

