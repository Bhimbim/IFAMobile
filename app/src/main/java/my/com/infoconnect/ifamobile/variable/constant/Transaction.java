package my.com.infoconnect.ifamobile.variable.constant;

/**
 * Created by emobilemac on 3/31/16.
 */
public class Transaction
{
    // CONNECTION TYPE

    public static final String CONNECTION_TYPE_SMS = "SMS";
    public static final String CONNECTION_TYPE_USSD = "USSD";
    public static final String CONNECTION_TYPE_GPRS = "GPRS";

    public static final String SMS_PENDINGINTENT_DELIVERED = "PendingIntentDelivered";
    public static final String SMS_PENDINGINTENT_SENT = "PendingIntentSent";

    // TRANSACTION TYPE

    public static final String TRANSACTION_TYPE_PICKUPDELIERY = "PickUpDelivery";
    public static final String TRANSACTION_SECTION_PICKUPDELIERY = "Pick Up Delivery";

    // PACKAGE

    public static final String PACKAGE_SERVICETYPE_SS = "Super Speed";
    public static final String PACKAGE_SERVICETYPE_YES = "Yakin Esok Sampai";
    public static final String PACKAGE_SERVICETYPE_REG = "Regular";
    public static final String PACKAGE_SERVICETYPE_OKE = "Ongkos Kirim Ekonomis";
    public static final String PACKAGE_SERVICETYPE_JNE = "JNE Loyalty Card";

    public static final String PACKAGE_PACKAGETYPE_PACKAGE = "Package";
    public static final String PACKAGE_PACKAGETYPE_DOCUMENT = "Document";
    public static final String PACKAGE_PACKAGETYPE_PARCEL = "Parcel";

    public static final String ORDER_STATE_AVAILABLE = "Available";
    public static final String ORDER_STATE_PAID = "Paid";
    public static final String ORDER_STATE_ONPROCESS = "On Process";
    public static final String ORDER_STATE_ONDELIVERY = "On Delivery";
    public static final String ORDER_STATE_CLOSED = "Closed";
    public static final String ORDER_STATE_CANCELED = "Canceled";

    public static final String BUNDLE_KEY_ORDER = "Object Delivery";
    public static final String BUNDLE_KEY_FORMMODIFIER = "Form Modifier";
    public static final String BUNDLE_KEY_FROM = "Sender Details";

    public static final String BUNDLE_VALUE_SENDERDETAILS = "Sender Details";
    public static final String BUNDLE_VALUE_RECIPIENTDETAILS = "Recipient Details";
    public static final String BUNDLE_VALUE_ORDERDETAILS = "Order Details";

    // RESPONSE GPRS

    // public static final String GPRS_URL_DEVELOPMENT = "http://192.168.0.67:9000/mbiz";
    // public static final String GPRS_URL_DEVELOPMENT = "http://192.168.0.11:3000/mbiz";
    public static final String GPRS_URL_DEVELOPMENT = "http://125.161.19.11:3000/mbiz";
    public static final String GPRS_KEY_PHONE = "phone";
    public static final String GPRS_KEY_AMOUNT = "amount";
    public static final String GPRS_KEY_RESPONSECODE = "rc";
    public static final String GPRS_KEY_MESSAGE = "message";

    // DEFAULT VARIABLE

    public static final String USER_PASSWORD_DEFAULT = "1234";
}