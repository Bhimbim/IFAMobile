package my.com.infoconnect.ifamobile.variable.constant;

/**
 * Created by emobilemac on 3/31/16.
 */
public class Database
{
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