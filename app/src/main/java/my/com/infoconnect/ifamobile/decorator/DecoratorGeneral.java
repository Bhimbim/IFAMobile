// PACKAGE

package my.com.infoconnect.ifamobile.decorator;


// IMPORT

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

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.General;
import id.co.jne.jnemobile.courier.function.TypefaceGenerator;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.widget.PagerAdapter;

/**
 * Created by ibrahimaziztejokusumo on 3/2/16.
 */


// CLASS

public class DecoratorGeneral extends AppCompatActivity
{
    // VARIABLE

        // IMPORT

        public TypefaceGenerator functionTypefaceGenerator;
        public id.co.jne.jnemobile.courier.function.UserInterface functionUserInterface;
        // protected LinkGenerator functionLinkGenerator;
        public General functionGeneral;

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
        functionUserInterface = new id.co.jne.jnemobile.courier.function.UserInterface(this, this);
        // functionLinkGenerator = new LinkGenerator(this, this);
        functionGeneral = new General(this, this, functionTypefaceGenerator);


        // TYPEFACE

        listTypefacePrimary.add(R.id.textViewName);

        listTypefaceSecondary.add(R.id.textViewPosition);
        listTypefaceSecondary.add(R.id.textViewProfile);
        listTypefaceSecondary.add(R.id.textViewMessages);
        listTypefaceSecondary.add(R.id.textViewChangePassword);
        listTypefaceSecondary.add(R.id.textViewOptions);
        listTypefaceSecondary.add(R.id.textViewLogout);


        // LAYOUT

            // LAYOUT DECLARATION

            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            viewGroupTabLayout = (ViewGroup) tabLayout.getChildAt(0);
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            final ImageButton imageButtonNavigation = (ImageButton) findViewById(R.id.imageButtonNavigation);
            final LinearLayout linearLayoutPageContainer = (LinearLayout) findViewById(R.id.linearLayoutPageContainer);

            // LAYOUT SETTING

            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_order)));
            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_onProcess)));
            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_history)));

            pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(pagerAdapter);
            viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        // TYPEFACE

            // TITLE / TAB

            listTypefaceSecondary.add(R.id.textViewToolbarTitle);

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

        imageButtonNavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                functionUserInterface.buttonNavigation(linearLayoutPageContainer);
            }
        });

        // buttonBack.setOnClickListener(functionLinkGenerator.goToBack);
        // buttonLogOut.setOnClickListener(functionLinkGenerator.goToLogin);
    }


    // WIDGET


}