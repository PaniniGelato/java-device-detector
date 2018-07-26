/**
 * 
 */
package io.driocc.devicedetector.custom;

import io.driocc.devicedetector.OperatingSystem;
import io.driocc.devicedetector.client.Browser;
import io.driocc.devicedetector.device.DeviceParserAbstract;
import io.driocc.devicedetector.utils.Utils;

/**
 * @author kyon
 *
 */
public class DetectConsultant {
	
	protected static boolean usesMobileBrowser(String clientType, String clientShortName){
		return "browser".equals(clientType) && Browser.isMobileOnlyBrowser(clientShortName);
	}

	public static boolean isMobile(Integer deviceType, String clientType, String clientShortName, String osShortName, Boolean isBot){
		// Mobile device types
		if (deviceType!=null) {
			return DeviceParserAbstract.isMobile(deviceType);
		}
		// Check for browsers available for mobile devices only
		if (usesMobileBrowser(clientType, clientShortName)) {
			return true;
		}
		return !isBot && !isDesktop(osShortName, clientType, clientShortName);
	}
	/**
	* Returns if the parsed UA was identified as desktop device
	* Desktop devices are all devices with an unknown type that are running a desktop os
	*
	* @return bool
	*/
	public static boolean isDesktop(String osShortName, String clientType, String clientShortName){
		if(Utils.isEmpty(osShortName)  || OperatingSystem.UNKNOWN.equals(osShortName))return false;
		// Check for browsers available for mobile devices only
		if (usesMobileBrowser(clientType, clientShortName)) {
			return false;
		}
		String decodedFamily = OperatingSystem.getOsFamily(osShortName);
		return OperatingSystem.DESKTOP_OS.contains(decodedFamily);
	}
}
