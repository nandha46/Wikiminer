package com.nandha.wiki.wikiminer.entities;

import java.util.Date;
import java.util.Map;

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

class Labels {

	String language;
	String value;

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Labels [language=" + language + ", value=" + value + "]";
	}

}

class PageData {
	int pageid;
	boolean ns;
	String title;
	long lastrevid;
	Date modified;
	String type;
	String id;
	Map<String, Labels[]> labels;
	Map<String, Labels[]> descriptions;
	Map<String, Labels[]> aliases;
	Map<String, Object[]> claims;
	Map<String, Object[]> sitelinks;

	/**
	 * @return the pageid
	 */
	public int getPageid() {
		return pageid;
	}

	/**
	 * @param pageid the pageid to set
	 */
	public void setPageid(int pageid) {
		this.pageid = pageid;
	}

	/**
	 * @return the ns
	 */
	public boolean isNs() {
		return ns;
	}

	/**
	 * @param ns the ns to set
	 */
	public void setNs(boolean ns) {
		this.ns = ns;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the lastrevid
	 */
	public long getLastrevid() {
		return lastrevid;
	}

	/**
	 * @param lastrevid the lastrevid to set
	 */
	public void setLastrevid(long lastrevid) {
		this.lastrevid = lastrevid;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the labels
	 */
	public Map<String, Labels[]> getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(Map<String, Labels[]> labels) {
		this.labels = labels;
	}

	/**
	 * @return the descriptions
	 */
	public Map<String, Labels[]> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Map<String, Labels[]> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the aliases
	 */
	public Map<String, Labels[]> getAliases() {
		return aliases;
	}

	/**
	 * @param aliases the aliases to set
	 */
	public void setAliases(Map<String, Labels[]> aliases) {
		this.aliases = aliases;
	}

	/**
	 * @return the claims
	 */
	public Map<String, Object[]> getClaims() {
		return claims;
	}

	/**
	 * @param claims the claims to set
	 */
	public void setClaims(Map<String, Object[]> claims) {
		this.claims = claims;
	}

	/**
	 * @return the sitelinks
	 */
	public Map<String, Object[]> getSitelinks() {
		return sitelinks;
	}

	/**
	 * @param sitelinks the sitelinks to set
	 */
	public void setSitelinks(Map<String, Object[]> sitelinks) {
		this.sitelinks = sitelinks;
	}

	@Override
	public String toString() {
		return "PageData [pageid=" + pageid + ", ns=" + ns + ", title=" + title + ", lastrevid=" + lastrevid
				+ ", modified=" + modified + ", type=" + type + ", id=" + id + ", labels=" + labels + ", descriptions="
				+ descriptions + ", aliases=" + aliases + ", claims=" + claims + ", sitelinks=" + sitelinks + "]";
	}

}