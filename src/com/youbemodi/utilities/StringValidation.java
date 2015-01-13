package com.youbemodi.utilities;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.youbemodi.constants.LoggerConstants;

public class StringValidation {
	static Logger logger = Logger.getLogger(StringValidation.class);
	private static final int VALID = 0;
	private static final int EMPTY = 1;
	private static final int NONALPHANUMERIC = 2;
	private static final int NONALPHABETIC = 3;
	private static final int NONNUMERIC = 4;
	private static final int CONTAINSSPACE = 5;
	
	private static final Pattern ALPHANUMERIC = Pattern.compile("[^a-zA-Z0-9]");
	private static final Pattern NUMERIC = Pattern.compile("[^0-9]");
	private static final Pattern ALPHABETIC = Pattern.compile("[^a-zA-Z]");
	private static final Pattern SPACE = Pattern.compile("\\s");
	
	/*
	 * This method checks the input string for various conditions like "nonEmpty", "alphaNumeric", "alphabetic",
	 * "numeric" and "containsNoSpace" depending the values of corresponding Boolean values that are True. 
	 * Returns validity values as follows:
	 * 0 - input string adheres to all the set boolean values
	 * 1 - input string doesn't adhere to non-emptiness
	 * 2 - input string is not alphanumeric
	 * 3 - input string is not alphabetic
	 * 4 - input string is not numeric
	 * 5 - input string contains whitespace(s)
	 */
	public static int stringCheck(String string, Boolean nonEmpty, Boolean alphaNumeric, Boolean alphabetic, Boolean numeric, Boolean containsNoSpace)
	{		
		/* Assume the string is valid and passes all tests */
		int validityValue = VALID;
		
		/* Check for emptiness. If empty return the invalid code 1 */
		if(nonEmpty && string.equalsIgnoreCase(LoggerConstants.EMPTY_STRING))
		{
			logger.warn(LoggerConstants.EMPTY_STRING_WARNING);
			validityValue = EMPTY;
			return validityValue;
		}
		
		/* Check for alphanumeric. If non-alphanumeric return the invalid code 2 */
		if(alphaNumeric && ALPHANUMERIC.matcher(string).find())
		{
			logger.warn(LoggerConstants.NON_ALPHANUMERIC_STRING_WARNING);
			validityValue = NONALPHANUMERIC;
			return validityValue;
		}
		
		/* Check for alphabetic. If non-alphabetic return the invalid code 3 */
		if(alphabetic && ALPHABETIC.matcher(string).find())
		{
			logger.warn(LoggerConstants.NON_ALPHABETIC_STRING_WARNING);
			validityValue = NONALPHABETIC;
			return validityValue;
		}
		
		/* Check for numeric. If non-numeric return the invalid code 4 */
		if(numeric && NUMERIC.matcher(string).find())
		{
			logger.warn(LoggerConstants.NON_NUMERIC_STRING_WARNING);
			validityValue = NONNUMERIC;
			return validityValue;
		}
		
		/* Check for space. If contains space, return the invalid code 5 */
		if(containsNoSpace && SPACE.matcher(string).find())
		{
			logger.warn(LoggerConstants.CONTAINS_SPACE);
			validityValue = CONTAINSSPACE;
			return validityValue;
		}
		
		return validityValue;
	}
}
