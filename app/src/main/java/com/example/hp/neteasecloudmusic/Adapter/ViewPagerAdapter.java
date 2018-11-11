package com.example.hp.neteasecloudmusic.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private Fragment currentFragment;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> list ) {
        super(fm);
        fragmentList = list;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        currentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList != null? fragmentList.get(i):null;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    public List<Fragment> getFragmentList() {
        return fragmentList;
    }
}
