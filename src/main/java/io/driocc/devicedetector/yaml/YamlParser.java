/**
 * 
 */
package io.driocc.devicedetector.yaml;

import java.io.InputStream;
import java.util.LinkedList;
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
	private YamlParser() {}	
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> get(String yamlPath) {
		List<Map<String, Object>> regexes = null;
		try {
			if(CACHE.containsKey(yamlPath)) {
				regexes = CACHE.get(yamlPath);
			} else {
				Yaml yaml = new Yaml();
				InputStream is = YamlParser.class.getClassLoader().getResourceAsStream(yamlPath);
				//it is a LinkedHashMap
				Object obj = yaml.load(is);
				if(obj instanceof List){
					regexes = (List<Map<String, Object>>)obj;
				}else if(obj instanceof Map){
					regexes = new LinkedList<>();
					Map<String, Object> e = (Map<String, Object>)obj;
					regexes.add(e);
				}
				CACHE.put(yamlPath, regexes);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return regexes;
	}
}