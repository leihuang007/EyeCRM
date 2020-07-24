/**
 * 
 */
package cn.live.shinobi_hl.common.utils.uiTypeConverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 * @author Huanglei
 * 
 */
public class SqlDateConverter extends StrutsTypeConverter {

	private static String DATE_TIME_FOMART = "yyyy-MM-dd HH:mm:ss";

	private static String DATE_FOMART = "yyyy-MM-dd";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util
	 * .Map, java.lang.String[], java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (toClass != java.sql.Date.class) {
			return null;
		}
		Date date = null;
		String dateString = null;
		SimpleDateFormat format = null;
		if (values != null && values.length > 0) {
			try {
				dateString = values[0];
				if (StringUtils.isBlank(dateString)) {
					return null;
				}
				if (dateString.indexOf(' ') > 0) {
					format = new SimpleDateFormat(DATE_TIME_FOMART);
				} else {
					format = new SimpleDateFormat(DATE_FOMART);
				}
				date = format.parse(dateString);
			} catch (ParseException e) {
				date = null;
			}
		} else {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util
	 * .Map, java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		if (!(o instanceof java.sql.Date)) {
			return null;
		}
		Date d = (Date) o;
		SimpleDateFormat format = new SimpleDateFormat(DATE_FOMART);
		return format.format(d);
	}

}
