// PACKAGE

package my.com.infoconnect.ifamobile.widget;


// IMPORT

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.co.jne.jnemobile.courier.activity.History;
import id.co.jne.jnemobile.courier.activity.OnProcess;
import id.co.jne.jnemobile.courier.activity.Order;


// CLASS

public class PagerAdapter extends FragmentStatePagerAdapter
{
    int intPageSize;
    private Order fragmentOrderList;
    private OnProcess fragmentOnProcess;
    private History fragmentHistory;

    public PagerAdapter(FragmentManager fm, int intPageSize)
    {
        super(fm);
        this.intPageSize = intPageSize;

        fragmentOrderList = new Order();
        fragmentOnProcess = new OnProcess();
        fragmentHistory = new History();
    }



    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return fragmentOrderList;
            case 1:
                return fragmentOnProcess;
            case 2:
                return fragmentHistory;
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