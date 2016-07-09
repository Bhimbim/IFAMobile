package my.com.infoconnect.ifamobile.variable.object;

/**
 * Created by ibrahimaziztejokusumo on 2/16/16.
 */

public class Recipient
{
    // VARIABLE

    private int intID;
    private String stringName;
    private String stringProvince;
    private String stringCity;
    private String stringPostalCode;
    private String stringAddress;
    private String stringHint;
    private String stringLatitude;
    private String stringLongitude;
    private String stringTelephone;
    private String stringMobileTelephone;


    // CONSTRUCTOR

    public Recipient()
    {

    }


    // SETTER GETTER

    public int getIntID()
    {
        return intID;
    }

    public void setIntID(int intID)
    {
        this.intID = intID;
    }

    public int getStringID()
    {
        return intID;
    }

    public void setStringID(String stringID)
    {
        this.intID = Integer.parseInt(stringID);
    }

    public String getStringName()
    {
        return stringName;
    }

    public void setStringName(String stringName)
    {
        this.stringName = stringName;
    }

    public String getStringProvince()
    {
        return stringProvince;
    }

    public void setStringProvince(String stringProvince)
    {
        this.stringProvince = stringProvince;
    }

    public String getStringCity()
    {
        return stringCity;
    }

    public void setStringCity(String stringCity)
    {
        this.stringCity = stringCity;
    }

    public String getStringPostalCode()
    {
        return stringPostalCode;
    }

    public void setStringPostalCode(String stringPostalCode)
    {
        this.stringPostalCode = stringPostalCode;
    }

    public String getStringAddress()
    {
        return stringAddress;
    }

    public void setStringAddress(String stringAddress)
    {
        this.stringAddress = stringAddress;
    }

    public String getStringHint()
    {
        return stringHint;
    }

    public void setStringHint(String stringHint)
    {
        this.stringHint = stringHint;
    }

    public String getStringLatitude()
    {
        return stringLatitude;
    }

    public void setStringLatitude(String stringLatitude)
    {
        this.stringLatitude = stringLatitude;
    }

    public String getStringLongitude()
    {
        return stringLongitude;
    }

    public void setStringLongitude(String stringLongitude)
    {
        this.stringLongitude = stringLongitude;
    }

    public String getStringTelephone()
    {
        return stringTelephone;
    }

    public void setStringTelephone(String stringTelephone)
    {
        this.stringTelephone = stringTelephone;
    }

    public String getStringMobileTelephone()
    {
        return stringMobileTelephone;
    }

    public void setStringMobileTelephone(String stringMobileTelephone)
    {
        this.stringMobileTelephone = stringMobileTelephone;
    }
}