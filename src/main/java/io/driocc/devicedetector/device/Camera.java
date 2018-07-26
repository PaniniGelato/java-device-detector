/**
 * 
 */
package io.driocc.devicedetector.device;

import io.driocc.devicedetector.DetectResult;

/**
 * @author kyon
 *
 */
public class Camera extends DeviceParserAbstract {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/device/cameras.yml";
	private static final String PARSER = "camera";
    public Camera(){
    	super(PARSER, FIXTURE_FILE);
    }
    public Camera(String type, String file){
    	super(type, file);
    }
    public DetectResult parse(String userAgent) {
        if (this.preMatchOverall(userAgent)) {
            return null;
        }
        return super.parse(userAgent);
    }

}
