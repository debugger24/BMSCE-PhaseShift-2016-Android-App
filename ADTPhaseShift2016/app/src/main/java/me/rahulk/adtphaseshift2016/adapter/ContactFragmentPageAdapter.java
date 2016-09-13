package me.rahulk.adtphaseshift2016.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import me.rahulk.adtphaseshift2016.ContactCore;
import me.rahulk.adtphaseshift2016.ContactEmergency;
import me.rahulk.adtphaseshift2016.EventEvents;
import me.rahulk.adtphaseshift2016.EventWorkshops;

/**
 * Created by rahulcomp24 on 08/09/16.
 */
public class ContactFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Core", "Emergency"};
    private Context context;

    public ContactFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Log.v("Changing Fragment", "Event Fragment");
            return new ContactCore();
        } else {
            Log.v("Changing Fragment", "Workshop Fragment");
            return new ContactEmergency();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
