package io.driocc.devicedetector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.concurrent.ThreadSafe;

import io.driocc.devicedetector.client.Browser;
import io.driocc.devicedetector.client.ClientParserAbstract;
import io.driocc.devicedetector.client.FeedReader;
import io.driocc.devicedetector.client.Library;
import io.driocc.devicedetector.client.MediaPlayer;
import io.driocc.devicedetector.client.MobileApp;
import io.driocc.devicedetector.client.PIM;
import io.driocc.devicedetector.custom.CompositeDetectResult;
import io.driocc.devicedetector.custom.DetectConsultant;
import io.driocc.devicedetector.device.Camera;
import io.driocc.devicedetector.device.CarBrowser;
import io.driocc.devicedetector.device.Console;
import io.driocc.devicedetector.device.DeviceParserAbstract;
import io.driocc.devicedetector.device.HbbTv;
import io.driocc.devicedetector.device.Mobile;
import io.driocc.devicedetector.device.PortableMediaPlayer;
import io.driocc.devicedetector.utils.Utils;

@ThreadSafe
public class DeviceDetector implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * Current version number of DeviceDetector
     */
    //static final String VERSION = "3.10.2";
	
    /**
     * Holds all registered client types
     * @var array
     */
    public static List<String> clientTypes = new ArrayList<>();
    protected List<ClientParserAbstract> clientParsers;
    protected List<DeviceParserAbstract> deviceParsers;
    protected OperatingSystem osParser;
    protected Bot botParser;
    protected VendorFragment vendorParser;
    private boolean skipBotDetection = false;
    /**
     * Constructor
     *
     * @param string $userAgent UA to parse
     */
    public DeviceDetector(){
    	clientParsers = new ArrayList<>();
    	clientParsers.add(new FeedReader());
        clientParsers.add(new MobileApp());
        clientParsers.add(new MediaPlayer());
        clientParsers.add(new PIM());
        clientParsers.add(new Browser());
        clientParsers.add(new Library());
        deviceParsers = new ArrayList<>();
        deviceParsers.add(new HbbTv());
        deviceParsers.add(new Console());
        deviceParsers.add(new CarBrowser());
        deviceParsers.add(new Camera());
        deviceParsers.add(new PortableMediaPlayer());
        deviceParsers.add(new Mobile());
        osParser = new OperatingSystem();
        botParser = new Bot();
        vendorParser = new VendorFragment();
    }
    
    public List<ClientParserAbstract> getClientParsers(){
        return this.clientParsers;
    }
    
    public List<DeviceParserAbstract> getDeviceParsers(){
        return this.deviceParsers;
    }
    public Bot getBotParser(){
        return this.botParser;
    }

    /**
     * Sets whether to discard additional bot information
     * If information is discarded it's only possible check whether UA was detected as bot or not.
     * (Discarding information speeds up the detection a bit)
     *
     * @param bool $discard
     */
    public void discardBotInformation(boolean discard){
    	botParser.setDiscardDetails(discard);
    }

    /**
     * Sets whether to skip bot detection.
     * It is needed if we want bots to be processed as a simple clients. So we can detect if it is mobile client,
     * or desktop, or enything else. By default all this information is not retrieved for the bots.
     *
     * @param bool $skip
     */
    public void skipBotDetection(boolean skip){
        this.skipBotDetection = skip;
    }

    /**
     * Returns if the parsed UA was identified as a touch enabled device
     *
     * Note: That only applies to windows 8 tablets
     *
     * @return bool
     */
    public boolean isTouchEnabled(String userAgent){
        String regex = "Touch";
        List<String> ret = this.matchUserAgent(userAgent, regex);
        if(ret!=null && ret.size()>0) {
        	return true;
        }
        return false;
    }

    /**
     * Returns if the parsed UA contains the 'Android; Tablet;' fragment
     *
     * @return bool
     */
    protected boolean hasAndroidTableFragment(String userAgent){
    	String regex = "Android( [\\.0-9]+)?; Tablet;";
    	List<String> ret = this.matchUserAgent(userAgent, regex);
        if(ret!=null && ret.size()>0) {
        	return true;
        }
        return false;
    }

    /**
     * Returns if the parsed UA contains the 'Android; Mobile;' fragment
     *
     * @return bool
     */
    protected boolean hasAndroidMobileFragment(String userAgent){
    	String regex = "Android( [\\.0-9]+)?; Mobile;";
    	List<String> ret = this.matchUserAgent(userAgent, regex);
    	if(ret!=null && ret.size()>0) {
        	return true;
        }
        return false;
    }
    
    private static Pattern LETTER_PATTERN = Pattern.compile("([a-z])", Pattern.CASE_INSENSITIVE);
    /**
     * Triggers the parsing of the current user agent
     */
    public CompositeDetectResult parse(String userAgent) {
    	CompositeDetectResult ret = null;
        // skip parsing for empty useragents or those not containing any letter
        if (Utils.isEmpty(userAgent)) {
            return null;
        }
        if(!LETTER_PATTERN.matcher(userAgent).find()) {
        	return null;
        }
        DetectResult bot = this.parseBot(userAgent);
        if (bot!=null && bot.isBot()) {
        	ret = new CompositeDetectResult();
            return ret;
        }
        DetectResult os = this.parseOs(userAgent);
        /**
         * Parse Clients
         * Clients might be browsers, Feed Readers, Mobile Apps, Media Players or
         * any other application accessing with an parseable UA
         */
        DetectResult client = this.parseClient(userAgent);
        DetectResult device = this.parseDevice(userAgent, client, os);
        ret = new CompositeDetectResult();
        ret.setClient(client);
        ret.setOs(os);
        ret.setDevice(device);
        return ret;
    }
    
    /**
     * Parses the UA for bot information using the Bot parser
     */
    protected DetectResult parseBot(String userAgent){
        if (skipBotDetection) {
            return null;
        }
        DetectResult ret = botParser.parse(userAgent);
		return ret;
    }
    protected DetectResult parseClient(String userAgent){
    	DetectResult ret = null;
        for(ClientParserAbstract p : this.clientParsers) {
        	ret = p.parse(userAgent);
        	if(ret!=null) {
        		break;
        	}
        }
        return ret;
    }
    protected DetectResult parseDevice(String userAgent, DetectResult client, DetectResult os){
    	DetectResult ret = null;
        for (DeviceParserAbstract p : getDeviceParsers()) {
            DetectResult _temp = p.parse(userAgent);
            if(_temp!=null) {
            	ret = _temp;
                break;
            }
        }
        if(ret==null) {
        	ret = new DetectResult();
        }
        /**
         * If no brand has been assigned try to match by known vendor fragments
         */
        String brand = ret.getBrand();
        String brandId = ret.getBrandId();
        if (Utils.isEmpty(ret.getBrand())) {
        	DetectResult v = vendorParser.parse(userAgent);
        	if(v!=null) {
	        	brand = v.getBrand();
	        	brandId = v.getBrandId();
	        	ret.setBrandId(brandId);
        	}
        }
        String osShortName = os!=null?os.getShortName():null;
        String osFamily = OperatingSystem.getOsFamily(osShortName);
        String osVersion = os!=null?os.getVersion():null;
        String clientName = client!=null?client.getName():null;
        /**
         * Assume all devices running iOS / Mac OS are from Apple
         */
        List<String> APPLE = Arrays.asList(new String[] {"ATV", "IOS", "MAC"});
        if (Utils.isEmpty(brand) && APPLE.contains(osShortName)) {
            brand = "AP";
        }
        /**
         * Chrome on Android passes the device type based on the keyword 'Mobile'
         * If it is present the device should be a smartphone, otherwise it's a tablet
         * See https://developer.chrome.com/multidevice/user-agent#chrome_for_android_user_agent
         */
        List<String> CHROME = Arrays.asList(new String[] {"Chrome", "Chrome Mobile"});
        String device = ret.getDevice();
        Integer deviceType = ret.getDeviceType();
        if (Utils.isEmpty(device) && "Android".equals(osFamily) && CHROME.contains(client.getName())) {
            List<String> m1 = this.matchUserAgent(userAgent, "Chrome/[\\.0-9]* Mobile");
            if(m1!=null && m1.size()>0){
            	deviceType = DeviceParserAbstract.DEVICE_TYPE_SMARTPHONE;
            } else {
            	List<String> m2 = this.matchUserAgent(userAgent, "Chrome/[\\.0-9]* (?!Mobile)");
            	if(m2!=null && m2.size()>0){
            		deviceType = DeviceParserAbstract.DEVICE_TYPE_TABLET;
            	}
            }
        }
        /**
         * Some user agents simply contain the fragment 'Android; Tablet;' or 'Opera Tablet', so we assume those devices as tablets
         */
        if (Utils.isEmpty(device) && (this.hasAndroidTableFragment(userAgent) || this.matchUserAgent(userAgent, "Opera Tablet")!=null)) {
        	deviceType = DeviceParserAbstract.DEVICE_TYPE_TABLET;
        }
        /**
         * Some user agents simply contain the fragment 'Android; Mobile;', so we assume those devices as smartphones
         */
        if (Utils.isEmpty(device) && this.hasAndroidMobileFragment(userAgent)) {
        	deviceType = DeviceParserAbstract.DEVICE_TYPE_SMARTPHONE;
        }
        /**
         * Android up to 3.0 was designed for smartphones only. But as 3.0, which was tablet only, was published
         * too late, there were a bunch of tablets running with 2.x
         * With 4.0 the two trees were merged and it is for smartphones and tablets
         *
         * So were are expecting that all devices running Android < 2 are smartphones
         * Devices running Android 3.X are tablets. Device type of Android 2.X and 4.X+ are unknown
         */
        if (Utils.isEmpty(device) && "AND".equals(osShortName) && !"".equals(osVersion)) {
            if (Utils.versionCompare(osVersion, "2.0") == -1) {
            	deviceType = DeviceParserAbstract.DEVICE_TYPE_SMARTPHONE;
            } else if (Utils.versionCompare(osVersion, "3.0") >= 0 && Utils.versionCompare(osVersion, "4.0") == -1) {
            	deviceType = DeviceParserAbstract.DEVICE_TYPE_TABLET;
            }
        }
        /**
         * All detected feature phones running android are more likely a smartphone
         */
        if (deviceType == DeviceParserAbstract.DEVICE_TYPE_FEATURE_PHONE && "Android".equals(osFamily)) {
        	deviceType = DeviceParserAbstract.DEVICE_TYPE_SMARTPHONE;
        }
        /**
         * According to http://msdn.microsoft.com/en-us/library/ie/hh920767(v=vs.85).aspx
         * Internet Explorer 10 introduces the "Touch" UA string token. If this token is present at the end of the
         * UA string, the computer has touch capability, and is running Windows 8 (or later).
         * This UA string will be transmitted on a touch-enabled system running Windows 8 (RT)
         *
         * As most touch enabled devices are tablets and only a smaller part are desktops/notebooks we assume that
         * all Windows 8 touch devices are tablets.
         */
        if (Utils.isEmpty(device) && ("WRT".equals(osShortName) || ("WIN".equals(osShortName) && Utils.versionCompare(osVersion, "8.0")>0) && isTouchEnabled(userAgent))) {
            deviceType = DeviceParserAbstract.DEVICE_TYPE_TABLET;
        }
        /**
         * All devices running Opera TV Store are assumed to be a tv
         */
        if (this.matchUserAgent(userAgent, "Opera TV Store")!=null) {
            deviceType = DeviceParserAbstract.DEVICE_TYPE_TV;
        }
        /**
         * Devices running Kylo or Espital TV Browsers are assumed to be a TV
         */
        List<String> Kylo = Arrays.asList(new String[] {"Kylo", "Espial TV Browser"});
        if (Utils.isEmpty(device) && Kylo.contains(clientName)) {
        	deviceType = DeviceParserAbstract.DEVICE_TYPE_TV;
        }
        // set device type to desktop for all devices running a desktop os that were not detected as an other device type
        if (Utils.isEmpty(device) && client!=null && DetectConsultant.isDesktop(osShortName, client.getType(), client.getShortName())) {
            deviceType = DeviceParserAbstract.DEVICE_TYPE_DESKTOP;
        }
        if(deviceType!=null) {
        	ret.setDeviceType(deviceType);
        	ret.setDevice(DeviceParserAbstract.DEVICE_TYPES.inverse().get(deviceType));
        }
        return ret;
    }

    protected DetectResult parseOs(String userAgent){
        return this.osParser.parse(userAgent);
    }

    public List<String> matchUserAgent(String userAgent, String regex){
    	if(Utils.isEmpty(userAgent)) {
			return null;
		}
		String regexStr = "(?:^|[^A-Z_-])(?:" + regex + ")";
		Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(userAgent);
		List<String> matches = null;
		while(matcher.find()) {
			if(matches==null) {
				matches = new ArrayList<String>();
			}
			matches.add(matcher.group());
		}
		return matches;
    }

}
