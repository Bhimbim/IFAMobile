package my.com.infoconnect.ifamobile.function;

/**
 * Created by ibrahimaziztejokusumo on 2/1/16.
 */


// IMPORT

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import id.co.jne.jnemobile.courier.variable.Public;


// CLASS

public class Map
{
    // CLASS DECLARATION

    private Public PublicPublic = new Public();


    // CLASS INITIALIZATION

    private Activity activity;
    private Context context;
    private GoogleMap googleMap;

    public Map(Activity activity, Context context)
    {
        this.activity = activity;
        this.context = context;
    }


    // GET LOCATION

    public Location getLastKnownLocation()
    {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> listProviders = locationManager.getProviders(true);
        Location locationBest = null;

        for (String provider : listProviders)
        {
            if
            (
                ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            )
            {
                ActivityCompat.requestPermissions
                (activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
                ActivityCompat.requestPermissions
                (activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            }

            Location locationCurrent = locationManager.getLastKnownLocation(provider);

            if (locationCurrent == null)
            {
                continue;
            }
            if (locationBest == null || locationCurrent.getAccuracy() < locationBest.getAccuracy())
            {
                // Found best last known location: %s", l);
                locationBest = locationCurrent;
            }
        }

        return locationBest;
    }

    // SET MARKER

    public Marker mapMarker(GoogleMap map, LatLng latLng, String stringTitle, String
            stringSnippet, int intIcon)
    {
        Marker marker = map.addMarker
        (
            new MarkerOptions()
            .position(latLng)
            .title(stringTitle)
            .snippet(stringSnippet)
            .icon(BitmapDescriptorFactory.fromResource(intIcon))
        );

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        return marker;
    }
}