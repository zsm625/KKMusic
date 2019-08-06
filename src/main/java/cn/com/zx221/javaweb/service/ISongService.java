package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.SongListVO;
import cn.com.zx221.javaweb.vo.SongVo;

/**
 * 歌曲业务
 * 
 * @author ZSM
 *
 * @time 2019年8月5日下午5:11:01
 */
public interface ISongService {
	// 在专辑详细信息页面根据专辑id显示歌曲列表
	public List<SongVo> findSongInfByCdId(int cdId);

	/*
	 * 从数据库中，根据条件，查询出页面要显示的list 1）调用dao的查询方法，获取po list 2）将polist转变为volist
	 */
	public List<SongListVO> seacheSongList(String songTypeName);
	// 在歌曲详细页面根据songListId显示歌曲列表

}
