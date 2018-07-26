/**
 * 
 */
package io.driocc.devicedetector;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.driocc.devicedetector.yaml.YamlParser;

/**
 * @author kyon
 *
 */
public class YamlParserTest {
	@Test
	public void test() throws Exception {
		String path = "regexes/device/cameras.yml";
		List<Map<String, Object>> list = YamlParser.get(path);
		for(Map<String, Object> m : list) {
			System.out.println(m);
		}
	}
}
