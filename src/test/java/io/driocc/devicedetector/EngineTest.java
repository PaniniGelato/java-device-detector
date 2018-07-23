/**
 * 
 */
package io.driocc.devicedetector;

import org.junit.Test;

import io.driocc.devicedetector.client.engine.Engine;

/**
 * @author kyon
 *
 */
public class EngineTest {
	@Test
	public void test() {
		String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
		Engine e = Engine.getInstance();
		DetectResult ret = e.parse(ua);
		System.out.println(ret.getEngine());
		System.out.println(ret.getEngineVersion());		
	}
}
