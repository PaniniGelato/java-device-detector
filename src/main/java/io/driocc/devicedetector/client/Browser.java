/**
 * 
 */
package io.driocc.devicedetector.client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.client.engine.Engine;
import io.driocc.devicedetector.yaml.YamlParser;


/**
 * @author kyon
 *
 */
public class Browser extends ClientParserAbstract {

	private static final long serialVersionUID = 1L;
	
	private static final String FIXTURE_FILE = "regexes/client/browsers.yml";
    private static final String PARSER = "browser";
    /**
     * Known browsers mapped to their internal short codes
     */
    private Map<String, String> availableBrowsers;
    /**
     * Browser families mapped to the short codes of the associated browsers
     */
    private Map<String, String[]> browserFamilies;
    /**
     * Browsers that are available for mobile devices only
     */
    private List<String> mobileOnlyBrowsers;
    private Browser(){
    	super();
		this.setType(PARSER);
		this.setYaml(FIXTURE_FILE);
		this.setRegexes(YamlParser.get(this.getYaml()));
    	availableBrowsers = new HashMap<>();
        availableBrowsers.put("36","360 Phone Browser");
        availableBrowsers.put("3B","360 Browser");
        availableBrowsers.put("AA","Avant Browser");
        availableBrowsers.put("AB","ABrowse");
        availableBrowsers.put("AF","ANT Fresco");
        availableBrowsers.put("AG","ANTGalio");
        availableBrowsers.put("AL","Aloha Browser");
        availableBrowsers.put("AM","Amaya");
        availableBrowsers.put("AO","Amigo");
        availableBrowsers.put("AN","Android Browser");
        availableBrowsers.put("AR","Arora");
        availableBrowsers.put("AV","Amiga Voyager");
        availableBrowsers.put("AW","Amiga Aweb");
        availableBrowsers.put("AT","Atomic Web Browser");
        availableBrowsers.put("BB","BlackBerry Browser");
        availableBrowsers.put("BD","Baidu Browser");
        availableBrowsers.put("BS","Baidu Spark");
        availableBrowsers.put("BE","Beonex");
        availableBrowsers.put("BJ","Bunjalloo");
        availableBrowsers.put("BL","B-Line");
        availableBrowsers.put("BR","Brave");
        availableBrowsers.put("BK","BriskBard");
        availableBrowsers.put("BX","BrowseX");
        availableBrowsers.put("CA","Camino");
        availableBrowsers.put("CC","Coc Coc");
        availableBrowsers.put("CD","Comodo Dragon");
        availableBrowsers.put("C1","Coast");
        availableBrowsers.put("CX","Charon");
        availableBrowsers.put("CF","Chrome Frame");
        availableBrowsers.put("CH","Chrome");
        availableBrowsers.put("CI","Chrome Mobile iOS");
        availableBrowsers.put("CK","Conkeror");
        availableBrowsers.put("CM","Chrome Mobile");
        availableBrowsers.put("CN","CoolNovo");
        availableBrowsers.put("CO","CometBird");
        availableBrowsers.put("CP","ChromePlus");
        availableBrowsers.put("CR","Chromium");
        availableBrowsers.put("CY","Cyberfox");
        availableBrowsers.put("CS","Cheshire");
        availableBrowsers.put("DB","dbrowser");
        availableBrowsers.put("DE","Deepnet Explorer");
        availableBrowsers.put("DF","Dolphin");
        availableBrowsers.put("DO","Dorado");
        availableBrowsers.put("DL","Dooble");
        availableBrowsers.put("DI","Dillo");
        availableBrowsers.put("EI","Epic");
        availableBrowsers.put("EL","Elinks");
        availableBrowsers.put("EB","Element Browser");
        availableBrowsers.put("EP","GNOME Web");
        availableBrowsers.put("ES","Espial TV Browser");
        availableBrowsers.put("FB","Firebird");
        availableBrowsers.put("FD","Fluid");
        availableBrowsers.put("FE","Fennec");
        availableBrowsers.put("FF","Firefox");
        availableBrowsers.put("FL","Flock");
        availableBrowsers.put("FM","Firefox Mobile");
        availableBrowsers.put("FW","Fireweb");
        availableBrowsers.put("FN","Fireweb Navigator");
        availableBrowsers.put("GA","Galeon");
        availableBrowsers.put("GE","Google Earth");
        availableBrowsers.put("HJ","HotJava");
        availableBrowsers.put("IA","Iceape");
        availableBrowsers.put("IB","IBrowse");
        availableBrowsers.put("IC","iCab");
        availableBrowsers.put("I2","iCab Mobile");
        availableBrowsers.put("I1","Iridium");
        availableBrowsers.put("ID","IceDragon");
        availableBrowsers.put("IV","Isivioo");
        availableBrowsers.put("IW","Iceweasel");
        availableBrowsers.put("IE","Internet Explorer");
        availableBrowsers.put("IM","IE Mobile");
        availableBrowsers.put("IR","Iron");
        availableBrowsers.put("JS","Jasmine");
        availableBrowsers.put("JI","Jig Browser");
        availableBrowsers.put("KI","Kindle Browser");
        availableBrowsers.put("KM","K-meleon");
        availableBrowsers.put("KO","Konqueror");
        availableBrowsers.put("KP","Kapiko");
        availableBrowsers.put("KY","Kylo");
        availableBrowsers.put("KZ","Kazehakase");
        availableBrowsers.put("LB","Liebao");
        availableBrowsers.put("LG","LG Browser");
        availableBrowsers.put("LI","Links");
        availableBrowsers.put("LU","LuaKit");
        availableBrowsers.put("LS","Lunascape");
        availableBrowsers.put("LX","Lynx");
        availableBrowsers.put("MB","MicroB");
        availableBrowsers.put("MC","NCSA Mosaic");
        availableBrowsers.put("ME","Mercury");
        availableBrowsers.put("MF","Mobile Safari");
        availableBrowsers.put("MI","Midori");
        availableBrowsers.put("MU","MIUI Browser");
        availableBrowsers.put("MS","Mobile Silk");
        availableBrowsers.put("MX","Maxthon");
        availableBrowsers.put("NB","Nokia Browser");
        availableBrowsers.put("NO","Nokia OSS Browser");
        availableBrowsers.put("NV","Nokia Ovi Browser");
        availableBrowsers.put("NF","NetFront");
        availableBrowsers.put("NL","NetFront Life");
        availableBrowsers.put("NP","NetPositive");
        availableBrowsers.put("NS","Netscape");
        availableBrowsers.put("OB","Obigo");
        availableBrowsers.put("OD","Odyssey Web Browser");
        availableBrowsers.put("OF","Off By One");
        availableBrowsers.put("OE","ONE Browser");
        availableBrowsers.put("OI","Opera Mini");
        availableBrowsers.put("OM","Opera Mobile");
        availableBrowsers.put("OP","Opera");
        availableBrowsers.put("ON","Opera Next");
        availableBrowsers.put("OR","Oregano");
        availableBrowsers.put("OV","Openwave Mobile Browser");
        availableBrowsers.put("OW","OmniWeb");
        availableBrowsers.put("OT","Otter Browser");
        availableBrowsers.put("PL","Palm Blazer");
        availableBrowsers.put("PM","Pale Moon");
        availableBrowsers.put("PR","Palm Pre");
        availableBrowsers.put("PU","Puffin");
        availableBrowsers.put("PW","Palm WebPro");
        availableBrowsers.put("PA","Palmscape");
        availableBrowsers.put("PX","Phoenix");
        availableBrowsers.put("PO","Polaris");
        availableBrowsers.put("PT","Polarity");
        availableBrowsers.put("PS","Microsoft Edge");
        availableBrowsers.put("QQ","QQ Browser");
        availableBrowsers.put("QT","Qutebrowser");
        availableBrowsers.put("QZ","QupZilla");
        availableBrowsers.put("RK","Rekonq");
        availableBrowsers.put("RM","RockMelt");
        availableBrowsers.put("SB","Samsung Browser");
        availableBrowsers.put("SA","Sailfish Browser");
        availableBrowsers.put("SC","SEMC-Browser");
        availableBrowsers.put("SE","Sogou Explorer");
        availableBrowsers.put("SF","Safari");
        availableBrowsers.put("SH","Shiira");
        availableBrowsers.put("SK","Skyfire");
        availableBrowsers.put("SS","Seraphic Sraf");
        availableBrowsers.put("SL","Sleipnir");
        availableBrowsers.put("SM","SeaMonkey");
        availableBrowsers.put("SN","Snowshoe");
        availableBrowsers.put("SR","Sunrise");
        availableBrowsers.put("SP","SuperBird");
        availableBrowsers.put("ST","Streamy");
        availableBrowsers.put("SX","Swiftfox");
        availableBrowsers.put("TZ","Tizen Browser");
        availableBrowsers.put("TS","TweakStyle");
        availableBrowsers.put("UC","UC Browser");
        availableBrowsers.put("VI","Vivaldi");
        availableBrowsers.put("VB","Vision Mobile Browser");
        availableBrowsers.put("WE","WebPositive");
        availableBrowsers.put("WF","Waterfox");
        availableBrowsers.put("WO","wOSBrowser");
        availableBrowsers.put("WT","WeTab Browser");
        availableBrowsers.put("YA","Yandex Browser");
        availableBrowsers.put("XI","Xiino");
        
        /**
         * Browser families mapped to the short codes of the associated browsers
         *
         * @var array
         */
        browserFamilies = new HashMap<>();        
        browserFamilies.put("Android Browser",   new String[] {"AN", "MU"});
        browserFamilies.put("BlackBerry Browser",new String[] {"BB"});
        browserFamilies.put("Baidu",             new String[] {"BD", "BS"});
        browserFamilies.put("Amiga",             new String[] {"AV", "AW"});
        browserFamilies.put("Chrome",            new String[] {"CH", "BR", "CC", "CD", "CM", "CI", "CF", "CN", "CR", "CP", "IR", "RM", "AO", "TS", "VI", "PT"});
        browserFamilies.put("Firefox",           new String[] {"FF", "FE", "FM", "SX", "FB", "PX", "MB", "EI", "WF"});
        browserFamilies.put("Internet Explorer", new String[] {"IE", "IM", "PS"});
        browserFamilies.put("Konqueror",         new String[] {"KO"});
        browserFamilies.put("NetFront",          new String[] {"NF"});
        browserFamilies.put("Nokia Browser",     new String[] {"NB", "NO", "NV", "DO"});
        browserFamilies.put("Opera",             new String[] {"OP", "OM", "OI", "ON"});
        browserFamilies.put("Safari",            new String[] {"SF", "MF"});
        browserFamilies.put("Sailfish Browser",  new String[] {"SA"});
        
        mobileOnlyBrowsers = Arrays.asList(new String[] {
                "36", "PU", "SK", "MF", "OI", "OM", "DB", "ST", "BL", "IV", "FM", "C1", "AL"});
    };
    private static class LazyHolder {
        static final Browser INSTANCE = new Browser();
    }

