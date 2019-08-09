package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SlsongListPO;
import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.SongPO;

/**
 * 专辑与歌曲的关系表
 * 
 * @author ZSM
 *
 * @time 2019年8月5日上午10:55:21
 */
public interface ISongDAO {
	/**
	 * 根据专辑id找到属于这个专辑的歌曲列表
	 * 
	 * @author ZSM
	 * @param cdId
	 * @return
	 */
	public List<SongPO> findSongsByCdId(int cdId);

	public int countSongBySingerId(int song_singerId);

	public List<SongPO> findSongBySingerId(int song_singerId);

	/*
	 * 查询歌单列表
	 */
	public List<SongListPO> searchSongList(String songTypeName);

	/*
	 * 查询歌曲歌单表
	 */
	public List<SlsongListPO> searchSlsongList(int songlistId);

	/*
	 * 通过songid查询歌曲列表的PO(歌曲、歌手、专辑、时长)
	 */
	public SongPO searchSongBysongid(Integer integers);

	/*
	 * 通过songlistId查询歌单列表的信息
	 */
	public SongListPO searchSongList(int songlistId);

}
