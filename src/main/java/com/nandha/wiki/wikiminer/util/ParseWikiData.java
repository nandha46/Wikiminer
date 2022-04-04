package com.nandha.wiki.wikiminer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		BufferedReader bReader = new BufferedReader(new FileReader(
				new File("C:\\Users\\nandh\\eclipse-workspace\\Wiki crawler\\Java App\\json files\\Vidya Balan.json")));
		String jsonText = bReader.lines().collect(Collectors.joining());
		bReader.close();
		ObjectMapper om = new ObjectMapper();
		WikiData data = om.readValue(jsonText, WikiData.class);
		
	}
	
	public static void main(String args[]) throws IOException {
		readFile();
	}
}
