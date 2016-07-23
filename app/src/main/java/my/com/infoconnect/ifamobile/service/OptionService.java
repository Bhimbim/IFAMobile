package my.com.infoconnect.ifamobile.service;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.database.Manager;
import my.com.infoconnect.ifamobile.database.Select;
import my.com.infoconnect.ifamobile.entity.OptionEntity;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class OptionService
{
    public List<OptionEntity> getAllOption()
    {
        Manager databaseManager = Manager.getInstance();
        Select selectIFA = new Select(databaseManager.openDatabase());

        Cursor cursorPoint = selectIFA.selectOption(); // function to retrieve all values from a table - written in Mydatabase.java file
        List<OptionEntity> listOption = new ArrayList<OptionEntity>();

        if (cursorPoint != null && cursorPoint.getCount() > 0){
            cursorPoint.moveToFirst();

            do {
                try {
                    OptionEntity optionEntity = new OptionEntity();
                    optionEntity.setId(cursorPoint.getInt(0));
                    optionEntity.setQuestionnaireId(cursorPoint.getInt(1));
                    optionEntity.setOption(cursorPoint.getString(2));

                    listOption.add(optionEntity);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "error while find all getAllOption : ", e);
                }
            } while (cursorPoint.moveToNext());
        }
        Log.d(getClass().getSimpleName(), "result find all getAllOption : "+listOption.toString());
        cursorPoint.close();
        databaseManager.closeDatabase();
        return listOption;
    }
}

