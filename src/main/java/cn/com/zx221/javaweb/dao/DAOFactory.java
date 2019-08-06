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
	/**
	 * 反射产生对象
	 * 
	 * @param clsName
	 * @return
	 * @throws Exception
	 */
	private Object createObject(String clsName) throws Exception {
		Object obj = null;
		Class cls = Class.forName(clsName);
		obj = cls.newInstance();
		return obj;
	}

	public SingerDAO createSingerDAO() {
		SingerDAO dao = null;
		try {
			dao = (SingerDAO) this.createObject(this.props.getProperty("singerDAO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
		String clsName = props.getProperty("CdDao");


	
	/**
	 * 创建ISongDAO实例
	 * 
	 * @author ZSM
	 * @return
	 */
	public ISongDAO createSongDAO() {
		ISongDAO dao = null;
		try {
			dao = (ISongDAO) this.createObject(this.props.getProperty("songDAO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	
	public IMVDao creatMVDAo() {
		IMVDao mv = null;
		String clsName = props.getProperty("MVDao");
		try {
			Class cls = Class.forName(clsName);
			mv = (IMVDao) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
