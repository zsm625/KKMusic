package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
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
			System.out.println("sql-->" + sql);
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

}
