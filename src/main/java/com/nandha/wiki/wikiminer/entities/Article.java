package com.nandha.wiki.wikiminer.entities;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version
 *
 * @since
 **/

public class Article {

	private String item;
	private String itemLabel;

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the itemLabel
	 */
	public String getItemLabel() {
		return itemLabel;
	}

	/**
	 * @param itemLabel the itemLabel to set
	 */
	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	@Override
	public String toString() {
		return "Article [item=" + item + ", itemLabel=" + itemLabel + "]";
	}

}
