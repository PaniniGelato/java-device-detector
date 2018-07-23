/**
 * 
 */
package io.driocc.devicedetector;

import java.io.Serializable;

/**
 * @author kyon
 *
 */
public class DetectResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String shortName;
	private String version;
	private String platform;
	private String browser;
	private String browserEngine;
	private String browserEngineVersion;
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
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * @return the browserEngine
	 */
	public String getBrowserEngine() {
		return browserEngine;
	}
	/**
	 * @param browserEngine the browserEngine to set
	 */
	public void setBrowserEngine(String browserEngine) {
		this.browserEngine = browserEngine;
	}
	/**
	 * @return the browserEngineVersion
	 */
	public String getBrowserEngineVersion() {
		return browserEngineVersion;
	}
	/**
	 * @param browserEngineVersion the browserEngineVersion to set
	 */
	public void setBrowserEngineVersion(String browserEngineVersion) {
		this.browserEngineVersion = browserEngineVersion;
	}
	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}
	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}
}
