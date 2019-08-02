package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SongListPO;

public interface ISongDAO {
	/*
	   *查询歌单列表
	 */
  public List<SongListPO> searchSongList(int userId,int typeId);
}
