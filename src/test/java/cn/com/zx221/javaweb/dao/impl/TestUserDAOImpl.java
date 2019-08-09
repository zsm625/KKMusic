package cn.com.zx221.javaweb.dao.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.po.UserPO;

public class TestUserDAOImpl {
	private IUserDAO dao;

	@Before
	public void before() {
    dao = DAOFactory.getFactoryInstance().createUserDAO();
	}
	@Test
	public void findUserByPhone() {
		boolean flag = dao.findUserByPhone("13574572193");
		System.out.println(flag);
	}
	@Test
	public void regist() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.format(date);
		boolean flag = dao.regist("小花", "46jncjkx", "30223898", date);
		System.out.println(flag);
	}
	@Test
	public void findPassword() {
		String password = dao.findPassword("13574572193");
		System.out.println(password);
	}
	@Test
	public void findUser(String phone) {
		UserPO po = dao.findUser("13574572193");
		System.out.println(po.getUserId());
	}
	@Test
	public void findUserById() {
		UserPO userPO = dao.findUserById(1);
		System.out.println(userPO.getUserLoginId());
	}
}
