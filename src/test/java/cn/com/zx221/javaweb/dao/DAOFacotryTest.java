package cn.com.zx221.javaweb.dao;

import org.junit.Test;

/**
 * 测试DAO工厂
 * @author ZSM
 *
 * @version 创建时间:2019年8月1日下午4:38:52
 */
public class DAOFacotryTest {
	@Test
	public void daoDactoryTest() {
		DAOFactory factory = DAOFactory.getFactoryInstance();
		System.out.println(factory);
	}
	@Test
	public void createCdDAO() {
		DAOFactory factory = DAOFactory.getFactoryInstance();
		ICdDAO dao = factory.createCdDAO();
		System.out.println(dao);
	}
    @Test
    public void creatMVDAo() {
    	DAOFactory factory=DAOFactory.getFactoryInstance();
    	IMVDao dao=factory.creatMVDAo();
    	System.out.println(dao);
    }
	
}
