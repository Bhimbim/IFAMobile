package my.com.infoconnect.ifamobile.variable.constant;


import java.util.ArrayList;

/**
 * Created by ibrahimaziztejokusumo on 5/3/16.
 */

public class Dummy
{
    // SENDER

    public static final String[] DUMMY_SENDER_ITEM1 =
    {
        "1",
        "Alexander Hariyanto",
        "DKI Jakarta",
        "Central Jakarta",
        "10410",
        "Ruko Atrium Complex block A number 7 135th Senen Raya St.",
        "Between Lumire Hotel and Oasis Amir Hotel, behind Cowell Tower",
        "-6.175056",
        "106.839809",
        "021 1234567",
        "1234567890"
    };

    public static final String[] DUMMY_SENDER_ITEM2 =
    {
        "2",
        "A Teddy Tjandra",
        "Tangerang",
        "Banten",
        "10123",
        "Bumi Serpong Damai, block B number 8 11th Damai St.",
        "Behind Pasar Rakyat",
        "-6.29767",
        "106.66371",
        "021 2345678",
        "2345678901"
    };

    public static final String[] DUMMY_SENDER_ITEM3 =
    {
        "3",
        "Meliesa Soedjito",
        "DKI Jakarta",
        "Jakarta Timur",
        "10321",
        "Rawamangun, block C number 9 12th Timur St.",
        "Near Tebet",
        "-6.19760",
        "106.87979",
        "021 3456789",
        "3456789012"
    };

    public static final ArrayList<String[]> DUMMY_LIST_SENDER = new ArrayList<String[]>()
    {{
        add(DUMMY_SENDER_ITEM1);
        add(DUMMY_SENDER_ITEM2);
        add(DUMMY_SENDER_ITEM3);
    }};


    // RECIPIENT

    public static final String[] DUMMY_RECIPIENT_ITEM1 =
    {
        "1",
        "Meliesa Soedjito",
        "DKI Jakarta",
        "Jakarta Timur",
        "10321",
        "Rawamangun, block C number 9 12th Timur St.",
        "Near Tebet",
        "-6.19760",
        "106.87979",
        "021 3456789",
        "3456789012"
    };

    public static final String[] DUMMY_RECIPIENT_ITEM2 =
    {
        "2",
        "A Teddy Tjandra",
        "Tangerang",
        "Banten",
        "10123",
        "Bumi Serpong Damai, block B number 8 11th Damai St.",
        "Behind Pasar Rakyat",
        "-6.29767",
        "106.66371",
        "021 2345678",
        "2345678901"
    };

    public static final String[] DUMMY_RECIPIENT_ITEM3 =
    {
        "3",
        "Alexander Hariyanto",
        "DKI Jakarta",
        "Central Jakarta",
        "10410",
        "Ruko Atrium Complex block A number 7 135th Senen Raya St.",
        "Between Lumire Hotel and Oasis Amir Hotel, behind Cowell Tower",
        "-6.175056",
        "106.839809",
        "021 1234567",
        "1234567890"
    };

    public static final ArrayList<String[]> DUMMY_LIST_RECIPIENT = new ArrayList<String[]>()
    {{
        add(DUMMY_RECIPIENT_ITEM1);
        add(DUMMY_RECIPIENT_ITEM2);
        add(DUMMY_RECIPIENT_ITEM3);
    }};


    // PACKAGE

    public static final String[] DUMMY_PACKAGE_ITEM1 =
    {
        "1",
        "Baju",
        Transaction.PACKAGE_SERVICETYPE_YES,
        Transaction.PACKAGE_PACKAGETYPE_PACKAGE,
        "1",
        "0",
        "0",
        "0",
        "Jangan basah",
        "Boleh ditumpuk",
        "30000"
    };

    public static final String[] DUMMY_PACKAGE_ITEM2 =
    {
        "2",
        "Berkas",
        Transaction.PACKAGE_SERVICETYPE_SS,
        Transaction.PACKAGE_PACKAGETYPE_DOCUMENT,
        "1",
        "0",
        "0",
        "0",
        "Jangan basah, jangan lecek",
        "Boleh ditumpuk",
        "25000"
    };

    public static final String[] DUMMY_PACKAGE_ITEM3 =
    {
        "3",
        "Bingkisan lebaran",
        Transaction.PACKAGE_SERVICETYPE_REG,
        Transaction.PACKAGE_PACKAGETYPE_PARCEL,
        "5",
        "0",
        "0",
        "0",
        "Jangan ditumpuk",
        "Isinya makanan",
        "150000",
    };

    public static final ArrayList<String[]> DUMMY_LIST_PACKAGE = new ArrayList<String[]>()
    {{
        add(DUMMY_PACKAGE_ITEM1);
        add(DUMMY_PACKAGE_ITEM2);
        add(DUMMY_PACKAGE_ITEM3);
    }};
}
