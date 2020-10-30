package com.example.medupe.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.medupe.R;
import com.example.medupe.ui_main.AcceptedFragment;
import com.example.medupe.ui_main.DeclinedFrament;
import com.example.medupe.ui_main.OnHoldFragment;

public class SectionsPagerAdapterPayments extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[] {R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapterPayments(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 :
                return new OnHoldFragment ();
            case 1 :
                return new AcceptedFragment ();
            case 2 :
                return new DeclinedFrament ();
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) mContext.getResources(TAB_TITLES[position]);
    }


    @Override
    public int getCount(int position) {
        return 3;
    }
}
