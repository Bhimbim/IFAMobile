package my.com.infoconnect.ifamobile.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.R;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class ProspectSearch extends android.support.v4.app.Fragment
{
    // INITIALIZATION

    // LAYOUT

    private ViewGroup viewGroup;
    private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
    private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
    private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_prospect_search, container, false);


        // EVENT

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.relativeLayoutSearchFragmentcontainer, new SearchList());
        transaction.commit();

        return viewGroup;
    }
}
