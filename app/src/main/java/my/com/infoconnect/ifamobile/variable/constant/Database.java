package my.com.infoconnect.ifamobile.variable.constant;

/**
 * Created by emobilemac on 3/31/16.
 */
public class Database
{
    // TABLE

        // USER

        public static final String TABLE_USER_NAME 			= "user";

        public static final String COLOUMN_USER_ID				= "id";
        public static final String COLOUMN_USER_PASSWORD 		= "password";
        public static final String COLOUMN_USER_CONNECTIONTYPE	= "connectiontype";
        public static final String COLOUMN_USER_SMSCOMPATIBILITY	= "connectiontype";
        public static final String COLOUMN_USER_PASSWORDCHANGED		= "passwordchanged";

        // SOURCE ACCOUNT

        public static final String TABLE_SOURCEACCOUNT_NAME = "sourceaccount";

        public static final String COLOUMN_SOURCEACCOUNT_ID = "id";
        public static final String COLOUMN_SOURCEACCOUNT_INDEX = "index";
        public static final String COLOUMN_SOURCEACCOUNT_NUMBER = "accountnumber";

        // CATEGORY

        public static final String TABLE_CATEGORY_NAME = "category";

        public static final String COLOUMN_CATEGORY_ID = "id";
        public static final String COLOUMN_CATEGORY_NAME = "name";
        public static final String COLOUMN_CATEGORY_TYPE = "type";

        // DESTINATION ACCOUNT

        public static final String TABLE_DESTINATIONACOUNT_NAME = "destinationaccount";

        public static final String COLOUMN_DESTINATIONACCOUNT_ID = "id";
        public static final String COLOUMN_DESTINATIONACCOUNT_NAME = "accountnumber";
        public static final String COLOUMN_DESTINATIONACCOUNT_HOLDER = "accountholder";
        public static final String COLOUMN_DESTINATIONACCOUNT_BANKCODE = "bankcode";

        // BANK

        public static final String TABLE_BANK_NAME = "bank";

        public static final String COLOUMN_BANK_ID = "id";
        public static final String COLOUMN_BANK_NAME = "bankname";
        public static final String COLOUMN_BANK_CODE = "bankcode";
        public static final String COLOUMN_BANK_CATEGORY = "category";
        public static final String COLOUMN_BANK_INDEX = "index";
        public static final String COLOUMN_BANK_STATE = "state";

        // PURCHASE

        public static final String TABLE_PURCHASE_NAME = "purchase";

        public static final String COLOUMN_PURCHASE_ID = "id";
        public static final String COLOUMN_PURCHASE_NUMBER = "customernumber";
        public static final String COLOUMN_PURCHASE_HOLDER = "customername";
        public static final String COLOUMN_PURCHASE_BILLER = "billercode";

        // NOMINAL

        public static final String TABLE_NOMINAL_NAME = "nominal";

        public static final String COLOUMN_NOMINAL_ID = "id";
        public static final String COLOUMN_NOMINAL_CODE = "billercode";
        public static final String COLOUMN_NOMINAL_INDEX = "index";
        public static final String COLOUMN_NOMINAL_VALUE = "nominalvalue";
        public static final String COLOUMN_NOMINAL_STATE = "state";

        // PAYMENT

        public static final String TABLE_PAYMENT_NAME = "payment";

        public static final String COLOUMN_PAYMENT_ID = "id";
        public static final String COLOUMN_PAYMENT_NUMBER = "customernumber";
        public static final String COLOUMN_PAYMENT_HOLDER = "customername";
        public static final String COLOUMN_PAYMENT_BILLER = "billercode";

        // BILLER

        public static final String TABLE_BILLER_NAME  = "biller";

        public static final String COLOUMN_BILLER_ID = "id";
        public static final String COLOUMN_BILLER_NAME = "billername";
        public static final String COLOUMN_BILLER_CODE = "billercode";
        public static final String COLOUMN_BILLER_CATEGORY = "category";
        public static final String COLOUMN_BILLER_INDEX  = "index";
        public static final String COLOUMN_BILLER_STATE = "state";

        // MENU

        public static final String TABLE_MENU_NAME = "menu";

        public static final String COLOUMN_MENU_ID = "id";
        public static final String COLOUMN_MENU_NAME = "name";
        public static final String COLOUMN_MENU_STATE = "state";

        // KEY

        public static final String TABLE_KEY_NAME = "key";

        public static final String COLOUMN_KEY_ID = "id";
        public static final String COLOUMN_KEY_VALUE = "value";
        public static final String COLOUMN_KEY_INDEX = "index";


    // CREATE TABLE

    public static final String CREATE_TABLE_USER =
            "create table " + TABLE_USER_NAME
                    + "("
                    + COLOUMN_USER_ID + " integer primary key, "
                    + COLOUMN_USER_PASSWORD + " text not null, "
                    + COLOUMN_USER_CONNECTIONTYPE + " text not null,"
                    + COLOUMN_USER_PASSWORDCHANGED + " boolean not null, "
                    + COLOUMN_USER_SMSCOMPATIBILITY + "boolean not null"
                    + ");";

