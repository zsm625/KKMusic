package cn.com.zx221.javaweb.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;

import cn.com.zx221.javaweb.service.IUserService;
import cn.com.zx221.javaweb.service.ServiceFactory;

public class TestUserServiceImpl {
	IUserService userService = ServiceFactory.getFactoryInstance().createIUserService();
	@Test
	public void regist() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.format(date);
		boolean flag = userService.regist("小宇","232fddc","13254",date);
		System.out.println(flag);
	}
	@Test
	public void findPassword() {
		String password = userService.findPassword("13574572193");
		System.out.println(password);
	}	
}
