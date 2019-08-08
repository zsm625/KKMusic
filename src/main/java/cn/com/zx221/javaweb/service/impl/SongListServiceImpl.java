package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ISongListDAO;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.service.ISongListService;
import cn.com.zx221.javaweb.vo.SongVo;

public class SongListServiceImpl implements ISongListService {
private ISongListDAO songListDao = DAOFactory.getFactoryInstance().createSongListDAO();
	@Override
	public List<SongVo> findSongVoBySongListId(int songlistId) {
		List<SongVo> result =null;
		List<SongPO> songPos = songListDao.findSongBySongListId(songlistId);
		if(songPos!=null) {
			result = new ArrayList<SongVo>();
			for(SongPO po:songPos) {
				SongVo vo = new SongVo(po);
				result.add(vo);
			}
		}
		return result;
	}

}