    public static final String CREATE_TABLE_SOURCEACCOUNT =
            "create table " + TABLE_SOURCEACCOUNT_NAME
                    + "("
                    + COLOUMN_SOURCEACCOUNT_ID + " integer primary key autoincrement , "
                    + COLOUMN_SOURCEACCOUNT_INDEX + " integer not null,"
                    + COLOUMN_SOURCEACCOUNT_NUMBER + " text not null "
                    + ");";

    public static final String CREATE_TABLE_CATEGORY =
            "create table " + TABLE_CATEGORY_NAME
                    + "("
                    + COLOUMN_CATEGORY_ID + " integer primary key autoincrement, "
                    + COLOUMN_CATEGORY_NAME + " text not null, "
                    + COLOUMN_CATEGORY_TYPE + " text not null "
                    + ");";

    public static final String CREATE_TABLE_DESTINATIONACCOUNT =
            "create table " + TABLE_DESTINATIONACOUNT_NAME
                    + "("
                    + COLOUMN_DESTINATIONACCOUNT_ID + " integer primary key autoincrement, "
                    + COLOUMN_DESTINATIONACCOUNT_BANKCODE + " text not null, "
                    + COLOUMN_DESTINATIONACCOUNT_NAME + " text not null, "
                    + COLOUMN_DESTINATIONACCOUNT_HOLDER + " text not null"
                    + ");";

    public static final String CREATE_TABLE_BANK =
        "create table " + TABLE_BANK_NAME
        + "("
            + COLOUMN_BANK_ID + " integer primary key autoincrement, "
            + COLOUMN_BANK_CODE + " text not null, "
            + COLOUMN_BANK_NAME + " text not null,"
            + COLOUMN_BANK_CATEGORY + " text not null, "
            + COLOUMN_BANK_INDEX + " integer not null,"
            + COLOUMN_BANK_STATE + " boolean not null"
        + ");";

    public static final String CREATE_TABLE_PURCHASE =
            "create table " + TABLE_PURCHASE_NAME
                    + "("
                    + COLOUMN_PURCHASE_ID + " integer primary key autoincrement, "
                    + COLOUMN_PURCHASE_NUMBER + " text not null, "
                    + COLOUMN_PURCHASE_HOLDER + " text not null,"
                    + COLOUMN_PURCHASE_BILLER + " text not null "
                    + ");";

    public static final String CREATE_TABLE_NOMINAL =
            "create table " + TABLE_NOMINAL_NAME
                    + "("
                    + COLOUMN_NOMINAL_ID + " integer primary key autoincrement, "
                    + COLOUMN_NOMINAL_CODE + " text not null, "
                    + COLOUMN_NOMINAL_VALUE + " text not null, "
                    + COLOUMN_NOMINAL_INDEX + " integer not null,"
                    + COLOUMN_NOMINAL_STATE + " boolean not null"
                    + ");";

    public static final String CREATE_TABLE_PAYMENT =
        "create table " + TABLE_PAYMENT_NAME
        + "("
            + COLOUMN_PAYMENT_ID + " integer primary key autoincrement, "
            + COLOUMN_PAYMENT_NUMBER + " text not null, "
            + COLOUMN_PAYMENT_HOLDER + " text not null,"
            + COLOUMN_PAYMENT_BILLER + " text not null "
        + ");";

    public static final String CREATE_TABLE_BILLER =
            "create table " + TABLE_BILLER_NAME
                    + "("
                    + COLOUMN_BILLER_ID + " integer primary key autoincrement, "
                    + COLOUMN_BILLER_CODE + " text not null, "
                    + COLOUMN_BILLER_NAME + " text not null,"
                    + COLOUMN_BILLER_CATEGORY + " text not null, "
                    + COLOUMN_BILLER_INDEX + " integer not null,"
                    + COLOUMN_BILLER_STATE + " boolean not null"
                    + ");";

    public static final String CREATE_TABLE_MENU =
            "create table " + TABLE_MENU_NAME
                    + "("
                    + COLOUMN_MENU_ID + " integer primary key autoincrement, "
                    + COLOUMN_MENU_NAME + " text not null, "
                    + COLOUMN_MENU_STATE + " boolean not null "
                    + ");";

    public static final String CREATE_TABLE_KEY =
            "create table " + TABLE_KEY_NAME
                    + "("
                    + COLOUMN_KEY_ID + " integer primary key autoincrement, "
                    + COLOUMN_KEY_VALUE + " text not null, "
                    + COLOUMN_KEY_INDEX + " text not null  "
                    + ");";


    // QUERY

    public static final String QUERY_CONDITION_AND = "and";
    public static final String QUERY_CONDIRION_OR = "or";
    public static final String QUERY_SORT_ASCENDING = "asc";
    public static final String QUERY_SORY_DESCENDING = "desc";

    // RESULT CODE

    public static final int RESULTCODE_DATABASE_POSITIVE		= 0;
    public static final int RESULTCODE_DATABASE_NEGATIVE		= 1;
    public static final int RESULTCODE_DATABASE_ERROR         = -1;

    // CONTENT

    public static final String VALUE_CATEGORY_TRANSFER = "Transfer";
    public static final String VALUE_CATEGORY_PURCHASE = "Purchase";
}