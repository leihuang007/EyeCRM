/**
 * 
 */
package cn.live.shinobi_hl.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Huanglei
 * 
 */
public class DateFormater {

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
	public static final String LONG_FORMAT = "yyyy-MM-dd hh:mm:ss";
	public static final String NARROW_LONG_FORMAT = "yyyyMMddHHmmssSSSS";

	public static String dateToString(Date date) {
		if (null == date) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
			return sdf.format(date);
		}
	}

	public static String dateToString(Date date, String format) {
		if (null == date) {
			return "";
		} else if (StringUtils.isBlank(format)) {
			return dateToString(date);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
}
