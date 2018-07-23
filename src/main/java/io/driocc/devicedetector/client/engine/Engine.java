/**
 * 
 */
package io.driocc.devicedetector.client.engine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.client.ClientParserAbstract;
import io.driocc.devicedetector.yaml.YamlParser;

/**
 * @author kyon
 *
 */
public class Engine extends ClientParserAbstract {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/client/browser_engine.yml";
    private Engine() {
    	super();
    	this.setType("browserengine");
    	this.setRegexes(YamlParser.get(FIXTURE_FILE));
    	
    }
	private static class LazyHolder {
        static final Engine INSTANCE = new Engine();
    }

    public static Engine getInstance() {
        return LazyHolder.INSTANCE;
    }
    /**
     * Known browser engines mapped to their internal short codes
     *
     * @var array
     */
    protected List<String> availableEngines = Arrays.asList(new String[] {
    		"WebKit",
            "Blink",
            "Trident",
            "Text-based",
            "Dillo",
            "iCab",
            "Elektra",
            "Presto",
            "Gecko",
            "KHTML",
            "NetFront",
            "Edge"	
    });
    /**
     * Returns list of all available browser engines
     * @return array
     */
    public List<String> getAvailableEngines(){
        return this.availableEngines;
    }
    public DetectResult parse(String userAgent){
    	List<String> matches = null;
    	Map<String, Object> thisRegex = null;
    	for (Map<String, Object> regex : this.getRegexes()) {
            matches = this.matchUserAgent(userAgent, regex.get("regex").toString());
            if (matches!=null && matches.size()>0) {
            	thisRegex = regex;
                break;
            }
        }
        if (matches==null || matches.size()<1) {
            return null;
        }
        String name  = this.buildByMatch(thisRegex.get("name").toString(), matches);
        for(String engine : this.getAvailableEngines()){
            if (engine.toLowerCase().equals(name.toLowerCase())) {
            	name = engine;
            }
        }
        String browserEngineVersion = buildEngineVersion(userAgent, name);
        DetectResult ret = new DetectResult();
        ret.setEngine(name);
        ret.setEngineVersion(browserEngineVersion);
		return ret;
    }    
    public String buildEngineVersion(String userAgent, String engine) {
    	if(engine==null || "".equals(engine)) {
    		return null;
    	}
    	String ret = null;
    	String reg = engine+"\\s*/?\\s*(((?=\\d+\\.\\d)\\d+[.\\d]*)|(.\\d{1,7}(?=(?:\\D|$))))";
    	Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(userAgent);
		if(matcher.find()){
			ret = matcher.group();
		}
    	return ret;
    }
}
