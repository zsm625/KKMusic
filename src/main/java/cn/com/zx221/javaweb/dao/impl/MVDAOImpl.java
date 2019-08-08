package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.IMVDao;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.MVPO;

public class MVDAOImpl implements IMVDao {

	@Override
	public int MVCount(String mvArea, String myType) {
		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			StringBuffer sql = new StringBuffer();
			ArrayList<Object> al = new ArrayList<Object>();
			// 获取记录,无条件
			sql.append("select count(*) from mv");
			sql.append(" where 1=1");
			// 有条件,添加where语句
			if (mvArea != null) {
				sql.append(" and mv_area = ?");
				al.add(mvArea);
			}
			if (myType != null) {
				sql.append(" and mv_type = ?");
				al.add(myType);
			}

			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			// 有条件，设置占位符
			for (int i = 0; i < al.size(); i++) {
				pstmt.setObject(i + 1, al.get(i));
			}
			// 执行
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public List<MVPO> searchCurrPageMV(int currPageNo, int number, String mvArea, String mvType) {
		List<MVPO> mvList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			ArrayList<Object> al = new ArrayList<Object>();
			conn = dbConn.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select mv_id,mv_name,mv_area,mv_type");
			sql.append(",mv_playCount,mv_introduce,mv_issue,mv_singerName,mv_url");
			sql.append(" from mv");
			sql.append(" where 1=1");

			// 判断是否有查询条件
			if (mvArea != null) {
				mvArea = new String(mvArea.getBytes("iso-8859-1"), "utf-8");
				if ("全部".equals(mvArea)) {
					mvArea = null;
				} else {
					sql.append(" and mv_area = ?");
					al.add(mvArea);
				}
			}
			if (mvType != null) {
				mvType = new String(mvType.getBytes("iso-8859-1"), "utf-8");
				if ("全部".equals(mvType)) {
					mvType = null;
				} else {
					sql.append(" and mv_type = ?");
					al.add(mvType);
				}
			}

			sql.append(" limit ?,?");
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println("SQL:" + sql.toString());
			al.add((currPageNo - 1) * number);
			al.add(number);
			for (int i = 0; i < al.size(); i++) {
				System.out.println("param:" + al.get(i));
				pstmt.setObject(i + 1, al.get(i));
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				mvList = new ArrayList<MVPO>();
				while (rs.next()) {
					MVPO mv = new MVPO();
					mv.setMvArea(rs.getString("mv_area"));
					mv.setMvId(rs.getInt("mv_id"));
					mv.setMvIntroduce(rs.getString("mv_introduce"));
					mv.setMvIssue(rs.getTimestamp("mv_issue"));
					mv.setMvName(rs.getString("mv_name"));
					mv.setMvPlayCount(rs.getInt("mv_playCount"));
					mv.setMvSingerName(rs.getString("mv_singerName"));
					mv.setMvType(rs.getString("mv_type"));
					mv.setMvUrl(rs.getString("mv_url"));
					mvList.add(mv);
					System.out.println("MVDAOImpl： " + mv.getMvArea() + "  " + mv.getMvId() + "  " + mv.getMvIntroduce()
							+ "  " + mv.getMvName() + "  " + mv.getMvPlayCount() + mv.getMvUrl());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return mvList;
	}

	@Override
	public int findMVPlayCount(int mvId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select mv_playCount from mv where mv_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mvId);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				// count=rs.getInt(1);
				count = rs.getInt("mv_playCount");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
