// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

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

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.*;
import id.co.jne.jnemobile.courier.function.Map;
import id.co.jne.jnemobile.courier.variable.constant.Dummy;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.Order;
import id.co.jne.jnemobile.courier.variable.object.Recipient;
import id.co.jne.jnemobile.courier.variable.object.Sender;
import id.co.jne.jnemobile.courier.widget.ListOrderAdapter;


// CLASS

public class OrderList extends android.support.v4.app.Fragment
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
        private List<id.co.jne.jnemobile.courier.variable.object.Order> listOrder;
        private ListOrderAdapter listOrderAdapter;
        private id.co.jne.jnemobile.courier.function.Map functionMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_order_list, container, false);

        functionMap = new Map(getActivity(), getContext());
        listViewOrder = (ListView) viewGroup.findViewById(R.id.listViewOrder);
        listOrder = new ArrayList<Order>();

        for (int i = 0; i < 3; i++)
        {
            Order objectOrder = new Order();
            objectOrder.setIntID(i + 1);
            objectOrder.setStringState(Transaction.ORDER_STATE_AVAILABLE);

            Sender objectSender = new Sender();
            objectSender.setStringID(Dummy.DUMMY_LIST_SENDER.get(i)[0]);
            objectSender.setStringName(Dummy.DUMMY_LIST_SENDER.get(i)[1]);
            objectSender.setStringProvince(Dummy.DUMMY_LIST_SENDER.get(i)[2]);
            objectSender.setStringCity(Dummy.DUMMY_LIST_SENDER.get(i)[3]);
            objectSender.setStringPostalCode(Dummy.DUMMY_LIST_SENDER.get(i)[4]);
            objectSender.setStringAddress(Dummy.DUMMY_LIST_SENDER.get(i)[5]);
            objectSender.setStringHint(Dummy.DUMMY_LIST_SENDER.get(i)[6]);
            objectSender.setStringLatitude(Dummy.DUMMY_LIST_SENDER.get(i)[7]);
            objectSender.setStringLongitude(Dummy.DUMMY_LIST_SENDER.get(i)[8]);
            objectSender.setStringTelephone(Dummy.DUMMY_LIST_SENDER.get(i)[9]);
            objectSender.setStringMobileTelephone(Dummy.DUMMY_LIST_SENDER.get(i)[10]);
            objectOrder.setObjectSender(objectSender);

            Recipient objectRecipient = new Recipient();
            objectRecipient.setStringID(Dummy.DUMMY_LIST_RECIPIENT.get(i)[0]);
            objectRecipient.setStringName(Dummy.DUMMY_LIST_RECIPIENT.get(i)[1]);
            objectRecipient.setStringProvince(Dummy.DUMMY_LIST_RECIPIENT.get(i)[2]);
            objectRecipient.setStringCity(Dummy.DUMMY_LIST_RECIPIENT.get(i)[3]);
            objectRecipient.setStringPostalCode(Dummy.DUMMY_LIST_RECIPIENT.get(i)[4]);
            objectRecipient.setStringAddress(Dummy.DUMMY_LIST_RECIPIENT.get(i)[5]);
            objectRecipient.setStringHint(Dummy.DUMMY_LIST_RECIPIENT.get(i)[6]);
            objectRecipient.setStringLatitude(Dummy.DUMMY_LIST_RECIPIENT.get(i)[7]);
            objectRecipient.setStringLongitude(Dummy.DUMMY_LIST_RECIPIENT.get(i)[8]);
            objectRecipient.setStringTelephone(Dummy.DUMMY_LIST_RECIPIENT.get(i)[9]);
            objectRecipient.setStringMobileTelephone(Dummy.DUMMY_LIST_RECIPIENT.get(i)[10]);
            objectOrder.setObjectRecipient(objectRecipient);

            Package objectPackage = new Package();
            objectPackage.setStringID(Dummy.DUMMY_LIST_PACKAGE.get(i)[0]);
            objectPackage.setStringDescription(Dummy.DUMMY_LIST_PACKAGE.get(i)[1]);
            objectPackage.setStringServiceType(Dummy.DUMMY_LIST_PACKAGE.get(i)[2]);
            objectPackage.setStringPackageType(Dummy.DUMMY_LIST_PACKAGE.get(i)[3]);
            objectPackage.setStringWeight(Dummy.DUMMY_LIST_PACKAGE.get(i)[4]);
            objectPackage.setStringLong(Dummy.DUMMY_LIST_PACKAGE.get(i)[5]);
            objectPackage.setStringWidth(Dummy.DUMMY_LIST_PACKAGE.get(i)[5]);
            objectPackage.setStringTall(Dummy.DUMMY_LIST_PACKAGE.get(i)[7]);
            objectPackage.setStringSpecificInstruction(Dummy.DUMMY_LIST_PACKAGE.get(i)[8]);
            objectPackage.setStringNote(Dummy.DUMMY_LIST_PACKAGE.get(i)[9]);
            objectPackage.setIntPackageValue(Integer.parseInt(Dummy.DUMMY_LIST_PACKAGE.get(i)[10]));
            objectOrder.setObjectPackage(objectPackage);

            listOrder.add(objectOrder);
        }

        listOrderAdapter = ((Home)getActivity()).functionUserInterface.setListViewSetting
            (listViewOrder, listOrder, ((Home)getActivity()).functionTypefaceGenerator, false);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.textViewTitle);
        listTypefaceSecondary.add(R.id.textViewContent);
        listTypefaceSecondary.add(R.id.textViewRadiusMin);
        listTypefaceSecondary.add(R.id.textViewRadiusMax);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary
                (), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            linearLayoutAlert = (LinearLayout) viewGroup.findViewById(R.id.includeOrderAlertList);

            TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
            TextView textViewContent = (TextView) viewGroup.findViewById(R.id.textViewContent);
            TextView textViewRadiusMin = (TextView) viewGroup.findViewById(R.id.textViewRadiusMin);
            TextView textViewRadiusMax = (TextView) viewGroup.findViewById(R.id.textViewRadiusMax);

            SeekBar seekBarRadius = (SeekBar) viewGroup.findViewById(R.id.seekBarRadius);

            // LAYOUT SETTING

            textViewTitle.setText(getActivity().getResources().getString(R.string.alert_list_orderTitle));
            textViewContent.setText(getActivity().getResources().getString(R.string.alert_list_orderContent));
            textViewRadiusMin.setText(getActivity().getResources().getString(R.string.order_radius_min));
            textViewRadiusMax.setText(getActivity().getResources().getString(R.string.order_radius_max));

            seekBarRadius.setMax(100);
            seekBarRadius.setProgress(50);

            if (listOrder.isEmpty())
            {
                linearLayoutAlert.setVisibility(View.VISIBLE);
            }
            else
            {
                linearLayoutAlert.setVisibility(View.GONE);
            }


        // EVENT

        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Fragment fragmentTarget = new OrderDetails();
                Bundle bundleSend = new Bundle();
                bundleSend.putSerializable(Transaction.BUNDLE_KEY_ORDER, listOrder.get(position));
                fragmentTarget.setArguments(bundleSend);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim.transition_fly_out);
                fragmentTransaction.replace(R.id.relativeLayoutOrderFragmentcontainer, fragmentTarget).commit();
            }
        });

        seekBarRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                Location locationCurrent = functionMap.getLastKnownLocation();
                List<Order> listOrderTemporary = new ArrayList<Order>();

                for (int i = 0; i < listOrder.size(); i++)
                {
                    String stringSenderLatitude = listOrder.get(i).getObjectSender()
                            .getStringLatitude();
                    String stringSenderLongitude = listOrder.get(i).getObjectSender()
                            .getStringLongitude();

                    float[] floatDistance = new float[2];

                    Location.distanceBetween(locationCurrent.getLatitude(),
                            locationCurrent.getLongitude(), Double.valueOf(stringSenderLatitude),
                            Double.valueOf(stringSenderLongitude), floatDistance);

                    Log.i("Sender position", "latitude = " + stringSenderLatitude + ", longitude " +
                            "= " + stringSenderLongitude);

                    Log.i("Courier position", "latitude = " + locationCurrent.getLatitude() + ", " +
                            "longitude" +
                            " " +
                            "= " + locationCurrent.getLongitude());

                    float floatProgress = seekBar.getProgress() * 200;

                    Log.i("Distance", "distance = " + floatDistance[0]);

                    Log.i("Seek Bar", "seekBar progress = " + seekBar.getProgress() + ", seekBar " +
                            "distance" +
                            " " +
                            "= " + floatProgress);

                    if (floatDistance[0] < floatProgress)
                    {
                        listOrderTemporary.add(listOrder.get(i));
                    }
                    else
                    {

                    }
                }

                ((Home)getActivity()).functionUserInterface.setListViewSetting(listViewOrder,
                        listOrderTemporary, ((Home)getActivity()).functionTypefaceGenerator, false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

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
            listOrder.remove(((Home)getActivity()).getObjectOrder().getIntID() - 1);
            ((Home)getActivity()).functionUserInterface.setListViewSetting(listViewOrder,
                    listOrder, ((Home)getActivity()).functionTypefaceGenerator, false);

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