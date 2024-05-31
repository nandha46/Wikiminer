package com.nandha.wiki.wikiminer.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version 0.0.3
 *
 * @since 4 Apr 2022
 **/

public class WikiData {
	
	Map<String, PageData> entities;
	


	/**
	 * @return the entities
	 */
	public Map<String, PageData> getEntities() {
		return entities;
	}



	/**
	 * @param entities the entities to set
	 */
	public void setEntities(Map<String, PageData> entities) {
		this.entities = entities;
	}



	@Override
	public String toString() {
		return "WikiData [entities=" + entities + "]";
	}
	
	
}

class ClaimObj {
	String id;
	String type;
	String rank;
	Mainsnak mainsnak;
}

class Mainsnak {
	String snaktype;
	String propety;
	String hash;
	String datatype;
	Datavalue datavalue;
}

class References {
	String hash;
	Map<String, Mainsnak> snaks;
	@JsonProperty("snaks-order")
	String[] snaksOrder;

}

class Datavalue {
	long value;
	String type;
}

class Sitelinks {
	String site;
	String title;
	String[] badges;
}
