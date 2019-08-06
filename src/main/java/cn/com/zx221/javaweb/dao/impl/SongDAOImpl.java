package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.SongListPO;
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cdId);
			rs = pstmt.executeQuery();
			if (rs != null) {
				result = new ArrayList<SongPO>();
				while (rs.next()) {
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
		} finally {
			dbCon.close(conn, pstmt, rs);
		}

		return result;
	}

	@Override
	public List<SongListPO> searchSongList(String songTypeName) {
		List<SongListPO> songList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConnection();
			String sql = "select songlist_id,songlist_userId,songlist_name,songlist_typeId,"
					+ " songlist_accessCount,songlist_introduce,songlist_collection,songlist_tags,songlist_picUrl from songlist ";
			// 判断是否有查询条件，如果有，就在sql后添加where语句
			if (songTypeName != null && !(songTypeName = songTypeName.trim()).equals("")) {
				sql = "select * from songlist,songtype"
						+ "  where songlist.songlist_typeId=songtype.song_typeId and songtype.song_typeName = ?";

			}
			pstmt = conn.prepareStatement(sql);
			// 判断是否有条件，设置占位符信息
			if (songTypeName != null && !songTypeName.equals("")) {
				pstmt.setString(1, songTypeName);
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				songList = new ArrayList<SongListPO>();
				SongListPO song = null;
				while (rs.next()) {
					song = new SongListPO();
					song.setSonglistPicUrl(rs.getString("songlist_picUrl"));
					song.setSonglistName(rs.getString("songlist_name"));
					song.setSonglistAccessCount(rs.getInt("songlist_accessCount"));
					song.setSonglistCollection(rs.getInt("songlist_collection"));
					song.setSonglistId(rs.getInt("songlist_id"));
					song.setSonglistIntroduce(rs.getString("songlist_introduce"));
					song.setSonglistTags(rs.getString("songlist_tags"));
					song.setSonglistTypeId(rs.getInt("songlist_typeId"));
					song.setSonglistUserId(rs.getInt("songlist_userId"));
					songList.add(song);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return songList;
	}

	@Override
	public List<SongPO> searchSongPlayImfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
