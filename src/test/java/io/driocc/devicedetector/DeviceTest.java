/**
 * 
 */
package io.driocc.devicedetector;

import org.junit.Test;

import io.driocc.devicedetector.device.Mobile;

/**
 * @author kyon
 *
 */
public class DeviceTest {
	String ua = "Mozilla/5.0 (Linux; Android 8.0.0; G8342 Build/47.1.A.12.205) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.70 Mobile Safari/537.36";
	@Test
	public void test() {	
		DetectResult ret = new Mobile().parse(ua);
		if(ret!=null) {
			System.out.println(ret.getDevice() + "," + ret.getModel() + "," + ret.getBrand() + "," + ret.getBrandId());
		}
	}
}
