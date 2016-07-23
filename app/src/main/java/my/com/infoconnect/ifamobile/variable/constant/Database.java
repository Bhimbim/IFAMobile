package my.com.infoconnect.ifamobile.variable.constant;

/**
 * Created by emobilemac on 3/31/16.
 */
public class Database
{
    //DATABASE

    public static final String DATABASE_NAME = "IFA_MOBILE";
    public static final int DATABASE_VERSION = 1;


    // SYNTAX

    public static final String compactTableQuestionnaire =
            "create table " + Database.ENTITY_QUESTIONNAIRE
                    + "("
                    + Database.COLUMN_QUESTIONNAIRE_ID + " integer primary key,"
                    + Database.COLUMN_QUESTIONNAIRE_DESCRIPTION + " text not null "
                    + ");";

    public static final String compactTableQuestion =
            "create table " + Database.ENTITY_QUESTION
                    + "("
                    + Database.COLUMN_QUESTION_ID + " integer primary key, "
                    + Database.COLUMN_QUESTION_QUESTIONNAIREID + " integer, "
                    + Database.COLUMN_QUESTION_QUESTION + " text not null "
                    + ");";

    public static final String compactTableOption =
            "create table " + Database.ENTITY_OPTION
                    + "("
                    + Database.COLUMN_OPTION_ID + " integer primary key, "
                    + Database.COLUMN_OPTION_QUESTIONNAIREID + " integer, "
                    + Database.COLUMN_OPTION_OPTION + " text not null "
                    + ");";

    public static final String compactTableProspect=
            "create table " + Database.ENTITY_PROSPECT
                    + "("
                    + Database.COLUMN_PROSPECT_ID + " integer primary key, "
                    + Database.COLUMN_PROSPECT_NAME  + " text, "
                    + Database.COLUMN_PROSPECT_TITLE + " text, "
                    + Database.COLUMN_PROSPECT_BIRTHDAY + " date, "
                    + Database.COLUMN_PROSPECT_GENDER + " text, "
                    + Database.COLUMN_PROSPECT_ADDRESS + " text, "
                    + Database.COLUMN_PROSPECT_TELEPHONENUMBER + " text, "
                    + Database.COLUMN_PROSPECT_EMAIL + " text, "
                    + Database.COLUMN_PROSPECT_UPDATEDON + " date, "
                    + Database.COLUMN_PROSPECT_UPDATEDBY + " int, "
                    + Database.COLUMN_PROSPECT_CREATEDON + " date, "
                    + Database.COLUMN_PROSPECT_CREATEDBY + " int "
                    + ");";


    // SYNTAX

    public static final String QUERY_CONDITION_AND = "and";
    public static final String QUERY_CONDIRION_OR = "or";
    public static final String QUERY_SORT_ASCENDING = "asc";
    public static final String QUERY_SORY_DESCENDING = "desc";

    // TABLE

        // AGENT
        public static final String ENTITY_AGENT 			= "User";

        public static final String COLUMN_AGENT_ID				= "id";
        public static final String COLUMN_AGENT_NAME 		= "name";
        public static final String COLUMN_AGENT_PASSWORD	= "password";
        public static final String COLUMN_AGENT_ADDRESS	= "address";
        public static final String COLUMN_AGENT_TELEPHONENUMBER		= "telephonenumber";
        public static final String COLUMN_AGENT_EMAIL		= "email";

        // QUESTIONNAIRE

        public static final String ENTITY_QUESTIONNAIRE  = "Questionnaire";

        public static final String COLUMN_QUESTIONNAIRE_ID  = "id";
        public static final String COLUMN_QUESTIONNAIRE_DESCRIPTION ="desc";
        public static final String COLUMN_QUESTIONNAIRE_STATE  = "state";

        // CATEGORY

        public static final String TABLE_CATEGORY_NAME = "category";

        public static final String COLOUMN_CATEGORY_ID = "id";
        public static final String COLOUMN_CATEGORY_NAME = "name";
        public static final String COLOUMN_CATEGORY_TYPE = "type";

        // QUESTION

        public static final String ENTITY_QUESTION = "Question";

        public static final String COLUMN_QUESTION_ID = "id";
        public static final String COLUMN_QUESTION_QUESTIONNAIREID = "questionnaireid";
        public static final String COLUMN_QUESTION_QUESTION = "question";
        public static final String COLUMN_QUESTION_STATE = "state";

        // OPTION
        public static final String ENTITY_OPTION = "Option";

        public static final String COLUMN_OPTION_ID = "id";
        public static final String COLUMN_OPTION_QUESTIONNAIREID = "questionnaireid";
        public static final String COLUMN_OPTION_OPTION = "option";
        public static final String COLUMN_OPTION_STATE = "state";


        // PROSPECT

        public static final String ENTITY_PROSPECT = "Prospect";

        public static final String COLUMN_PROSPECT_ID = "id";
        public static final String COLUMN_PROSPECT_NAME = "name";
        public static final String COLUMN_PROSPECT_TITLE = "title";
        public static final String COLUMN_PROSPECT_BIRTHDAY = "birthday";
        public static final String COLUMN_PROSPECT_GENDER = "gender";
        public static final String COLUMN_PROSPECT_STATE = "state";
        public static final String COLUMN_PROSPECT_ADDRESS = "address";
        public static final String COLUMN_PROSPECT_TELEPHONENUMBER = "telephonenumber";
        public static final String COLUMN_PROSPECT_EMAIL = "email";
        public static final String COLUMN_PROSPECT_CREATEDON = "createdon";
        public static final String COLUMN_PROSPECT_CREATEDBY = "createdby";
        public static final String COLUMN_PROSPECT_UPDATEDON = "updatedon";
        public static final String COLUMN_PROSPECT_UPDATEDBY = "updatedby";
}