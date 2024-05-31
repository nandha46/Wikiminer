package com.nandha.wiki.wikiminer;

import java.io.IOException;

import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemIdValue;
import org.wikidata.wdtk.datamodel.interfaces.MediaInfoDocument;
import org.wikidata.wdtk.datamodel.interfaces.Statement;
import org.wikidata.wdtk.datamodel.interfaces.Value;
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;

/**
*
*
* @author Nandhakumar Subramanian
* 
* @version 
*
* @since 
**/

public class OnlineMediaInfoExample {
	public static void main(String[] args) throws IOException, MediaWikiApiErrorException {
	//	ExampleHelpers.configureLogging();
		printDocumentation();

		WikibaseDataFetcher commonsDataFetcher = WikibaseDataFetcher.getWikimediaCommonsDataFetcher();
		WikibaseDataFetcher wikidataDataFetcher = WikibaseDataFetcher.getWikidataDataFetcher();

		System.out.println("*** Retrieving a media info document ...");
		MediaInfoDocument mediaInfoDocument = (MediaInfoDocument) commonsDataFetcher.getEntityDocumentByTitle("commonswiki", "File:Black hole - Messier 87 crop max res.jpg");

		// Print the English caption
		System.out.println("Caption: " + mediaInfoDocument.getLabels().get("en").getText());

		// Print the depict with labels from Wikidata:
		for (Statement statement : mediaInfoDocument.findStatementGroup("P180").getStatements()) {
			Value value = statement.getValue();
			if (value instanceof ItemIdValue) {
				ItemDocument depict = (ItemDocument) wikidataDataFetcher.getEntityDocument(((ItemIdValue) value).getId());
				System.out.println("Depict: " + depict.getLabels().get("en").getText() + "(" + depict.getEntityId().getIri() + ")");
			}
		}

		System.out.println("*** Done.");
	}

	/**
	 * Prints some basic documentation about this program.
	 */
	public static void printDocumentation() {
		System.out.println("********************************************************************");
		System.out.println("*** Wikidata Toolkit: MediaInfoDataExample");
		System.out.println("*** ");
		System.out.println("*** It does not download any dump files. See source code for details.");
		System.out.println("********************************************************************");
	}
}

