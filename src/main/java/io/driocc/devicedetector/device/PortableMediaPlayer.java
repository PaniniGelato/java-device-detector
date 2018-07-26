/**
 * 
 */
package io.driocc.devicedetector.device;

import io.driocc.devicedetector.DetectResult;

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
	private static final String PARSER = "PortableMediaPlayer";
    public PortableMediaPlayer(){
    	super(PARSER, FIXTURE_FILE);
    }
    public PortableMediaPlayer(String type, String file){
    	super(type, file);
    }

    public DetectResult parse(String userAgent) {
        if (this.preMatchOverall(userAgent)) {
            return null;
        }
        return super.parse(userAgent);
    }

}
