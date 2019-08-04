package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.util.Constant;

public class SingerDAOImpl implements SingerDAO {

	public int singerCount(String singer_initial, String areaId, String singer_sex, String singer_type) {
		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select count(*) from singer";
			if (singer_initial != null && !(singer_initial = singer_initial.trim()).equals("")) {
				sql += " where singer_initial = ?";
			}
			if (areaId != null && !(areaId = areaId.trim()).equals("")) {
				sql += " where areaId = ?";
			}
			if (singer_sex != null && !(singer_sex = singer_sex.trim()).equals("")) {
				sql += " where singer_sex = ?";
			}
			if (singer_type != null && !(singer_type = singer_type.trim()).equals("")) {
				sql += " where singer_type = ?";
			}
			pstmt = conn.prepareStatement(sql);

			if (singer_initial != null && !(singer_initial = singer_initial.trim()).equals("")) {
				pstmt.setString(1, singer_initial);
			}
			if (areaId != null && !(areaId = areaId.trim()).equals("")) {
				pstmt.setString(1, areaId);
			}
			if (singer_sex != null && !(singer_sex = singer_sex.trim()).equals("")) {
				pstmt.setString(1, singer_sex);
			}
			if (singer_type != null && !(singer_type = singer_type.trim()).equals("")) {
				pstmt.setString(1, singer_type);
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return count;
	}
	public List<SingerPo> findSinger(int currPageNo, int number, String singer_initial, String areaId,
			String singer_sex, String singer_type) {
		List<SingerPo> singerList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from singer";
			if (singer_initial != null && !(singer_initial = singer_initial.trim()).equals("")) {
				sql += " where singer_initial = ?";
			}
			if (areaId != null && !(areaId = areaId.trim()).equals("")) {
				sql += " where areaId = ?";
			}
			if (singer_sex != null && !(singer_sex = singer_sex.trim()).equals("")) {
				sql += " where singer_sex = ?";
			}
			if (singer_type != null && !(singer_type = singer_type.trim()).equals("")) {
				sql += " where singer_type = ?";
			}
			sql += " limit ?,?";
			pstmt = conn.prepareStatement(sql);
			currPageNo--;
				if (singer_initial != null && !(singer_initial = singer_initial.trim()).equals("")) {
					pstmt.setString(1, singer_initial);
					pstmt.setInt(2, currPageNo * number);
					pstmt.setInt(3, number);
				} else if (areaId != null && !(areaId = areaId.trim()).equals("")) {
					pstmt.setString(1, areaId);
					pstmt.setInt(2, currPageNo * number);
					pstmt.setInt(3, number);
				} else if (singer_sex != null && !(singer_sex = singer_sex.trim()).equals("")) {
					pstmt.setString(1, singer_sex);
					pstmt.setInt(2, currPageNo * number);
					pstmt.setInt(3, number);
				} else if (singer_type != null && !(singer_type = singer_type.trim()).equals("")) {
					pstmt.setString(1, singer_type);
					pstmt.setInt(2, currPageNo * number);
					pstmt.setInt(3, number);
				} else {
					pstmt.setInt(1, currPageNo * number);
					pstmt.setInt(2, number);
				}
			rs = pstmt.executeQuery();
			if (rs != null) {
				singerList = new ArrayList<SingerPo>();
				SingerPo singer = null;
				while (rs.next()) {
					singer = new SingerPo();
					singer.setSinger_id(rs.getInt("singer_id"));
					singer.setSinger_name(rs.getString("singer_name"));
					singer.setSinger_accessCount(rs.getInt("Singer_accessCount"));
					singer.setSinger_collection(rs.getInt("singer_collection"));
					singer.setSinger_areaId(rs.getString("singer_areaId"));
					singer.setSinger_introduce(rs.getString("singer_introduce"));
					singer.setSinger_birthday(rs.getTimestamp("singer_birthday"));
					singer.setSinger_photoUrl(rs.getString("singer_photoUrl"));
					singer.setSinger_sex(rs.getString("singer_sex"));
					singer.setSinger_initial(rs.getString("singer_initial"));
					singer.setSinger_type(rs.getString("singer_type"));
					singerList.add(singer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singerList;
	}
}
