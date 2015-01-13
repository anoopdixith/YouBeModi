package com.youbemodi.io;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.youbemodi.constants.FilePaths;
import com.youbemodi.constants.LoggerConstants;

public class Boot {
	static Logger logger = Logger.getLogger(Boot.class);
	static String path = FilePaths.qualityFilePath;
	/* Use UTF-8 charset. This includes 17*pow(2,16) code space */
	static Charset encoding = Charset.defaultCharset();
	
	public static void main(String args[])
	{
		/* Start generating qualities from properties file */
		GenerateQuality generateQuality = new GenerateQuality();
		Boolean fileUploadStatus = generateQuality.readQualityFile(path,encoding);
		List<String> qualityFile = new ArrayList<String>();
		if(fileUploadStatus)
		{
			qualityFile = generateQuality.getAllLines();
		}
		Boolean fileParseStatus = generateQuality.parseQualityFile(qualityFile);
		if(fileParseStatus)
		{
			logger.info(LoggerConstants.SUCCESS_MESSAGE);
		}
		
	}
	
}
