package my.com.infoconnect.ifamobile.variable.object;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.Transaction;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;

/**
 * Created by ibrahimaziztejokusumo on 2/16/16.
 */

public class Package
{
    // VARIABLE


    private int intID;
    private String stringDescription;
    private String stringServiceType;
    private String stringPackageType;
    private int intWeight;
    private int intLong;
    private int intWidth;
    private int intTall;
    private String stringSpecificInstruction;
    private String stringNote;
    private int intPackageValue;


    // CONSTRUCTOR

    public Package()
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

    public String getStringDescription()
    {
        return stringDescription;
    }

    public void setStringDescription(String stringDescription)
    {
        this.stringDescription = stringDescription;
    }

    public String getStringServiceType()
    {
        return stringServiceType;
    }

    public void setStringServiceType(String stringServiceType)
    {
        this.stringServiceType = stringServiceType;
    }

    public String getStringPackageType()
    {
        return stringPackageType;
    }

    public int getIntPackageType(String stringResourceSize)
    {
        int intIcon;

        if (stringPackageType.equals(Transaction.PACKAGE_PACKAGETYPE_PACKAGE))
        {
            if (stringResourceSize.equals(UserInterface.IMAGE_RESOURCE_SMALL))
            {
                intIcon = R.drawable.icon_package_small;
            }
            else
            {
                intIcon = R.drawable.icon_package_large;
            }
        }
        else if (stringPackageType.equals(Transaction.PACKAGE_PACKAGETYPE_DOCUMENT))
        {
            if (stringResourceSize.equals(UserInterface.IMAGE_RESOURCE_SMALL))
            {
                intIcon = R.drawable.icon_document_small;
            }
            else
            {
                intIcon = R.drawable.icon_document_large;
            }
        }
        else
        {
            if (stringResourceSize.equals(UserInterface.IMAGE_RESOURCE_SMALL))
            {
                intIcon = R.drawable.icon_parcel_small;
            }
            else
            {
                intIcon = R.drawable.icon_parcel_large;
            }
        }

        return intIcon;
    }

    public void setStringPackageType(String stringPackageType)
    {
        this.stringPackageType = stringPackageType;
    }

    public int getIntWeight()
    {
        return intWeight;
    }

    public String getStringWeight()
    {
        return String.valueOf(intWeight);
    }

    public void setIntWeight(int intWeight)
    {
        this.intWeight = intWeight;
    }

    public void setStringWeight(String stringWeight)
    {
        this.intWeight = Integer.parseInt(stringWeight);
    }

    public int getIntLong()
    {
        return intLong;
    }

    public String getStringLong()
    {
        return String.valueOf(intLong);
    }

    public void setIntLong(int intLong)
    {
        this.intLong = intLong;
    }

    public void setStringLong(String stringLong)
    {
        this.intLong = Integer.parseInt(stringLong);
    }

    public int getIntWidth()
    {
        return intWidth;
    }

    public String getStringWidth()
    {
        return String.valueOf(intWidth);
    }

    public void setIntWidth(int intWidth)
    {
        this.intWidth = intWidth;
    }

    public void setStringWidth(String stringWidth)
    {
        this.intWidth = Integer.parseInt(stringWidth);
    }

    public int getIntTall()
    {
        return intTall;
    }

    public String getStringTall()
    {
        return String.valueOf(intTall);
    }

    public void setIntTall(int intTall)
    {
        this.intTall = intTall;
    }

    public void setStringTall(String stringTall)
    {
        this.intTall = Integer.parseInt(stringTall);
    }

    public String getStringSpecificInstruction()
    {
        return stringSpecificInstruction;
    }

    public void setStringSpecificInstruction(String stringSpecificInstruction)
    {
        this.stringSpecificInstruction = stringSpecificInstruction;
    }

    public String getStringNote()
    {
        return stringNote;
    }

    public void setStringNote(String stringNote)
    {
        this.stringNote = stringNote;
    }

    public int getIntPackageValue()
    {
        return intPackageValue;
    }

    public String getStringPackageValue()
    {
        return String.valueOf(intPackageValue);
    }

    public void setIntPackageValue(int intPackageValue)
    {
        this.intPackageValue = intPackageValue;
    }

    public void setStringPackageValue(String stringPackageValue)
    {
        this.intPackageValue = Integer.parseInt(stringPackageValue);
    }
}