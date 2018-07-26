/**
 * 
 */
package io.driocc.devicedetector.custom;

import io.driocc.devicedetector.DetectResult;

/**
 * @author kyon
 *
 */
public class CompositeDetectResult {
	private DetectResult bot;
	private DetectResult os;
	private DetectResult client;
	private DetectResult device;
	/**
	 * @return the bot
	 */
	public DetectResult getBot() {
		return bot;
	}
	/**
	 * @param bot the bot to set
	 */
	public void setBot(DetectResult bot) {
		this.bot = bot;
	}
	/**
	 * @return the os
	 */
	public DetectResult getOs() {
		return os;
	}
	/**
	 * @param os the os to set
	 */
	public void setOs(DetectResult os) {
		this.os = os;
	}
	/**
	 * @return the client
	 */
	public DetectResult getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(DetectResult client) {
		this.client = client;
	}
	/**
	 * @return the device
	 */
	public DetectResult getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(DetectResult device) {
		this.device = device;
	}
}
