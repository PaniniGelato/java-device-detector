/**
 * 
 */
package io.driocc.devicedetector;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.MatchesPattern;

import org.junit.Test;

import io.driocc.devicedetector.utils.Utils;

/**
 * @author kyon
 *
 */
public class MatchTest {
	public List<String> matchUserAgent(String userAgent, String regex){
    	List<String> matches = null;
		if(Utils.isEmpty(userAgent)) {
			return null;
		}
		String regexStr = "(?:^|[^A-Z_-])(?:" + regex + ")";
		Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(userAgent);
		matcher.matches();
		while(matcher.find()) {
			if(matches!=null){
				matches = new ArrayList<String>();
			}
			matches.add(matcher.group());
		}
		return matches;
    }
	@Test
	public void t() {
		String ua = "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Mobile; SM-G9350 Build/MMB29M";
		matchUserAgent(ua, "Android( [\\.0-9]+)?; Mobile;");
	}
}
