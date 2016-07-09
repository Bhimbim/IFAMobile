// PACKAGE

package my.com.infoconnect.ifamobile.composer;


// IMPORT

import android.app.Activity;
import android.content.Context;

import id.co.jne.jnemobile.courier.variable.constant.Transaction;

/**
 * Created by ibrahimaziztejokusumo on 3/2/16.
 */


// CLASS

public class PickUpDelivery
{
    // INITIALIZATION

    private Activity activity;
    private Context context;

    String stringTelephone = "";
    String stringTotalCost = "";
    String stringConnectionType = "";

    public PickUpDelivery(Activity activity, Context context, String stringConnectionType)
    {
        this.activity = activity;
        this.context = context;
        this.stringTotalCost = "0";
        this.stringConnectionType = stringConnectionType;
    }

    public String composePickUpDelivery()
    {
        String stringResult = "";

        if(stringConnectionType.equals(Transaction.CONNECTION_TYPE_GPRS))
        {
            stringResult = "?" + Transaction.GPRS_KEY_PHONE + "=" + stringTelephone + "&" +
                Transaction.GPRS_KEY_AMOUNT + "=" +
                    stringTotalCost;
        }
        else if (stringConnectionType.equals(Transaction.CONNECTION_TYPE_SMS))
        {

        }
        else if (stringConnectionType.equals(Transaction.CONNECTION_TYPE_USSD))
        {

        }
        else
        {

        }

        return stringResult;
    }

    public String getStringTelephone()
    {
        return stringTelephone;
    }

    public void setStringTelephone(String stringTelephone)
    {
        this.stringTelephone = stringTelephone;
    }

    public String getStringTotalCost()
    {
        return stringTotalCost;
    }

    public void setStringTotalCost(String stringTotalCost)
    {
        this.stringTotalCost = stringTotalCost;
    }

    public String getStringConnectionType()
    {
        return stringConnectionType;
    }

    public void setStringConnectionType(String stringConnectionType)
    {
        this.stringConnectionType = stringConnectionType;
    }
}