// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;


// CLASS

public class Order extends android.support.v4.app.Fragment
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

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_order, container, false);


        // EVENT

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.relativeLayoutOrderFragmentcontainer, new OrderList());
        transaction.commit();

        return viewGroup;
    }
}