package cn.com.zx221.javaweb.service;

import java.util.List;

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

}
