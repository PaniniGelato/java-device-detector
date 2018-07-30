/**
 * 
 */
package io.driocc.devicedetector.client;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.ParserAbstract;
import io.driocc.devicedetector.utils.Utils;

/**
 * @author kyon
 *
 */
public class ClientParserAbstract extends ParserAbstract{

	/**
	 * @param type
	 * @param file
	 */
	public ClientParserAbstract(String type, String file) {
		super(type, file);		
	}

	private static final long serialVersionUID = 1L;

	public DetectResult parse(String userAgent) {
		DetectResult ret = null;
        if (this.preMatchOverall(userAgent)) {
            for(Map<String,Object> regexObj : this.getRegexes()) {
                List<String> matches = this.matchUserAgent(userAgent, regexObj.get("regex").toString());
                if (matches!=null && matches.size()>0) {
                	ret = new DetectResult();
                	String name = buildByMatch(regexObj.get("name").toString(), matches);
                	String version = buildVersion(regexObj.get("version").toString(), matches);
                	ret.setType(this.getType());
                	ret.setName(name);
                	ret.setVersion(version);
                }
            }
        }
        return ret;
	}
	
	/**
     * Returns all names defined in the regexes
     *
     * Attention: This method might not return all names of detected clients
     *
     * @return array
     */
	public List<String> getAvailableClients(){
		List<Map<String,Object>> regexes = this.getRegexes();
        final List<String> nameList = new LinkedList<>();
        regexes.forEach(x->nameList.add(x.get("name").toString()));
        List<String> ret = nameList.stream().distinct().collect(Collectors.toList());
        ret.sort(Comparator.naturalOrder());
        return ret;
	}
	
	/**
	 * @param userAgent
	 * @param osRegex
	 * @return
	 */
	protected String buildVersionByCaptureGroup(String userAgent, Map<String, Object> osRegex) {
		String ret = null;
		Object versionRegex = osRegex.get("version");
		if(versionRegex!=null) {
			String versionStr = versionRegex.toString();
			if(versionStr.indexOf("$")>=0) {
				String groupStr = versionStr.replaceAll("\\$", "");
				if(Utils.isNumeric(groupStr)) {
					Integer cg = Integer.valueOf(groupStr);
					String regex = osRegex.get("regex").toString();
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(userAgent);
					if(matcher.find() && matcher.groupCount()>=cg) {
						ret = matcher.group(cg);
					}
				}else{
					ret = versionStr;
				}
			}else{
				ret = versionStr;
			}
		}
		return ret;
	}
}
