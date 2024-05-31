package com.nandha.wiki.wikiminer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nandha.wiki.wikiminer.App;
import com.nandha.wiki.wikiminer.entities.PageData;
import com.nandha.wiki.wikiminer.entities.People;
import com.nandha.wiki.wikiminer.entities.WikiData;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version 0.0.2
 *
 * @since 6 Apr 2022
 **/

public class ParseWikiData {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParseWikiData.class);

	static void readFile() throws IOException {
		InputStream iStream = App.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(iStream);
		File folder = new File(props.getProperty("input.folder"));
		if (folder.isDirectory()) {
			File[] jsonFiles = folder.listFiles();
			List<File> jsonList = Arrays.asList(jsonFiles);
			jsonList.forEach(file -> {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String json = reader.lines().collect(Collectors.joining());
					reader.close();
					WikiData data = new ObjectMapper().readValue(json, WikiData.class);
					PageData value = data.getEntities().entrySet().stream().findFirst().get().getValue();
					People people = new People();
					// Name
					people.setName(value.getLabels().get("en").getValue());
					// Description
					people.setDescription(value.getDescriptions().get("en").getValue());
					JsonNode node = value.getClaims();
					// Gender
					JsonNode p21 = node.get("P21");
					JsonNode mainsnak = p21.get(0).path("mainsnak");
					JsonNode datavalue = mainsnak.path("datavalue");
					JsonNode val = datavalue.path("value");
					String genderId = val.path("id").toPrettyString();

					switch (genderId) {
					case "Q6581097":
						people.setGender("Male");
						break;
					case "Q6581072":
						people.setGender("Female");
						break;
					case "Q1097630":
						people.setGender("Intersex");
						break;
					default:
						people.setGender(genderId);

					}

					// Image url
					String imageFileName = node.get("P18").get(0).path("mainsnak").path("datavalue").path("value")
							.toPrettyString();
					// Country of Citizenship
					// TODO check nullpointer for pagedata without country info
					String countryId = node.path("P27").get(0).path("mainsnak").path("datavalue").path("value")
							.path("id").toPrettyString();
					if (countryId.equals("Q668")) {
						people.setCountryOfCitizenship("India");
					} else {
						people.setCountryOfCitizenship(countryId);
					}

					// DateofBirth
					String dob = node.get("P569").get(0).path("mainsnak").path("datavalue").path("value").path("time")
							.toPrettyString();

				//	people.setBirthDate(LocalDate.parse(dob);
					// Native language

					LOGGER.info(people.getCountryOfCitizenship());

				} catch (FileNotFoundException e) {
					LOGGER.info("File not found: {}", file);
				} catch (IOException e) {
					LOGGER.error("Input file error");
				} catch (NullPointerException e) {
					LOGGER.error("Null pointer");
				}
			});

		}
	}

	public static void main(String[] args) throws IOException {
		readFile();
	}
}
