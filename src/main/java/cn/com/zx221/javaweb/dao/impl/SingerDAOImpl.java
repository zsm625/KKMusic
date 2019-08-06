package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.SingerPo;

public class SingerDAOImpl implements SingerDAO {

	public int singerCount(String singer_initial, String singer_areaId, String singer_sex, String singer_type) {
		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select count(*) from singer";
			if (singer_initial.equals("热门")) {
			} else {
				sql += " where singer_initial = ?";
				// System.out.println(sql);
			}
			if (singer_areaId.equals("全部")) {
			} else {
				if (singer_initial.equals("热门")) {
					sql += " where singer_areaId = ?";
				} else {
					sql += " and singer_areaId = ?";
				}
			}
			if (singer_sex.equals("全部")) {
			} else {
				if (singer_areaId.equals("全部") && singer_initial.equals("热门")) {
					sql += " where singer_sex = ?";
				} else {
					sql += " and singer_sex = ?";
				}
			}
			if (singer_type.equals("全部")) {
			} else {
				if (singer_areaId.equals("全部") && singer_initial.equals("热门") && singer_sex.equals("全部")) {
					sql += " where singer_type = ?";
				} else {
					sql += " and singer_type = ?";
				}
			}
			pstmt = conn.prepareStatement(sql);
			if (!singer_initial.equals("热门") && !singer_sex.equals("全部") && !singer_areaId.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_sex);
				pstmt.setString(4, singer_type);

			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_sex);
			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_type);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_sex);
				pstmt.setString(3, singer_type);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_sex);
				pstmt.setString(3, singer_type);
			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_sex);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_type);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_sex);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_type);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_sex);
				pstmt.setString(2, singer_type);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_sex);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_type);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
			}
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


	public List<SingerPo> findSinger(int currPageNo, int number, String singer_initial, String singer_areaId,
			String singer_sex, String singer_type) {
		List<SingerPo> singerList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from singer";
			if (singer_initial.equals("热门")) {
			} else {
				sql += " where singer_initial = ?";
				// System.out.println(sql);
			}
			if (singer_areaId.equals("全部")) {
			} else {
				if (singer_initial.equals("热门")) {
					sql += " where singer_areaId = ?";
				} else {
					sql += " and singer_areaId = ?";
				}
			}
			if (singer_sex.equals("全部")) {
			} else {
				if (singer_areaId.equals("全部") && singer_initial.equals("热门")) {
					sql += " where singer_sex = ?";
				} else {
					sql += " and singer_sex = ?";
				}
			}
			if (singer_type.equals("全部")) {
			} else {
				if (singer_areaId.equals("全部") && singer_initial.equals("热门") && singer_sex.equals("全部")) {
					sql += " where singer_type = ?";
				} else {
					sql += " and singer_type = ?";
				}
			}
			sql += " limit ?,?";
			pstmt = conn.prepareStatement(sql);
			currPageNo--;

			if (!singer_initial.equals("热门") && !singer_sex.equals("全部") && !singer_areaId.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_sex);
				pstmt.setString(4, singer_type);
				pstmt.setInt(5, currPageNo * number);
				pstmt.setInt(6, number);

			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_sex);
				pstmt.setInt(4, currPageNo * number);
				pstmt.setInt(5, number);
			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setString(3, singer_type);
				pstmt.setInt(4, currPageNo * number);
				pstmt.setInt(5, number);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_sex);
				pstmt.setString(3, singer_type);
				pstmt.setInt(4, currPageNo * number);
				pstmt.setInt(5, number);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_sex);
				pstmt.setString(3, singer_type);
				pstmt.setInt(4, currPageNo * number);
				pstmt.setInt(5, number);
			} else if (!singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_areaId);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_sex);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setString(2, singer_type);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_sex);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setString(2, singer_type);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_sex);
				pstmt.setString(2, singer_type);
				pstmt.setInt(3, currPageNo * number);
				pstmt.setInt(4, number);
			} else if (!singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_initial);
				pstmt.setInt(2, currPageNo * number);
				pstmt.setInt(3, number);
			} else if (singer_initial.equals("热门") && !singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_areaId);
				pstmt.setInt(2, currPageNo * number);
				pstmt.setInt(3, number);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && !singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
				pstmt.setString(1, singer_sex);
				pstmt.setInt(2, currPageNo * number);
				pstmt.setInt(3, number);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& !singer_type.equals("全部")) {
				pstmt.setString(1, singer_type);
				pstmt.setInt(2, currPageNo * number);
				pstmt.setInt(3, number);
			} else if (singer_initial.equals("热门") && singer_areaId.equals("全部") && singer_sex.equals("全部")
					&& singer_type.equals("全部")) {
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
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return singerList;
	}

	/**
	 * 根据id查找歌手信息
	 */
	public SingerPo findSingerById(int singerId) {
		SingerPo singer = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select * from singer where singer_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, singerId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(conn, pstmt, rs);
		}
		return singer;
	}
}
