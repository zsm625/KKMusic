package cn.com.zx221.javaweb.service.impl;

import java.sql.Date;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.po.UserPO;
import cn.com.zx221.javaweb.service.IUserService;
import cn.com.zx221.javaweb.vo.UserVO;

public class UserServiceImpl implements IUserService {
	private IUserDAO user = DAOFactory.getFactoryInstance().createUserDAO();

	public boolean regist(String userName, String password, String phone, Date registDate) {
		boolean flag = user.regist(userName, password, phone, registDate);
		return flag;
	}
	public String findPassword(String phone) {
		String password = user.findPassword(phone);
		return password;
	}
	public UserVO findUser(String phone) {
		UserPO userPO = user.findUser(phone);
		UserVO userVO = new UserVO(userPO);
		return userVO;
	}
	public UserVO findUserById(int userId) {
		UserPO userPO = user.findUserById(userId);
		UserVO userVO = new UserVO(userPO);
		return userVO;
	}
}
