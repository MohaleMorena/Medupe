package com.example.medupe;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SectionsPagerAdapter extends PagerAdapter {
    public SectionsPagerAdapter(DoctorAppointments searchDoctorSpecialityActivity , Object supportFragmentManager) {

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
