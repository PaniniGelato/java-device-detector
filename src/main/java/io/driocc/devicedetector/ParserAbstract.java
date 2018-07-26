package io.driocc.devicedetector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;

import io.driocc.devicedetector.custom.VersionConsultant;
import io.driocc.devicedetector.utils.Utils;
import io.driocc.devicedetector.yaml.YamlParser;

public abstract class ParserAbstract implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String yaml;
	private List<Map<String, Object>> regexes;
	private VersionConsultant versionConsultant;
    public ParserAbstract(String type, String file) {
    	this.setType(type);
    	this.setYaml(file);
    	this.setRegexes(YamlParser.get(file));
    	this.versionConsultant = new VersionConsultant();
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
	 * @return the yaml
	 */
	public String getYaml() {
		return yaml;
	}
	/**
	 * @param yaml the yaml to set
	 */
	public void setYaml(String yaml) {
		this.yaml = yaml;
	}	
	/**
	 * @return the regexes
	 */
	public List<Map<String, Object>> getRegexes() {
		return regexes;
	}
	/**
	 * @param regexes the regexes to set
	 */
	public void setRegexes(List<Map<String, Object>> regexes) {
		this.regexes = regexes;
	}
	
	public List<String> matchUserAgent(String userAgent, String regex) {
		List<String> matchs = new ArrayList<String>();
		if(Utils.isEmpty(userAgent)) {
			return null;
		}
		String reg = "(?:^|[^A-Z0-9\\-_]|[^A-Z0-9\\-]_|sprd-)(?:" + regex + ")";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(userAgent);
		while(matcher.find()) {
			matchs.add(matcher.group());
		}
		return matchs;
	}
	
	/**
	 * 
	 * @param item
	 * @param matches
	 * @return
	 */
    protected String buildByMatch(String item, List<String> matches){
    	for(int i=1; i<=3; i++) {
			String str = "$" + i;
			int start = item.indexOf(str);
			if(start == -1) {
				continue;
			}
			String startStr = item.substring(0, start);
			String repl = "";
			if(i < (matches.size()+1)) {
				repl = matches.get(i-1);
			}
			item = item.replace(startStr + str, repl).trim();
		}
		return item;
    }
    
    /**
     * Builds the version with the given $versionString and $matches
     *
     * Example:
     * versionString = 'v$2'
     * matches = array('version_1_0_1', '1_0_1')
     * return value would be v1.0.1
     * @param versionString
     * @param matches
     * @return
     */
    protected String buildVersion(String versionString, List<String> matches) {
		String ver = buildByMatch(versionString, matches);
		ver = Utils.isEmpty(ver) ? "" : ver;
		Integer maxMinorParts = this.versionConsultant.getMaxMinorParts();
		if (maxMinorParts!=null && Utils.countChar(versionString, '.') > maxMinorParts) {
            String[] versionParts = versionString.split(".");
            List<String> newVersionPartsList = Arrays.asList(versionParts).subList(0, maxMinorParts + 1);
            ver = Joiner.on(".").join(newVersionPartsList);
        }
		return ver;
	}
    
    /**
     * Tests the useragent against a combination of all regexes
     *
     * All regexes returned by getRegexes() will be reversed and concated with '|'
     * Afterwards the big regex will be tested against the user agent
     *
     * Method can be used to speed up detections by making a big check before doing checks for every single regex
     * @param userAgent
     * @return
     */
	protected boolean preMatchOverall(String userAgent) {
		// TODO Auto-generated method stub
		return false;
	}

}
