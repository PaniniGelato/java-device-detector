/**
 * 
 */
package io.driocc.devicedetector.client;

/**
 * @author kyon
 *
 */
public class Library extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;

	protected static final String FIXTURE_FILE = "regexes/client/libraries.yml";
    protected static final String PARSER = "libraries";
    
    public Library(){
    	super(PARSER, FIXTURE_FILE);		
    }
    public Library(String type, String file){
    	super(type, file);
    }
}
