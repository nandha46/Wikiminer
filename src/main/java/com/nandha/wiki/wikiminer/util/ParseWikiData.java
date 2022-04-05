package com.nandha.wiki.wikiminer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nandha.wiki.wikiminer.App;
import com.nandha.wiki.wikiminer.entities.WikiData;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version
 *
 * @since
 **/

public class ParseWikiData {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParseWikiData.class);
	
	static void readFile() throws IOException {
		InputStream iStream = App.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(iStream);
		
		BufferedReader bReader = new BufferedReader(new FileReader(
				new File(props.getProperty("input.folder"),"Vidya Balan - Copy.json")));
		String jsonText = bReader.lines().collect(Collectors.joining());
		bReader.close();
		ObjectMapper om = new ObjectMapper();
		WikiData data = om.readValue(jsonText, WikiData.class);
		LOGGER.info("{}",data);
	}
	
	public static void main(String[] args) throws IOException {
		readFile();
	}
}
