package cn.com.zx221.javaweb.dao;

import java.sql.Date;
import java.util.List;

import cn.com.zx221.javaweb.po.UserPO;

public interface IUserDAO {
	public UserPO searchUser(int songlistUserId);
	
	public boolean findUserByPhone(String phone);
	
	public boolean regist(String userName,String password,String phone,Date registDate);
 
	public String findPassword(String phone);
	
	public UserPO findUser(String phone);
	
	public UserPO findUserById(int userId);
}
