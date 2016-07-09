package my.com.infoconnect.ifamobile.variable.object;

import java.io.Serializable;

/**
 * Created by ibrahimaziztejokusumo on 2/16/16.
 */

public class Order implements Serializable
{
    // VARIABLE

    private int intID;
    private String stringState;
    private Sender objectSender;
    private Recipient objectRecipient;
    private Package objectPackage;


    // SETTER GETTER

    public int getIntID()
    {
        return intID;
    }

    public void setIntID(int intID)
    {
        this.intID = intID;
    }

    public Sender getObjectSender()
    {
        return objectSender;
    }

    public void setObjectSender(Sender objectSender)
    {
        this.objectSender = objectSender;
    }

    public Recipient getObjectRecipient()
    {
        return objectRecipient;
    }

    public void setObjectRecipient(Recipient objectRecipient)
    {
        this.objectRecipient = objectRecipient;
    }

    public Package getObjectPackage()
    {
        return objectPackage;
    }

    public void setObjectPackage(Package objectPackage)
    {
        this.objectPackage = objectPackage;
    }

    public String getStringState()
    {
        return stringState;
    }

    public void setStringState(String stringState)
    {
        this.stringState = stringState;
    }
}