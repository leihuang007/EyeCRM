/**
 * 
 */
package cn.live.shinobi_hl.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Huanglei
 * 
 */
public class CommonUtils {

	/**
	 * 将URL形式的参数转化为MAP对象。
	 * 
	 * @param url
	 * @return
	 */
	public static Map<String, String> urlToMap(String url) {
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isBlank(url)) {
			String[] keyValues = url.split("&");
			String[] keyVa = null;
			for (String keyValue : keyValues) {
				keyVa = keyValue.split("=");
				if (keyVa.length == 2) {
					try {
						map.put(keyVa[0],
								java.net.URLDecoder.decode(keyVa[1], "UTF-8"));
					} catch (UnsupportedEncodingException e) {
					}
					System.out.println(keyVa[0] + " : " + keyVa[1]);
				} else if (keyVa.length == 1) {
					map.put(keyVa[0], "");
					System.out.println(keyVa[0] + " : " + "emp");
				}
			}
		}
		return map;
	}
}
