package my.com.infoconnect.ifamobile.function;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.R;
import my.com.infoconnect.ifamobile.variable.constant.UserInterface;
import my.com.infoconnect.ifamobile.widget.PagerAdapter;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */

public class DecoratorGeneral extends AppCompatActivity
{
    // VARIABLE

    // IMPORT

    public TypefaceGenerator functionTypefaceGenerator;
//    public id.co.jne.jnemobile.courier.function.UserInterface functionUserInterface;
    // protected LinkGenerator functionLinkGenerator;
//    public General functionGeneral;

    // LAYOUT

    protected List<Integer> listTypefacePrimary = new ArrayList<Integer>();
    protected List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
    protected List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

    protected Toolbar toolbar;
    protected TabLayout tabLayout;
    protected TextView textViewToolbarTitle;
    protected ViewPager viewPager;
    public PagerAdapter pagerAdapter;
    protected ViewGroup viewGroupTabLayout;


    // INITIALIZE USER INTERFACE

    protected void initializeUserInterface()
    {
        // GENERAL IMPORT

        functionTypefaceGenerator = new TypefaceGenerator(this, this);

        // TYPEFACE

        // LAYOUT

        // LAYOUT DECLARATION

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewGroupTabLayout = (ViewGroup) tabLayout.getChildAt(0);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        final LinearLayout linearLayoutPageContainer = (LinearLayout) findViewById(R.id.linearLayoutPageContainer);

        // LAYOUT SETTING

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_prospect_search)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_prospect_add)));

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // IMPLEMENTATOR

        functionTypefaceGenerator.typefaceImplementor
                (
                        listTypefacePrimary, functionTypefaceGenerator.typefacePrimary(), UserInterface.FONT_PRIMARY_NAME
                );

        functionTypefaceGenerator.typefaceImplementor
                (
                        listTypefaceSecondary, functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME
                );

        functionTypefaceGenerator.typefaceImplementor
                (
                        listTypefaceTertiary, functionTypefaceGenerator.typefaceTertiary(), UserInterface.FONT_TERTIARY_NAME
                );

        functionTypefaceGenerator.typefaceTabLayout(viewGroupTabLayout,
                functionTypefaceGenerator.typefaceSecondary(), R.color.theme_quinary);


        // EVENT

        // buttonBack.setOnClickListener(functionLinkGenerator.goToBack);
        // buttonLogOut.setOnClickListener(functionLinkGenerator.goToLogin);
    }


    // WIDGET


}
