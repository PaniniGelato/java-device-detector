/**
 * 
 */
package io.driocc.devicedetector.client;

/**
 * @author kyon
 *
 */
public class PIM extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;
	protected static final String FIXTURE_FILE = "regexes/client/pim.yml";
    protected static final String PARSER = "pim";
    
    public PIM(){
    	super(PARSER, FIXTURE_FILE);
    }
    public PIM(String type, String file){
    	super(type, file);
    }
}
