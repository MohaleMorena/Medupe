package com.example.medupe.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
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

import com.example.medupe.Appointment;
import com.example.medupe.Doctor;
import com.example.medupe.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppointmentAdapter extends BaseAdapter {

    private final Context context;
    int i = 0;
    Context mContext;
    LayoutInflater inflater;
    List<Appointment> appointmentList;
    ArrayList <Appointment> arrayList;
    String emailDoctor, emailPatient;


    public AppointmentAdapter(FragmentActivity activity , List < Appointment > myAppointments , Context context) {
        this.context = context;
        mContext = this.context;
        this.appointmentList = appointmentList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Appointment>();
        this.arrayList.addAll(appointmentList);

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {

        return appointmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return appointmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    public View getView(int position , View convertView , ViewGroup parent) {
        convertView = inflater.inflate( R.layout.appointment_row, null);

        final CircleImageView doctorPicture = convertView.findViewById(R.id.profile_image);


        final TextView doctorFullName = convertView.findViewById(R.id.fullName);
        final TextView day = convertView.findViewById(R.id.day);
        final TextView time = convertView.findViewById(R.id.time);


        final Appointment appointment = appointmentList.get(position);
        emailDoctor = appointment.getEmailDoctor();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Doctors");
        reference.addValueEventListener(new ValueEventListener (){

            private com.example.medupe.models.Doctor databaseError;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                {
                    PolicyNode dataSnapshot = null;
                    for (Iterator < ? extends PolicyNode > it = dataSnapshot.getChildren (); it.hasNext (); ) {
                        DataSnapshot data = (DataSnapshot) it.next ();
                        Doctor doctor = data.getValue( Doctor.class);
                        if (Objects.equals ( doctor.getEmail () , appointment.getEmailDoctor () )) {
                            doctorFullName.setText("Dr. "+doctor.getFullName());
                            day.setText( (Integer) appointment.getDate() );
                            time.setText(appointment.getTime());
                        }
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
