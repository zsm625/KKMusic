package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ISongDAO;
<<<<<<< HEAD
import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.UserPO;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.vo.SongListVO;

public class SongServiceImpl implements ISongService {
	private ISongDAO songDAO = DAOFactory.getFactoryInstance().createSongDAO();
	private IUserDAO userDAO = DAOFactory.getFactoryInstance().createUserDAO();

	@Override
	public List<SongListVO> seacheSongList(String songTypeName) {
		SongListVO vo = null;
		List<SongListVO> songlist = null;
		List<SongListPO> songlistpo = this.songDAO.searchSongList(songTypeName);
		// 将POList转变为VOList
		songlist = new ArrayList<SongListVO>();
		for (SongListPO po : songlistpo) {
			// System.out.println("po-->" + po.getSonglistUserId());
			vo = new SongListVO(po);
			UserPO userpo = this.userDAO.searchUser(po.getSonglistUserId());
			// System.out.println("userpo-->" + userpo);
			vo.setUserPO(userpo);
			// System.out.println("userId-->" + vo.getUserPO().getUserId());
			songlist.add(vo);
		}
		return songlist;
=======
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.vo.SongVo;

public class SongServiceImpl implements ISongService {
	private ISongDAO songDao = DAOFactory.getFactoryInstance().createSongDAO();
	/**
	 * 根据专辑id查歌曲
	 */
	public List<SongVo> findSongInfByCdId(int cdId) {
		List<SongVo> result = null;
		List<SongPO> pos = songDao.findSongsByCdId(cdId);
		if(pos!=null) {
			result = new ArrayList<SongVo>();
			for (SongPO songPO : pos) {
				SongVo vo = new SongVo(songPO);
				result.add(vo);
			}
		}
		
		return result;
>>>>>>> refs/remotes/origin/master
	}

}
