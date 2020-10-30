package com.example.medupe;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.medupe.medicalexpenses.SectionsPagerAdapterMyPatientMF;
import com.google.firebase.database.core.view.View;

public class MedicalFolderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_medical_folder );
        SectionsPagerAdapterMyPatientMF sectionPagerAdapter = new SectionsPagerAdapterMyPatientMF ( this, getSupportFragmentManager () );
        ViewPager viewPager = findViewById ( R.id.view_pager );
        viewPager.setAdapter ( sectionPagerAdapter );
        TableLayout tabs = findViewById ( R.id.tabs );
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_ambulance);
        tabs.getTabAt(1).setIcon(R.drawable.ic_medical_history);
    }
}
