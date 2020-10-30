package com.example.medupe;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientProfileInformations extends AppCompatActivity {
    TextView fullName, cin, email, phoneNumber, maritalStatus, birthDate;
    CircleImageView circleImageView;
    FirebaseUser user;
    String uid;
    String Uri;
    DatabaseReference databaseReference;
    String firstNameRetrieved, lastNameRetrieved, cinRetrieved, emailRetrieved, phoneNumberRetrieved, maritalStatusRetrieved, birthdateRetrieved;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_patient_profile_informations);

        fullName = findViewById(R.id.fullName);
        cin = findViewById(R.id.cin);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);
        maritalStatus = findViewById(R.id.maritalStatus);
        birthDate = findViewById(R.id.birthDate);
        circleImageView = findViewById(R.id.profile_image);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("Patients");

        databaseReference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DatabaseReference dataSnapshot = null;
                firstNameRetrieved =  dataSnapshot.child(uid).child("firstName").getValue(String.class);
                lastNameRetrieved =  dataSnapshot.child(uid).child("lastName").getValue(String.class);
                fullName.setText(firstNameRetrieved+" "+lastNameRetrieved);
                cinRetrieved = dataSnapshot.child(uid).child("cin").getValue(String.class);
                cin.setText(cinRetrieved);
                emailRetrieved = dataSnapshot.child(uid).child("email").getValue(String.class);
                email.setText(emailRetrieved);
                phoneNumberRetrieved = dataSnapshot.child(uid).child("phoneNumber").getValue(String.class);
                phoneNumber.setText(phoneNumberRetrieved);
                birthdateRetrieved = dataSnapshot.child(uid).child("birthDate").getValue(String.class);
                birthDate.setText(birthdateRetrieved);
                maritalStatusRetrieved = dataSnapshot.child(uid).child("maritalStatus").getValue(String.class);
                maritalStatus.setText(maritalStatusRetrieved);

                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference profileRef = storageReference.child("Profile pictures").child(emailRetrieved + ".jpg");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        } );
    }

    public void editProfile(View view) {
    }
}
