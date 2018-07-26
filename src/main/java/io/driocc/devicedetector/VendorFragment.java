/**
 * 
 */
package io.driocc.devicedetector;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.driocc.devicedetector.device.DeviceParserAbstract;

/**
 * @author kyon
 *
 */
public class VendorFragment extends ParserAbstract {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String FIXTURE_FILE = "regexes/vendorfragments.yml";
    protected static final String PARSER = "vendorfragments";
    public VendorFragment() {
    	super(PARSER,FIXTURE_FILE);
    }
    public VendorFragment(String type, String file) {
    	super(type, file);
    }
    public DetectResult parse(String userAgent){
    	Map<String,Object> rs = this.getRegexes().get(0);
    	for (Entry<String,Object> e : rs.entrySet()) {
    		String brand = e.getKey();
    		List<String> regexes = (List<String>)e.getValue();
    		for (String r : regexes) {
                List<String> matches = this.matchUserAgent(userAgent, r + "[^a-z0-9]+");
                if(matches!=null && matches.size()>0) {
                	String brandId = DeviceParserAbstract.DEVICE_BRANDS.inverse().get(brand);
                	DetectResult ret = new DetectResult();
                	ret.setBrand(brand);
                	ret.setBrandId(brandId);
                	return ret;
                }
            }
        }
        return null;
    }
}