package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ICdDAO;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.CdPo;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SlsongListPO;
import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.po.UserPO;
import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.vo.SlsongListVO;
import cn.com.zx221.javaweb.vo.SongListVO;
import cn.com.zx221.javaweb.vo.SongVo;

public class SongServiceImpl implements ISongService {

	private ISongDAO songDAO = DAOFactory.getFactoryInstance().createSongDAO();

	private IUserDAO userDAO = DAOFactory.getFactoryInstance().createUserDAO();
	private ISongDAO songDao = DAOFactory.getFactoryInstance().createSongDAO();
	private SingerDAO singerDao = DAOFactory.getFactoryInstance().createSingerDAO();

	private ICdDAO cdDao = DAOFactory.getFactoryInstance().createCdDAO();


	/**
	 * 根据专辑id查歌曲
	 */
	public List<SongVo> findSongInfByCdId(int cdId) {
		List<SongVo> result = null;
		List<SongPO> pos = songDao.findSongsByCdId(cdId);
		
		if (pos != null) {
			result = new ArrayList<SongVo>();
			for (SongPO songPO : pos) {
				SongVo vo = new SongVo(songPO);
				SingerPo singer = singerDao.findSingerById(vo.getSongSinger());
				vo.setSingerName(singer.getSinger_name());
				result.add(vo);
			}
		}

		return result;
	}

	public List<SongListVO> seacheSongList(String songTypeName) {
		SongListVO vo = null;
		List<SongListVO> songlist = null;
		List<SongListPO> songlistpo = this.songDao.searchSongList(songTypeName);
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
	}

	@Override
	public SongVo findSongById(int songId) {
		SongVo vo = null;
		SongPO po = songDao.findSongBySongId(songId);
		if(po!=null) {
			vo = new SongVo(po);
			SingerPo singerPo = singerDao.findSingerById(po.getSongSinger());
			vo.setSingerName(singerPo.getSinger_name());
		}
		return vo;
	}

	/**
	 * 查询歌曲名称、歌手名字、专辑名字、播放时长
	 */
	@Override
	public List<SlsongListVO> searchSlsongList(int songlistId) {
		SlsongListVO vo = null;
		List<SlsongListVO> slsonglistvo = null;
		List<SlsongListPO> slsonglistpo = this.songDao.searchSlsongList(songlistId);
		slsonglistvo = new ArrayList<SlsongListVO>();
		ArrayList<Integer> allSongId = new ArrayList<Integer>();
		for (SlsongListPO po : slsonglistpo) {
			vo = new SlsongListVO(po);
			SongPO songPO = this.songDao.searchSongBysongid(po.getSongId());
			SongVo songVo = new SongVo(songPO);
			SingerPo singerpo = this.singerDao.fingSingerBySongId(songPO.getSongId());
			CdPo cdPo = this.cdDao.searchCdBySongid(songPO.getSongId());
			songVo.setSingerPo(singerpo);
			songVo.setCdPo(cdPo);
			vo.setSongVo(songVo);
			slsonglistvo.add(vo);
		}
		return slsonglistvo;
	}

	@Override
	public SongListVO searchSongList(int songlistId) {
		SongListVO songlistvo = null;
		SongListPO songlistpo = this.songDao.searchSongList(songlistId);
		songlistvo = new SongListVO(songlistpo);
		return songlistvo;
	}
}
