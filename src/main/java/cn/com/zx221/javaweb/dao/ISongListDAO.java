package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SongPO;

/**
 * 歌曲歌单
 * @author ZSM
 *
 * @time 2019年8月8日下午5:25:35
 */
public interface ISongListDAO {
	/**
	 * 根据歌单号找到相应的歌曲
	 *@author ZSM
	 * @param songListId
	 * @return
	 */
	public List<SongPO> findSongBySongListId(int songListId);
}
