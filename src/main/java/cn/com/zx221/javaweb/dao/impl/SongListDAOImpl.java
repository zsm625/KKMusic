package cn.com.zx221.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.ISongListDAO;
import cn.com.zx221.javaweb.db.DBConnection;
import cn.com.zx221.javaweb.po.SongPO;

public class SongListDAOImpl implements ISongListDAO {

	@Override
	public List<SongPO> findSongBySongListId(int songListId) {
		/*
		 * 通过歌单id从歌曲歌单表中找到相应的歌曲id
		 */
		List<SongPO> result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();
		conn = dbCon.getConnection();
		//select * from song where song_id=(select song_id from slsonglist where songlist_id=?);
		String sql = " select * from song s join slsonglist sls on s.song_id=sls.song_id where sls.songlist_id= ? ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, songListId);
			rs=pstmt.executeQuery();
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

}
