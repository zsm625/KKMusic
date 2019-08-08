package cn.com.zx221.javaweb.util;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class UtilsTest {
	/**
	 * 对时间转换的测试
	 *@author ZSM
	 */
	@Test
	public void getStrTimeTest() {
		Date date = new Date();
		Timestamp time =new Timestamp(date.getTime());
		String strTime = Utils.getStrTime(time);
		System.out.println(strTime);
	}
}