    public static Browser getInstance() {
        return LazyHolder.INSTANCE;
    }
    /**
     * Returns list of all available browsers
     * @return array
     */
    public Map<String, String> getAvailableBrowsers(){
        return availableBrowsers;
    }
    /**
     * Returns list of all available browser families
     * @return array
     */
    public Map<String, String[]> getAvailableBrowserFamilies(){
        return this.browserFamilies;
    }
    /**
     * @param browserLabel
     * @return
     */
    public String getBrowserFamily(String browserLabel){
    	for(Entry<String, String[]> e : this.browserFamilies.entrySet()) {
    		String[] labels = e.getValue();
        	if(labels==null)return null;
            for (String label : labels) {
                if(label.equals(browserLabel)) {
                	return e.getKey();
                }
            }
    	}
        return null;
    }
    /**
     * Returns if the given browser is mobile only
     *
     * @param string $browser  Label or name of browser
     * @return bool
     */
    public boolean isMobileOnlyBrowser(String browser){
    	if(this.mobileOnlyBrowsers.contains(browser)) {
    		return true;
    	}
    	for(Entry<String, String> e : availableBrowsers.entrySet()) {
    		if(e.getValue().equals(browser)) {
    			if(this.mobileOnlyBrowsers.contains(e.getKey())){
    				return true;
    			}
    		}
    	}
    	return false;        
    }
    public DetectResult parse(String userAgent){
    	List<String> matches = null;
    	Map<String, Object> currentRegexObj = null;
        for (Map<String, Object> regexObj : this.getRegexes()) {
            matches = this.matchUserAgent(userAgent, regexObj.get("regex").toString());
            if (matches!=null && matches.size()>0) {
            	currentRegexObj = regexObj;
                break;
            }
        }
        if (matches==null || matches.size()<1) {
            return null;
        }
        String name = this.buildByMatch(currentRegexObj.get("name").toString(), matches);
        DetectResult ret = null;
        for(Entry<String, String> browserShort : this.getAvailableBrowsers().entrySet()) {        	 
            if (name.toLowerCase().equals(browserShort.getValue().toLowerCase())) {
                String version = this.buildVersion(currentRegexObj.get("version").toString(), matches);
                DetectResult engine = null;
                ret = new DetectResult();
                ret.setType("browser");
                ret.setName(name);
                ret.setShortName(browserShort.getKey());
                ret.setVersion(version);
                Object engineObj = currentRegexObj.get("engine");
                if(currentRegexObj.containsKey("engine")) {
                	engine = this.buildEngine(userAgent, (Map)engineObj, version);
                	ret.setEngine(engine.getEngine());
                    ret.setEngineVersion(engine.getEngineVersion());
                }
                break;
            }
        }
        return ret;
    }
    protected DetectResult buildEngine(String userAgent, Map<String, Object> engineData, String browserVersion){
    	DetectResult ret =null;
    	String engine = null;
    	String ver = null;
        // if an engine is set as default
        if (engineData.containsKey("default")) {
            engine = engineData.get("default").toString();
        }
        // check if engine is set for browser version
        Object versionObj = engineData.get("versions");        
        if (versionObj!=null && versionObj instanceof Map) {
        	Map<Object, Object> versions = (Map<Object, Object>)versionObj;
            Set<Object> versionNums = versions.keySet();
            List<Object> versionList = Arrays.asList(versionNums.toArray());            
			versionList.sort(new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					return Browser.versionCompare(o1.toString(), o2.toString());
			}});
			for(Object version : versionList) {
	            if (versionCompare(browserVersion, version.toString()) >= 0) {
	                engine = versions.get(version).toString();
	                ver = version.toString();
	            }
			}
        }
        // try to detect the engine using the regexes
        if (engine==null || "".equals(engine)) {
            Engine ee = Engine.getInstance();
            ret = ee.parse(userAgent);
        } else {
        	ret = new DetectResult();
        	ret.setEngine(engine);
        	ret.setEngineVersion(ver);
        }
        return ret;
    }
    /**
	 * @param browserVersion
	 * @param version
	 * @return
	 */
	private static int versionCompare(String browserVersion, String version) {
		String[] vals1 = browserVersion.split("\\.");
	    String[] vals2 = version.split("\\.");
	    int i = 0;
	    // set index to first non-equal ordinal or length of shortest version string
	    while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
	      i++;
	    }
	    // compare first non-equal ordinal number
	    if (i < vals1.length && i < vals2.length) {
	        int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
	        return Integer.signum(diff);
	    }
	    // the strings are equal or one string is a substring of the other
	    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
	    return Integer.signum(vals1.length - vals2.length);
	}
	/**
	 * we don't need this function
	 * @param userAgent
	 * @param engine
	 * @return
	 */
	protected String buildEngineVersion(String userAgent, String engine){
        return null;
    }

}
