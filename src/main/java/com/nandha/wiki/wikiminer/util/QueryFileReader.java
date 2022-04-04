package com.nandha.wiki.wikiminer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nandha.wiki.wikiminer.entities.Article;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version
 *
 * @since
 **/

public class QueryFileReader {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueryFileReader.class);

	static String readFile() throws IOException {
		LOGGER.info("Reading input file");
		BufferedReader reader = new BufferedReader(
				new FileReader(new File("C:\\Users\\nandh\\eclipse-workspace\\Wiki crawler\\query.json")));
		String json = reader.lines().collect(Collectors.joining());
		reader.close();
		return json;
	}

	public static List<Article> mapJsonArray() throws IOException {
		ObjectMapper om = new ObjectMapper();
		LOGGER.info("Mapping read file to Json and then List");
		return om.readValue(readFile(), new TypeReference<List<Article>>() {
		});
	}
}
