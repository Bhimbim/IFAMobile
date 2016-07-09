package my.com.infoconnect.ifamobile.function;

import android.app.Activity;
import android.content.Context;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Regex;

/**
 * Created by ibrahimaziztejokusumo on 3/22/16.
 */
public class Validation
{
    // INITIALIZATION

    private Activity activity;
    private Context context;

    public Validation(Activity activity, Context context)
    {
        this.activity = activity;
        this.context = context;
    }


    // USER

    public Boolean validatePassword(String stringPassword)
    {
        Boolean validationState = false;

        if (stringPassword.length() != activity.getResources().getInteger(R.integer.rule_password_length))
        {

        }
        else if (stringPassword.matches(Regex.isNumeric))
        {

        }
        else
        {
            validationState = true;
        }

        return validationState;
    }
}