package com.example.medupe.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medupe.Doctor;

import java.util.List;

public class doctorAdapters extends RecyclerView.Adapter {
    public doctorAdapters(List < Doctor > myDoctors) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder , int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
