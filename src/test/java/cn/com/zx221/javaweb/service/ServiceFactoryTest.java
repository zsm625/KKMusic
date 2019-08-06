package cn.com.zx221.javaweb.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 业务层实例工厂测试
 * 
 * @author ZSM
 *
 * @version 创建时间:2019年8月1日下午4:45:10
 */
public class ServiceFactoryTest {
	@Test
	public void serviceFactoryTest() {
		ServiceFactory factory = ServiceFactory.getFactoryInstance();
		System.out.println(factory);
	}
	@Test
  	public void createSingerService() {
		ServiceFactory factory = ServiceFactory.getFactoryInstance();
		SingerService singer = factory.createSingerService();
		Assert.assertNotNull(singer);
	}
}
