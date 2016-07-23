package my.com.infoconnect.ifamobile.service;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.database.Manager;
import my.com.infoconnect.ifamobile.database.Select;
import my.com.infoconnect.ifamobile.entity.QuestionnaireEntity;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class QuestionnaireService
{
    public List<QuestionnaireEntity> getAllQuestionnaire()	{
        Manager databaseManager = Manager.getInstance();
        Select selectIFA = new Select(databaseManager.openDatabase());

        Cursor cursorPoint = selectIFA.selectQuestionnaire(); // function to retrieve all values from a table - written in Mydatabase.java file
        List<QuestionnaireEntity> listQuestionnaire = new ArrayList<QuestionnaireEntity>();

        if (cursorPoint != null && cursorPoint.getCount() > 0){
            cursorPoint.moveToFirst();

            do {
                try {
                    QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
                    questionnaireEntity.setId(cursorPoint.getInt(0));
                    questionnaireEntity.setDesc(cursorPoint.getString(1));

                    listQuestionnaire.add(questionnaireEntity);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "error while find all getAllQuestionnaire : ", e);
                }
            } while (cursorPoint.moveToNext());
        }
        Log.d(getClass().getSimpleName(), "result find all getAllQuestionnaire : "+listQuestionnaire.toString());
        cursorPoint.close();
        databaseManager.closeDatabase();
        return listQuestionnaire;
    }
}

