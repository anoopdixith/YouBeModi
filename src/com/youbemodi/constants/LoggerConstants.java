package com.youbemodi.constants;

public class LoggerConstants {
	/* Exceptions */
	public static final String IO_EXCEPTION = "IO Exception - File not found.";
	public static final String INVALID_FILE_FORMAT_EXCEPTION = "\"quality.properties\" File format invalid - Check the file descriptior.";
	public static final String EMPTY_FILE_EXCEPTION = "\"quality.properties\" file appears to be empty.";
	public static final String INVALID_QUALITY_NAME_EXCEPTION = "Invalid \"quality\" name - \"quality\" name cannot be empty or contain non-alphanumeric characters except underscores.";
	public static final String INCOMPLETE_FILE_EXCEPTION1 = "Incomplete \"quality.properties\" File - Check the \"total_number_of_such_property_instances\" value and after.";
	public static final String INCOMPLETE_FILE_EXCEPTION2 = "Incomplete \"quality.properties\" File - Check the \"number_of_elements\" value and after.";
	public static final String QUANTITY_INVALID_FORMAT_EXCETION = "\"quantity\" is invalid - remove any non numeric character if present.";
	
	/* Success */
	public static final String SUCCESS_MESSAGE = "Success.";
	
	/* File Descriptors */
	public static final String QUALITY_DESCRIPTOR = "quality";
	
	/* Utility Warnings */
	public static final String EMPTY_STRING_WARNING = "Empty string.";
	public static final String NON_ALPHANUMERIC_STRING_WARNING = "Non alphanumeric string.";
	public static final String NON_ALPHABETIC_STRING_WARNING = "Non alphabetic string.";
	public static final String NON_NUMERIC_STRING_WARNING = "Non numeric string.";
	public static final String CONTAINS_SPACE = "String contains space.";
	
	/* Separators used in properties files and elsewhere */
	public static final String COLON_SEPARATOR = ":";
	public static final String UNDERSCORE_SEPARATOR = "_";
	public static final String EMPTY_STRING = "";
	
}
