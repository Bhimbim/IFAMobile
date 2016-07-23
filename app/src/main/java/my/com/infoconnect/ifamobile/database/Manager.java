package my.com.infoconnect.ifamobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

import my.com.infoconnect.ifamobile.variable.constant.Database;
/**
 * Created by ERIC ANG on 7/22/2016.
 */
public class Manager
{
    private static Manager _instance;
    private DatabaseHelper helper;
    private SQLiteDatabase mDatabase;

    private AtomicInteger mOpenCounter = new AtomicInteger();

    private Manager(Context databaseContext)
    {
        helper = new DatabaseHelper(databaseContext);
    }

    public static void initDatabase(Context databaseContext)
    {
        if (_instance == null)
        {
            synchronized (databaseContext)
            {
                if (_instance == null)
                {
                    _instance = new Manager(databaseContext);
                    Log.v("DB", "Created Singleton instance");
                }
            }
        }
    }

    public static synchronized Manager getInstance()
    {
        if (_instance == null)
        {
            throw new IllegalStateException
                    (
                            Manager.class.getSimpleName()
                                    + " is not initialized, call initDatabase(..) method first."
                    );
        }

        return _instance;
    }

    public synchronized SQLiteDatabase openDatabase()
    {
        if(mOpenCounter.incrementAndGet() == 1)
        {
            // Opening new database
            mDatabase = helper.getWritableDatabase();
        }

        return mDatabase;
    }

    public synchronized void closeDatabase()
    {
        if(mOpenCounter.decrementAndGet() == 0)
        {
            // Closing database
            mDatabase.close();
        }
    }

    private class DatabaseHelper extends SQLiteOpenHelper
    {
        private static final String databaseName = Database.DATABASE_NAME;
        private static final int databaseVersion = Database.DATABASE_VERSION;

        DatabaseHelper(Context databaseContext)
        {
            super(databaseContext, databaseName, null, databaseVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            // TODO Auto-generated method stub
            db.execSQL(Database.compactTableQuestionnaire);
            db.execSQL(Database.compactTableQuestion);
            db.execSQL(Database.compactTableOption);
            db.execSQL(Database.compactTableProspect);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            // TODO Auto-generated method stub
        }
    }
}

