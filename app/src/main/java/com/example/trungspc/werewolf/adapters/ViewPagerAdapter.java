package com.example.trungspc.werewolf.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.trungspc.werewolf.fragments.AchievementsCompleted;
import com.example.trungspc.werewolf.fragments.AchievementsInProgressFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AchievementsInProgressFragment();
            case 1:
                return new AchievementsCompleted();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
