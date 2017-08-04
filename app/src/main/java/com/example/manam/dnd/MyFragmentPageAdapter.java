package com.example.manam.dnd;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by manam on 5/16/2017.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    // Holds tab titles
    private String tabTitles[] = new String[] { "Stats", "Weapons", "Spells", "Notes" };
    private Context context;



    public MyFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new Stats();
        } else if(position == 1) {
            return new Weapons();
        } else if(position == 2) {
            return new Spells();
        } else if (position ==3) {
            return new Notes();
        }

        return null;
    }
}