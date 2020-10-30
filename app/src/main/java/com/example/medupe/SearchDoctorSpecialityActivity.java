package com.example.medupe;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.medupe.ui_main.FragmentOne;
import com.google.android.material.tabs.TabLayout;

public class SearchDoctorSpecialityActivity extends AppCompatActivity {
    int position;
    SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_search_doctor_speciality);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        searchView = findViewById(R.id.mySearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (position==1)
                {
                    if (TextUtils.isEmpty ( s )){
                        FragmentOne.getAdapter().filter("");
                        FragmentOne.getListView().clearTextFilter();
                    }else {
                        FragmentOne.getAdapter().filter(s);
                    }

                }
                return false;
            }
        });
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition ();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
