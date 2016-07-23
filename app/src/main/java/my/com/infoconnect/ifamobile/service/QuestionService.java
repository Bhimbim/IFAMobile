package my.com.infoconnect.ifamobile.service;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.database.Manager;
import my.com.infoconnect.ifamobile.database.Select;
import my.com.infoconnect.ifamobile.entity.QuestionEntity;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class QuestionService
{
    public List<QuestionEntity> getAllQuestion()	{
        Manager databaseManager = Manager.getInstance();
        Select selectIFA = new Select(databaseManager.openDatabase());

        Cursor cursorPoint = selectIFA.selectQuestion(); // function to retrieve all values from a table - written in Mydatabase.java file
        List<QuestionEntity> listQuestion = new ArrayList<QuestionEntity>();

        if (cursorPoint != null && cursorPoint.getCount() > 0){
            cursorPoint.moveToFirst();

            do {
                try {
                    QuestionEntity questionEntity = new QuestionEntity();
                    questionEntity.setId(cursorPoint.getInt(0));
                    questionEntity.setQuestionnaireId(cursorPoint.getInt(1));
                    questionEntity.setQuestion(cursorPoint.getString(2));

                    listQuestion.add(questionEntity);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "error while find all getAllQuestion : ", e);
                }
            } while (cursorPoint.moveToNext());
        }
        Log.d(getClass().getSimpleName(), "result find all getAllQuestion : "+listQuestion.toString());
        cursorPoint.close();
        databaseManager.closeDatabase();
        return listQuestion;
    }
}

