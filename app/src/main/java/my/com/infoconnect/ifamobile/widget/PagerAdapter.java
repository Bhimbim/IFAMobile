// PACKAGE

package my.com.infoconnect.ifamobile.widget;


// IMPORT

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import my.com.infoconnect.ifamobile.activity.Prospect;
import my.com.infoconnect.ifamobile.activity.ProspectAdd;
import my.com.infoconnect.ifamobile.activity.ProspectSearch;


// CLASS

public class PagerAdapter extends FragmentStatePagerAdapter
{
    int intPageSize;
    private ProspectSearch fragmentProspectList;
    private ProspectAdd fragmentProspectAdd;
//    private History fragmentHistory;

    public PagerAdapter(FragmentManager fm, int intPageSize)
    {
        super(fm);
        this.intPageSize = intPageSize;

        fragmentProspectList = new ProspectSearch();
        fragmentProspectAdd = new ProspectAdd();
//        fragmentHistory = new History();
    }



    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return fragmentProspectList;
            case 1:
                return fragmentProspectAdd;
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return intPageSize;
    }
}