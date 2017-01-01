package me.rahulk.adtphaseshift2016.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import me.rahulk.adtphaseshift2016.EventEvents;
import me.rahulk.adtphaseshift2016.EventWorkshops;

/**
 * Created by rahulcomp24 on 08/09/16.
 */
public class EventFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Events", "Workshops"};
    private Context context;

    public EventFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Log.v("Changing Fragment", "Event Fragment");
            return new EventEvents();
        } else {
            Log.v("Changing Fragment", "Workshop Fragment");
            return new EventWorkshops();
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
