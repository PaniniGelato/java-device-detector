/**
 * 
 */
package io.driocc.devicedetector.device;

import io.driocc.devicedetector.DetectResult;

/**
 * @author kyon
 *
 */
public class CarBrowser extends DeviceParserAbstract {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/device/car_browsers.yml";
    private static final String PARSER = "car browser";
	public CarBrowser(){
    	super(PARSER, FIXTURE_FILE);
    }
    public CarBrowser(String type, String file){
    	super(type, file);
    }
    public DetectResult parse(String userAgent) {
        if (this.preMatchOverall(userAgent)) {
            return null;
        }
        return super.parse(userAgent);
    }

}
