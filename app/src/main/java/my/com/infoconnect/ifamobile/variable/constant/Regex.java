package my.com.infoconnect.ifamobile.variable.constant;


// CLASS

public class Regex
{
	// IS

	public static final String isAlphabet = ".[a-zA-Z]*.";
	public static final String isAlphabetLower = ".[a-z]*.";
	public static final String isAlphabetUpper = ".[A-Z]*.";
	public static final String isNumeric = ".[0-9]*.";
	public static final String isTelephoneNumber = "^(\\+62|\\+0|0)[0-9]{5,12}$";
	public static final String isAlphaNumeric = ".[a-zA-Z0-9]*.";
	public static final String isName = ".[a-zA-Z0-9\\s]*.";
	public static final String isEmail ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// NOT 
	
	public static final String notAlphabet = ".^[a-zA-Z]*.";
	public static final String notAlphabetLower = ".^[a-z]*.";
	public static final String notAlphabetUpper = ".^[A-Z]*.";
	public static final String notNumeric = ".[^0-9]*.";
	public static final String notAlphaNumeric = ".^[a-zA-Z0-9]*.";
}