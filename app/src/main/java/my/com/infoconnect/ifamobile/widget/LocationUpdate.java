package my.com.infoconnect.ifamobile.widget;

import android.app.Activity;
import android.content.ContentResolver;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by ibrahimaziztejokusumo on 5/2/16.
 */

public class LocationUpdate extends Activity implements LocationListener
{
    @Override
    public void onLocationChanged(Location location)
    {
        // GET GEOLOCATION COORDINATES

        Log.i("Get Location", "Location changed: Lat: " + location.getLatitude() + " Lng: "
                + location.getLongitude());

        String stringLongitude = "Longitude: " + location.getLongitude();
        String stringLatitude = "Latitude: " + location.getLatitude();


        // GET GEOLOCATION ADDRESS

        String stringCityName = null;
        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> listAddresses;

        try
        {
            listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            if (listAddresses.size() > 0)
            {
                System.out.println(listAddresses.get(0).getLocality());
                stringCityName = listAddresses.get(0).getLocality();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.i("Get Location", stringLongitude + "\n" + stringLatitude + "\n\nMy Current City is: "
                + stringCityName);
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public Boolean checkGPS()
    {
        ContentResolver contentResolver = getBaseContext().getContentResolver();
        boolean booleanState = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);

        if (booleanState)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}