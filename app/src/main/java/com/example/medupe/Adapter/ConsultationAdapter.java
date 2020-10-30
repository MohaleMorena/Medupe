package com.example.medupe.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.example.medupe.Doctor;
import com.example.medupe.R;
import com.example.medupe.models.Consultation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConsultationAdapter extends BaseAdapter {
    int i = 0;
    Context mContext;
    LayoutInflater inflater;
    List <Consultation> consultationList;
    ArrayList < Consultation > arrayList;

    public ConsultationAdapter(FragmentActivity activity , List < Consultation > myConsultations) {
    }

    @Override
    public int getCount() {
        return consultationList.size();
    }

    @Override
    public Object getItem(int position) {
        return consultationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position , View convertView , ViewGroup parent) {
        final CircleImageView doctorPicture = convertView.findViewById( R.id.profile_image);


        final TextView doctorFullName = convertView.findViewById(R.id.fullName);
        final TextView day = convertView.findViewById(R.id.day);


        final Consultation Consultation = consultationList.get(position);
        final String emailDoctor = Consultation.getDoctorEmail();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        reference.addValueEventListener( new ValueEventListener () {
            private com.example.medupe.models.Doctor databaseError;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                {
                    Doctor doctor = data.getValue(Doctor.class);
                    if(doctor.getEmail().equals(emailDoctor))
                    {
                        doctorFullName.setText("Dr. "+doctor.getFullName());
                        day.setText(Consultation.getDate());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        final StorageReference profileRef = storageReference.child("Profile pictures").child(emailDoctor+".jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener <Uri> () {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(mContext).load(uri).into(doctorPicture);

            }
        });
        return convertView;
    }
}
