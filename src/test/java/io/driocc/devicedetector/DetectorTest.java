/**
 * 
 */
package io.driocc.devicedetector;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.driocc.devicedetector.custom.CompositeDetectResult;

/**
 * @author kyon
 *
 */
public class DetectorTest {

	@Test
	public void test() {	
		List<String> uas = new ArrayList<String>();
		uas.add("Android/6.0.1 (samsung SM-G9280;zh_CN) App/3.4.8 AliApp(DingTalk/3.4.8) com.alibaba.android.rimet/0 Channel/10002068 language/zh-CN");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; OPPO R9S Plus Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043313 Safari/537.36 ");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; MI 5 Build/MXB48T; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043313 Safari/537.36 MicroMessenger/6.5.10.1080 NetType/WIFI Language/zh_CN");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; MI NOTE LTE Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36; unicom{version:android@5.31,desmobile:15587929251}");
		uas.add("Mozilla/5.0 (Linux; Android 5.1.1; vivo X7 Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/39.0.0.0 Mobile Safari/537.36 Fanxing2/6.6665.3.6.0 NetType/WIFI FXBannerActivity/1");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; vivo Y66 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704.81 Mobile Safari/537.36 WindVane/8.0.0 yk_web_sdk_1.0.4.1 Youku/6.9.0 (Android 6.0.1; Bridge_SDK; GUID a468f55b9f049e7be2bd3fd60b7e9534; UTDID WWNf+UIMaZwDAKoq3S+v27v4;)");
		uas.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		uas.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		uas.add("PlayStation 4");
		DeviceDetector d = new DeviceDetector();
		for(String ua : uas) {
			CompositeDetectResult ret = d.parse(ua);
			if(ret!=null) {
				System.out.println(ret);
			}
			System.out.println("--------------------------");
		}
	}
}
