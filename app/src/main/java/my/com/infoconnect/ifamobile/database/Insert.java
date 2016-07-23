package my.com.infoconnect.ifamobile.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import my.com.infoconnect.ifamobile.entity.OptionEntity;
import my.com.infoconnect.ifamobile.entity.ProspectEntity;
import my.com.infoconnect.ifamobile.entity.QuestionEntity;
import my.com.infoconnect.ifamobile.entity.QuestionnaireEntity;
import my.com.infoconnect.ifamobile.variable.constant.Database;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class Insert
{
    public static long insertQuestionnaire(QuestionnaireEntity questionnaireEntity)
    {
        SQLiteDatabase databaseInsert = Manager.getInstance().openDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(Database.COLUMN_QUESTIONNAIRE_ID, questionnaireEntity.getId());
        initialValues.put(Database.COLUMN_QUESTIONNAIRE_DESCRIPTION, questionnaireEntity.getDesc());

        long rowId = databaseInsert.insert(Database.ENTITY_QUESTIONNAIRE, null, initialValues);
        Manager.getInstance().closeDatabase();

        return rowId;
    }

    public static long insertQuestion(QuestionEntity questionEntity)
    {
        SQLiteDatabase databaseInsert = Manager.getInstance().openDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(Database.COLUMN_QUESTION_QUESTIONNAIREID, questionEntity.getQuestionnaireId());
        initialValues.put(Database.COLUMN_QUESTION_QUESTION, questionEntity.getQuestion());

        long rowId = databaseInsert.insert(Database.ENTITY_QUESTION, null, initialValues);
        Manager.getInstance().closeDatabase();

        return rowId;
    }

    public static long insertOption(OptionEntity optionEntity)
    {
        SQLiteDatabase databaseInsert = Manager.getInstance().openDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(Database.COLUMN_OPTION_QUESTIONNAIREID, optionEntity.getQuestionnaireId());
        initialValues.put(Database.COLUMN_OPTION_OPTION, optionEntity.getOption());

        long rowId = databaseInsert.insert(Database.ENTITY_OPTION, null, initialValues);
        Manager.getInstance().closeDatabase();

        return rowId;
    }

    public static long insertProspect(ProspectEntity prospectEntity)
    {
        SQLiteDatabase databaseInsert = Manager.getInstance().openDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(Database.COLUMN_PROSPECT_NAME, prospectEntity.getName());
        initialValues.put(Database.COLUMN_PROSPECT_TITLE, prospectEntity.getTitle());
        initialValues.put(Database.COLUMN_PROSPECT_BIRTHDAY, String.valueOf(prospectEntity.getBirthday()));
        initialValues.put(Database.COLUMN_PROSPECT_GENDER, prospectEntity.getGender());
        initialValues.put(Database.COLUMN_PROSPECT_ADDRESS, prospectEntity.getAddress());
        initialValues.put(Database.COLUMN_PROSPECT_TELEPHONENUMBER, prospectEntity.getTelephoneNumber());
        initialValues.put(Database.COLUMN_PROSPECT_EMAIL, prospectEntity.getEmail());
        initialValues.put(Database.COLUMN_PROSPECT_UPDATEDON, String.valueOf(prospectEntity.getUpdatedOn()));
        initialValues.put(Database.COLUMN_PROSPECT_UPDATEDBY, prospectEntity.getUpdatedBy());
        initialValues.put(Database.COLUMN_PROSPECT_CREATEDON, String.valueOf(prospectEntity.getCreatedOn()));
        initialValues.put(Database.COLUMN_PROSPECT_CREATEDBY, prospectEntity.getCreatedBy());

        long rowId = databaseInsert.insert(Database.ENTITY_PROSPECT, null, initialValues);
        Manager.getInstance().closeDatabase();

        return rowId;
    }
}

