// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.composer.PickUpDelivery;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.Syntax;


// CLASS

public class PaymentDetails extends android.support.v4.app.Fragment
{
    // INIITLIAZATION

        // LAYOUT

        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_payment_details,
                container, false);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.editTextTotalPackage);
        listTypefaceSecondary.add(R.id.editTextDeliveryCost);
        listTypefaceSecondary.add(R.id.editTextOtherCosts);
        listTypefaceSecondary.add(R.id.editTextInsurance);
        listTypefaceSecondary.add(R.id.editTextInsuranceAdmin);
        listTypefaceSecondary.add(R.id.editTextPickUpCost);
        listTypefaceSecondary.add(R.id.editTextTotalCost);
        listTypefaceSecondary.add(R.id.editTextPickTelephone);

        listTypefaceSecondary.add(R.id.textViewPickTelephone);
        listTypefaceSecondary.add(R.id.textViewTotalPackage);
        listTypefaceSecondary.add(R.id.textViewDeliveryCost);
        listTypefaceSecondary.add(R.id.textViewOtherCosts);
        listTypefaceSecondary.add(R.id.textViewInsurance);
        listTypefaceSecondary.add(R.id.textViewInsuranceAdmin);
        listTypefaceSecondary.add(R.id.textViewPickUpCost);
        listTypefaceSecondary.add(R.id.textViewTotalCost);

        listTypefaceSecondary.add(R.id.textViewPaymentPaperTitle);

        listTypefaceSecondary.add(R.id.buttonBill);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);

            final EditText editTextPickTelephone = (EditText) viewGroup.findViewById(R.id.editTextPickTelephone);
            final EditText editTextPickTotalCost = (EditText) viewGroup.findViewById(R.id.editTextTotalCost);

            Button buttonNext = (Button) viewGroup.findViewById(R.id.buttonBill);

            // LAYOUT SETTING

            frameLayoutGuide.setVisibility(View.VISIBLE);

            String[] arrayDummySender =
            {
                "3", "5000", "0", "0", "0", "2000", "7000"
            };

            for (int i = 0; i < 7; i++)
            {
                EditText editTextForm = (EditText) viewGroup.findViewById(listTypefaceSecondary.get(i));
                editTextForm.setText(arrayDummySender[i]);
            }

            android.support.v4.app.Fragment fragmentOnProcess = ((Home)getActivity()).pagerAdapter.getItem(1);
            ((OnProcess)fragmentOnProcess).setOnProcessGuide(getResources().getString(R.string.guide_payment));


        // EVENT

        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Syntax objectSyntax = new Syntax();
                objectSyntax.setStringTransactionSection(Transaction.TRANSACTION_SECTION_PICKUPDELIERY);
                PickUpDelivery composePickUpDelivery = new PickUpDelivery(getActivity(),
                        getContext(), Transaction.CONNECTION_TYPE_GPRS);
                composePickUpDelivery.setStringTelephone(editTextPickTelephone.getText().toString());
                composePickUpDelivery.setStringTotalCost(editTextPickTotalCost.getText().toString());
                objectSyntax.setStringSyntax(composePickUpDelivery.composePickUpDelivery());
                objectSyntax.setStringConnectionType(Transaction.CONNECTION_TYPE_GPRS);
                ((Home)getActivity()).functionGeneral.sendSyntax(objectSyntax);
            }
        });

        return viewGroup;
    }
}