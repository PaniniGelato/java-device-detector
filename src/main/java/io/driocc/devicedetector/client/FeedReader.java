/**
 * 
 */
package io.driocc.devicedetector.client;

/**
 * @author kyon
 *
 */
public class FeedReader extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;
	protected static final String FIXTURE_FILE = "regexes/client/feed_readers.yml";
    protected static final String PARSER = "feed reader";
    
    public FeedReader(){
    	super(PARSER, FIXTURE_FILE);		
    }
    public FeedReader(String type, String file){
    	super(type, file);
    }
}
