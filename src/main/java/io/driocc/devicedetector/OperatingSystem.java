package io.driocc.devicedetector;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.driocc.devicedetector.utils.Utils;
import io.driocc.devicedetector.yaml.YamlParser;
	
/**
 * 
 * @author kyon
 *
 */
public class OperatingSystem extends ParserAbstract {
		
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/oss.yml";
	public Map<String, String> operatingSystems;
	public Map<String, String[]> osFamilies;	
	private OperatingSystem() {
		this.setType("os");
		this.setYaml(FIXTURE_FILE);
		this.setRegexes(YamlParser.get(this.getYaml()));
		operatingSystems = new HashMap<String, String>();
		operatingSystems.put("AIX", "AIX");
        operatingSystems.put("AND", "Android");
        operatingSystems.put("AMG", "AmigaOS");
        operatingSystems.put("ATV", "Apple TV");
        operatingSystems.put("ARL", "Arch Linux");
        operatingSystems.put("BTR", "BackTrack");
        operatingSystems.put("SBA", "Bada");
        operatingSystems.put("BEO", "BeOS");
        operatingSystems.put("BLB", "BlackBerry OS");
        operatingSystems.put("QNX", "BlackBerry Tablet OS");
        operatingSystems.put("BMP", "Brew");
        operatingSystems.put("CES", "CentOS");
        operatingSystems.put("COS", "Chrome OS");
        operatingSystems.put("CYN", "CyanogenMod");
        operatingSystems.put("DEB", "Debian");
        operatingSystems.put("DFB", "DragonFly");
        operatingSystems.put("FED", "Fedora");
        operatingSystems.put("FOS", "Firefox OS");
        operatingSystems.put("BSD", "FreeBSD");
        operatingSystems.put("GNT", "Gentoo");
        operatingSystems.put("GTV", "Google TV");
        operatingSystems.put("HPX", "HP-UX");
        operatingSystems.put("HAI", "Haiku OS");
        operatingSystems.put("IRI", "IRIX");
        operatingSystems.put("INF", "Inferno");
        operatingSystems.put("KNO", "Knoppix");
        operatingSystems.put("KBT", "Kubuntu");
        operatingSystems.put("LIN", "GNU/Linux");
        operatingSystems.put("LBT", "Lubuntu");
        operatingSystems.put("VLN", "VectorLinux");
        operatingSystems.put("MAC", "Mac");
        operatingSystems.put("MAE", "Maemo");
        operatingSystems.put("MDR", "Mandriva");
        operatingSystems.put("SMG", "MeeGo");
        operatingSystems.put("MCD", "MocorDroid");
        operatingSystems.put("MIN", "Mint");
        operatingSystems.put("MLD", "MildWild");
        operatingSystems.put("MOR", "MorphOS");
        operatingSystems.put("NBS", "NetBSD");
        operatingSystems.put("MTK", "MTK / Nucleus");
        operatingSystems.put("WII", "Nintendo");
        operatingSystems.put("NDS", "Nintendo Mobile");
        operatingSystems.put("OS2", "OS/2");
        operatingSystems.put("T64", "OSF1");
        operatingSystems.put("OBS", "OpenBSD");
        operatingSystems.put("PSP", "PlayStation Portable");
        operatingSystems.put("PS3", "PlayStation");
        operatingSystems.put("RHT", "Red Hat");
        operatingSystems.put("ROS", "RISC OS");
        operatingSystems.put("REM", "Remix OS");
        operatingSystems.put("RZD", "RazoDroiD");
        operatingSystems.put("SAB", "Sabayon");
        operatingSystems.put("SSE", "SUSE");
        operatingSystems.put("SAF", "Sailfish OS");
        operatingSystems.put("SLW", "Slackware");
        operatingSystems.put("SOS", "Solaris");
        operatingSystems.put("SYL", "Syllable");
        operatingSystems.put("SYM", "Symbian");
        operatingSystems.put("SYS", "Symbian OS");
        operatingSystems.put("S40", "Symbian OS Series 40");
        operatingSystems.put("S60", "Symbian OS Series 60");
        operatingSystems.put("SY3", "Symbian^3");
        operatingSystems.put("TDX", "ThreadX");
        operatingSystems.put("TIZ", "Tizen");
        operatingSystems.put("UBT", "Ubuntu");
        operatingSystems.put("WTV", "WebTV");
        operatingSystems.put("WIN", "Windows");
        operatingSystems.put("WCE", "Windows CE");
        operatingSystems.put("WMO", "Windows Mobile");
        operatingSystems.put("WPH", "Windows Phone");
        operatingSystems.put("WRT", "Windows RT");
        operatingSystems.put("XBX", "Xbox");
        operatingSystems.put("XBT", "Xubuntu");
        operatingSystems.put("YNS", "YunOs");
        operatingSystems.put("IOS", "iOS");
        operatingSystems.put("POS", "palmOS");
        operatingSystems.put("WOS", "webOS");
        osFamilies = new HashMap<String, String[]>();
		osFamilies.put("Android", new String[]{"AND", "CYN", "REM", "RZD", "MLD", "MCD", "YNS"});
		osFamilies.put("AAndroid", new String[]{"AND", "CYN", "REM", "RZD", "MLD", "MCD", "YNS"});
		osFamilies.put("AAmigaOS", new String[]{"AMG", "MOR"});
		osFamilies.put("Apple TV", new String[]{"ATV"});
		osFamilies.put("BlackBerry", new String[]{"BLB", "QNX"});
		osFamilies.put("Brew", new String[]{"BMP"});
		osFamilies.put("BeOS", new String[]{"BEO", "HAI"});
		osFamilies.put("Chrome OS", new String[]{"COS"});
		osFamilies.put("Firefox OS", new String[]{"FOS"});
		osFamilies.put("Gaming Console", new String[]{"WII", "PS3"});
		osFamilies.put("Google TV", new String[]{"GTV"});
		osFamilies.put("IBM", new String[]{"OS2"});
		osFamilies.put("iOS", new String[]{"IOS"});
		osFamilies.put("RISC OS", new String[]{"ROS"});
		osFamilies.put("GNU/Linux", new String[]{"LIN", "ARL", "DEB", "KNO", "MIN", "UBT", "KBT", "XBT", "LBT", "FED", "RHT", "VLN", "MDR", "GNT", "SAB", "SLW", "SSE", "CES", "BTR", "SAF"});
		osFamilies.put("Mac", new String[]{"MAC"});
		osFamilies.put("Mobile Gaming Console", new String[]{"PSP", "NDS", "XBX"});
		osFamilies.put("Real-time OS", new String[]{"MTK", "TDX"});
		osFamilies.put("Other Mobile", new String[]{"WOS", "POS", "SBA", "TIZ", "SMG", "MAE"});
		osFamilies.put("Symbian", new String[]{"SYM", "SYS", "SY3", "S60", "S40"});
		osFamilies.put("Unix", new String[]{"SOS", "AIX", "HPX", "BSD", "NBS", "OBS", "DFB", "SYL", "IRI", "T64", "INF"});
		osFamilies.put("WebTV", new String[]{"WTV"});
		osFamilies.put("Windows", new String[]{"WIN"});
		osFamilies.put("Windows Mobile", new String[]{"WPH", "WMO", "WCE", "WRT"});
	}
	
