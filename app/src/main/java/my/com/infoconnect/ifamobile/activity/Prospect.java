package my.com.infoconnect.ifamobile.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.FrameLayout;

import my.com.infoconnect.ifamobile.R;
import my.com.infoconnect.ifamobile.function.DecoratorGeneral;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class Prospect extends DecoratorGeneral
{
    // INITIALIZATION

    private FrameLayout frameLayoutGuide;

    // ONCREATE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // INITIALIZATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_prospect);


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
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.relativeLayoutProspectAddFragmentcontainer, new
                            GeneralInformation());
                    transaction.commit();
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
}
