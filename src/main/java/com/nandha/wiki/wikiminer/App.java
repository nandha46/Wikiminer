package com.nandha.wiki.wikiminer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.nandha.wiki.wikiminer.entities.Article;
import com.nandha.wiki.wikiminer.util.JsonWriter;
import com.nandha.wiki.wikiminer.util.QueryFileReader;
import com.nandha.wiki.wikiminer.util.WikiCrawler;

/**
 * Simple Java Application to Scrape Wikipedia People data
 *
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		LOGGER.info("=========App Start=====");
		Profiler profiler = new Profiler(App.class.getName());
		profiler.setLogger(LOGGER);
		profiler.start("Crawl Session");
		List<Article> articles = QueryFileReader.mapJsonArray();
		LOGGER.info("Number of Articles to be Crawled: {}", articles.size());
		articles.forEach(x -> {
			try {
				BufferedWriter bwrite = JsonWriter.getWriter(x.getItemLabel());
				LOGGER.info("---Sleeping---");
				Thread.sleep(1000l);
				LOGGER.info("---wake up---");
				profiler.startNested("Http Request");
				bwrite.write(WikiCrawler.run(x.getItem()));
				profiler.stop().log();
				JsonWriter.closeWriter(bwrite);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				LOGGER.info("---Thread Interruption--");
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		});
			profiler.stop().log();
		LOGGER.info("=====App Stop=======");
	}
}
