// PACKAGE

package my.com.infoconnect.ifamobile.decorator;


// IMPORT

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.TypefaceGenerator;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;

/**
 * Created by ibrahimaziztejokusumo on 3/2/16.
 */


// CLASS

public class DecoratorForm extends AppCompatActivity
{
    // VARIABLE

        // IMPORT

        protected TypefaceGenerator functionTypefaceGenerator;
        protected id.co.jne.jnemobile.courier.function.UserInterface functionUserInterface;
        // protected LinkGenerator functionLinkGenerator;

        // LAYOUT

        protected List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        protected List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        protected List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

        protected List<Integer> listEditText = new ArrayList<Integer>();
        protected List<Integer> listSpinner = new ArrayList<Integer>();
        protected List<Integer> listRadioButton = new ArrayList<Integer>();
        protected List<Integer> listCheckBox = new ArrayList<Integer>();



    // INITIALIZE USER INTERFACE

    protected void initializeUserInterface()
    {
        // GENERAL IMPORT

        functionTypefaceGenerator = new TypefaceGenerator(this, this);
        functionUserInterface = new id.co.jne.jnemobile.courier.function.UserInterface(this, this);
        // functionLinkGenerator = new LinkGenerator(this, this);


        // LAYOUT DECLARATION



        // LAYOUT SETTING




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



        // EVENT

        // buttonBack.setOnClickListener(functionLinkGenerator.goToBack);
        // buttonLogOut.setOnClickListener(functionLinkGenerator.goToLogin);
    }


    // WIDGET

    public void initializeWidgetButtonReset()
    {
//        Button buttonReset = (Button) findViewById(R.id.buttonReset);
//
//        buttonReset.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                functionUserInterface.formReset(listEditText, listSpinner, listRadioButton, listCheckBox);
//            }
//        });
    }
}