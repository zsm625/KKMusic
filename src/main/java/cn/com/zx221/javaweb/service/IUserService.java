package cn.com.zx221.javaweb.service;

import java.sql.Date;

import cn.com.zx221.javaweb.vo.UserVO;

public interface IUserService {
	public boolean regist(String userName, String password, String phone, Date registDate);
	public String findPassword(String phone);
	public UserVO findUser(String phone);
	public UserVO findUserById(int userId);
}
