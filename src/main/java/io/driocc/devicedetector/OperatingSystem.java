package io.driocc.devicedetector;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.driocc.devicedetector.utils.Utils;
	
/**
 * 
 * @author kyon
 *
 */
public class OperatingSystem extends ParserAbstract {
		
	private static final long serialVersionUID = 1L;
	private static final String FIXTURE_FILE = "regexes/oss.yml";
	public static final String UNKNOWN = "UNK";
	public static Map<String, String> OPERATING_SYSTEMS;
	public static Map<String, String[]> OS_FAMILIES;
	public static List<String> DESKTOP_OS = Arrays.asList(new String[] {
			"AmigaOS", "IBM", "GNU/Linux", "Mac", "Unix", "Windows", "BeOS", "Chrome OS"	
	});
	public OperatingSystem() {
		super("os", FIXTURE_FILE);
	}
	public OperatingSystem(String type, String file) {
		super(type,file);
	}
	static {
		OPERATING_SYSTEMS = new HashMap<String, String>();
		OPERATING_SYSTEMS.put("AIX", "AIX");
        OPERATING_SYSTEMS.put("AND", "Android");
        OPERATING_SYSTEMS.put("AMG", "AmigaOS");
        OPERATING_SYSTEMS.put("ATV", "Apple TV");
        OPERATING_SYSTEMS.put("ARL", "Arch Linux");
        OPERATING_SYSTEMS.put("BTR", "BackTrack");
        OPERATING_SYSTEMS.put("SBA", "Bada");
        OPERATING_SYSTEMS.put("BEO", "BeOS");
        OPERATING_SYSTEMS.put("BLB", "BlackBerry OS");
        OPERATING_SYSTEMS.put("QNX", "BlackBerry Tablet OS");
        OPERATING_SYSTEMS.put("BMP", "Brew");
        OPERATING_SYSTEMS.put("CES", "CentOS");
        OPERATING_SYSTEMS.put("COS", "Chrome OS");
        OPERATING_SYSTEMS.put("CYN", "CyanogenMod");
        OPERATING_SYSTEMS.put("DEB", "Debian");
        OPERATING_SYSTEMS.put("DFB", "DragonFly");
        OPERATING_SYSTEMS.put("FED", "Fedora");
        OPERATING_SYSTEMS.put("FOS", "Firefox OS");
        OPERATING_SYSTEMS.put("BSD", "FreeBSD");
        OPERATING_SYSTEMS.put("GNT", "Gentoo");
        OPERATING_SYSTEMS.put("GTV", "Google TV");
        OPERATING_SYSTEMS.put("HPX", "HP-UX");
        OPERATING_SYSTEMS.put("HAI", "Haiku OS");
        OPERATING_SYSTEMS.put("IRI", "IRIX");
        OPERATING_SYSTEMS.put("INF", "Inferno");
        OPERATING_SYSTEMS.put("KNO", "Knoppix");
        OPERATING_SYSTEMS.put("KBT", "Kubuntu");
        OPERATING_SYSTEMS.put("LIN", "GNU/Linux");
        OPERATING_SYSTEMS.put("LBT", "Lubuntu");
        OPERATING_SYSTEMS.put("VLN", "VectorLinux");
        OPERATING_SYSTEMS.put("MAC", "Mac");
        OPERATING_SYSTEMS.put("MAE", "Maemo");
        OPERATING_SYSTEMS.put("MDR", "Mandriva");
        OPERATING_SYSTEMS.put("SMG", "MeeGo");
        OPERATING_SYSTEMS.put("MCD", "MocorDroid");
        OPERATING_SYSTEMS.put("MIN", "Mint");
        OPERATING_SYSTEMS.put("MLD", "MildWild");
        OPERATING_SYSTEMS.put("MOR", "MorphOS");
        OPERATING_SYSTEMS.put("NBS", "NetBSD");
        OPERATING_SYSTEMS.put("MTK", "MTK / Nucleus");
        OPERATING_SYSTEMS.put("WII", "Nintendo");
        OPERATING_SYSTEMS.put("NDS", "Nintendo Mobile");
        OPERATING_SYSTEMS.put("OS2", "OS/2");
        OPERATING_SYSTEMS.put("T64", "OSF1");
        OPERATING_SYSTEMS.put("OBS", "OpenBSD");
        OPERATING_SYSTEMS.put("PSP", "PlayStation Portable");
        OPERATING_SYSTEMS.put("PS3", "PlayStation");
        OPERATING_SYSTEMS.put("RHT", "Red Hat");
        OPERATING_SYSTEMS.put("ROS", "RISC OS");
        OPERATING_SYSTEMS.put("REM", "Remix OS");
        OPERATING_SYSTEMS.put("RZD", "RazoDroiD");
        OPERATING_SYSTEMS.put("SAB", "Sabayon");
        OPERATING_SYSTEMS.put("SSE", "SUSE");
        OPERATING_SYSTEMS.put("SAF", "Sailfish OS");
        OPERATING_SYSTEMS.put("SLW", "Slackware");
        OPERATING_SYSTEMS.put("SOS", "Solaris");
        OPERATING_SYSTEMS.put("SYL", "Syllable");
        OPERATING_SYSTEMS.put("SYM", "Symbian");
        OPERATING_SYSTEMS.put("SYS", "Symbian OS");
        OPERATING_SYSTEMS.put("S40", "Symbian OS Series 40");
        OPERATING_SYSTEMS.put("S60", "Symbian OS Series 60");
        OPERATING_SYSTEMS.put("SY3", "Symbian^3");
        OPERATING_SYSTEMS.put("TDX", "ThreadX");
        OPERATING_SYSTEMS.put("TIZ", "Tizen");
        OPERATING_SYSTEMS.put("UBT", "Ubuntu");
        OPERATING_SYSTEMS.put("WTV", "WebTV");
        OPERATING_SYSTEMS.put("WIN", "Windows");
        OPERATING_SYSTEMS.put("WCE", "Windows CE");
        OPERATING_SYSTEMS.put("WMO", "Windows Mobile");
        OPERATING_SYSTEMS.put("WPH", "Windows Phone");
        OPERATING_SYSTEMS.put("WRT", "Windows RT");
        OPERATING_SYSTEMS.put("XBX", "Xbox");
        OPERATING_SYSTEMS.put("XBT", "Xubuntu");
        OPERATING_SYSTEMS.put("YNS", "YunOs");
        OPERATING_SYSTEMS.put("IOS", "iOS");
        OPERATING_SYSTEMS.put("POS", "palmOS");
        OPERATING_SYSTEMS.put("WOS", "webOS");
        OS_FAMILIES = new HashMap<String, String[]>();
		OS_FAMILIES.put("Android", new String[]{"AND", "CYN", "REM", "RZD", "MLD", "MCD", "YNS"});
		OS_FAMILIES.put("AAndroid", new String[]{"AND", "CYN", "REM", "RZD", "MLD", "MCD", "YNS"});
		OS_FAMILIES.put("AAmigaOS", new String[]{"AMG", "MOR"});
		OS_FAMILIES.put("Apple TV", new String[]{"ATV"});
		OS_FAMILIES.put("BlackBerry", new String[]{"BLB", "QNX"});
		OS_FAMILIES.put("Brew", new String[]{"BMP"});
		OS_FAMILIES.put("BeOS", new String[]{"BEO", "HAI"});
		OS_FAMILIES.put("Chrome OS", new String[]{"COS"});
		OS_FAMILIES.put("Firefox OS", new String[]{"FOS"});
		OS_FAMILIES.put("Gaming Console", new String[]{"WII", "PS3"});
		OS_FAMILIES.put("Google TV", new String[]{"GTV"});
		OS_FAMILIES.put("IBM", new String[]{"OS2"});
		OS_FAMILIES.put("iOS", new String[]{"IOS"});
		OS_FAMILIES.put("RISC OS", new String[]{"ROS"});
		OS_FAMILIES.put("GNU/Linux", new String[]{"LIN", "ARL", "DEB", "KNO", "MIN", "UBT", "KBT", "XBT", "LBT", "FED", "RHT", "VLN", "MDR", "GNT", "SAB", "SLW", "SSE", "CES", "BTR", "SAF"});
		OS_FAMILIES.put("Mac", new String[]{"MAC"});
		OS_FAMILIES.put("Mobile Gaming Console", new String[]{"PSP", "NDS", "XBX"});
		OS_FAMILIES.put("Real-time OS", new String[]{"MTK", "TDX"});
		OS_FAMILIES.put("Other Mobile", new String[]{"WOS", "POS", "SBA", "TIZ", "SMG", "MAE"});
		OS_FAMILIES.put("Symbian", new String[]{"SYM", "SYS", "SY3", "S60", "S40"});
		OS_FAMILIES.put("Unix", new String[]{"SOS", "AIX", "HPX", "BSD", "NBS", "OBS", "DFB", "SYL", "IRI", "T64", "INF"});
		OS_FAMILIES.put("WebTV", new String[]{"WTV"});
		OS_FAMILIES.put("Windows", new String[]{"WIN"});
		OS_FAMILIES.put("Windows Mobile", new String[]{"WPH", "WMO", "WCE", "WRT"});
	}

