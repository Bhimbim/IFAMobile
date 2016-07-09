package my.com.infoconnect.ifamobile.variable.object;

import id.co.jne.jnemobile.courier.variable.constant.Transaction;

/**
 * Created by ibrahimaziztejokusumo on 3/22/16.
 */
public class Syntax
{
    String stringConnectionType = "";
    String stringSMSTarget = "";
    String stringTransactionSection = "";
    String stringSyntax = "";

    public Syntax()
    {
        this.stringConnectionType = Transaction.CONNECTION_TYPE_GPRS;
    }

    public String getStringConnectionType()
    {
        return stringConnectionType;
    }

    public void setStringConnectionType(String stringConnectionType)
    {
        this.stringConnectionType = stringConnectionType;
    }

    public String getStringSMSTarget()
    {
        return stringSMSTarget;
    }

    public void setStringSMSTarget(String stringSMSTarget)
    {
        this.stringSMSTarget = stringSMSTarget;
    }

    public String getStringTransactionSection()
    {
        return stringTransactionSection;
    }

    public void setStringTransactionSection(String stringTransactionSection)
    {
        this.stringTransactionSection = stringTransactionSection;
    }

    public String getStringSyntax()
    {
        return stringSyntax;
    }

    public void setStringSyntax(String stringSyntax)
    {
        this.stringSyntax = stringSyntax;
    }
}
