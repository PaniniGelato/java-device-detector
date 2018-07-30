/**
 * 
 */
package io.driocc.devicedetector;

import com.google.common.base.MoreObjects;

/**
 * @author kyon
 *
 */
public class BotDetail {
	private String name;
	private String category;
	private String url;
	private String producerName;
	private String producerUrl;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the producerName
	 */
	public String getProducerName() {
		return producerName;
	}
	/**
	 * @param producerName the producerName to set
	 */
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	/**
	 * @return the producerUrl
	 */
	public String getProducerUrl() {
		return producerUrl;
	}
	/**
	 * @param producerUrl the producerUrl to set
	 */
	public void setProducerUrl(String producerUrl) {
		this.producerUrl = producerUrl;
	}
	
	public String toString() {
		return MoreObjects.toStringHelper(this)
			    .add("name", name)
			    .add("category", category)
			    .add("url", url)
			    .add("producerName", producerName)
			    .add("producerUrl", producerUrl)
			    .omitNullValues().toString();
	}
}
