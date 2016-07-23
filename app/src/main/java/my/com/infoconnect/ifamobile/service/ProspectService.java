package my.com.infoconnect.ifamobile.service;

import android.database.Cursor;
import android.util.Log;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.database.Manager;
import my.com.infoconnect.ifamobile.database.Select;
import my.com.infoconnect.ifamobile.entity.ProspectEntity;
import my.com.infoconnect.ifamobile.entity.QuestionEntity;

/**
 * Created by ERIC ANG on 7/23/2016.
 */
public class ProspectService {

    public List<ProspectEntity> getAllProspect()	{
        Manager databaseManager = Manager.getInstance();
        Select selectIFA = new Select(databaseManager.openDatabase());

        Cursor cursorPoint = selectIFA.selectProspect(); // function to retrieve all values from a table - written in Mydatabase.java file
        List<ProspectEntity> listProspect = new ArrayList<ProspectEntity>();

        if (cursorPoint != null && cursorPoint.getCount() > 0){
            cursorPoint.moveToFirst();

            do {
                try {
                    ProspectEntity prospectEntity = new ProspectEntity();
                    prospectEntity.setId(cursorPoint.getInt(0));
                    prospectEntity.setName(cursorPoint.getString(1));
                    prospectEntity.setTitle(cursorPoint.getString(2));
                    prospectEntity.setBirthday(cursorPoint.getString(3));
                    prospectEntity.setGender(cursorPoint.getString(4));
                    prospectEntity.setAddress(cursorPoint.getString(5));
                    prospectEntity.setTelephoneNumber(cursorPoint.getString(6));
                    prospectEntity.setEmail(cursorPoint.getString(7));
                    prospectEntity.setUpdatedOn(cursorPoint.getString(8));
                    prospectEntity.setUpdatedBy(cursorPoint.getInt(9));
                    prospectEntity.setCreatedOn(cursorPoint.getString(10));
                    prospectEntity.setCreatedBy(cursorPoint.getInt(11));

                    listProspect.add(prospectEntity);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "error while find all getAllProspect : ", e);
                }
            } while (cursorPoint.moveToNext());
        }
        Log.d(getClass().getSimpleName(), "result find all getAllProspect : "+listProspect.toString());
        cursorPoint.close();
        databaseManager.closeDatabase();
        return listProspect;
    }
}
