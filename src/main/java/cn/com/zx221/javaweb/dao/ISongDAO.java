package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SongPO;

/**
 * 专辑与歌曲的关系表
 * @author ZSM
 *
 * @time 2019年8月5日上午10:55:21
 */
public interface ISongDAO {
	/**
	 * 根据专辑id找到属于这个专辑的歌曲列表
	 *@author ZSM
	 * @param cdId
	 * @return
	 */
	public List<SongPO> findSongsByCdId(int cdId);
}
