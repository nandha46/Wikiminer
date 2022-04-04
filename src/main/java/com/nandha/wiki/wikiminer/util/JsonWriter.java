package com.nandha.wiki.wikiminer.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version
 *
 * @since
 **/

public class JsonWriter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonWriter.class);

	private JsonWriter() {

	}

	public static BufferedWriter getWriter(String name) throws IOException {
		LOGGER.info("Creating writer Instance..");
		Path path = Paths.get("json files");
		try {
			Files.createDirectories(path);
		} catch (FileAlreadyExistsException e) {
			LOGGER.info("Folder already exists");
		}

		path = path.resolve(name + ".json");

		return new BufferedWriter(new FileWriter(path.toFile()));
	}

	public static void closeWriter(BufferedWriter bWriter) throws IOException {
		bWriter.close();
	}
}
