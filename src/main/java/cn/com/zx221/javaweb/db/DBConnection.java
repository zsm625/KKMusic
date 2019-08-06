package cn.com.zx221.javaweb.db;

import java.io.InputStream;
import java.sql.Connection;
<<<<<<< HEAD
=======
import java.sql.PreparedStatement;
>>>>>>> refs/remotes/origin/master
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库连接
 * 
 * @author Administrator
 */
public class DBConnection {
	private static DBConnection dbCon;
	private DruidDataSource druidDataSource;
	private String username;
	private String url;
	private String password;

	private DBConnection() {
		try {
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		Properties props = new Properties();
		InputStream inStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			props.load(inStream);

			this.url = props.getProperty("url");
			this.username = props.getProperty("username");
			this.password = props.getProperty("password");

			this.druidDataSource = new DruidDataSource();
			this.druidDataSource.setUrl(this.url);
			this.druidDataSource.setUsername(this.username);
			this.druidDataSource.setPassword(this.password);
			this.druidDataSource.init();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static DBConnection getInstance() {
		if (dbCon == null) {
			dbCon = new DBConnection();
		}
		return dbCon;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = this.druidDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

<<<<<<< HEAD
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
=======
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
>>>>>>> refs/remotes/origin/master
			e.printStackTrace();
		}
	}
}
