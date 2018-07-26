/**
 * 
 */
package io.driocc.devicedetector;

import java.util.List;
import java.util.Map;

import io.driocc.devicedetector.yaml.YamlParser;

/**
 * @author kyon
 *
 */
public class Bot extends ParserAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String FIXTURE_FILE = "regexes/bots.yml";
    protected static final String PARSER = "bot";
    protected Boolean discardDetails = false;
    
    public Bot() {
    	super(PARSER,FIXTURE_FILE);
    }
    public Bot(String type, String file, boolean discardDetails) {
    	super(type, file);
    	this.discardDetails = discardDetails;
    }
    /**
     * Enables information discarding
     */
    public void setDiscardDetails(boolean discardDetails){
        this.discardDetails = discardDetails;
    }
	/**
	 * @return the discardDetails
	 */
	public boolean getDiscardDetails() {
		return discardDetails;
	}
    /**
     * Parses the current UA and checks whether it contains bot information
     *
     * @see bots.yml for list of detected bots
     *
     * Step 1: Build a big regex containing all regexes and match UA against it
     * -> If no matches found: return
     * -> Otherwise:
     * Step 2: Walk through the list of regexes in bots.yml and try to match every one
     * -> Return the matched data
     *
     * If $discardDetails is set to TRUE, the Step 2 will be skipped
     * $bot will be set to TRUE instead
     *
     * NOTE: Doing the big match before matching every single regex speeds up the detection
     */
    public DetectResult parse(String userAgent) {
    	DetectResult ret = null;
        if (this.preMatchOverall(userAgent)) {
            if (this.discardDetails) {
            	ret = new DetectResult();
            	ret.setBot(true);
            } else {
            	List<String> matches = null;
            	List<Map<String, Object>> list = this.getRegexes();
                for (Map<String, Object> ll : list) {
                    matches = this.matchUserAgent(userAgent, ll.get("regex").toString());
                    if (matches!=null && matches.size()>0) {
                    	ret = new DetectResult();
                    	ret.setBot(true);
                    	BotDetail bot = new BotDetail();
                    	bot.setName(ll.get("name").toString());
                    	bot.setCategory(ll.get("category")!=null?ll.get("category").toString():null);
                    	bot.setUrl(ll.get("url")!=null?ll.get("url").toString():null);
                    	if(ll.get("producer")!=null) {
                    		Map<String,String> p = (Map)ll.get("producer");
                    		bot.setProducerName(p.get("name")!=null?p.get("name"):null);
                    		bot.setProducerUrl(p.get("url")!=null?p.get("url"):null);
                    	}
                    	ret.setBotDetail(bot);
                        break;
                    }
                }
            }
        }
        return ret;
    }

}
