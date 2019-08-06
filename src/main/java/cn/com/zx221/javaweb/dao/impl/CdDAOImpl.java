package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.ICdDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.CdPo;

/**
 * 
 * @author ZSM
 *
 * @time 2019年8月2日下午2:49:57
 */
public class CdDAOImpl implements ICdDAO {

	/**
	 * 在 专辑首页显示的数据查询
	 */
	public List<CdPo> findCD(Timestamp startTime, Timestamp endTime, String area, String singerName) {
		List<CdPo> result = new ArrayList<CdPo>();
		CdPo cdPo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String str = " cd_publishDate between ? and ? order by cd_collectionCount limit 0,5 ";
		String sql = "select * from cd where " + str;
		if ((singerName == null || singerName.trim().equals("")) && (area != null && !(area.trim().equals("")))) {
			sql = " select cd.*,singer.singer_id , singer.singer_areaId from cd,singer "
					+ " where cd.cd_singerId=singer.singer_id and singer.singer_areaId= ? and " + str;

		}
		if ((area == null || area.trim().equals("")) && (singerName != null && !(singerName.trim().equals("")))) {
			sql = " select cd.*,singer.singer_id,singer.singer_name from cd,singer "
					+ "where cd.cd_singerId=singer.singer_id and singer.singer_name=? and " + str;
		}
		try {
			pstmt = conn.prepareStatement(sql);

			if ((singerName == null || singerName.trim().equals("")) && (area != null && !(area.trim().equals("")))) {
				pstmt.setString(1, area);
				pstmt.setTimestamp(2, startTime);
				pstmt.setTimestamp(3, endTime);
			}
			if ((area == null || area.trim().equals("")) && (singerName != null && !(singerName.trim().equals("")))) {
				pstmt.setString(1, singerName);
				pstmt.setTimestamp(2, startTime);
				pstmt.setTimestamp(3, endTime);
			}
			if ((area == null || area.trim().equals("")) && (singerName == null || singerName.trim().equals(""))) {
				pstmt.setTimestamp(1, startTime);
				pstmt.setTimestamp(2, endTime);
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					cdPo = new CdPo();
					cdPo.setCd_name(rs.getString("cd_name"));
					cdPo.setCd_id(rs.getInt("cd_id"));
					cdPo.setCd_publishDate(rs.getTimestamp("cd_publishDate"));
					cdPo.setCd_coverUrl(rs.getString("cd_coverUrl"));
					cdPo.setCd_collectionCount(rs.getInt("cd_collectionCount"));
					cdPo.setCd_singerId(rs.getInt("cd_singerId"));
					cdPo.setCd_introduce(rs.getString("cd_introduce"));
					cdPo.setCd_synopsis(rs.getString("cd_synopsis"));
					result.add(cdPo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.close(conn, pstmt, rs);
		}

		return result;
	}

	/**
	 * 根据ID查询具体专辑
	 */
	public CdPo findCDById(int cdId) {
		CdPo cdPo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = "select * from cd where cd_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cdId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				cdPo = new CdPo();
				cdPo.setCd_name(rs.getString("cd_name"));
				cdPo.setCd_id(rs.getInt("cd_id"));
				cdPo.setCd_publishDate(rs.getTimestamp("cd_publishDate"));
				cdPo.setCd_coverUrl(rs.getString("cd_coverUrl"));
				cdPo.setCd_collectionCount(rs.getInt("cd_collectionCount"));
				cdPo.setCd_singerId(rs.getInt("cd_singerId"));
				cdPo.setCd_introduce(rs.getString("cd_introduce"));
				cdPo.setCd_synopsis(rs.getString("cd_synopsis"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return cdPo;
	}

	/**
	 * 根据专辑名模糊查询专辑
	 */
	public List<CdPo> findCDByName(String cdName) {
		List<CdPo> result = null;
		CdPo cdPo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = "select * from cd where cd_name like ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+cdName+"%");
			rs = pstmt.executeQuery();
			if (rs != null) {
				result = new ArrayList<CdPo>();
				while (rs.next()) {
					cdPo = new CdPo();
					cdPo.setCd_name(rs.getString("cd_name"));
					cdPo.setCd_id(rs.getInt("cd_id"));
					cdPo.setCd_publishDate(rs.getTimestamp("cd_publishDate"));
					cdPo.setCd_coverUrl(rs.getString("cd_coverUrl"));
					cdPo.setCd_collectionCount(rs.getInt("cd_collectionCount"));
					cdPo.setCd_singerId(rs.getInt("cd_singerId"));
					cdPo.setCd_introduce(rs.getString("cd_introduce"));
					cdPo.setCd_synopsis(rs.getString("cd_synopsis"));
					result.add(cdPo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return result;
		
	}

	public List<CdPo> findCDBySingerType(Timestamp startTime,Timestamp endTime,String singerType) {
		List<CdPo> result = null;
		CdPo cdPo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String str = " cd_publishDate between ? and ? order by cd_collectionCount limit 0,5 ";
		String sql = "select cd.*,singer.singer_id , singer.singer_type from cd,singer "
				+ " where cd.cd_singerId=singer.singer_id and singer.singer_type= ? and "+str;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, singerType);
			pstmt.setTimestamp(2, startTime);
			pstmt.setTimestamp(3, endTime);
			rs = pstmt.executeQuery();
			if (rs != null) {
				result = new ArrayList<CdPo>();
				while (rs.next()) {
					cdPo = new CdPo();
					cdPo.setCd_name(rs.getString("cd_name"));
					cdPo.setCd_id(rs.getInt("cd_id"));
					cdPo.setCd_publishDate(rs.getTimestamp("cd_publishDate"));
					cdPo.setCd_coverUrl(rs.getString("cd_coverUrl"));
					cdPo.setCd_collectionCount(rs.getInt("cd_collectionCount"));
					cdPo.setCd_singerId(rs.getInt("cd_singerId"));
					cdPo.setCd_introduce(rs.getString("cd_introduce"));
					cdPo.setCd_synopsis(rs.getString("cd_synopsis"));
					result.add(cdPo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return result;
	}
	/*
	 * 根据歌手id查询cd数量
	 */
	public int countCDBySingerId(int cdSingerId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = "select count(*) from cd where cd_singerId = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cdSingerId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return count;
	}
	/*
	 * 根据歌手id查询cd信息
	 */
	public List<CdPo> fingCdBySingerId(int cd_SingerId){
		List<CdPo> cdList = null;
		CdPo cdPo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = "select * from cd where cd_singerId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cd_SingerId);
			rs = pstmt.executeQuery();
			if (rs != null) {
				cdList = new ArrayList<CdPo>();
				while (rs.next()) {
					cdPo = new CdPo();
					cdPo.setCd_name(rs.getString("cd_name"));
					cdPo.setCd_id(rs.getInt("cd_id"));
					cdPo.setCd_publishDate(rs.getTimestamp("cd_publishDate"));
					cdPo.setCd_coverUrl(rs.getString("cd_coverUrl"));
					cdPo.setCd_collectionCount(rs.getInt("cd_collectionCount"));
					cdPo.setCd_singerId(rs.getInt("cd_singerId"));
					cdPo.setCd_introduce(rs.getString("cd_introduce"));
					cdPo.setCd_synopsis(rs.getString("cd_synopsis"));
					cdList.add(cdPo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return cdList;
	}
}
