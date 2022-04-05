package com.nandha.wiki.wikiminer.entities;

import java.util.Date;
import java.util.HashMap;
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

	Map<String, PageData> entities = new HashMap<>();

	@Override
	public String toString() {
		return "WikiData [entities=" + entities + "]";
	}

}

class Labels {

	String language;
	String value;

	@Override
	public String toString() {
		return "Labels [language=" + language + ", value=" + value + "]";
	}

}

class Datavalue{
	long value;
	String type;
}

class Mainsnak {
	String snaktype;
	String propety;
	String hash;
	String datatype;
	Datavalue datavalue;
}

class ClaimObj {
	String id;
	String type;
	String rank;
	Mainsnak mainsnak;
	References[] references;
}

class References {
	String hash;
	Map<String, Mainsnak> snaks;
	@JsonProperty("snaks-order")
	String[] snaksOrder;
	
}

class Sitelinks {
	String site;
	String title;
	String[] badges;
}

class PageData {
	int pageid;
	boolean ns;
	String title;
	long lastrevid;
	Date modified;
	String type;
	String id;
	Map<String, Labels> labels;
	Map<String, Labels> descriptions;
	Map<String, Labels[]> aliases;
	Map<String, ClaimObj[]> claims;
	Map<String, Sitelinks> sitelinks;

	@Override
	public String toString() {
		return "PageData [pageid=" + pageid + ", ns=" + ns + ", title=" + title + ", lastrevid=" + lastrevid
				+ ", modified=" + modified + ", type=" + type + ", id=" + id + ", labels=" + labels + ", descriptions="
				+ descriptions + ", aliases=" + aliases + ", claims=" + claims + ", sitelinks=" + sitelinks + "]";
	}

}