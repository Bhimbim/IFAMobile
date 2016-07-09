// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.FormModifier;
import id.co.jne.jnemobile.courier.variable.object.Recipient;


// CLASS

public class RecipientDetails extends android.support.v4.app.Fragment
{
    // INIITLIAZATION

        // LAYOUT

        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

        // OBJECT

        private FormModifier objectFormModifier;
        private id.co.jne.jnemobile.courier.variable.object.Order objectOrder;
        private Recipient objectRecipient;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_recipient_details, container, false);

        Bundle bundleReceive = getArguments();
        objectFormModifier = new FormModifier(getActivity(), getContext(), viewGroup);
        objectOrder = (id.co.jne.jnemobile.courier.variable.object.Order) bundleReceive.getSerializable(Transaction.BUNDLE_KEY_ORDER);
        objectRecipient = objectOrder.getObjectRecipient();

        Log.i("test", objectFormModifier.getImageButtonEdit().toString());


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

        listTypefaceSecondary.add(R.id.textViewRecipientPaperTitle);

        listTypefaceSecondary.add(R.id.buttonNext);
        listTypefaceSecondary.add(R.id.buttonDone);
        listTypefaceSecondary.add(R.id.buttonViewLocation);
        listTypefaceSecondary.add(R.id.buttonPickLocation);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);

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

            if (objectOrder != null)
            {
                editTextName.setText(objectRecipient.getStringName());
                editTextProvince.setText(objectRecipient.getStringProvince());
                editTextCity.setText(objectRecipient.getStringCity());
                editTextPostalCode.setText(objectRecipient.getStringPostalCode());
                editTextAddress.setText(objectRecipient.getStringAddress());
                editTextHint.setText(objectRecipient.getStringHint());
                editTextTelephone.setText(objectRecipient.getStringTelephone());
                editTextMobileTelephone.setText(objectRecipient.getStringMobileTelephone());
            }
            else
            {

            }

            android.support.v4.app.Fragment fragmentOnProcess = ((Home)getActivity()).pagerAdapter.getItem(1);
            ((OnProcess)fragmentOnProcess).setOnProcessGuide(getResources().getString(R.string
                    .guide_recipient));


        // EVENT

        final android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);

        final Bundle bundleSend = new Bundle();
        bundleSend.putString(Transaction.BUNDLE_KEY_FROM, Transaction.BUNDLE_VALUE_RECIPIENTDETAILS);

        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                objectRecipient.setStringProvince(editTextProvince.getText().toString());
                objectRecipient.setStringCity(editTextCity.getText().toString());
                objectRecipient.setStringPostalCode(editTextPostalCode.getText().toString());
                objectRecipient.setStringAddress(editTextAddress.getText().toString());
                objectRecipient.setStringHint(editTextHint.getText().toString());
                objectRecipient.setStringTelephone(editTextTelephone.getText().toString());
                objectRecipient.setStringMobileTelephone(editTextMobileTelephone.getText().toString());

                objectOrder.setObjectRecipient(objectRecipient);
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER , ((Home)getActivity()).functionUserInterface.getBooleanFormModifier());

                Fragment fragmentTarget = new PackageDetails();
                fragmentTarget.setArguments(bundleSend);

                fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer,
                        fragmentTarget).commit();
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

    public static class PackageDetails extends Fragment
    {
        // INIITLIAZATION

            // LAYOUT

            private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
            private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
            private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

        // OBJECT

        private FormModifier objectFormModifier;
        private id.co.jne.jnemobile.courier.variable.object.Order objectOrder;
        private Package objectPackage;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // INITIALIZATION

            ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_package_details, container, false);

            Bundle bundleReceive = getArguments();
            objectFormModifier = new FormModifier(getActivity(), getContext(), viewGroup);
            objectOrder = (id.co.jne.jnemobile.courier.variable.object.Order) bundleReceive.getSerializable(Transaction.BUNDLE_KEY_ORDER);
            objectPackage = objectOrder.getObjectPackage();


            // TYPEFACE

            listTypefaceSecondary.add(R.id.editTextDescription);
            listTypefaceSecondary.add(R.id.editTextServiceType);
            listTypefaceSecondary.add(R.id.editTextPackageType);
            listTypefaceSecondary.add(R.id.editTextSpecificInstruction);
            listTypefaceSecondary.add(R.id.editTextNote);
            listTypefaceSecondary.add(R.id.editTextPackageValue);
            listTypefaceSecondary.add(R.id.editTextWeight);
            listTypefaceSecondary.add(R.id.editTextLong);
            listTypefaceSecondary.add(R.id.editTextWidth);
            listTypefaceSecondary.add(R.id.editTextTall);

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
            listTypefaceSecondary.add(R.id.buttonDone);

            ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
            (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);

            // LAYOUT

                // LAYOUT DECLARATION

                FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);

                final EditText editTextDescription = (EditText) viewGroup.findViewById(R.id
                        .editTextDescription);
                final EditText editTextServiceType = (EditText) viewGroup.findViewById(R.id
                        .editTextServiceType);
                final EditText editTextPackageType = (EditText) viewGroup.findViewById(R.id
                        .editTextPackageType);
                final EditText editTextWeight = (EditText) viewGroup.findViewById(R.id
                        .editTextWeight);
                final EditText editTextLong = (EditText) viewGroup.findViewById(R.id.editTextLong);
                final EditText editTextWidth = (EditText) viewGroup.findViewById(R.id.editTextWidth);
                final EditText editTextTall = (EditText) viewGroup.findViewById(R.id.editTextTall);
                final EditText editTextSpecificInstruction = (EditText) viewGroup.findViewById(R.id
                        .editTextSpecificInstruction);
                final EditText editTextNote = (EditText) viewGroup.findViewById(R.id
                        .editTextNote);
                final EditText editTextPackageValue = (EditText) viewGroup.findViewById(R.id
                        .editTextPackageValue);

                Button buttonNext = (Button) viewGroup.findViewById(R.id.buttonNext);

                objectFormModifier.addListEditText(R.id.editTextDescription);
                objectFormModifier.addListEditText(R.id.editTextServiceType);
                objectFormModifier.addListEditText(R.id.editTextPackageType);
                objectFormModifier.addListEditText(R.id.editTextWeight);
                objectFormModifier.addListEditText(R.id.editTextLong);
                objectFormModifier.addListEditText(R.id.editTextWidth);
                objectFormModifier.addListEditText(R.id.editTextTall);
                objectFormModifier.addListEditText(R.id.editTextSpecificInstruction);
                objectFormModifier.addListEditText(R.id.editTextNote);
                objectFormModifier.addListEditText(R.id.editTextPackageValue);

                // LAYOUT SETTING

                frameLayoutGuide.setVisibility(View.VISIBLE);

                if (objectOrder != null)
                {
                    editTextDescription.setText(objectPackage.getStringDescription());
                    editTextServiceType.setText(objectPackage.getStringServiceType());
                    editTextPackageType.setText(objectPackage.getStringPackageType());
                    editTextWeight.setText(objectPackage.getStringWeight());
                    editTextLong.setText(objectPackage.getStringLong());
                    editTextWidth.setText(objectPackage.getStringWidth());
                    editTextTall.setText(objectPackage.getStringTall());
                    editTextSpecificInstruction.setText(objectPackage.getStringSpecificInstruction());
                    editTextNote.setText(objectPackage.getStringNote());
                    editTextPackageValue.setText(objectPackage.getStringPackageValue());
                }
                else
                {

                }

                Fragment fragmentOnProcess = ((Home)getActivity()).pagerAdapter.getItem(1);
                ((OnProcess)fragmentOnProcess).setOnProcessGuide(getResources().getString(R.string.guide_package));


            // EVENT

            buttonNext.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Fragment fragmentTarget = new PaymentDetails();
                    Bundle bundleSend = new Bundle();

                    objectPackage.setStringDescription(editTextDescription.getText().toString());
                    objectPackage.setStringServiceType(editTextServiceType.getText().toString());
                    objectPackage.setStringPackageType(editTextPackageType.getText().toString());
                    objectPackage.setStringWeight(editTextWeight.getText().toString());
                    objectPackage.setStringLong(editTextLong.getText().toString());
                    objectPackage.setStringWidth(editTextWidth.getText().toString());
                    objectPackage.setStringTall(editTextTall.getText().toString());
                    objectPackage.setStringSpecificInstruction(editTextSpecificInstruction.getText().toString());
                    objectPackage.setStringNote(editTextNote.getText().toString());
                    objectPackage.setStringPackageValue(editTextPackageValue.getText().toString());

                    objectOrder.setObjectPackage(objectPackage);

                    bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                    fragmentTarget.setArguments(bundleSend);

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim
                            .transition_fly_out);
                    fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer,
                            fragmentTarget).commit();
                }
            });

            ((Home)getActivity()).functionUserInterface.layoutModifyForm(objectFormModifier);

            return viewGroup;
        }
    }
}