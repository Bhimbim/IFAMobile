package my.com.infoconnect.ifamobile.entity;

/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class QuestionnaireEntity
{
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    private int id;
    private String desc;

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}

