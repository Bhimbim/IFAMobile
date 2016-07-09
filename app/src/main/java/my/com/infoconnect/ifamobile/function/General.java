package my.com.infoconnect.ifamobile.function;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;
import id.co.jne.jnemobile.courier.variable.object.Syntax;


/**
 * Created by ibrahimaziztejokusumo on 3/22/16.
 */
public class General
{
    // INITIALIZATION

    private Activity activity;
    private Context context;
    private TypefaceGenerator typefaceGenerator;

    public General(Activity activity, Context context, TypefaceGenerator typefaceGenerator)
    {
        this.activity = activity;
        this.context = context;
        this.typefaceGenerator = typefaceGenerator;
    }


    // NOTIFICATIONS

    public void infoToast(String stringContent, String stringDuration)
    {
        int toastDuration;

        if(stringDuration.equals(id.co.jne.jnemobile.courier.variable.constant.UserInterface.TOAST_DURATION_LONG))
        {
            toastDuration = Toast.LENGTH_SHORT;
        }
        else
        {
            toastDuration = Toast.LENGTH_LONG;
        }

        Toast toast = Toast.makeText(context, stringContent, toastDuration);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    /* public void infoAlertDialog(String stringTitle, String stringContent, Boolean
    booleanResponse)

    {
        AlertDialog.Builder dialogInformation = new AlertDialog.Builder(activity);
        activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        activity.getWindow().setBackgroundDrawableResource(R.color.general_transparent);

        if(booleanResponse == false)
        {
            dialogInformation
                .setTitle(stringTitle)
                .setMessage(stringContent)
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.button_exit),
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });
        }
        else
        {
            final EditText editTextResponse = new EditText(context);
            dialogInformation
                .setTitle(stringTitle)
                .setMessage(stringContent)
                .setView(editTextResponse)
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.button_submit),
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    })
                .setNegativeButton(activity.getResources().getString(R.string.button_exit),
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });
        }

        AlertDialog alertDialogInformation = dialogInformation.create();
        alertDialogInformation.show();
    } */

    public void interactionAlertPayment(String stringTitle, String stringContent)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        ViewGroup viewGroup = (ViewGroup) activity.getLayoutInflater().inflate(R.layout.alert_payment, null);

        TextView textViewPaperTitle = (TextView) viewGroup.findViewById(R.id.textViewPaperTitle);
        textViewPaperTitle.setTypeface(typefaceGenerator.typefaceSecondary());
        TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
        textViewTitle.setTypeface(typefaceGenerator.typefaceSecondary());
        TextView textViewContent = (TextView) viewGroup.findViewById(R.id.textViewContent);
        textViewContent.setTypeface(typefaceGenerator.typefaceSecondary());
        Button buttonPrint = (Button) viewGroup.findViewById(R.id.buttonPrint);
        buttonPrint.setTypeface(typefaceGenerator.typefaceSecondary());
        ImageButton buttonCancel = (ImageButton) viewGroup.findViewById(R.id.buttonClose);

        textViewPaperTitle.setText(activity.getResources().getString(R.string.alert_payment_confirmation));
        textViewTitle.setText(stringTitle);
        textViewContent.setText(stringContent);

        dialogBuilder.setView(viewGroup);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        buttonPrint.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alertDialog.cancel();
            }
        });

        alertDialog.show();
    }


    // CURRENCY

    public String formatCurrency(String stringCurrency)
    {
        String arrayCurrencyFormat;

        if(stringCurrency.equals(Character.CURRENCY_IDR_FORMAT))
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[0];
        }
        else if (stringCurrency.equals(Character.CURRENCY_USD_FORMAT))
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[1];
        }
        else if (stringCurrency.equals(Character.CURRENCY_EUR_FORMAT))
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[2];
        }
        else if (stringCurrency.equals(Character.CURRENCY_AUG_FORMAT))
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[3];
        }
        else if (stringCurrency.equals(Character.CURRENCY_SGD_FORMAT))
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[4];
        }
        else
        {
            arrayCurrencyFormat = Character.CURRENCY_ARRAY_FORMAT[0];
        }

        return arrayCurrencyFormat;
    }


    // SEND SYNTAX

    private BroadcastReceiver broadcastReceiverSent;
    private BroadcastReceiver broadcastReceiverDelivered;
    ProgressDialog progressDialog;

    public String sendSyntax(final Syntax objectSyntax)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_circle);
        TextView textViewTitle = (TextView) progressDialog.findViewById(R.id.textViewTitle);
        textViewTitle.setTypeface(typefaceGenerator.typefaceSecondary());
        textViewTitle.setText(activity.getResources().getString(R.string.progress_title_general));
        TextView textViewContent = (TextView) progressDialog.findViewById(R.id.textViewContent);
        textViewContent.setTypeface(typefaceGenerator.typefaceSecondary());
        textViewContent.setText
        (
            activity.getResources().getString(R.string.progress_content_prefix) +
            objectSyntax.getStringConnectionType() +
            activity.getResources().getString(R.string.progress_content_infix) +
            objectSyntax.getStringTransactionSection() +
            activity.getResources().getString(R.string.progress_content_suffix)
        );
        ImageView imageViewProgressCircle = (ImageView) progressDialog.findViewById(R.id
                .imageViewProgressCircle);
        android.view.animation.Animation animationRotate360 = AnimationUtils.loadAnimation(context, R
                .anim.animation_rotate360);
        imageViewProgressCircle.setAnimation(animationRotate360);

        progressDialog.getWindow().setBackgroundDrawableResource(R.color.general_transparent);

        String stringResult = "";

        if(objectSyntax.getStringConnectionType().equals(Transaction.CONNECTION_TYPE_SMS))
        {
            PendingIntent pendingIntentSent = PendingIntent.getBroadcast
                (activity, 0, new Intent(Transaction.SMS_PENDINGINTENT_SENT), 0);
            PendingIntent pendingIntentDelivered = PendingIntent.getBroadcast
                (activity, 0, new Intent(Transaction.SMS_PENDINGINTENT_DELIVERED), 0);

            if(System.getProperty("os.name").equals("qnx"))
            {
                Intent GoToCreateSMS = new Intent(Intent.ACTION_VIEW);
                GoToCreateSMS.setType("vnd.android-dir/mms-sms");
                GoToCreateSMS.putExtra("address", objectSyntax.getStringSMSTarget());
                GoToCreateSMS.putExtra("sms_body", objectSyntax.getStringSyntax());
                context.startActivity(GoToCreateSMS);
            }
            else
            {
                //---when the SMS has been sent---
                broadcastReceiverSent = new BroadcastReceiver()
                {
                    @Override
                    public void onReceive(Context arg0, Intent arg1)
                    {
                        String toastContent = null;

                        switch (getResultCode())
                        {
                            case Activity.RESULT_OK:
                                toastContent =
                                    activity.getResources().getString(R.string.process_smsInquiry_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsSent_infix);
                                break;
                            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsGeneric_infix);
                                break;
                            case SmsManager.RESULT_ERROR_NO_SERVICE:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsNoService_infix);
                                break;
                            case SmsManager.RESULT_ERROR_NULL_PDU:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsProtocol_infix);
                                break;
                            case SmsManager.RESULT_ERROR_RADIO_OFF:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsRadio_infix);
                                break;
                        }

                        activity.unregisterReceiver(broadcastReceiverSent);
                        infoToast(toastContent, id.co.jne.jnemobile.courier.variable.constant.UserInterface.TOAST_DURATION_LONG);
                    }
                };

                //---when the SMS has been delivered---
                broadcastReceiverDelivered = new BroadcastReceiver()
                {
                    @Override
                    public void onReceive(Context arg0, Intent arg1)
                    {
                        String toastContent = "";

                        switch (getResultCode())
                        {
                            case Activity.RESULT_OK:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsProgress_infix);
                                break;
                            case Activity.RESULT_CANCELED:
                                progressDialog.cancel();
                                toastContent =
                                    activity.getResources().getString(R.string.process_sms_prefix)
                                    + objectSyntax.getStringConnectionType()
                                    + activity.getResources().getString(R.string.process_smsCanceled_infix);
                                break;
                        }

                        activity.unregisterReceiver(broadcastReceiverDelivered);
                        infoToast(toastContent, UserInterface.TOAST_DURATION_LONG);
                    }
                };

                activity.registerReceiver(broadcastReceiverSent, new IntentFilter(Transaction.SMS_PENDINGINTENT_SENT));
                activity.registerReceiver(broadcastReceiverDelivered, new IntentFilter(Transaction.SMS_PENDINGINTENT_DELIVERED));

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage
                    (objectSyntax.getStringSMSTarget(), null, objectSyntax.getStringSyntax(), pendingIntentSent, pendingIntentDelivered);
            }
        }
        else if (objectSyntax.getStringConnectionType().equals(Transaction.CONNECTION_TYPE_USSD))
        {
            activity.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel: " +
                    objectSyntax.getStringSyntax() + Uri.encode("#"))));
        }
        else if (objectSyntax.getStringConnectionType().equals(Transaction.CONNECTION_TYPE_GPRS))
        {
            String[] arrayParam = {objectSyntax.getStringSyntax()};
            new GPRSRequest().execute(arrayParam[0]);
        }
        else
        {

        }

        return stringResult;
    }

    // HTTP

    public class GPRSRequest extends AsyncTask<String,Void,Void>
    {
        String stringResult = "";
        HttpURLConnection httpURLConnection = null;


        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @SuppressLint("LongLogTag")
        @Override
        protected Void doInBackground(String... params)
        {
            try
            {
                if(GPRSConnectivity())
                {
                    // stringSyntax = "?phone="+params[0]+"&amount="+params[1];
                    Log.i("SendMessage | GPRSRequest", "GPPRS start with syntax = " + Transaction
                            .GPRS_URL_DEVELOPMENT + params[0]);

                    // CONNECTION

                    httpURLConnection = (HttpURLConnection) ((new URL(Transaction.GPRS_URL_DEVELOPMENT + params[0]).openConnection()));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty("Content-Type", "application/text");
                    httpURLConnection.setRequestProperty("Accept", "application/text");
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();



                    // OUTPUT

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    //bufferedWriter.write(params[0]);
                    bufferedWriter.close();
                    outputStream.close();

                    // INPUT

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((stringResult = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(stringResult);
                    }

                    bufferedReader.close();

                    stringResult = stringBuilder.toString();

                    Log.i("SendSyntax | GPRSRequest", "GPRS response = " + stringResult);
                }
                else
                {

                }
            }
            catch (Exception e)
            {
                Log.i("SendSyntax | GPRSRequest", "GPRS exception = " + e.getLocalizedMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            progressDialog.cancel();

            if(stringResult.length() > 0)
            {
                if (GPRSResponse(stringResult).get(0).equals("rc=0"))
                {
                    interactionAlertPayment
                            ("Payment Confirmation", "Customer Alexander Hariyanto has " +
                                    "successfully paid the current order, message : " + GPRSResponse
                                    (stringResult).get(1));
                } else
                {

                }
            }
            else
            {

            }

            super.onPostExecute(aVoid);
        }
    }

    @SuppressLint("LongLogTag")
    public boolean GPRSConnectivity()
    {
        ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
        {
            return true;
        }
        else
        {
            infoToast("No GPRS signal, please check your GPRS signal or your data connection " +
                    "might be off.", UserInterface.TOAST_DURATION_LONG);
            Log.i("SendSyntax | GPRSRequest", "GPRS connectivity = " + networkInfo.toString());

            return false;
        }
    }

    public ArrayList<String> GPRSResponse(String stringResponse)
    {
        ArrayList<String> arrayResult = new ArrayList<String>();

        if (stringResponse.length() > 0)
        {
            arrayResult.add(stringResponse.substring(stringResponse.indexOf(Transaction
                    .GPRS_KEY_RESPONSECODE + "="), stringResponse.indexOf("&")));
            arrayResult.add(stringResponse.substring(stringResponse.indexOf(Transaction
                    .GPRS_KEY_MESSAGE + "="), stringResponse.length()));
        }
        else
        {

        }

        return arrayResult;
    }
}