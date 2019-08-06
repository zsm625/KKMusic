package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.vo.SongVO;

public interface ISongDAO {
	/*
	 * 查询歌单列表
	 */
	public List<SongListPO> searchSongList(String songTypeName);

	/*
	 * 查看歌单列表项的播放歌曲的相关信息(歌曲 、歌手、专辑、 时长)
	 */
	public List<SongVO> searchSongPlayImfo();
}
