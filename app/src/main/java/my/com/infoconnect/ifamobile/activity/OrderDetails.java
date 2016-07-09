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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.FormModifier;
import id.co.jne.jnemobile.courier.variable.object.Order;
import id.co.jne.jnemobile.courier.variable.object.Sender;


// CLASS

public class OrderDetails extends Fragment
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
        private Package objectPackage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INIITLIAZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_order_details,
                container, false);
        objectFormModifier = new FormModifier(getActivity(), getContext(), viewGroup);

        Bundle bundleReceive = getArguments();
        objectOrder = (Order) bundleReceive.getSerializable(Transaction.BUNDLE_KEY_ORDER);
        objectSender = objectOrder.getObjectSender();
        objectPackage = objectOrder.getObjectPackage();


        // TYPEFACE

        listTypefaceSecondary.add(R.id.editTextName);
        listTypefaceSecondary.add(R.id.editTextProvince);
        listTypefaceSecondary.add(R.id.editTextCity);
        listTypefaceSecondary.add(R.id.editTextAddress);
        listTypefaceSecondary.add(R.id.editTextDescription);

        listTypefaceSecondary.add(R.id.textViewName);
        listTypefaceSecondary.add(R.id.textViewProvince);
        listTypefaceSecondary.add(R.id.textViewCity);
        listTypefaceSecondary.add(R.id.textViewAddress);
        listTypefaceSecondary.add(R.id.textViewDescription);
        listTypefaceSecondary.add(R.id.textViewLong);
        listTypefaceSecondary.add(R.id.textViewWidth);
        listTypefaceSecondary.add(R.id.textViewTall);
        listTypefaceSecondary.add(R.id.textViewWeight);

        listTypefaceSecondary.add(R.id.textViewSenderPaperTitle);
        listTypefaceSecondary.add(R.id.textViewPackagePaperTitle);

        listTypefaceSecondary.add(R.id.buttonTakeOrder);
        listTypefaceSecondary.add(R.id.buttonViewLocation);
        listTypefaceSecondary.add(R.id.buttonPickLocation);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            EditText editTextName = (EditText) viewGroup.findViewById(R.id.editTextName);
            EditText editTextProvince = (EditText) viewGroup.findViewById(R.id.editTextProvince);
            EditText editTextCity = (EditText) viewGroup.findViewById(R.id.editTextCity);
            EditText editTextAddress = (EditText) viewGroup.findViewById(R.id.editTextAddress);
            EditText editTextDescription = (EditText) viewGroup.findViewById(R.id.editTextDescription);

            TextView textViewLong = (TextView) viewGroup.findViewById(R.id.textViewLong);
            TextView textViewWidth = (TextView) viewGroup.findViewById(R.id.textViewWidth);
            TextView textViewTall = (TextView) viewGroup.findViewById(R.id.textViewTall);
            TextView textViewWeight = (TextView) viewGroup.findViewById(R.id.textViewWeight);

            ImageView imageViewPackageType = (ImageView) viewGroup.findViewById(R.id.imageViewPackageType);

            Button buttonTakeOrder = (Button) viewGroup.findViewById(R.id.buttonTakeOrder);
            Button buttonViewLocation = (Button) viewGroup.findViewById(R.id.buttonViewLocation);
            Button buttonPickLocation = (Button) viewGroup.findViewById(R.id.buttonPickLocation);

            // LAYOUT SETTING

            if (objectOrder != null)
            {
                editTextName.setText(objectSender.getStringName());
                editTextProvince.setText(objectSender.getStringProvince());
                editTextCity.setText(objectSender.getStringCity());
                editTextAddress.setText(objectSender.getStringAddress());
                editTextDescription.setText(objectPackage.getStringDescription());

                textViewLong.setText(objectPackage.getStringLong());
                textViewWidth.setText(objectPackage.getStringWidth());
                textViewTall.setText(objectPackage.getStringTall());
                textViewWeight.setText(objectPackage.getStringWeight());

                imageViewPackageType.setImageResource(objectPackage.getIntPackageType(UserInterface
                        .IMAGE_RESOURCE_LARGE));
            }
            else
            {

            }


        // EVENT

        final Fragment fragmentTarget = new Map();

        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);

        final Bundle bundleSend = new Bundle();
        bundleSend.putString(Transaction.BUNDLE_KEY_FROM, Transaction.BUNDLE_VALUE_ORDERDETAILS);

        buttonTakeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((Home)getActivity()).setObjectOrder(objectOrder);
                ((Home)getActivity()).switchTab(1);
                getFragmentManager().popBackStack();
            }
        });

        buttonViewLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER, false);

                fragmentTarget.setArguments(bundleSend);
                fragmentTransaction.replace(R.id.relativeLayoutOrderFragmentcontainer,
                        fragmentTarget)
                        .commit();
            }
        });

        buttonPickLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);
                bundleSend.putBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER, false);

                fragmentTarget.setArguments(bundleSend);
                fragmentTransaction.replace(R.id.relativeLayoutOrderFragmentcontainer,
                        fragmentTarget)
                        .commit();
            }
        });

        return viewGroup;
    }
}