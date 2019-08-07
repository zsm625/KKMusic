package cn.com.zx221.javaweb.dao.impl;

import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.IUserDAO;

public class UserDAOImpTest {
	@Test
	public void test() {
		IUserDAO userDAO = DAOFactory.getFactoryInstance().createUserDAO();
		// System.out.println(userDAO);
	}

}
