package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.SongVo;

/**
 * 歌曲歌单
 * @author ZSM
 *
 * @time 2019年8月8日下午5:50:13
 */
public interface ISongListService {
	public List<SongVo> findSongVoBySongListId(int songlistId);
}
