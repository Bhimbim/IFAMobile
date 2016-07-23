package my.com.infoconnect.ifamobile.database;

import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import my.com.infoconnect.ifamobile.entity.OptionEntity;
import my.com.infoconnect.ifamobile.entity.ProspectEntity;
import my.com.infoconnect.ifamobile.entity.QuestionEntity;
import my.com.infoconnect.ifamobile.entity.QuestionnaireEntity;
import my.com.infoconnect.ifamobile.service.OptionService;
import my.com.infoconnect.ifamobile.service.ProspectService;
import my.com.infoconnect.ifamobile.service.QuestionService;
import my.com.infoconnect.ifamobile.service.QuestionnaireService;
import my.com.infoconnect.ifamobile.variable.Public;
import my.com.infoconnect.ifamobile.variable.constant.Character;

/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class Initiate {

    public static void initiateQuestionnaire()
    {
        QuestionnaireService queService = new QuestionnaireService();
        List<QuestionnaireEntity> listQuestionnaire = queService.getAllQuestionnaire();

        for(int i=0;i<listQuestionnaire.size();i++)
        {
            QuestionnaireEntity entity = listQuestionnaire.get(i);
            Log.d("QuestionnaireEntity","Id :"+entity.getId());
            Log.d("QuestionnaireEntity","Desc :"+entity.getDesc());
        }
        if(listQuestionnaire.size() == 0)
        {
            int count = Public.QuestionnaireCount;
            for(int i = 0;i < count; i++)
            {
                QuestionnaireEntity entity = new QuestionnaireEntity();
                entity.setId(i+1);
                entity.setDesc("Questionnaire -"+(i+1));
                Insert.insertQuestionnaire(entity);
            }
        }
    }

    public static void initiateQuestion()
    {
        QuestionService questService = new QuestionService();
        List<QuestionEntity> listQuestion = questService.getAllQuestion();
        for(int i=0;i<listQuestion.size();i++)
        {
            QuestionEntity entity = listQuestion.get(i);
            Log.d("QuestionEntity","Id :"+entity.getId());
            Log.d("QuestionEntity","QuestionnaireId :"+entity.getQuestionnaireId());
            Log.d("QuestionEntity","Question :"+entity.getQuestion());
        }
        if(listQuestion.size() == 0)
        {
            for(int i = 0;i< Public.ArrayQuestion.length ;i++)
            {
                String[] arrQuestion = Public.ArrayQuestion[i].split(Character.CHARACTER_DATABASE_SEPARATOR);
                QuestionEntity entity = new QuestionEntity();
                entity.setQuestionnaireId(Integer.valueOf(arrQuestion[0]));
                entity.setQuestion(arrQuestion[1]);
                Insert.insertQuestion(entity);
            }
        }
    }

    public static void initiateOption()
    {
        OptionService optService = new OptionService();
        List<OptionEntity> listOption = optService.getAllOption();
        for(int i=0;i<listOption.size();i++)
        {
            OptionEntity entity = listOption.get(i);
            Log.d("OptionEntity","Id :"+entity.getId());
            Log.d("OptionEntity","QuestionnaireId :"+entity.getQuestionnaireId());
            Log.d("OptionEntity","Option :"+entity.getOption());
        }
        if(listOption.size() == 0)
        {
            for(int i = 0;i< Public.ArrayOption.length ;i++)
            {
                String[] arrOption = Public.ArrayOption[i].split(Character.CHARACTER_DATABASE_SEPARATOR);
                OptionEntity entity = new OptionEntity();
                entity.setQuestionnaireId(Integer.valueOf(arrOption[0]));
                entity.setOption(arrOption[1]);
                Insert.insertOption(entity);
            }
        }
    }

    public static void initiateProspect()
    {
        ProspectService proService = new ProspectService();
        List<ProspectEntity> listProspect = proService.getAllProspect();
        for(int i=0;i<listProspect.size();i++)
        {
            ProspectEntity entity = listProspect.get(i);
            Log.d("ProspectEntity","Id :"+entity.getId());
            Log.d("ProspectEntity","Name :"+entity.getName());
            Log.d("ProspectEntity","Title :"+entity.getTitle());
            Log.d("ProspectEntity","Birthday :"+entity.getBirthday());
            Log.d("ProspectEntity","Gender :"+entity.getGender());
            Log.d("ProspectEntity","Address :"+entity.getAddress());
            Log.d("ProspectEntity","Tel No :"+entity.getTelephoneNumber());
            Log.d("ProspectEntity","Email :"+entity.getEmail());
            Log.d("ProspectEntity","Updated On :"+entity.getUpdatedOn());
            Log.d("ProspectEntity","Updated By :"+entity.getUpdatedBy());
            Log.d("ProspectEntity","Created On :"+entity.getCreatedOn());
            Log.d("ProspectEntity","Created By :"+entity.getCreatedBy());
        }
        if(listProspect.size() == 0)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for(int i = 0;i< Public.ArrayProspect.length;i++)
            {
                String[] arrProspect = Public.ArrayProspect[i].split(Character.CHARACTER_DATABASE_SEPARATOR);
                ProspectEntity entity = new ProspectEntity();
                entity.setName(arrProspect[0]);
                entity.setTitle(arrProspect[1]);
                entity.setBirthday(arrProspect[2]);
                entity.setGender(arrProspect[3]);
                entity.setAddress(arrProspect[4]);
                entity.setTelephoneNumber(arrProspect[5]);
                entity.setEmail(arrProspect[6]);
                entity.setCreatedOn(sdf.format(new java.util.Date()));
                entity.setCreatedBy(1);
                entity.setUpdatedOn(sdf.format(new java.util.Date()));
                entity.setUpdatedBy(1);
                Insert.insertProspect(entity);
            }
        }
    }
}
