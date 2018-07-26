/**
 * 
 */
package io.driocc.devicedetector.client;

/**
 * @author kyon
 *
 */
public class MobileApp extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;
	protected static final String FIXTURE_FILE = "regexes/client/mobile_apps.yml";
    protected static final String PARSER = "mobile apps";
    
    public MobileApp(){
    	super(PARSER, FIXTURE_FILE);		
    }
    public MobileApp(String type, String file){
    	super(type, file);
    }
}
