package com.youbemodi.io;

import org.apache.log4j.Logger;

import com.youbemodi.constants.LoggerConstants;
import com.youbemodi.constants.QualityFilePlaceholders;
import com.youbemodi.utilities.StringValidation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GenerateQuality {
	static Logger logger = Logger.getLogger(GenerateQuality.class);
	private List<String> allLines = new ArrayList<String>();

	public List<String> getAllLines() {
		return allLines;
	}

	public void setAllLines(List<String> allLines) {
		this.allLines = allLines;
	}

	/*
	 * This method reads the "properties.txt" file.
	 */
	Boolean readQualityFile(String path, Charset encoding) {
		logger.info("Path is " + path);
		Boolean readStatus = false;
		try {
			/* Using Non-Blocking IO (NIO) package for better file operations */
			setAllLines(Files.readAllLines(Paths.get(path), encoding));
		} catch (IOException ioException) {
			logger.error(LoggerConstants.IO_EXCEPTION);
			return readStatus;
		}
		readStatus = true;
		return readStatus;
	}

	/*
	 * This method parses the read properties file and generate the model
	 * variables.
	 */
	Boolean parseQualityFile(List<String> qualitiesList) {
		Boolean parseStatus = false;
		Iterator<String> qualityIterator = qualitiesList.iterator();
		if (qualityIterator.hasNext()) {
			StringBuilder qualityNameFormat = new StringBuilder(
					qualityIterator.next());
			String[] firstLine = qualityNameFormat.toString().split(
					LoggerConstants.COLON_SEPARATOR);
			if (!firstLine[QualityFilePlaceholders.formatDescriptorPositionNumber]
					.equalsIgnoreCase(LoggerConstants.QUALITY_DESCRIPTOR)) {
				logger.error(LoggerConstants.INVALID_FILE_FORMAT_EXCEPTION);
				return parseStatus;
			}

			StringBuilder qualityName = new StringBuilder(
					firstLine[QualityFilePlaceholders.qualityNamePositionNumber]);

			/* Validate the "qualityName" */
			if (!validateQualityName(qualityName.toString())) {
				return parseStatus;
			}
			logger.info("Quality name is \"" + qualityName + "\"");

			/*
			 * Get the number of "quality" objects to be generated.
			 */
			Long quantity = 0L;
			if (qualityIterator.hasNext()) {
				try {
					quantity = Long.parseLong(qualityIterator.next());
				} catch (NumberFormatException nfe) {
					logger.error(LoggerConstants.QUANTITY_INVALID_FORMAT_EXCETION);
					return parseStatus;
				}
				logger.info("Number of \"quality\" objects to be generated is "
						+ quantity.toString());
			} else {
				logger.error(LoggerConstants.INCOMPLETE_FILE_EXCEPTION1);
				return parseStatus;
			}

			/*
			 * Get the number of elements field from the quality.properties
			 * file.
			 */
			Integer numberOfElements = 0;
			if (qualityIterator.hasNext()) {
				try {
					numberOfElements = Integer.parseInt(qualityIterator.next());
				} catch (NumberFormatException nfe) {
					logger.error(LoggerConstants.QUANTITY_INVALID_FORMAT_EXCETION);
					return parseStatus;
				}
				logger.info("Number of \"quality\" elements is "
						+ numberOfElements.toString());
			} else {
				logger.error(LoggerConstants.INCOMPLETE_FILE_EXCEPTION2);
			}

			/*
			 * Now create a list of all the qualities.
			 */

		} else {
			logger.error(LoggerConstants.EMPTY_FILE_EXCEPTION);
			return parseStatus;
		}
		parseStatus = true;
		return parseStatus;
	}

	private Boolean validateQualityName(String qualityName) {
		Boolean returnValue = true;
		/*
		 * underscores are allowed in the "quality" name. Hence, for validate,
		 * underscores are temporarily replaced by empty char
		 */
		qualityName = qualityName.replace(
				LoggerConstants.UNDERSCORE_SEPARATOR.charAt(0), '\0');

		/* Check if the "quality" name is non empty and has no whitespace */
		if (StringValidation.stringCheck(qualityName, true, true, false, false,
				true) != 0) {
			logger.error(LoggerConstants.INVALID_QUALITY_NAME_EXCEPTION);
			returnValue = false;
			return returnValue;
		}

		return returnValue;
	}

}
