package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.vo.SongVo;

public class SongServiceImpl implements ISongService {
	private ISongDAO songDao = DAOFactory.getFactoryInstance().createSongDAO();
	private SingerDAO singerDao = DAOFactory.getFactoryInstance().createSingerDAO();
	/**
	 * 根据专辑id查歌曲
	 */
	public List<SongVo> findSongInfByCdId(int cdId) {
		List<SongVo> result = null;
		List<SongPO> pos = songDao.findSongsByCdId(cdId);
		
		if(pos!=null) {
			result = new ArrayList<SongVo>();
			for (SongPO songPO : pos) {
				SingerPo singer = singerDao.findSingerById(songPO.getSongSinger());
				SongVo vo = new SongVo(songPO);
				vo.setSingerName(singer.getSinger_name());
				result.add(vo);
			}
		}
		
		return result;
	}

}
