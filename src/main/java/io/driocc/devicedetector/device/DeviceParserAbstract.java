/**
 * 
 */
package io.driocc.devicedetector.device;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.ParserAbstract;

/**
 * @author kyon
 *
 */
public class DeviceParserAbstract extends ParserAbstract {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static final Integer DEVICE_TYPE_DESKTOP              = 0;
    public static final Integer DEVICE_TYPE_SMARTPHONE           = 1;
    public static final Integer DEVICE_TYPE_TABLET               = 2;
    public static final Integer DEVICE_TYPE_FEATURE_PHONE        = 3;
    public static final Integer DEVICE_TYPE_CONSOLE              = 4;
    public static final Integer DEVICE_TYPE_TV                   = 5; // including set top boxes, blu-ray players,...
    public static final Integer DEVICE_TYPE_CAR_BROWSER          = 6;
    public static final Integer DEVICE_TYPE_SMART_DISPLAY        = 7;
    public static final Integer DEVICE_TYPE_CAMERA               = 8;
    public static final Integer DEVICE_TYPE_PORTABLE_MEDIA_PAYER = 9;
    public static final Integer DEVICE_TYPE_PHABLET              = 10;
	public static BiMap<String, Integer> DEVICE_TYPES = HashBiMap.create();
	public static BiMap<String, String> DEVICE_BRANDS = HashBiMap.create();
	public static List<Integer> MOBILES = Arrays.asList(new Integer[] {
			DEVICE_TYPE_FEATURE_PHONE,
	        DEVICE_TYPE_SMARTPHONE,
	        DEVICE_TYPE_TABLET,
	        DEVICE_TYPE_PHABLET,
	        DEVICE_TYPE_CAMERA,
	        DEVICE_TYPE_PORTABLE_MEDIA_PAYER
	});
	public DeviceParserAbstract(String type, String file) {
		super(type, file);		
	}	
	static{
		DEVICE_TYPES.put("desktop", DEVICE_TYPE_DESKTOP);
		DEVICE_TYPES.put("smartphone", DEVICE_TYPE_SMARTPHONE);
		DEVICE_TYPES.put("tablet", DEVICE_TYPE_TABLET);
		DEVICE_TYPES.put("feature phone", DEVICE_TYPE_FEATURE_PHONE);
		DEVICE_TYPES.put("console", DEVICE_TYPE_CONSOLE);
		DEVICE_TYPES.put("tv", DEVICE_TYPE_TV);
		DEVICE_TYPES.put("car browser", DEVICE_TYPE_CAR_BROWSER);
		DEVICE_TYPES.put("smart display", DEVICE_TYPE_SMART_DISPLAY);
		DEVICE_TYPES.put("camera", DEVICE_TYPE_CAMERA);
		DEVICE_TYPES.put("portable media player", DEVICE_TYPE_PORTABLE_MEDIA_PAYER);
		DEVICE_TYPES.put("phablet", DEVICE_TYPE_PHABLET);
		DEVICE_BRANDS.put("3Q", "3Q");
        DEVICE_BRANDS.put("AC", "Acer");
        DEVICE_BRANDS.put("AZ", "Ainol");
        DEVICE_BRANDS.put("AI", "Airness");
        DEVICE_BRANDS.put("AL", "Alcatel");
        DEVICE_BRANDS.put("A2", "Allview");
        DEVICE_BRANDS.put("A1", "Altech UEC");
        DEVICE_BRANDS.put("AN", "Arnova");
        DEVICE_BRANDS.put("KN", "Amazon");
        DEVICE_BRANDS.put("AO", "Amoi");
        DEVICE_BRANDS.put("AP", "Apple");
        DEVICE_BRANDS.put("AR", "Archos");
        DEVICE_BRANDS.put("AS", "ARRIS");
        DEVICE_BRANDS.put("AT", "Airties");
        DEVICE_BRANDS.put("AU", "Asus");
        DEVICE_BRANDS.put("AV", "Avvio");
        DEVICE_BRANDS.put("AX", "Audiovox");
        DEVICE_BRANDS.put("AY", "Axxion");
        DEVICE_BRANDS.put("BB", "BBK");
        DEVICE_BRANDS.put("BE", "Becker");
        DEVICE_BRANDS.put("BI", "Bird");
        DEVICE_BRANDS.put("BL", "Beetel");
        DEVICE_BRANDS.put("BM", "Bmobile");
        DEVICE_BRANDS.put("BN", "Barnes & Noble");
        DEVICE_BRANDS.put("BO", "BangOlufsen");
        DEVICE_BRANDS.put("BQ", "BenQ");
        DEVICE_BRANDS.put("BS", "BenQ-Siemens");
        DEVICE_BRANDS.put("BU", "Blu");
        DEVICE_BRANDS.put("BW", "Boway");
        DEVICE_BRANDS.put("BX", "bq");
        DEVICE_BRANDS.put("BV", "Bravis");
        DEVICE_BRANDS.put("BR", "Brondi");
        DEVICE_BRANDS.put("B1", "Bush");
        DEVICE_BRANDS.put("CB", "CUBOT");
        DEVICE_BRANDS.put("CF", "Carrefour");
        DEVICE_BRANDS.put("CP", "Captiva");
        DEVICE_BRANDS.put("CS", "Casio");
        DEVICE_BRANDS.put("CA", "Cat");
        DEVICE_BRANDS.put("CE", "Celkon");
        DEVICE_BRANDS.put("CC", "ConCorde");
        DEVICE_BRANDS.put("C2", "Changhong");
        DEVICE_BRANDS.put("CH", "Cherry Mobile");
        DEVICE_BRANDS.put("CK", "Cricket");
        DEVICE_BRANDS.put("C1", "Crosscall");
        DEVICE_BRANDS.put("CL", "Compal");
        DEVICE_BRANDS.put("CN", "CnM");
        DEVICE_BRANDS.put("CM", "Crius Mea");
        DEVICE_BRANDS.put("CR", "CreNova");
        DEVICE_BRANDS.put("CT", "Capitel");
        DEVICE_BRANDS.put("CQ", "Compaq");
        DEVICE_BRANDS.put("CO", "Coolpad");
        DEVICE_BRANDS.put("CW", "Cowon");
        DEVICE_BRANDS.put("CU", "Cube");
        DEVICE_BRANDS.put("CY", "Coby Kyros");
        DEVICE_BRANDS.put("DA", "Danew");
        DEVICE_BRANDS.put("DT", "Datang");
        DEVICE_BRANDS.put("DE", "Denver");
        DEVICE_BRANDS.put("DS", "Desay");
        DEVICE_BRANDS.put("DB", "Dbtel");
        DEVICE_BRANDS.put("DC", "DoCoMo");
        DEVICE_BRANDS.put("DI", "Dicam");
        DEVICE_BRANDS.put("DL", "Dell");
        DEVICE_BRANDS.put("DN", "DNS");
        DEVICE_BRANDS.put("DM", "DMM");
        DEVICE_BRANDS.put("DO", "Doogee");
        DEVICE_BRANDS.put("DV", "Doov");
        DEVICE_BRANDS.put("DP", "Dopod");
        DEVICE_BRANDS.put("DU", "Dune HD");
        DEVICE_BRANDS.put("EB", "E-Boda");
        DEVICE_BRANDS.put("EA", "EBEST");
        DEVICE_BRANDS.put("EC", "Ericsson");
        DEVICE_BRANDS.put("ES", "ECS");
        DEVICE_BRANDS.put("EI", "Ezio");
        DEVICE_BRANDS.put("EL", "Elephone");
        DEVICE_BRANDS.put("EP", "Easypix");
        DEVICE_BRANDS.put("E1", "Energy Sistem");
        DEVICE_BRANDS.put("ER", "Ericy");
        DEVICE_BRANDS.put("EN", "Eton");
        DEVICE_BRANDS.put("ET", "eTouch");
        DEVICE_BRANDS.put("EV", "Evertek");
        DEVICE_BRANDS.put("EX", "Explay");
        DEVICE_BRANDS.put("EZ", "Ezze");
        DEVICE_BRANDS.put("FA", "Fairphone");
        DEVICE_BRANDS.put("FL", "Fly");
        DEVICE_BRANDS.put("FO", "Foxconn");
        DEVICE_BRANDS.put("FU", "Fujitsu");
        DEVICE_BRANDS.put("GM", "Garmin-Asus");
        DEVICE_BRANDS.put("GA", "Gateway");
        DEVICE_BRANDS.put("GD", "Gemini");
        DEVICE_BRANDS.put("GI", "Gionee");
        DEVICE_BRANDS.put("GG", "Gigabyte");
        DEVICE_BRANDS.put("GS", "Gigaset");
        DEVICE_BRANDS.put("GC", "GOCLEVER");
        DEVICE_BRANDS.put("GL", "Goly");
        DEVICE_BRANDS.put("GO", "Google");
        DEVICE_BRANDS.put("GR", "Gradiente");
        DEVICE_BRANDS.put("GU", "Grundig");
        DEVICE_BRANDS.put("HA", "Haier");
        DEVICE_BRANDS.put("HS", "Hasee");
        DEVICE_BRANDS.put("HI", "Hisense");
        DEVICE_BRANDS.put("HL", "Hi-Level");
        DEVICE_BRANDS.put("HM", "Homtom");
        DEVICE_BRANDS.put("HO", "Hosin");
        DEVICE_BRANDS.put("HP", "HP");
        DEVICE_BRANDS.put("HT", "HTC");
        DEVICE_BRANDS.put("HU", "Huawei");
        DEVICE_BRANDS.put("HX", "Humax");
        DEVICE_BRANDS.put("HY", "Hyrican");
        DEVICE_BRANDS.put("HN", "Hyundai");
        DEVICE_BRANDS.put("IA", "Ikea");
        DEVICE_BRANDS.put("IB", "iBall");
        DEVICE_BRANDS.put("IJ", "i-Joy");
        DEVICE_BRANDS.put("IY", "iBerry");
        DEVICE_BRANDS.put("IK", "iKoMo");
        DEVICE_BRANDS.put("IM", "i-mate");
        DEVICE_BRANDS.put("I1", "iOcean");
        DEVICE_BRANDS.put("IW", "iNew");
        DEVICE_BRANDS.put("IF", "Infinix");
        DEVICE_BRANDS.put("IN", "Innostream");
        DEVICE_BRANDS.put("II", "Inkti");
        DEVICE_BRANDS.put("IX", "Intex");
        DEVICE_BRANDS.put("IO", "i-mobile");
        DEVICE_BRANDS.put("IQ", "INQ");
        DEVICE_BRANDS.put("IT", "Intek");
        DEVICE_BRANDS.put("IV", "Inverto");
        DEVICE_BRANDS.put("IZ", "iTel");
        DEVICE_BRANDS.put("JI", "Jiayu");
        DEVICE_BRANDS.put("JO", "Jolla");
        DEVICE_BRANDS.put("KA", "Karbonn");
        DEVICE_BRANDS.put("KD", "KDDI");
        DEVICE_BRANDS.put("K1", "Kiano");
        DEVICE_BRANDS.put("KI", "Kingsun");
        DEVICE_BRANDS.put("KO", "Konka");
        DEVICE_BRANDS.put("KM", "Komu");
        DEVICE_BRANDS.put("KB", "Koobee");
        DEVICE_BRANDS.put("KT", "K-Touch");
        DEVICE_BRANDS.put("KH", "KT-Tech");
        DEVICE_BRANDS.put("KP", "KOPO");
        DEVICE_BRANDS.put("KR", "Koridy");
        DEVICE_BRANDS.put("KU", "Kumai");
        DEVICE_BRANDS.put("KY", "Kyocera");
        DEVICE_BRANDS.put("KZ", "Kazam");
        DEVICE_BRANDS.put("LV", "Lava");
        DEVICE_BRANDS.put("LA", "Lanix");
        DEVICE_BRANDS.put("LC", "LCT");
        DEVICE_BRANDS.put("L1", "LeEco");
        DEVICE_BRANDS.put("LE", "Lenovo");
        DEVICE_BRANDS.put("LN", "Lenco");
        DEVICE_BRANDS.put("LP", "Le Pan");
        DEVICE_BRANDS.put("LG", "LG");
        DEVICE_BRANDS.put("LI", "Lingwin");
        DEVICE_BRANDS.put("LO", "Loewe");
        DEVICE_BRANDS.put("LM", "Logicom");
        DEVICE_BRANDS.put("LX", "Lexibook");
        DEVICE_BRANDS.put("MJ", "Majestic");
        DEVICE_BRANDS.put("MA", "Manta Multimedia");
        DEVICE_BRANDS.put("MB", "Mobistel");
        DEVICE_BRANDS.put("M3", "Mecer");
        DEVICE_BRANDS.put("MD", "Medion");
        DEVICE_BRANDS.put("M2", "MEEG");
        DEVICE_BRANDS.put("M1", "Meizu");
        DEVICE_BRANDS.put("ME", "Metz");
        DEVICE_BRANDS.put("MX", "MEU");
        DEVICE_BRANDS.put("MI", "MicroMax");
        DEVICE_BRANDS.put("M5", "MIXC");
        DEVICE_BRANDS.put("MC", "Mediacom");
        DEVICE_BRANDS.put("MK", "MediaTek");
        DEVICE_BRANDS.put("MO", "Mio");
        DEVICE_BRANDS.put("MM", "Mpman");
        DEVICE_BRANDS.put("M4", "Modecom");
        DEVICE_BRANDS.put("MF", "Mofut");
        DEVICE_BRANDS.put("MR", "Motorola");
        DEVICE_BRANDS.put("MS", "Microsoft");
        DEVICE_BRANDS.put("MZ", "MSI");
        DEVICE_BRANDS.put("MU", "Memup");
        DEVICE_BRANDS.put("MT", "Mitsubishi");
        DEVICE_BRANDS.put("ML", "MLLED");
        DEVICE_BRANDS.put("MQ", "M.T.T.");
        DEVICE_BRANDS.put("MY", "MyPhone");
        DEVICE_BRANDS.put("NE", "NEC");
        DEVICE_BRANDS.put("NA", "Netgear");
        DEVICE_BRANDS.put("NG", "NGM");
        DEVICE_BRANDS.put("NO", "Nous");
        DEVICE_BRANDS.put("NI", "Nintendo");
        DEVICE_BRANDS.put("N1", "Noain");
        DEVICE_BRANDS.put("NK", "Nokia");
        DEVICE_BRANDS.put("NM", "Nomi");
        DEVICE_BRANDS.put("NN", "Nikon");
        DEVICE_BRANDS.put("NW", "Newgen");
        DEVICE_BRANDS.put("NX", "Nexian");
        DEVICE_BRANDS.put("NT", "NextBook");
        DEVICE_BRANDS.put("OD", "Onda");
        DEVICE_BRANDS.put("ON", "OnePlus");
        DEVICE_BRANDS.put("OP", "OPPO");
        DEVICE_BRANDS.put("OR", "Orange");
        DEVICE_BRANDS.put("OT", "O2");
        DEVICE_BRANDS.put("OK", "Ouki");
        DEVICE_BRANDS.put("OU", "OUYA");
        DEVICE_BRANDS.put("OO", "Opsson");
        DEVICE_BRANDS.put("PA", "Panasonic");
        DEVICE_BRANDS.put("PE", "PEAQ");
        DEVICE_BRANDS.put("PG", "Pentagram");
        DEVICE_BRANDS.put("PH", "Philips");
        DEVICE_BRANDS.put("PI", "Pioneer");
        DEVICE_BRANDS.put("PL", "Polaroid");
        DEVICE_BRANDS.put("PM", "Palm");
        DEVICE_BRANDS.put("PO", "phoneOne");
        DEVICE_BRANDS.put("PT", "Pantech");
        DEVICE_BRANDS.put("PY", "Ployer");
        DEVICE_BRANDS.put("PV", "Point of View");
        DEVICE_BRANDS.put("PP", "PolyPad");
        DEVICE_BRANDS.put("P2", "Pomp");
        DEVICE_BRANDS.put("PS", "Positivo");
        DEVICE_BRANDS.put("PR", "Prestigio");
        DEVICE_BRANDS.put("P1", "ProScan");
        DEVICE_BRANDS.put("PU", "PULID");
        DEVICE_BRANDS.put("QI", "Qilive");
        DEVICE_BRANDS.put("QT", "Qtek");
        DEVICE_BRANDS.put("QM", "QMobile");
        DEVICE_BRANDS.put("QU", "Quechua");
        DEVICE_BRANDS.put("OV", "Overmax");
        DEVICE_BRANDS.put("OY", "Oysters");
        DEVICE_BRANDS.put("RA", "Ramos");
        DEVICE_BRANDS.put("RC", "RCA Tablets");
        DEVICE_BRANDS.put("RB", "Readboy");
        DEVICE_BRANDS.put("RI", "Rikomagic");
        DEVICE_BRANDS.put("RM", "RIM");
        DEVICE_BRANDS.put("RK", "Roku");
        DEVICE_BRANDS.put("RO", "Rover");
        DEVICE_BRANDS.put("SA", "Samsung");
        DEVICE_BRANDS.put("SD", "Sega");
        DEVICE_BRANDS.put("SE", "Sony Ericsson");
        DEVICE_BRANDS.put("S1", "Sencor");
        DEVICE_BRANDS.put("SF", "Softbank");
        DEVICE_BRANDS.put("SX", "SFR");
        DEVICE_BRANDS.put("SG", "Sagem");
        DEVICE_BRANDS.put("SH", "Sharp");
        DEVICE_BRANDS.put("SI", "Siemens");
        DEVICE_BRANDS.put("SN", "Sendo");
        DEVICE_BRANDS.put("S6", "Senseit");
        DEVICE_BRANDS.put("SK", "Skyworth");
        DEVICE_BRANDS.put("SC", "Smartfren");
        DEVICE_BRANDS.put("SO", "Sony");
        DEVICE_BRANDS.put("SP", "Spice");
        DEVICE_BRANDS.put("SU", "SuperSonic");
        DEVICE_BRANDS.put("S5", "Supra");
        DEVICE_BRANDS.put("SV", "Selevision");
        DEVICE_BRANDS.put("SY", "Sanyo");
        DEVICE_BRANDS.put("SM", "Symphony");
        DEVICE_BRANDS.put("SR", "Smart");
        DEVICE_BRANDS.put("S7", "Smartisan");
        DEVICE_BRANDS.put("S4", "Star");
        DEVICE_BRANDS.put("ST", "Storex");
        DEVICE_BRANDS.put("S2", "Stonex");
        DEVICE_BRANDS.put("S3", "SunVan");
        DEVICE_BRANDS.put("SZ", "Sumvision");
        DEVICE_BRANDS.put("TA", "Tesla");
        DEVICE_BRANDS.put("T5", "TB Touch");
        DEVICE_BRANDS.put("TC", "TCL");
        DEVICE_BRANDS.put("TE", "Telit");
        DEVICE_BRANDS.put("T4", "ThL");
        DEVICE_BRANDS.put("TH", "TiPhone");
        DEVICE_BRANDS.put("TB", "Tecno Mobile");
        DEVICE_BRANDS.put("TD", "Tesco");
        DEVICE_BRANDS.put("TI", "TIANYU");
        DEVICE_BRANDS.put("TL", "Telefunken");
        DEVICE_BRANDS.put("T2", "Telenor");
        DEVICE_BRANDS.put("TM", "T-Mobile");
        DEVICE_BRANDS.put("TN", "Thomson");
        DEVICE_BRANDS.put("T1", "Tolino");
        DEVICE_BRANDS.put("TO", "Toplux");
        DEVICE_BRANDS.put("TS", "Toshiba");
        DEVICE_BRANDS.put("TT", "TechnoTrend");
        DEVICE_BRANDS.put("T3", "Trevi");
        DEVICE_BRANDS.put("TU", "Tunisie Telecom");
        DEVICE_BRANDS.put("TR", "Turbo-X");
        DEVICE_BRANDS.put("TV", "TVC");
        DEVICE_BRANDS.put("TX", "TechniSat");
        DEVICE_BRANDS.put("TZ", "teXet");
        DEVICE_BRANDS.put("UN", "Unowhy");
        DEVICE_BRANDS.put("US", "Uniscope");
        DEVICE_BRANDS.put("UT", "UTStarcom");
        DEVICE_BRANDS.put("VA", "Vastking");
        DEVICE_BRANDS.put("VD", "Videocon");
        DEVICE_BRANDS.put("VE", "Vertu");
        DEVICE_BRANDS.put("VI", "Vitelcom");
        DEVICE_BRANDS.put("VK", "VK Mobile");
        DEVICE_BRANDS.put("VS", "ViewSonic");
        DEVICE_BRANDS.put("VT", "Vestel");
        DEVICE_BRANDS.put("VV", "Vivo");
        DEVICE_BRANDS.put("V1", "Voto");
        DEVICE_BRANDS.put("VO", "Voxtel");
        DEVICE_BRANDS.put("VF", "Vodafone");
        DEVICE_BRANDS.put("VZ", "Vizio");
        DEVICE_BRANDS.put("VW", "Videoweb");
        DEVICE_BRANDS.put("WA", "Walton");
        DEVICE_BRANDS.put("WE", "WellcoM");
        DEVICE_BRANDS.put("WY", "Wexler");
        DEVICE_BRANDS.put("WI", "Wiko");
        DEVICE_BRANDS.put("WL", "Wolder");
        DEVICE_BRANDS.put("WO", "Wonu");
        DEVICE_BRANDS.put("WX", "Woxter");
        DEVICE_BRANDS.put("XI", "Xiaomi");
        DEVICE_BRANDS.put("XO", "Xolo");
        DEVICE_BRANDS.put("YA", "Yarvik");
        DEVICE_BRANDS.put("YU", "Yuandao");
        DEVICE_BRANDS.put("YS", "Yusun");
        DEVICE_BRANDS.put("YT", "Ytone");
        DEVICE_BRANDS.put("ZE", "Zeemi");
        DEVICE_BRANDS.put("ZO", "Zonda");
        DEVICE_BRANDS.put("ZP", "Zopo");
        DEVICE_BRANDS.put("ZT", "ZTE");
        DEVICE_BRANDS.put("WB", "Web TV");
        DEVICE_BRANDS.put("XX", "Unknown");
	}
	/**
	 * @param userAgent
	 * @return
	 */
	public DetectResult parse(String userAgent) {
		//yaml of device default to a single map 
		Map<String,Object> regexes = this.getRegexes().get(0);
		Map<String,Object> thisRegex = null;
		List<String> matches = null;
		String brand = null;
		String brandId = null;
        for (Map.Entry<String, Object> e : regexes.entrySet()) {        	
        	Map<String,Object> regex = (Map)e.getValue();
            matches = this.matchUserAgent(userAgent, regex.get("regex").toString());
//            if(regex.get("model").toString().equals("Xperia XZ1")) {
//            	System.out.println("123");
//            }
            if (matches!=null && matches.size()>0) {
            	thisRegex = regex;
            	brand = e.getKey();
                break;
            }
        }
        if (matches==null || matches.size()<1) {
            return null;
        }
        if (!"Unknown".equals(brand)) {
            brandId = DEVICE_BRANDS.inverse().get(brand);            
        }
        Object regexDevice = thisRegex.get("device");
        String device = null;
        Integer deviceType = null;
        if(regexDevice!=null && DEVICE_TYPES.containsKey(regexDevice.toString())) {
        	device = regexDevice.toString();
        	deviceType = DEVICE_TYPES.get(device);
        }
        String model = "";
        if (thisRegex.get("model")!=null) {
        	String regexModel = thisRegex.get("model").toString();
            model = this.buildModel(regexModel, matches);
        }
        if (thisRegex.get("models")!=null) {
        	List<Map<String, Object>> regexModels = (List<Map<String, Object>>)thisRegex.get("models");
            List<String> modelMatches = null;
            Map<String, Object> thisModelRegex = null;
            for(Map<String, Object> modelRegex : regexModels) {
				modelMatches = this.matchUserAgent(userAgent, modelRegex.get("regex").toString());
                if (modelMatches!=null && modelMatches.size()>0) {
                	thisModelRegex = modelRegex;
                    break;
                }
            }
            if (modelMatches!=null && thisModelRegex!=null) {
            	model = this.buildModel(thisModelRegex.get("model").toString(), modelMatches);
                if (thisModelRegex.get("brand")!=null && DEVICE_BRANDS.containsValue(thisModelRegex.get("brand").toString())) {
                    brand = thisModelRegex.get("brand").toString();
                    brandId = DEVICE_BRANDS.inverse().get(brand);
                }
                if (thisModelRegex.get("device")!=null && DEVICE_TYPES.containsKey(thisModelRegex.get("device"))) {
                    deviceType = DEVICE_TYPES.get(thisModelRegex.get("device"));
                }

            }
        }
        DetectResult ret = new DetectResult();
        ret.setDevice(device);
        ret.setDeviceType(deviceType);
        ret.setBrand(brand);
        ret.setBrandId(brandId);
        ret.setModel(model);
		return ret;
	}
	/**
	 * @param regexModel
	 * @param matches
	 * @return
	 */
	private String buildModel(String regexModel, List<String> matches) {
		String model = null;
		model = this.buildByMatch(regexModel, matches);
		model = model.replaceAll("_", "");
		model = model.replaceAll("/ TD$/i", "");
        if ("Build".equals(model)) {
            return null;
        }
        return model;
	}
	
	public static boolean isMobile(Integer deviceType){
		if(MOBILES.contains(deviceType)) {
			return true;
		}
		return false;
	}
}
