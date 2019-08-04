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
	 
	/**
	 * 反射产生对象
	 * @param clsName
	 * @return
	 * @throws Exception
	 */
    private Object createObject(String clsName)throws Exception{
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
	
}
