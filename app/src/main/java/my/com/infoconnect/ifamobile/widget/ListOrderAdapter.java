package my.com.infoconnect.ifamobile.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.TypefaceGenerator;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.Order;
import id.co.jne.jnemobile.courier.variable.object.Sender;

/**
 * Created by ibrahimaziztejokusumo on 2/16/16.
 */


// ADAPTER

public class ListOrderAdapter extends ArrayAdapter<Order>
{
    // VARIABLE

    private Context context;
    private int intLayoutID;
    private List<Order> listOrder;
    private TypefaceGenerator typefaceGenerator;
    private Boolean booleanHistoryState;

    private static class ListOrderHolder
    {
        public TextView textViewName;
        public TextView textViewAddress;
        public TextView textViewWeight;
        public TextView textViewState;
        public ImageView imageViewPackageType;
    }


    // CONSTRUCTOR

    public ListOrderAdapter(Context context, int resource, List<Order> listOrder,
                            TypefaceGenerator typefaceGenerator, Boolean booleanHistoryState)
    {
        super(context, resource, listOrder);

        this.context = context;
        this.intLayoutID = resource;
        this.listOrder = listOrder;
        this.typefaceGenerator = typefaceGenerator;
        this.booleanHistoryState = booleanHistoryState;
    }


    // LAYOUT SETTING

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ListOrderHolder listOrderHolder = new ListOrderHolder();

        if (convertView == null)
        {
            LayoutInflater ListItemInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = ListItemInflater.inflate(intLayoutID, parent, false);

            TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            textViewName.setTypeface(typefaceGenerator.typefacePrimary());
            TextView textViewAddress = (TextView) convertView.findViewById(R.id.textViewAddress);
            textViewAddress.setTypeface(typefaceGenerator.typefaceSecondary());

            if (booleanHistoryState == true)
            {
                TextView textViewState = (TextView) convertView.findViewById(R.id.textViewState);
                textViewState.setTypeface(typefaceGenerator.typefaceSecondary());
                listOrderHolder.textViewState = textViewState;
            }
            else
            {
                TextView textViewWeight = (TextView) convertView.findViewById(R.id.textViewWeight);
                textViewWeight.setTypeface(typefaceGenerator.typefaceSecondary());
                listOrderHolder.textViewWeight = textViewWeight;
            }

            ImageView imageViewPackageType = (ImageView)convertView.findViewById(R.id.imageViewPackageType);

            listOrderHolder.textViewName = textViewName;
            listOrderHolder.textViewAddress = textViewAddress;
            listOrderHolder.imageViewPackageType = imageViewPackageType;

            convertView.setTag(listOrderHolder);
        }
        else
        {
            listOrderHolder = (ListOrderHolder) convertView.getTag();
        }

        Sender objectSender = listOrder.get(position).getObjectSender();
        Package objectPackage = listOrder.get(position).getObjectPackage();

        listOrderHolder.textViewName.setText(objectSender.getStringName());
        listOrderHolder.textViewAddress.setText(objectSender.getStringAddress());

        if (booleanHistoryState == true)
        {
            listOrderHolder.textViewState.setText(listOrder.get(position).getStringState());
        }
        else
        {
            listOrderHolder.textViewWeight.setText(objectPackage.getStringWeight());
        }


        listOrderHolder.imageViewPackageType.setImageResource
        (objectPackage.getIntPackageType(UserInterface.IMAGE_RESOURCE_SMALL));

        return convertView;
    }

    public int getOrderID(int position)
    {
        return listOrder.get(position).getIntID();
    }
}