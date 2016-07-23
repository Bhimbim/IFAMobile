package my.com.infoconnect.ifamobile.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import my.com.infoconnect.ifamobile.variable.constant.Database;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class Select
{
    private SQLiteDatabase databaseSelect;

    public Select(SQLiteDatabase databaseSelect)
    {
        this.databaseSelect = databaseSelect;
    }

    public Cursor selectOption()	{
		/*String table, String[] columns, String selection, String[] selectionArgs,
		* String groupBy, String having, String orderBy
		*/
        return databaseSelect.query(
                Database.ENTITY_OPTION,
                new String[] {
                        Database.COLUMN_OPTION_ID, Database.COLUMN_OPTION_QUESTIONNAIREID, Database.COLUMN_OPTION_OPTION
                },
                null, null, null, null,
                Database.COLUMN_OPTION_ID + " asc"
        );
    }

    public Cursor selectQuestionnaire()	{
		/*String table, String[] columns, String selection, String[] selectionArgs,
		* String groupBy, String having, String orderBy
		*/
        return databaseSelect.query(
                Database.ENTITY_QUESTIONNAIRE,
                new String[] {
                        Database.COLUMN_QUESTIONNAIRE_ID, Database.COLUMN_QUESTIONNAIRE_DESCRIPTION
                },
                null, null, null, null,
                Database.COLUMN_QUESTIONNAIRE_ID + " asc"
        );
    }

    public Cursor selectQuestion()	{
		/*String table, String[] columns, String selection, String[] selectionArgs,
		* String groupBy, String having, String orderBy
		*/
        return databaseSelect.query(
                Database.ENTITY_QUESTION,
                new String[] {
                        Database.COLUMN_QUESTION_ID, Database.COLUMN_QUESTION_QUESTIONNAIREID,Database.COLUMN_QUESTION_QUESTION
                },
                null, null, null, null,
                Database.COLUMN_QUESTION_ID + " asc"
        );
    }

    public Cursor selectProspect()	{
		/*String table, String[] columns, String selection, String[] selectionArgs,
		* String groupBy, String having, String orderBy
		*/
        return databaseSelect.query(
                Database.ENTITY_PROSPECT,
                new String[] {
                        Database.COLUMN_PROSPECT_ID, Database.COLUMN_PROSPECT_NAME,Database.COLUMN_PROSPECT_TITLE,
                        Database.COLUMN_PROSPECT_BIRTHDAY,Database.COLUMN_PROSPECT_GENDER,Database.COLUMN_PROSPECT_ADDRESS,
                        Database.COLUMN_PROSPECT_TELEPHONENUMBER,Database.COLUMN_PROSPECT_EMAIL,Database.COLUMN_PROSPECT_UPDATEDON,
                        Database.COLUMN_PROSPECT_UPDATEDBY,Database.COLUMN_PROSPECT_CREATEDON,Database.COLUMN_PROSPECT_CREATEDBY
                },
                null, null, null, null,
                Database.COLUMN_QUESTION_ID + " asc"
        );
    }
}

