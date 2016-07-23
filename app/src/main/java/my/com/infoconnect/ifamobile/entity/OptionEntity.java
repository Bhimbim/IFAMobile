package my.com.infoconnect.ifamobile.entity;

/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class OptionEntity
{
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuestionnaireId()
    {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId)
    {
        this.questionnaireId = questionnaireId;
    }

    public String getOption()
    {
        return option;
    }

    public void setOption(String option)
    {
        this.option = option;
    }

    private int id;
    private int questionnaireId;
    private String option;
}

