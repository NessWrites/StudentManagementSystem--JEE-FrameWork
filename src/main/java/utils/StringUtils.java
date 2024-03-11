/*
 * Author: NessWrites
 * ness4business@gmail.com
 * Student_Management_System String Messages
 * Islington College
 * AI-3
 * */

package utils;

public class StringUtils {
	
	//Start: DB Connection
	public static final String DRIVER_NAME= "com.mysql.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/student_management";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	//End : DB Connection
	
	
	//Start: Queries
	public static final String REGISTER_STUDENT_QUERY = "INSERT INTO student_info (firstname,lastname, birthday,gender,email,phoneNumber,subject,userName, password)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
	
	public static final String GET_ALL_STUDENT_INFO = "SELECT * FROM student_info WHERE username = ? AND password = ?";
	// End: Queries
	
	
	//Start: Validation Message
	public static final String FIRST_NAME = "Invalid first name format.";
	public static final String LAST_NAME = "Invalid last name format.";
	public static final String BIRTHDAY = "Invalid birthday format. Use YYYY-MM-DD.";
	public static final String GENDER ="Invalid gender format.";
	public static final String EMAIL = "Invalid email format";
	public static final String PHONE_NUMBER ="Invalid phone number format. Use 10 digits.";
	// public static final String subject (Subject is dropdown list)
	public static final String USER_NAME ="Invalid user name";
	public static final String PASSWORD = "Invalid password";
	
	
	
	
	//End: Validation Message
	
	// Start: Special Characters
	public static final String FIRST_NAME_REGEX = "[A-Za-z]+";
	public static final String LAST_NAME_REGEX = "[A-Za-z]+";
	public static final String BIRTHDAY_REGEX = "\\d{4}-\\d{2}-\\d{2}";
	public static final String GENDER_REGEX = "[MF]";
	public static final String EMAIL_REGEX = "[a-zA-Z0-9_&-.]+[@][.][a-z]{2,3}";
	public static final String PHONE_NUMBER_REGEX ="[89]\\d{9}" ;
	public static final String USER_NAME_REGEX = "\\w"; 
	public static final String PASSWORD_REGEX ="[a-zA-Z0-9_$&*@]+";
	
	
	
	
	// End :Special Characters
	
	
	/*
	REGEX [REGULAR EXPRESSIONS]
	
	Used for pattern matching or String
	[abc]  => a, b, c
	[^abc] => any character except a, b, c
	[a-z] => a to z
	[A-Z] => A to Z
	[a-z A-Z] => a to z , A to Z
	[0-9] => 0 to 9
	
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	[]? =>   occurs 0 or 1 time
	[]+ =>   occurs 1 or more times
	[]* =>   occurs 0 or more time
	[]{n} => occurs n time
	[]{n,} =>occurs n or more times
	[]{y,z} => occurs atleast y times, but less than a z times
	
	
	Regex           MetaCharacters
	\d				[0-9]
	\D				[^0-9] 
	\w				[a-z A-Z_0-9]
	\W				[^\w]
	
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	(escape character) "\" tells computer to treat following SPECIAL characters as search characters for '+' '.'
	\. ==> match . in a character
	.\. ==> match . in a character and a character before that... selects  "p." from "stop."
	\s ==> match any form of white space
	\S ==> match other than white space. can also be given by [^\s]
	
	-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Escape Sequence in Java
	-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	Sequence		Description
	\t				Insert a tab in the text at this point.
	\b				Insert a backspace in the text at this point.
	\n				Insert a newline in the text at this point.
	\r				Insert a carriage return in the text at this point.
	\f				Insert a form feed in the text at this point.
	\'				Insert a single quote character in the text at this point.
	\"				Insert a double quote character in the text at this point.
	\\				Insert a backslash character in the text at this point.

	
	
	*/
	
}
