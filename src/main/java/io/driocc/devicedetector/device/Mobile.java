/**
 * 
 */
package io.driocc.devicedetector.device;

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
	private static final String PARSER = "mobile";
    public Mobile(){
    	super(PARSER, FIXTURE_FILE);
    }
    public Mobile(String type, String file){
    	super(type, file);
    }
}
