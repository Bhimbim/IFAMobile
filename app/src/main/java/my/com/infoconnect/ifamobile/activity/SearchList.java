package my.com.infoconnect.ifamobile.activity;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.R;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class SearchList extends android.support.v4.app.Fragment
{
    // INITIALIZATION

    // LAYOUT

    private ViewGroup viewGroup;
    private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
    private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
    private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();
    private LinearLayout linearLayoutAlert;

    // OBJECT

    private ListView listViewOrder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_prospect_list, container, false);

        listViewOrder = (ListView) viewGroup.findViewById(R.id.listViewProspect);

        return viewGroup;
    }
}
