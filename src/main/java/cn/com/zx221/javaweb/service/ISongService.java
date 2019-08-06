package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.SongListVO;

public interface ISongService {
	/*
	 * 从数据库中，根据条件，查询出页面要显示的list 1）调用dao的查询方法，获取po list 2）将polist转变为volist
	 */
	public List<SongListVO> seacheSongList(String songTypeName);
}
