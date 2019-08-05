package cn.com.zx221.javaweb.service;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;


/**
 * 业务层实例创建的工厂
 * @author ZSM
 *
 * @version 创建时间:2019年8月1日下午4:42:44
 */
public class ServiceFactory {
	
	private static ServiceFactory factory;
	private Properties props = new Properties();
	private ServiceFactory() {
		this.init();
	}
	
	/**
	 *初始化加载配置文件 
	 */
	private void init() {
		InputStream inStream = ServiceFactory.class.getClassLoader().getResourceAsStream("service.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 创建工厂实例
	 * @return
	 */
	public static ServiceFactory getFactoryInstance() {
		if(factory ==null) {
			factory = new ServiceFactory();
		}
		return factory;
	}

	public IMVService creatMVService() {
		IMVService mv=null;
		String clsName=props.getProperty("MVService");
		try {
			Class cls = Class.forName(clsName);
			mv=(IMVService)cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}


}
