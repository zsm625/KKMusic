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
					+ "where cd.cd_singerId=singer.singer_id and singer.singer_areaId= ? and " + str;

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
}
