// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.widget.ListOrderAdapter;


// CLASS

public class HistoryList extends Fragment
{
    // INITIALIZATION

        // LAYOUT

        private ViewGroup viewGroup;
        private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();
        private LinearLayout linearLayoutAlert;

        private ListView listViewHistory;
        private List<Order> listOrder;
        private ListOrderAdapter listOrderAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_history_list, container, false);

        listViewHistory = (ListView) viewGroup.findViewById(R.id.listViewHistory);
        listOrder = new ArrayList<Order>();

        listOrderAdapter = ((Home)getActivity()).functionUserInterface.setListViewSetting
        (listViewHistory, listOrder, ((Home)getActivity()).functionTypefaceGenerator, true);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.textViewTitle);
        listTypefaceSecondary.add(R.id.textViewContent);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            linearLayoutAlert = (LinearLayout) viewGroup.findViewById(R.id
                    .includeHistoryAlertList);

            TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
            TextView textViewContent = (TextView) viewGroup.findViewById(R.id.textViewContent);

            // LAYOUT SETTING

            textViewTitle.setText(getActivity().getResources().getString(R.string
                    .alert_list_historyTitle));
            textViewContent.setText(getActivity().getResources().getString(R.string
                    .alert_list_historyContent));

            if (listOrder.isEmpty())
            {
                linearLayoutAlert.setVisibility(View.VISIBLE);
            }
            else
            {
                linearLayoutAlert.setVisibility(View.GONE);
            }


        // EVENT

        listViewHistory.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Fragment fragmentTarget = new MapTracking();
                Bundle bundleSend = new Bundle();
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, listOrder.get(position));
                fragmentTarget.setArguments(bundleSend);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);
                fragmentTransaction.replace(R.id.relativeLayoutHistoryFragmentcontainer, fragmentTarget).commit();
            }
        });

        return viewGroup;
    }


    @Override
    public void onResume()
    {
        super.onResume();


        // LIST VIEW

        if (((Home)getActivity()).getObjectOrder() != null)
        {
            listOrder.add(((Home)getActivity()).getObjectOrder());
            ((Home)getActivity()).functionUserInterface.setListViewSetting(listViewHistory,
                    listOrder, ((Home)getActivity()).functionTypefaceGenerator, true);

            if (listOrder.isEmpty())
            {
                linearLayoutAlert.setVisibility(View.VISIBLE);
            }
            else
            {
                linearLayoutAlert.setVisibility(View.GONE);
            }
        }
        else
        {

        }
    }
}