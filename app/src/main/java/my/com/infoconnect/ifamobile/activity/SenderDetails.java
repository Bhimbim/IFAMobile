// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.FormModifier;
import id.co.jne.jnemobile.courier.variable.object.Sender;


// CLASS

public class SenderDetails extends android.support.v4.app.Fragment
{
    // INIITLIAZATION

        // LAYOUT

        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

        // OBJECT

        private FormModifier objectFormModifier;
        private id.co.jne.jnemobile.courier.variable.object.Order objectOrder;
        private Sender objectSender;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INIITLIAZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_sender_details, container, false);

        objectFormModifier = new FormModifier(getActivity(), getContext(), viewGroup);
        objectOrder = ((Home)getActivity()).getObjectOrder();
        objectSender = objectOrder.getObjectSender();


        // TYPEFACE

        listTypefaceSecondary.add(R.id.editTextName);
        listTypefaceSecondary.add(R.id.editTextProvince);
        listTypefaceSecondary.add(R.id.editTextCity);
        listTypefaceSecondary.add(R.id.editTextPostalCode);
        listTypefaceSecondary.add(R.id.editTextAddress);
        listTypefaceSecondary.add(R.id.editTextHint);
        listTypefaceSecondary.add(R.id.editTextTelephone);
        listTypefaceSecondary.add(R.id.editTextMobileTelephone);

        listTypefaceSecondary.add(R.id.textViewName);
        listTypefaceSecondary.add(R.id.textViewProvince);
        listTypefaceSecondary.add(R.id.textViewCity);
        listTypefaceSecondary.add(R.id.textViewPostalCode);
        listTypefaceSecondary.add(R.id.textViewAddress);
        listTypefaceSecondary.add(R.id.textViewHint);
        listTypefaceSecondary.add(R.id.textViewTelephone);
        listTypefaceSecondary.add(R.id.textViewMobileTelephone);

        listTypefaceSecondary.add(R.id.textViewSenderPaperTitle);

        listTypefaceSecondary.add(R.id.buttonNext);
        listTypefaceSecondary.add(R.id.buttonDone);
        listTypefaceSecondary.add(R.id.buttonViewLocation);
        listTypefaceSecondary.add(R.id.buttonPickLocation);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);
            LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id
                .includeOnProcessAlertList);

            EditText editTextName = (EditText) viewGroup.findViewById(R.id.editTextName);
            final EditText editTextProvince = (EditText) viewGroup.findViewById(R.id.editTextProvince);
            final EditText editTextCity = (EditText) viewGroup.findViewById(R.id.editTextCity);
            final EditText editTextPostalCode = (EditText) viewGroup.findViewById(R.id
                    .editTextPostalCode);
            final EditText editTextAddress = (EditText) viewGroup.findViewById(R.id.editTextAddress);
            final EditText editTextHint = (EditText) viewGroup.findViewById(R.id.editTextHint);
            final EditText editTextTelephone = (EditText) viewGroup.findViewById(R.id.editTextTelephone);
            final EditText editTextMobileTelephone = (EditText) viewGroup.findViewById(R.id
                    .editTextMobileTelephone);

            Button buttonNext = (Button) viewGroup.findViewById(R.id.buttonNext);
            Button buttonViewLocation = (Button) viewGroup.findViewById(R.id.buttonViewLocation);
            Button buttonPickLocation = (Button) viewGroup.findViewById(R.id.buttonPickLocation);

            objectFormModifier.addListEditText(R.id.editTextProvince);
            objectFormModifier.addListEditText(R.id.editTextCity);
            objectFormModifier.addListEditText(R.id.editTextPostalCode);
            objectFormModifier.addListEditText(R.id.editTextAddress);
            objectFormModifier.addListEditText(R.id.editTextHint);
            objectFormModifier.addListEditText(R.id.editTextTelephone);
            objectFormModifier.addListEditText(R.id.editTextMobileTelephone);

            objectFormModifier.setButtonPickLocation(R.id.buttonPickLocation);
            objectFormModifier.setButtonViewLocation(R.id.buttonViewLocation);

            objectFormModifier.setLinearLayoutMapDefaultControl(R.id.linearLayoutMapDefaultControl);
            objectFormModifier.setLinearLayoutMapModifyControl(R.id.linearLayoutMapModifyControl);

            // LAYOUT SETTING

            frameLayoutGuide.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);

            if (objectOrder != null)
            {
                editTextName.setText(objectSender.getStringName());
                editTextProvince.setText(objectSender.getStringProvince());
                editTextCity.setText(objectSender.getStringCity());
                editTextPostalCode.setText(objectSender.getStringPostalCode());
                editTextAddress.setText(objectSender.getStringAddress());
                editTextHint.setText(objectSender.getStringHint());
                editTextTelephone.setText(objectSender.getStringTelephone());
                editTextMobileTelephone.setText(objectSender.getStringMobileTelephone());
            }
            else
            {

            }

            Fragment fragmentOnProcess = ((Home)getActivity()).pagerAdapter.getItem(1);
            ((OnProcess)fragmentOnProcess).setOnProcessGuide(getActivity().getResources().getString(R.string.guide_sender));


        // EVENT

        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);

        final Bundle bundleSend = new Bundle();
        bundleSend.putString(Transaction.BUNDLE_KEY_FROM, Transaction.BUNDLE_VALUE_SENDERDETAILS);

        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                objectSender.setStringProvince(editTextProvince.getText().toString());
                objectSender.setStringCity(editTextCity.getText().toString());
                objectSender.setStringPostalCode(editTextPostalCode.getText().toString());
                objectSender.setStringAddress(editTextAddress.getText().toString());
                objectSender.setStringHint(editTextHint.getText().toString());
                objectSender.setStringTelephone(editTextTelephone.getText().toString());
                objectSender.setStringMobileTelephone(editTextMobileTelephone.getText().toString());

                objectOrder.setObjectSender(objectSender);
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER , ((Home)getActivity()).functionUserInterface.getBooleanFormModifier());

                Fragment fragmentTarget = new RecipientDetails();
                fragmentTarget.setArguments(bundleSend);
                fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, fragmentTarget).commit();
            }
        });

        buttonViewLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER, ((Home)getActivity())
                        .functionUserInterface.getBooleanFormModifier());

                Fragment fragmentTarget = new Map();
                fragmentTarget.setArguments(bundleSend);
                fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, fragmentTarget).commit();
            }
        });

        buttonPickLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER, ((Home)getActivity())
                        .functionUserInterface.getBooleanFormModifier());

                Fragment fragmentTarget = new Map();
                fragmentTarget.setArguments(bundleSend);
                fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, fragmentTarget).commit();
            }
        });

        ((Home)getActivity()).functionUserInterface.layoutModifyForm(objectFormModifier);

        return viewGroup;
    }
}