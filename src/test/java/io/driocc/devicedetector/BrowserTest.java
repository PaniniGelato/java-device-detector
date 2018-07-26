/**
 * 
 */
package io.driocc.devicedetector;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.driocc.devicedetector.client.Browser;

/**
 * @author kyon
 *
 */
public class BrowserTest {
	@Test
	public void test() {	
		List<String> uas = new ArrayList<String>();
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; OPPO R9S Plus Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043313 Safari/537.36 ");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; MI 5 Build/MXB48T; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043313 Safari/537.36 MicroMessenger/6.5.10.1080 NetType/WIFI Language/zh_CN");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; MI NOTE LTE Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36; unicom{version:android@5.31,desmobile:15587929251}");
		uas.add("Mozilla/5.0 (Linux; Android 5.1.1; vivo X7 Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/39.0.0.0 Mobile Safari/537.36 Fanxing2/6.6665.3.6.0 NetType/WIFI FXBannerActivity/1");
		uas.add("Mozilla/5.0 (Linux; Android 6.0.1; vivo Y66 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/51.0.2704.81 Mobile Safari/537.36 WindVane/8.0.0 yk_web_sdk_1.0.4.1 Youku/6.9.0 (Android 6.0.1; Bridge_SDK; GUID a468f55b9f049e7be2bd3fd60b7e9534; UTDID WWNf+UIMaZwDAKoq3S+v27v4;)");
		uas.add("Mozilla/5.0 (Linux; Android 6.0; Le X620 Build/HEXCNFN5902606111S; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043313 Safari/537.36 V1_AND_SQ_7.1.5_708_YYB_D gamecenter QQ/7.1.5.3215 NetType/WIFI WebP/0.3.0 Pixel/1080");
		uas.add("Mozilla/5.0 (Linux; Android 6.0; GN8003 Build/MRA58K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile x5InKaraoke/6.2 TBS/043409 Safari/537.36 QQJSSDK/1.3  qua/V1_AND_KG_4.0.0_273_SJTX_D qmkege/4.0.0");
		uas.add("Dalvik/2.1.0 (Linux; U; Android 6.0.1; SM-G9350 Build/MMB29M");
		uas.add("Dalvik/1.6.0 (Linux; U; Android 4.2.1; Lenovo S898t MIUI/5.3.2)");
		uas.add("Dalvik/1.6.0 (Linux; U; Android 4.4.4; OPPO R7st Build/KTU84P");
		uas.add("Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11B554a Safari/9537.53");
		uas.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
				
		Browser b = new Browser();
		for(String ua : uas) {
			DetectResult ret = b.parse(ua);
			if(ret!=null) {
				System.out.println(ret.getName() + "," + ret.getShortName() + "," + ret.getVersion() + "," + ret.getEngine() + "," + ret.getEngineVersion());
			}else {
				System.out.println("cannot detect");
			}
		}
	}
}
