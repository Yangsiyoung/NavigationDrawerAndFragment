package android.dolbom.ark.mynavigationandfragment.adapter;

import android.dolbom.ark.mynavigationandfragment.fragments.FirstFragment;
import android.dolbom.ark.mynavigationandfragment.fragments.FourthFragment;
import android.dolbom.ark.mynavigationandfragment.fragments.SecondFragment;
import android.dolbom.ark.mynavigationandfragment.fragments.ThirdFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.Loader;

/**
 * Created by samsung on 2017-06-06.
 */

public class ToolBarTabPagerAdapter extends FragmentStatePagerAdapter{

    private int tabCount;

    public ToolBarTabPagerAdapter(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                FirstFragment firstFragment = new FirstFragment();
                return firstFragment;

            case 1:
                SecondFragment secondFragment = new SecondFragment();
                return secondFragment;

            case 2:
                ThirdFragment thirdFragment = new ThirdFragment();
                return thirdFragment;

            case 3:
                FourthFragment fourthFragment = new FourthFragment();
                return fourthFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
