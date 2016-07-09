package my.com.infoconnect.ifamobile.variable.constant;

/**
 * Created by ibrahimaziztejokusumo on 3/22/16.
 */
public class Character
{
    // CODING CHARACTER
    public static final String CHARACTER_DASH = " ";
    public static final String CHARACTER_APOSTROPHE = "'";
    // LOG

    public static final String CHARACTER_LOG_SEPARATOR = " - ";


    // USER INTERFACE

    public static final String CHARACTER_SPINNER_SEPARATOR = " // ";

    // DATABASE
    public static final String CHARACTER_DATABASE_SEPARATOR = " // ";

    // COMPOSER

    public static final String CHARACTER_USSD_SEPARATOR = "*";
    public static final String CHARACTER_USSD_CLOSURE = "#";
    public static final String CHARACTER_SMS_SEPARATOR = " ";
    public static final String CHARACTER_GPRS_SEPARATOR = "&";


    // CURRENCY

    public static final String CURRENCY_GENERAL_SEPARATOR = "_";

    public static final String CURRENCY_IDR_FORMAT = "IDR";
    public static final String CURRENCY_IDR_NAME = "Indonesia Rupiah";
    public static final String CURRENCY_IDR_PREFIX = "Rp. ";
    public static final String CURRENCY_IDR_SEPARATOR = ".";

    public static final String CURRENCY_USD_FORMAT = "USD";
    public static final String CURRENCY_USD_NAME = "United States Dollar";
    public static final String CURRENCY_USD_PREFIX = "$ ";
    public static final String CURRENCY_USD_SEPARATOR = ",";

    public static final String CURRENCY_EUR_FORMAT = "EUR";
    public static final String CURRENCY_EUR_NAME = "Euro";
    public static final String CURRENCY_EUR_PREFIX = "IDR";
    public static final String CURRENCY_EUR_SEPARATOR = ".";

    public static final String CURRENCY_AUG_FORMAT = "AUG";
    public static final String CURRENCY_AUG_NAME = "Australian Dollar";
    public static final String CURRENCY_AUG_PREFIX = "$ ";
    public static final String CURRENCY_AUG_SEPARATOR = ".";

    public static final String CURRENCY_SGD_FORMAT = "SGD";
    public static final String CURRENCY_SGD_NAME = "Singapore Dollar";
    public static final String CURRENCY_SGD_PREFIX = "$ ";
    public static final String CURRENCY_SGD_SEPARATOR = ".";

    public static final String[] CURRENCY_ARRAY_FORMAT =
    {
        CURRENCY_IDR_FORMAT + CURRENCY_GENERAL_SEPARATOR + CURRENCY_IDR_NAME + CURRENCY_GENERAL_SEPARATOR +
        CURRENCY_IDR_PREFIX + CURRENCY_GENERAL_SEPARATOR + CURRENCY_IDR_SEPARATOR,
        CURRENCY_USD_FORMAT + CURRENCY_GENERAL_SEPARATOR + CURRENCY_USD_NAME + CURRENCY_GENERAL_SEPARATOR +
        CURRENCY_USD_PREFIX + CURRENCY_GENERAL_SEPARATOR + CURRENCY_USD_SEPARATOR,
        CURRENCY_EUR_FORMAT + CURRENCY_GENERAL_SEPARATOR + CURRENCY_EUR_NAME + CURRENCY_GENERAL_SEPARATOR +
        CURRENCY_EUR_PREFIX + CURRENCY_GENERAL_SEPARATOR + CURRENCY_EUR_SEPARATOR,
        CURRENCY_AUG_FORMAT + CURRENCY_GENERAL_SEPARATOR + CURRENCY_AUG_NAME + CURRENCY_GENERAL_SEPARATOR +
        CURRENCY_AUG_PREFIX + CURRENCY_GENERAL_SEPARATOR + CURRENCY_AUG_SEPARATOR,
        CURRENCY_SGD_FORMAT + CURRENCY_GENERAL_SEPARATOR + CURRENCY_SGD_NAME + CURRENCY_GENERAL_SEPARATOR +
        CURRENCY_SGD_PREFIX + CURRENCY_GENERAL_SEPARATOR + CURRENCY_SGD_SEPARATOR
    };
}
