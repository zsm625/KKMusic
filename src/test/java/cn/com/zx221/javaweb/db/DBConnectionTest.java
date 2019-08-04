package cn.com.zx221.javaweb.db;

import java.sql.Connection;

import org.junit.Test;

/**
 * 
 * @author ZSM
 *
 * @version 创建时间:2019年8月1日下午4:23:16
 */
public class DBConnectionTest {
	@Test
	public void dbConnectionTest() {
		DBConnection dbCon = DBConnection.getInstance();
		Connection con = dbCon.getConnection();
		System.out.println(con);
	}
}
