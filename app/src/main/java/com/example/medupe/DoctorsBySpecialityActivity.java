package com.example.medupe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.medupe.Adapter.ListViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.*;

public class DoctorsBySpecialityActivity extends Activity {
    TextView doctorSpeciality;
    ListView myDoctorsBySpecialityListView;
    List <Doctor> myDoctors;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_doctors_by_speciality);
        Intent intent = getIntent();
        final String speciality = intent.getStringExtra("speciality");
        myDoctorsBySpecialityListView = findViewById(R.id.myDoctorsBySpeciality);
        doctorSpeciality = findViewById(R.id.speciality);
        doctorSpeciality.setText(speciality);
        myDoctors = new ArrayList <> ();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        reference.addValueEventListener( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myDoctors.clear();
                PolicyNode dataSnapshot = null;
                for (Iterator < ? extends PolicyNode > it = dataSnapshot.getChildren (); it.hasNext (); ) {
                    DataSnapshot data = (DataSnapshot) it.next ();
                    Doctor doctor = data.getValue(Doctor.class);
                    if(doctor.getSpeciality().equals(speciality))
                    {
                        myDoctors.add(doctor);
                        sort( unmodifiableList ( myDoctors ) );
                        adapter = new ListViewAdapter(getApplicationContext(), myDoctors);
                        myDoctorsBySpecialityListView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                com.example.medupe.models.Doctor databaseError = null;
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        myDoctorsBySpecialityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > parent, View view , int position , long id) {
                Intent intent = new Intent(getApplicationContext(), DisplayDoctorInfo.class);
                intent.putExtra("fullName",myDoctors.get(position).getFullName());
                intent.putExtra("email",myDoctors.get(position).getEmail());
                intent.putExtra("speciality",myDoctors.get(position).getSpeciality());
                intent.putExtra("phoneNumber",myDoctors.get(position).getPhoneNumber());
                intent.putExtra("address", myDoctors.get(position).getAddress());
                intent.putExtra("city", myDoctors.get(position).getCity());
                startActivity(intent);
            }

            });
        }

    private void sort(List < Doctor > unmodifiableList) {

    }
}
