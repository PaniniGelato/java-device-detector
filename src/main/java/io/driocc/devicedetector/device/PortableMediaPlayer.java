/**
 * 
 */
package io.driocc.devicedetector.device;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.yaml.YamlParser;

/**
 * @author kyon
 *
 */
public class PortableMediaPlayer extends DeviceParserAbstract {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/device/portable_media_player.yml";
    
    private PortableMediaPlayer(){
    	super();
    	this.setType("PortableMediaPlayer");
    	this.setRegexes(YamlParser.get(FIXTURE_FILE));
    }
    
    public DetectResult parse(String userAgent) {
        if (this.preMatchOverall(userAgent)) {
            return null;
        }
        return super.parse(userAgent);
    }

}
