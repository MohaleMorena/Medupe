package com.example.medupe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.medupe.Adapter.MyDoctorsAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDoctorInfoActivity extends Activity {
    ListView myDoctorsListView;
    List<Doctor> Doctors;
    List <Doctor> myDoctors;
    MyDoctorsAdapter adapter;
    private com.example.medupe.models.Doctor databaseError;
    private PolicyNode dataSnapshot;
    private Doctor doctor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_my_doctors );
        myDoctorsListView = findViewById ( R.id.myDoctors );
        Doctors = new ArrayList<>();
        myDoctors = new ArrayList <> ();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        reference.addValueEventListener( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Doctors.clear ();
                for (Iterator < ? extends PolicyNode > it = dataSnapshot.getChildren (); it.hasNext (); ) {
                    DataSnapshot data = (DataSnapshot) it.next ();
                    Doctors doctors = data.getValue (Doctors.class);
                    Doctors.add(doctor);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println ("The read failed:" + databaseError.getCode());

            }
        });


    }

    public void phoneCall(View view) {
    }

    public void Gmail(View view) {
    }

    public void Locate(View view) {
    }
}
