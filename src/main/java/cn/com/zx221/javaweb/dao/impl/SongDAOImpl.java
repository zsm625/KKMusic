package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.SongPO;

public class SongDAOImpl implements ISongDAO {

	/**
	 * 根据专辑id查询歌曲
	 */
	public List<SongPO> findSongsByCdId(int cdId) {
		List<SongPO> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = " select * from song where song_cd_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cdId);
			rs = pstmt.executeQuery();
			if(rs!=null) {
				result = new ArrayList<SongPO>();
				while(rs.next()) {
					SongPO po = new SongPO();
					po.setSongId(rs.getInt("song_id"));
					po.setSongName(rs.getString("song_name"));
					po.setSongSinger(rs.getInt("song_singer_id"));
					po.setMvId(rs.getInt("song_mv_id"));
					po.setCdId(rs.getInt("song_cd_id"));
					po.setSongPlayCount(rs.getInt("song_playcount"));
					po.setSongDownLoadCount(rs.getInt("song_downloadCount"));
					po.setSongCollectionCount(rs.getInt("song_collectionCount"));
					po.setSongPublishDate(rs.getTimestamp("song_publishDate"));
					po.setCyricUrl(rs.getString("song_url"));
					po.setCyricUrl(rs.getString("song_cyricUrl"));
					po.setSongTime(rs.getString("song_time"));
					po.setSongTypeId(rs.getInt("song_typeId"));
					po.setSongPicUrl(rs.getString("song_picUrl"));
					result.add(po);
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
 * 根据用户id查询单曲数量
 */
	public int countSongBySingerId(int song_singerId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = "select count(*) from song where song_singer_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, song_singerId);
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
	 * 根据用户id查询单曲信息
	 */
	public List<SongPO> findSongBySingerId(int song_singerId) {
		List<SongPO> songList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		String sql = " select * from song where song_singer_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, song_singerId);
			rs = pstmt.executeQuery();
			if(rs!=null) {
				songList = new ArrayList<SongPO>();
				while(rs.next()) {
					SongPO po = new SongPO();
					po.setSongId(rs.getInt("song_id"));
					po.setSongName(rs.getString("song_name"));
					po.setSongSinger(rs.getInt("song_singer_id"));
					po.setMvId(rs.getInt("song_mv_id"));
					po.setCdId(rs.getInt("song_cd_id"));
					po.setSongPlayCount(rs.getInt("song_playcount"));
					po.setSongDownLoadCount(rs.getInt("song_downloadCount"));
					po.setSongCollectionCount(rs.getInt("song_collectionCount"));
					po.setSongPublishDate(rs.getTimestamp("song_publishDate"));
					po.setCyricUrl(rs.getString("song_url"));
					po.setCyricUrl(rs.getString("song_cyricUrl"));
					po.setSongTime(rs.getString("song_time"));
					po.setSongTypeId(rs.getInt("song_typeId"));
					po.setSongPicUrl(rs.getString("song_picUrl"));
					songList.add(po);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbCon.close(conn, pstmt, rs);
		}
		return songList;
	}
}
