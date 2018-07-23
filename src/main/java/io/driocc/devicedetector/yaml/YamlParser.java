/**
 * 
 */
package io.driocc.devicedetector.yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.yaml.snakeyaml.Yaml;


/**
 * @author kyon
 *
 */
public class YamlParser {
	
	private static Map<String, List<Map<String, Object>>> CACHE = new ConcurrentHashMap<>(); 
	
	public static List<Map<String, Object>> get(String yamlPath) {
		List<Map<String, Object>> regexes = null;
		try {
			if(CACHE.containsKey(yamlPath)) {
				regexes = CACHE.get(yamlPath);
			} else {
				Yaml yaml = new Yaml();
				InputStream is = YamlParser.class.getClassLoader().getResourceAsStream(yamlPath);
				//it is a LinkedHashMap
				regexes = yaml.load(is);
				CACHE.put(yamlPath, regexes);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return regexes;
	}
}