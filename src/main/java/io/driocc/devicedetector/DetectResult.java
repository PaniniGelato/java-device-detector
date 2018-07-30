/**
 * 
 */
package io.driocc.devicedetector;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

/**
 * @author kyon
 *
 */
public class DetectResult implements Serializable {

	private static final long serialVersionUID = 1L;
	//for client
	private String type;
	private String name;
	private String shortName;
	private String version;
	private String platform;
	private String engine;
	private String engineVersion;
	//for device
	private String device;
	private Integer deviceType;
	private String brand;
	private String brandId;
	private String model;
	//for bot
	private boolean isBot;
	private BotDetail botDetail;
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
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}
	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}
	/**
	 * @return the engineVersion
	 */
	public String getEngineVersion() {
		return engineVersion;
	}
	/**
	 * @param engineVersion the engineVersion to set
	 */
	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}
	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the brandId
	 */
	public String getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the isBot
	 */
	public boolean isBot() {
		return isBot;
	}
	/**
	 * @param isBot the isBot to set
	 */
	public void setBot(boolean isBot) {
		this.isBot = isBot;
	}
	/**
	 * @return the botDetail
	 */
	public BotDetail getBotDetail() {
		return botDetail;
	}
	/**
	 * @param botDetail the botDetail to set
	 */
	public void setBotDetail(BotDetail botDetail) {
		this.botDetail = botDetail;
	}
	/**
	 * @return the deviceType
	 */
	public Integer getDeviceType() {
		return deviceType;
	}
	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("type", type)
				.add("name", name)
				.add("shortName", shortName)
				.add("version", version)
				.add("platform", platform)
				.add("engine", engine)
				.add("engineVersion", engineVersion)
				.add("device", device)
				.add("deviceType", deviceType)
				.add("brand", brand)
				.add("model", model)
				.add("isBot", isBot)
				.add("botDetail", botDetail)
				.omitNullValues().toString();
	}
}
