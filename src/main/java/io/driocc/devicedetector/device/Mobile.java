/**
 * 
 */
package io.driocc.devicedetector.device;

import io.driocc.devicedetector.yaml.YamlParser;

/**
 * @author kyon
 *
 */
public class Mobile extends DeviceParserAbstract {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/device/mobiles.yml";
    
    private Mobile(){
    	super();
    	this.setType("Mobile");
    	this.setRegexes(YamlParser.get(FIXTURE_FILE));
    }
}
