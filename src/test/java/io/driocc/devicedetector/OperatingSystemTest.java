/**
 * 
 */
package io.driocc.devicedetector;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author kyon
 *
 */
public class OperatingSystemTest {

	@Test
	public void test() {
		String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
		OperatingSystem os = OperatingSystem.getInstance();
		DetectResult ret = os.parse(ua);
		Assert.assertEquals("gg", "10", ret.getVersion());
	}
}
