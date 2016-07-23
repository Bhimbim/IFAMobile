package my.com.infoconnect.ifamobile.entity;

import java.sql.Date;

/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class ProspectEntity
{
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUpdatedOn()
    {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn)
    {
        this.updatedOn = updatedOn;
    }

    public int getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public String getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(String createdOn)
    {
        this.createdOn = createdOn;
    }

    public int getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(int createdBy)
    {
        this.createdBy = createdBy;
    }

    private int id;
    private String name;
    private String title;
    private String birthday;
    private String gender;
    private String address;
    private String telephoneNumber;
    private String email;
    private String updatedOn;
    private int updatedBy;
    private String createdOn;
    private int createdBy;
}
