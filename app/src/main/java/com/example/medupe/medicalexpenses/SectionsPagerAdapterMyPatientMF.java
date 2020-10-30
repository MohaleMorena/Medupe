package com.example.medupe.medicalexpenses;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

public class SectionsPagerAdapterMyPatientMF extends PagerAdapter {
    public SectionsPagerAdapterMyPatientMF(MedicalFolderActivity medicalFolderActivity , FragmentManager supportFragmentManager) {

    }

    public SectionsPagerAdapterMyPatientMF(com.example.medupe.MedicalFolderActivity medicalFolderActivity , FragmentManager supportFragmentManager) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view , @NonNull Object object) {
        return false;
    }
}
