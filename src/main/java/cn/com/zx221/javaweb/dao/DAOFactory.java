package cn.com.zx221.javaweb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 实现工厂生产DAO实例
 * 
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
	 * 初始化加载配置文件
	 */
	private void init() {
		InputStream inStream = DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ISongDAO createSongDAO() {
		ISongDAO dao = null;
		try {
			// 创建IFoodDAO对象（new 配置文件中foodDAO对应的实现类）
			dao = (ISongDAO) this.createObject(this.props.getProperty("songDAO"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return dao;
	}

	public IUserDAO createUserDAO() {
		IUserDAO dao = null;
		try {
			// 创建IFoodDAO对象（new 配置文件中foodDAO对应的实现类）
			dao = (IUserDAO) this.createObject(this.props.getProperty("userDAO"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return dao;
	}

	private Object createObject(String clsName) throws Exception {
		Object obj = null;
		// 加载类
		Class cls = Class.forName(clsName);
		// 反射产生对象
		obj = cls.newInstance();
		return obj;
	}

	/**
	 * 创建工厂实例
	 * 
	 * @return
	 */
	public static DAOFactory getFactoryInstance() {
		if (factory == null) {
			factory = new DAOFactory();
		}
		return factory;
	}

}
