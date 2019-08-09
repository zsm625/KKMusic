package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.UserPO;

public class UserVO extends UserPO {
	private UserPO userPO;

	public UserVO(UserPO userPO) {
		this.userPO = userPO;
	}

	@Override
	public int getUserId() {
		return userPO.getUserId();
	}

	@Override
	public String getUserLoginId() {
		return userPO.getUserLoginId();
	}

	@Override
	public String getUserPassword() {
		return userPO.getUserPassword();
	}

	@Override
	public String getUserSex() {
		return userPO.getUserSex();
	}

	@Override
	public String getUserPhone() {
		return userPO.getUserPhone();
	}

	@Override
	public String getUserType() {
		return userPO.getUserType();
	}

	@Override
	public String getUserSign() {
		return userPO.getUserSign();
	}

	@Override
	public String getUserHeadsculpictureUrl() {
		return userPO.getUserHeadsculpictureUrl();
	}

	@Override
	public Timestamp getUserRegistationDate() {
		return userPO.getUserRegistationDate();
	}
	
}
