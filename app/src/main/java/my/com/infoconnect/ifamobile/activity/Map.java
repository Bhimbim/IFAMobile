// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.Recipient;
import id.co.jne.jnemobile.courier.variable.object.Sender;


// CLASS

public class Map extends Fragment
{
    // INIITLIAZATION

        // LAYOUT

        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

        protected List<Integer> listEditText = new ArrayList<Integer>();
        protected List<Integer> listSpinner = new ArrayList<Integer>();
        protected List<Integer> listRadioButton = new ArrayList<Integer>();
        protected List<Integer> listCheckBox = new ArrayList<Integer>();

        // OBJECT

        private id.co.jne.jnemobile.courier.variable.object.Order objectOrder;
        private Sender objectSender;
        private Recipient objectRecipient;
        private Package objectPackage;
        private SupportMapFragment supportMapFragment;
        private Boolean booleanFormModifier;

        // MAP

        private LatLng latLongDefault;
        private LatLng latLongCurrent;
        private GoogleMap map;
        private String stringMapTitle;
        private String stringMapSnippet;
        private Location locationCurrent = null;
        private id.co.jne.jnemobile.courier.function.Map functionMap;
        private Marker marker;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INIITLIAZATION

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_map, container, false);

        final Bundle bundleReceive = getArguments();
        objectOrder = (id.co.jne.jnemobile.courier.variable.object.Order) bundleReceive.getSerializable(Transaction.BUNDLE_KEY_ORDER);
        objectSender = objectOrder.getObjectSender();
        objectRecipient = objectOrder.getObjectRecipient();
        objectPackage = objectOrder.getObjectPackage();
        booleanFormModifier = bundleReceive.getBoolean(Transaction.BUNDLE_KEY_FORMMODIFIER);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.buttonDone);

        ((Home) getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home) getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);
            LinearLayout linearLayoutLocationModifyControl = (LinearLayout) viewGroup.findViewById(R.id.linearLayoutLocationModifyControl);

            Button buttonDone = (Button) viewGroup.findViewById(R.id.buttonDone);
            ImageButton imageButtonGetCurrentLocation = (ImageButton) viewGroup.findViewById(R.id
                    .imageButtonGetCurrentLocation);
            ImageButton imageButtonPickLocation = (ImageButton) viewGroup.findViewById(R.id
                    .imageButtonPickLocation);

            // LAYOUT SETTING

            frameLayoutGuide.setVisibility(View.GONE);

            if (objectOrder != null)
            {
                stringMapSnippet = objectSender.getStringAddress();
                stringMapTitle = objectSender.getStringName();

                latLongDefault = new LatLng
                (
                    Double.valueOf(objectSender.getStringLatitude()),
                    Double.valueOf(objectSender.getStringLongitude())
                );
            }
            else
            {

            }

            if (booleanFormModifier == false)
            {
                linearLayoutLocationModifyControl.setVisibility(View.GONE);
            }
            else
            {
                linearLayoutLocationModifyControl.setVisibility(View.VISIBLE);
            }


        // EVENT

        buttonDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);

                Fragment fragmentTarget;
                Bundle bundleSend = new Bundle();
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, objectOrder);

                if (bundleReceive.getString(Transaction.BUNDLE_KEY_FROM).equals(Transaction
                        .BUNDLE_VALUE_SENDERDETAILS))
                {
                    objectSender.getStringLatitude();
                    objectSender.getStringLongitude();
                    fragmentTarget = new SenderDetails();
                    fragmentTarget.setArguments(bundleSend);
                    fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, fragmentTarget).commit();
                }
                else if (bundleReceive.getString(Transaction.BUNDLE_KEY_FROM).equals(Transaction
                        .BUNDLE_VALUE_RECIPIENTDETAILS))
                {
                    fragmentTarget = new RecipientDetails();
                    fragmentTarget.setArguments(bundleSend);
                    fragmentTransaction.replace(R.id.relativeLayoutOnProcessFragmentcontainer, fragmentTarget).commit();
                }
                else
                {
                    fragmentTarget = new OrderDetails();
                    fragmentTarget.setArguments(bundleSend);
                    fragmentTransaction.replace(R.id.relativeLayoutOrderFragmentcontainer, fragmentTarget).commit();
                }
            }
        });

        imageButtonGetCurrentLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                locationCurrent = functionMap.getLastKnownLocation();
                latLongCurrent = new LatLng
                (
                    Double.valueOf(locationCurrent.getLatitude()),
                    Double.valueOf(locationCurrent.getLongitude())
                );

                Log.i
                (
                    "Location", "current location, " +
                    "lat = " + locationCurrent.getLatitude() +
                    "longitude = " + locationCurrent.getLongitude()
                );

                if (marker != null && locationCurrent != null)
                {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());

                    ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R
                            .layout.alert_map, null);

                    TextView textViewPaperTitle = (TextView) viewGroup.findViewById(R.id.textViewPaperTitle);
                    textViewPaperTitle.setTypeface(((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary());
                    TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
                    textViewTitle.setTypeface(((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary());
                    TextView textViewContent = (TextView) viewGroup.findViewById(R.id.textViewContent);
                    textViewContent.setTypeface(((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary());
                    Button buttonPickLocation = (Button) viewGroup.findViewById(R.id.buttonPickLocation);
                    buttonPickLocation.setTypeface(((Home)getActivity()).functionTypefaceGenerator
                            .typefaceSecondary());
                    ImageButton buttonCancel = (ImageButton) viewGroup.findViewById(R.id.buttonClose);

                    try
                    {
                        Geocoder geo = new Geocoder(getContext(), Locale.getDefault());
                        List<Address> addresses = geo.getFromLocation(latLongCurrent.latitude, latLongCurrent.longitude, 1);

                        if (addresses.isEmpty())
                        {
                            textViewTitle.setText("Get Current Location");
                            textViewContent.setText("Please wait while we fetching your address.");
                        }
                        else
                        {
                            if (addresses.size() > 0)
                            {
                                textViewTitle.setText(addresses.get(0).getFeatureName());
                                textViewContent.setText
                                (
                                    addresses.get(0).getLocality() +", " +
                                    addresses.get(0).getAdminArea() + ", " +
                                    addresses.get(0).getCountryName()
                                );
                            }
                            else
                            {

                            }
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace(); // getFromLocation() may sometimes fail
                    }

                    textViewPaperTitle.setText(getActivity().getResources().getString(R.string.alert_map_getLocation));

                    dialogBuilder.setView(viewGroup);
                    final AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    buttonPickLocation.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            marker.remove();
                            marker = functionMap.mapMarker(map, latLongCurrent, stringMapTitle,
                                stringMapSnippet, objectPackage.getIntPackageType(UserInterface.IMAGE_RESOURCE_SMALL));
                            alertDialog.cancel();
                        }
                    });

                    buttonCancel.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            alertDialog.cancel();
                        }
                    });

                    alertDialog.show();
                }
                else
                {

                }
            }
        });

        imageButtonPickLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        return viewGroup;
    }


    // MAP SETUP

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FragmentManager fragmentManager = getChildFragmentManager();
        supportMapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.frameLayoutMap);
        supportMapFragment = SupportMapFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.frameLayoutMap, supportMapFragment).commit();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (map == null)
        {
            map = supportMapFragment.getMap();

            functionMap = new id.co.jne.jnemobile.courier.function.Map(getActivity(), getContext());
            marker = functionMap.mapMarker(map, latLongDefault, stringMapTitle, stringMapSnippet,
                objectPackage
                .getIntPackageType(UserInterface.IMAGE_RESOURCE_SMALL));
        }
        else
        {

        }
    }
}