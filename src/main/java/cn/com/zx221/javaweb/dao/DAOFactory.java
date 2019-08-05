package cn.com.zx221.javaweb.dao;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

/**
 * 实现工厂生产DAO实例
 * @author ZSM
 *
 * @version 创建时间:2019年8月1日下午4:31:52
 */
public class DAOFactory {
	private static DAOFactory factory;
	private Properties props = new Properties();
	private DAOFactory() {
		this.init();
	}
	
	/**
	 *初始化加载配置文件 
	 */
	private void init() {
		InputStream inStream = DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
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
	public static DAOFactory getFactoryInstance() {
		if(factory ==null) {
			factory = new DAOFactory();
		}
		return factory;
	}

	public ICdDAO createCdDAO() {
		ICdDAO cd = null;
		String clsName = props.getProperty("CdDao");
		try {
			Class cls = Class.forName(clsName);
			cd = (ICdDAO)cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cd;
	}
	
	public IMVDao creatMVDAo() {
		IMVDao mv=null;
		String clsName = props.getProperty("MVDao");
		try {
			Class cls = Class.forName(clsName);
			mv = (IMVDao)cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
