/**
 * 
 */
package io.driocc.devicedetector.client;

/**
 * @author kyon
 *
 */
public class MediaPlayer extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;
	protected static final String FIXTURE_FILE = "regexes/client/mediaplayers.yml";
    protected static final String PARSER = "mediaplayers";
    
    public MediaPlayer(){
    	super(PARSER, FIXTURE_FILE);		
    }
    public MediaPlayer(String type, String file){
    	super(type, file);
    }
}
