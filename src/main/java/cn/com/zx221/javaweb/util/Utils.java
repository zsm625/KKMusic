package cn.com.zx221.javaweb.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共处理工具
 * @author ZSM
 *
 * @time 2019年8月6日下午5:28:18
 */
public class Utils {

	public static String getStrTime(Timestamp timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = timestamp;
		String time = format.format(date);
		return time;
	}
}
