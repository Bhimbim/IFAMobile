// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class MapTracking extends Fragment
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

    private LatLng latLongCurrent;
    private GoogleMap map;
    private String stringMapTitle;
    private String stringMapSnippet;
    private id.co.jne.jnemobile.courier.function.Map functionMap;
    private Marker marker;
    private LocationManager locationManager;


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

            Button buttonDone = (Button) viewGroup.findViewById(R.id.buttonDone);

            // LAYOUT SETTING

            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        // EVENT

        buttonDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getFragmentManager().popBackStack();
            }
        });


        return viewGroup;
    }

    private LocationListener locationListener = new LocationListener()
    {
        @Override
        public void onLocationChanged(final Location location)
        {
            latLongCurrent = new LatLng
            (
                Double.valueOf(location.getLatitude()),
                Double.valueOf(location.getLongitude())
            );

            Log.i("onLocationChanged", "latitude = " + location.getLatitude() + ", longitude = " +
                    location.getLongitude());

            try
            {
                Geocoder geo = new Geocoder(getContext(), Locale.getDefault());
                List<Address> addresses = geo.getFromLocation(latLongCurrent.latitude, latLongCurrent.longitude, 1);

                if (addresses.isEmpty())
                {
                    stringMapTitle = "Get Current Location";
                    stringMapSnippet = "Please wait while we fetching your address.";
                }
                else
                {
                    if (addresses.size() > 0)
                    {
                        stringMapTitle = objectSender.getStringName();
                        stringMapSnippet =
                            addresses.get(0).getFeatureName() + ", " +
                            addresses.get(0).getLocality() + "/n" +
                            addresses.get(0).getAdminArea() + ", " +
                            addresses.get(0).getCountryName();
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

            functionMap = new id.co.jne.jnemobile.courier.function.Map(getActivity(), getContext());
            marker = functionMap.mapMarker(map, latLongCurrent, stringMapTitle, stringMapSnippet,
                objectPackage.getIntPackageType(UserInterface.IMAGE_RESOURCE_SMALL));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {

        }

        @Override
        public void onProviderEnabled(String provider)
        {

        }

        @Override
        public void onProviderDisabled(String provider)
        {

        }
    };


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



        if
        (
            ActivityCompat.checkSelfPermission(getContext(),
            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(getContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        )
        {
            ActivityCompat.requestPermissions
            (getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            ActivityCompat.requestPermissions
            (getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            map.setMyLocationEnabled(true);
            Log.i("Permission", "Access Fine Location = " + Boolean.valueOf(ActivityCompat
                    .checkSelfPermission(getContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                    .PERMISSION_GRANTED));

            Log.i("Permission", "Access Coarse Location = " + Boolean.valueOf(ActivityCompat
                    .checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager
                    .PERMISSION_GRANTED));
        }
        else
        {
            Log.i("Permission", "Granted");
        }



        if (map == null)
        {
            map = supportMapFragment.getMap();
            locationManager.requestLocationUpdates
                    (
                            LocationManager.NETWORK_PROVIDER,
                            UserInterface.LOCATION_REFRESH_TIME,
                            UserInterface.LOCATION_REFRESH_DISTANCE,
                            locationListener
                    );
        }
        else
        {

        }
    }
}