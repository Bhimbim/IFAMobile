// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.FrameLayout;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.decorator.DecoratorGeneral;
import id.co.jne.jnemobile.courier.variable.object.Order;


// CLASS

public class Home extends DecoratorGeneral
{
    // INITIALIZATION

    private FrameLayout frameLayoutGuide;
    private id.co.jne.jnemobile.courier.variable.object.Order objectOrder = null;


    // ONCREATE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // INITIALIZATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_home);


        // TYPEFACE

        //listTypefaceSecondary.add(R.id.editTextSearch);

        initializeUserInterface();

        //frameLayoutGuide = (FrameLayout) findViewById(R.id.includeGuide);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        // LAYOUT SETTING

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 1)
                {
                    if(getObjectOrder() == null)
                    {
                        //frameLayoutGuide.setVisibility(View.GONE);
                    }
                    else
                    {
                        //frameLayoutGuide.setVisibility(View.VISIBLE);

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, new SenderDetails());
                        transaction.commit();
                    }
                }
                else
                {

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    public void switchTab(int intTabPosition)
    {
        viewPager.setCurrentItem(intTabPosition);
    }

    public Order getObjectOrder()
    {
        return objectOrder;
    }

    public void setObjectOrder(Order objectOrder)
    {
        this.objectOrder = objectOrder;
    }
}