	private static class LazyHolder {
        static final OperatingSystem INSTANCE = new OperatingSystem();
    }

    public static OperatingSystem getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Map<String, String> getAvailableOperatingSystems(){
        return operatingSystems;
    }
    public Map<String, String[]> getAvailableOperatingSystemFamilies(){
        return osFamilies;
    }
    
    public DetectResult parse(String userAgent){
    	List<String> matches = null;
    	Map<String, Object> osRegex = null;
        for(Map<String, Object> regex : this.getRegexes()) {
        	matches = this.matchUserAgent(userAgent, regex.get("regex").toString());
            if (matches!=null && matches.size()>0) {
            	osRegex = regex;
                break;
            }
        }
        if (matches==null || matches.size()<1) {
            return null;
        }
        String name  = this.buildByMatch(osRegex.get("name").toString(), matches);
        String shortName = "UNK";        
        for (Entry<String, String> e : this.operatingSystems.entrySet()) {
        	if (e.getValue().toLowerCase().equals(name.toLowerCase())) {
                name = e.getValue();
                shortName = e.getKey();
            }
        }
        DetectResult ret = new DetectResult();
        ret.setName(name);
        ret.setShortName(shortName);
        ret.setVersion(this.buildVersion(osRegex.get("version").toString(), matches));
        ret.setPlatform(parsePlatform(userAgent));
        return ret;
    }

	protected String parsePlatform(String userAgent){
		List<String> matches = null;
		matches = this.matchUserAgent(userAgent, "arm");
        if (matches!=null && matches.size()>0)
            return "ARM";
        matches = this.matchUserAgent(userAgent, "WOW64|x64|win64|amd64|x86_64");
		if (matches!=null && matches.size()>0)
            return "x64";
        matches = this.matchUserAgent(userAgent, "i[0-9]86|i86pc");
        if (matches!=null && matches.size()>0)
            return "x86";
        return "";
    }
    /**
     * Returns the operating system family for the given operating system
     *
     * @param osLabel
     * @return string
     */
    public String getOsFamily(String osLabel){
    	for(Map.Entry<String, String[]> entry : this.osFamilies.entrySet()) {
			String family = entry.getKey();
			String[] array = entry.getValue();
			for(String label : array) {
				if(label.equals(osLabel)) {
					return family;
				}
			}
		}
		return null;
    }
    /**
     * Returns the full name for the given short name
     *
     * @param      $os
     * @param bool $ver
     *
     * @return bool|string
     */
    public String getNameFromId(String os, String ver){
    	String osFullName = this.operatingSystems.get(os);
        if (!Utils.isEmpty(osFullName)) {
        	osFullName = osFullName + " " + ver;
        	return osFullName.trim();
        }
        return null;
    }

}
