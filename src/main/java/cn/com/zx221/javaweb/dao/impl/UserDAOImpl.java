package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.UserPO;

public class UserDAOImpl implements IUserDAO {

	public UserPO searchUser(int songlistUserId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		UserPO user = null;
		try {
			conn = dbConn.getConnection();
			StringBuffer sb = new StringBuffer();

			sb.append("select *");
			sb.append(" from user");
			sb.append(" inner join songlist");
			sb.append(" on user.user_id = songlist.songlist_userId");
			sb.append(" where songlist_userId=?");
			sb.append(";");

			String sql = "select user_loginId from user inner join songlist "
					+ " on user.user_id = songlist.songlist_userId  " + " where songlist_userId=?";
			sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, songlistUserId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				user = new UserPO();
				user.setUserLoginId(rs.getString("user_loginId"));
				user.setUserHeadsculpictureUrl(rs.getString("user_headSculptureUrl"));
				user.setUserId(rs.getInt("user_id"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserRegistationDate(rs.getTimestamp("user_registationDate"));
				user.setUserSex(rs.getString("user_sex"));
				user.setUserSign(rs.getString("user_sign"));
				user.setUserType(rs.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return user;
	}
	/*
	 * 查询用户表里是否已经注册过该电话号码
	 */
	public boolean findUserByPhone(String phone) {
		boolean flag = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from user where user_phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return flag;
	}

	/*
	 * 注册
	 */
	public boolean regist(String userName, String password, String phone, Date registDate) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "insert into user(user_loginId,user_password,user_phone,user_registationDate) "
					+ "value(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			while (findUserByPhone(phone)) {
				pstmt.setString(1, userName);
				pstmt.setString(2, password);
				pstmt.setString(3, phone);
				pstmt.setDate(4, registDate);
				int count = pstmt.executeUpdate();
				if (count != 0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("注册：" + e.getMessage());
		} finally {
			dbConn.close(conn, pstmt);
		}
		return flag;
	}
	/*
	 * 通过电话号码查询用户密码
	 */
	public String findPassword(String phone) {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select user_password from user where user_phone = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				password = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("登陆密码：" + e.getMessage());
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return password;
	}
/*
 * 查询所有用户数据
 */
	public UserPO findUser(String phone) {
		UserPO userPO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from user where user_phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				userPO = new UserPO();
				userPO.setUserLoginId(rs.getString("user_loginId"));
				userPO.setUserHeadsculpictureUrl(rs.getString("user_headSculptureUrl"));
				userPO.setUserId(rs.getInt("user_id"));
				userPO.setUserPassword(rs.getString("user_password"));
				userPO.setUserPhone(rs.getString("user_phone"));
				userPO.setUserRegistationDate(rs.getTimestamp("user_registationDate"));
				userPO.setUserSex(rs.getString("user_sex"));
				userPO.setUserSign(rs.getString("user_sign"));
				userPO.setUserType(rs.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return userPO;
	}
	/*
	 * 通过用户id查询用户信息
	 */
	public UserPO findUserById(int userId){
		UserPO userPO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from user where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				userPO = new UserPO();
				userPO.setUserLoginId(rs.getString("user_loginId"));
				userPO.setUserHeadsculpictureUrl(rs.getString("user_headSculptureUrl"));
				userPO.setUserId(rs.getInt("user_id"));
				userPO.setUserPassword(rs.getString("user_password"));
				userPO.setUserPhone(rs.getString("user_phone"));
				userPO.setUserRegistationDate(rs.getTimestamp("user_registationDate"));
				userPO.setUserSex(rs.getString("user_sex"));
				userPO.setUserSign(rs.getString("user_sign"));
				userPO.setUserType(rs.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return userPO;
	}
}