    public Map<String, String> getAvailableOperatingSystems(){
        return OPERATING_SYSTEMS;
    }
    public Map<String, String[]> getAvailableOperatingSystemFamilies(){
        return OS_FAMILIES;
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
        String shortName = UNKNOWN;
        for (Entry<String, String> e : OPERATING_SYSTEMS.entrySet()) {
        	if (e.getValue().toLowerCase().equals(name.toLowerCase())) {
                name = e.getValue();
                shortName = e.getKey();
            }
        }
        DetectResult ret = new DetectResult();
        ret.setType(this.getType());
        ret.setName(name);
        ret.setShortName(shortName);
        ret.setVersion(this.buildVersionByCaptureGroup(userAgent, osRegex));
        ret.setPlatform(parsePlatform(userAgent));
        return ret;
    }

	/**
	 * @param userAgent
	 * @param osRegex
	 * @return
	 */
	private String buildVersionByCaptureGroup(String userAgent, Map<String, Object> osRegex) {
		String ret = null;
		Object versionRegex = osRegex.get("version");
		if(versionRegex!=null) {
			String versionStr = versionRegex.toString();
			if(versionStr.indexOf("$")>=0) {
				String groupStr = versionStr.replaceAll("\\$", "");
				if(Utils.isNumeric(groupStr)) {
					Integer cg = Integer.valueOf(groupStr);
					String regex = osRegex.get("regex").toString();
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(userAgent);
					if(matcher.find() && matcher.groupCount()>=cg) {
						ret = matcher.group(cg);
					}
				}else{
					ret = versionStr;
				}
			}else{
				ret = versionStr;
			}
		}
		return ret;
	}
	
	/**
	 * cannot get version while using this method
	 */
	protected String buildVersion(String versionString, List<String> matches) {
		return null;
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
    public static String getOsFamily(String osLabel){
    	for(Map.Entry<String, String[]> entry : OS_FAMILIES.entrySet()) {
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
    	String osFullName = OPERATING_SYSTEMS.get(os);
        if (!Utils.isEmpty(osFullName)) {
        	osFullName = osFullName + " " + ver;
        	return osFullName.trim();
        }
        return null;
    }

}
