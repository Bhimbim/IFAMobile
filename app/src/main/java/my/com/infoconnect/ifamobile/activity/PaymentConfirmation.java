// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.TypefaceGenerator;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;


// CLASS

public class PaymentConfirmation extends android.support.v4.app.Fragment
{
    // INIITLIAZATION

        // IMPORT

        private TypefaceGenerator typefaceGenerator;

        // LAYOUT

        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_package_details, container, false);

        typefaceGenerator = ((Home)getActivity()).functionTypefaceGenerator;


        // TYPEFACE

        listTypefaceSecondary.add(R.id.editTextDescription);
        listTypefaceSecondary.add(R.id.editTextServiceType);
        listTypefaceSecondary.add(R.id.editTextPackageType);
        listTypefaceSecondary.add(R.id.editTextWeight);
        listTypefaceSecondary.add(R.id.editTextLong);
        listTypefaceSecondary.add(R.id.editTextWidth);
        listTypefaceSecondary.add(R.id.editTextTall);
        listTypefaceSecondary.add(R.id.editTextSpecificInstruction);
        listTypefaceSecondary.add(R.id.editTextNote);
        listTypefaceSecondary.add(R.id.editTextPackageValue);

        listTypefaceSecondary.add(R.id.textViewDescription);
        listTypefaceSecondary.add(R.id.textViewServiceType);
        listTypefaceSecondary.add(R.id.textViewPackageType);
        listTypefaceSecondary.add(R.id.textViewWeight);
        listTypefaceSecondary.add(R.id.textViewLong);
        listTypefaceSecondary.add(R.id.textViewWidth);
        listTypefaceSecondary.add(R.id.textViewTall);
        listTypefaceSecondary.add(R.id.textViewSpecificInstruction);
        listTypefaceSecondary.add(R.id.textViewNote);
        listTypefaceSecondary.add(R.id.textViewPackageValue);

        listTypefaceSecondary.add(R.id.textViewPackagePaperTitle);

        listTypefaceSecondary.add(R.id.buttonNext);

        typefaceGenerator.typefaceFragment
        (listTypefaceSecondary, typefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);

        // LAYOUT

            // LAYOUT DECLARATION

            Button buttonNext = (Button) viewGroup.findViewById(R.id.buttonNext);

            // LAYOUT SETTING

            String[] arrayDummySender =
            {
                "Alexander Hariyanto", "DKI Jakarta", "Jakarta Pusat",
                "10410", "Ruko Atrium Complex block A number 8 135th Senen Raya St.", "Between " +
                "Lumire Hotel and Oasis Amir Hotel, behind Cowell Tower", "021 1234567",
                "1234567890"
            };

            for (int i = 0; i < 7; i++)
            {
                EditText editTextForm = (EditText) viewGroup.findViewById(listTypefaceSecondary.get(i));
                editTextForm.setText(arrayDummySender[i]);
            }

            android.support.v4.app.Fragment fragmentOnProcess = ((Home)getActivity()).pagerAdapter.getItem(1);
            ((OnProcess)fragmentOnProcess).setOnProcessGuide(getResources().getString(R.string
                .guide_done));


        // EVENT

        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, new RecipientDetails()).commit();
            }
        });

        return viewGroup;
    }
}