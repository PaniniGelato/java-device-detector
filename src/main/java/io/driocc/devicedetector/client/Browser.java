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
import io.driocc.devicedetector.utils.Utils;


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
    private static Map<String, String> AVAILABLE_BROWSERS;
    /**
     * Browser families mapped to the short codes of the associated browsers
     */
    private static Map<String, String[]> BROWSER_FAMILIES;
    /**
     * Browsers that are available for mobile devices only
     */
    private static List<String> MOBILE_ONLY_BROWSERS;
    private Engine engineParser;
    public Browser(){
    	super(PARSER, FIXTURE_FILE);
    	engineParser = new Engine();
    }
    public Browser(String type, String file){
    	super(type, file);
    	engineParser = new Engine();
    }
    static {
    	AVAILABLE_BROWSERS = new HashMap<>();
        AVAILABLE_BROWSERS.put("36","360 Phone Browser");
        AVAILABLE_BROWSERS.put("3B","360 Browser");
        AVAILABLE_BROWSERS.put("AA","Avant Browser");
        AVAILABLE_BROWSERS.put("AB","ABrowse");
        AVAILABLE_BROWSERS.put("AF","ANT Fresco");
        AVAILABLE_BROWSERS.put("AG","ANTGalio");
        AVAILABLE_BROWSERS.put("AL","Aloha Browser");
        AVAILABLE_BROWSERS.put("AM","Amaya");
        AVAILABLE_BROWSERS.put("AO","Amigo");
        AVAILABLE_BROWSERS.put("AN","Android Browser");
        AVAILABLE_BROWSERS.put("AR","Arora");
        AVAILABLE_BROWSERS.put("AV","Amiga Voyager");
        AVAILABLE_BROWSERS.put("AW","Amiga Aweb");
        AVAILABLE_BROWSERS.put("AT","Atomic Web Browser");
        AVAILABLE_BROWSERS.put("BB","BlackBerry Browser");
        AVAILABLE_BROWSERS.put("BD","Baidu Browser");
        AVAILABLE_BROWSERS.put("BS","Baidu Spark");
        AVAILABLE_BROWSERS.put("BE","Beonex");
        AVAILABLE_BROWSERS.put("BJ","Bunjalloo");
        AVAILABLE_BROWSERS.put("BL","B-Line");
        AVAILABLE_BROWSERS.put("BR","Brave");
        AVAILABLE_BROWSERS.put("BK","BriskBard");
        AVAILABLE_BROWSERS.put("BX","BrowseX");
        AVAILABLE_BROWSERS.put("CA","Camino");
        AVAILABLE_BROWSERS.put("CC","Coc Coc");
        AVAILABLE_BROWSERS.put("CD","Comodo Dragon");
        AVAILABLE_BROWSERS.put("C1","Coast");
        AVAILABLE_BROWSERS.put("CX","Charon");
        AVAILABLE_BROWSERS.put("CF","Chrome Frame");
        AVAILABLE_BROWSERS.put("CH","Chrome");
        AVAILABLE_BROWSERS.put("CI","Chrome Mobile iOS");
        AVAILABLE_BROWSERS.put("CK","Conkeror");
        AVAILABLE_BROWSERS.put("CM","Chrome Mobile");
        AVAILABLE_BROWSERS.put("CN","CoolNovo");
        AVAILABLE_BROWSERS.put("CO","CometBird");
        AVAILABLE_BROWSERS.put("CP","ChromePlus");
        AVAILABLE_BROWSERS.put("CR","Chromium");
        AVAILABLE_BROWSERS.put("CY","Cyberfox");
        AVAILABLE_BROWSERS.put("CS","Cheshire");
        AVAILABLE_BROWSERS.put("DB","dbrowser");
        AVAILABLE_BROWSERS.put("DE","Deepnet Explorer");
        AVAILABLE_BROWSERS.put("DF","Dolphin");
        AVAILABLE_BROWSERS.put("DO","Dorado");
        AVAILABLE_BROWSERS.put("DL","Dooble");
        AVAILABLE_BROWSERS.put("DI","Dillo");
        AVAILABLE_BROWSERS.put("EI","Epic");
        AVAILABLE_BROWSERS.put("EL","Elinks");
        AVAILABLE_BROWSERS.put("EB","Element Browser");
        AVAILABLE_BROWSERS.put("EP","GNOME Web");
        AVAILABLE_BROWSERS.put("ES","Espial TV Browser");
        AVAILABLE_BROWSERS.put("FB","Firebird");
        AVAILABLE_BROWSERS.put("FD","Fluid");
        AVAILABLE_BROWSERS.put("FE","Fennec");
        AVAILABLE_BROWSERS.put("FF","Firefox");
        AVAILABLE_BROWSERS.put("FL","Flock");
        AVAILABLE_BROWSERS.put("FM","Firefox Mobile");
        AVAILABLE_BROWSERS.put("FW","Fireweb");
        AVAILABLE_BROWSERS.put("FN","Fireweb Navigator");
        AVAILABLE_BROWSERS.put("GA","Galeon");
        AVAILABLE_BROWSERS.put("GE","Google Earth");
        AVAILABLE_BROWSERS.put("HJ","HotJava");
        AVAILABLE_BROWSERS.put("IA","Iceape");
        AVAILABLE_BROWSERS.put("IB","IBrowse");
        AVAILABLE_BROWSERS.put("IC","iCab");
        AVAILABLE_BROWSERS.put("I2","iCab Mobile");
        AVAILABLE_BROWSERS.put("I1","Iridium");
        AVAILABLE_BROWSERS.put("ID","IceDragon");
        AVAILABLE_BROWSERS.put("IV","Isivioo");
        AVAILABLE_BROWSERS.put("IW","Iceweasel");
        AVAILABLE_BROWSERS.put("IE","Internet Explorer");
        AVAILABLE_BROWSERS.put("IM","IE Mobile");
        AVAILABLE_BROWSERS.put("IR","Iron");
        AVAILABLE_BROWSERS.put("JS","Jasmine");
        AVAILABLE_BROWSERS.put("JI","Jig Browser");
        AVAILABLE_BROWSERS.put("KI","Kindle Browser");
        AVAILABLE_BROWSERS.put("KM","K-meleon");
        AVAILABLE_BROWSERS.put("KO","Konqueror");
        AVAILABLE_BROWSERS.put("KP","Kapiko");
        AVAILABLE_BROWSERS.put("KY","Kylo");
        AVAILABLE_BROWSERS.put("KZ","Kazehakase");
        AVAILABLE_BROWSERS.put("LB","Liebao");
        AVAILABLE_BROWSERS.put("LG","LG Browser");
        AVAILABLE_BROWSERS.put("LI","Links");
        AVAILABLE_BROWSERS.put("LU","LuaKit");
        AVAILABLE_BROWSERS.put("LS","Lunascape");
        AVAILABLE_BROWSERS.put("LX","Lynx");
        AVAILABLE_BROWSERS.put("MB","MicroB");
        AVAILABLE_BROWSERS.put("MC","NCSA Mosaic");
        AVAILABLE_BROWSERS.put("ME","Mercury");
        AVAILABLE_BROWSERS.put("MF","Mobile Safari");
        AVAILABLE_BROWSERS.put("MI","Midori");
        AVAILABLE_BROWSERS.put("MU","MIUI Browser");
        AVAILABLE_BROWSERS.put("MS","Mobile Silk");
        AVAILABLE_BROWSERS.put("MX","Maxthon");
        AVAILABLE_BROWSERS.put("NB","Nokia Browser");
        AVAILABLE_BROWSERS.put("NO","Nokia OSS Browser");
        AVAILABLE_BROWSERS.put("NV","Nokia Ovi Browser");
        AVAILABLE_BROWSERS.put("NF","NetFront");
        AVAILABLE_BROWSERS.put("NL","NetFront Life");
        AVAILABLE_BROWSERS.put("NP","NetPositive");
        AVAILABLE_BROWSERS.put("NS","Netscape");
        AVAILABLE_BROWSERS.put("OB","Obigo");
        AVAILABLE_BROWSERS.put("OD","Odyssey Web Browser");
        AVAILABLE_BROWSERS.put("OF","Off By One");
        AVAILABLE_BROWSERS.put("OE","ONE Browser");
        AVAILABLE_BROWSERS.put("OI","Opera Mini");
        AVAILABLE_BROWSERS.put("OM","Opera Mobile");
        AVAILABLE_BROWSERS.put("OP","Opera");
        AVAILABLE_BROWSERS.put("ON","Opera Next");
        AVAILABLE_BROWSERS.put("OR","Oregano");
        AVAILABLE_BROWSERS.put("OV","Openwave Mobile Browser");
        AVAILABLE_BROWSERS.put("OW","OmniWeb");
        AVAILABLE_BROWSERS.put("OT","Otter Browser");
        AVAILABLE_BROWSERS.put("PL","Palm Blazer");
        AVAILABLE_BROWSERS.put("PM","Pale Moon");
        AVAILABLE_BROWSERS.put("PR","Palm Pre");
        AVAILABLE_BROWSERS.put("PU","Puffin");
        AVAILABLE_BROWSERS.put("PW","Palm WebPro");
        AVAILABLE_BROWSERS.put("PA","Palmscape");
        AVAILABLE_BROWSERS.put("PX","Phoenix");
        AVAILABLE_BROWSERS.put("PO","Polaris");
        AVAILABLE_BROWSERS.put("PT","Polarity");
        AVAILABLE_BROWSERS.put("PS","Microsoft Edge");
        AVAILABLE_BROWSERS.put("QQ","QQ Browser");
        AVAILABLE_BROWSERS.put("QT","Qutebrowser");
        AVAILABLE_BROWSERS.put("QZ","QupZilla");
        AVAILABLE_BROWSERS.put("RK","Rekonq");
        AVAILABLE_BROWSERS.put("RM","RockMelt");
        AVAILABLE_BROWSERS.put("SB","Samsung Browser");
        AVAILABLE_BROWSERS.put("SA","Sailfish Browser");
        AVAILABLE_BROWSERS.put("SC","SEMC-Browser");
        AVAILABLE_BROWSERS.put("SE","Sogou Explorer");
        AVAILABLE_BROWSERS.put("SF","Safari");
        AVAILABLE_BROWSERS.put("SH","Shiira");
        AVAILABLE_BROWSERS.put("SK","Skyfire");
        AVAILABLE_BROWSERS.put("SS","Seraphic Sraf");
        AVAILABLE_BROWSERS.put("SL","Sleipnir");
        AVAILABLE_BROWSERS.put("SM","SeaMonkey");
        AVAILABLE_BROWSERS.put("SN","Snowshoe");
        AVAILABLE_BROWSERS.put("SR","Sunrise");
        AVAILABLE_BROWSERS.put("SP","SuperBird");
        AVAILABLE_BROWSERS.put("ST","Streamy");
        AVAILABLE_BROWSERS.put("SX","Swiftfox");
        AVAILABLE_BROWSERS.put("TZ","Tizen Browser");
        AVAILABLE_BROWSERS.put("TS","TweakStyle");
        AVAILABLE_BROWSERS.put("UC","UC Browser");
        AVAILABLE_BROWSERS.put("VI","Vivaldi");
        AVAILABLE_BROWSERS.put("VB","Vision Mobile Browser");
        AVAILABLE_BROWSERS.put("WE","WebPositive");
        AVAILABLE_BROWSERS.put("WF","Waterfox");
        AVAILABLE_BROWSERS.put("WO","wOSBrowser");
        AVAILABLE_BROWSERS.put("WT","WeTab Browser");
        AVAILABLE_BROWSERS.put("YA","Yandex Browser");
        AVAILABLE_BROWSERS.put("XI","Xiino");
        
        /**
         * Browser families mapped to the short codes of the associated browsers
         *
         * @var array
         */
        BROWSER_FAMILIES = new HashMap<>();        
        BROWSER_FAMILIES.put("Android Browser",   new String[] {"AN", "MU"});
        BROWSER_FAMILIES.put("BlackBerry Browser",new String[] {"BB"});
        BROWSER_FAMILIES.put("Baidu",             new String[] {"BD", "BS"});
        BROWSER_FAMILIES.put("Amiga",             new String[] {"AV", "AW"});
        BROWSER_FAMILIES.put("Chrome",            new String[] {"CH", "BR", "CC", "CD", "CM", "CI", "CF", "CN", "CR", "CP", "IR", "RM", "AO", "TS", "VI", "PT"});
        BROWSER_FAMILIES.put("Firefox",           new String[] {"FF", "FE", "FM", "SX", "FB", "PX", "MB", "EI", "WF"});
        BROWSER_FAMILIES.put("Internet Explorer", new String[] {"IE", "IM", "PS"});
        BROWSER_FAMILIES.put("Konqueror",         new String[] {"KO"});
        BROWSER_FAMILIES.put("NetFront",          new String[] {"NF"});
        BROWSER_FAMILIES.put("Nokia Browser",     new String[] {"NB", "NO", "NV", "DO"});
        BROWSER_FAMILIES.put("Opera",             new String[] {"OP", "OM", "OI", "ON"});
        BROWSER_FAMILIES.put("Safari",            new String[] {"SF", "MF"});
        BROWSER_FAMILIES.put("Sailfish Browser",  new String[] {"SA"});
        
        MOBILE_ONLY_BROWSERS = Arrays.asList(new String[] {
                "36", "PU", "SK", "MF", "OI", "OM", "DB", "ST", "BL", "IV", "FM", "C1", "AL"});
    };

    /**
     * @param browserLabel
     * @return
     */
    public static String getBrowserFamily(String browserLabel){
    	for(Entry<String, String[]> e : BROWSER_FAMILIES.entrySet()) {
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
    public static boolean isMobileOnlyBrowser(String browser){
    	if(Utils.isEmpty(browser))return false; 
    	if(MOBILE_ONLY_BROWSERS.contains(browser)) {
    		return true;
    	}
    	for(Entry<String, String> e : AVAILABLE_BROWSERS.entrySet()) {
    		if(e.getValue().equals(browser)) {
    			if(MOBILE_ONLY_BROWSERS.contains(e.getKey())){
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
        for(Entry<String, String> browserShort : AVAILABLE_BROWSERS.entrySet()) {        	 
            if (name.toLowerCase().equals(browserShort.getValue().toLowerCase())) {
                String version = this.buildVersionByCaptureGroup(userAgent, currentRegexObj);
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
					return Utils.versionCompare(o1.toString(), o2.toString());
			}});
			for(Object version : versionList) {
				String versionStr = version.toString();
	            if (Utils.versionCompare(browserVersion, versionStr) >= 0) {	            	
	            	//System.out.println(browserVersion + " vs " + version.toString());
	            	//get the left part and compare, true if equal
	            	String browserVersionLeft = browserVersion.contains(".")?browserVersion.split("\\.")[0]:browserVersion;
	            	String versionLeft = versionStr.contains(".")?versionStr.split(".")[0]:versionStr;
	            	if(Utils.isNumeric(browserVersionLeft) && Utils.isNumeric(versionLeft)) {
	            		if(Integer.valueOf(browserVersionLeft).compareTo(Integer.valueOf(versionLeft))==0) {
	            			engine = versions.get(version).toString();
	    	                ver = version.toString();
	            		}
	            	}
	            }
			}
        }
        // try to detect the engine using the regexes
        if (engine==null || "".equals(engine)) {
            ret = engineParser.parse(userAgent);
        } else {
        	ret = new DetectResult();
        	ret.setEngine(engine);
        	ret.setEngineVersion(ver);
        }
        return ret;
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
