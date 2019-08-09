package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ICdDAO;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.CdPo;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.service.SingerService;
import cn.com.zx221.javaweb.util.Constant;
import cn.com.zx221.javaweb.vo.CdVo;
import cn.com.zx221.javaweb.vo.SingerVo;
import cn.com.zx221.javaweb.vo.SongVo;

public class SingerServiceImpl implements SingerService {
	private SingerDAO singerDAO = DAOFactory.getFactoryInstance().createSingerDAO();
	private ICdDAO cdDAO = DAOFactory.getFactoryInstance().createCdDAO();
	private ISongDAO songDAO = DAOFactory.getFactoryInstance().createSongDAO();

	public int PageNumber(String singer_initial, String areaId, String singer_sex, String singer_type) {
		int sumCount = this.singerDAO.singerCount(singer_initial, areaId, singer_sex, singer_type);
		// System.out.println(sumCount);
		// 计算总页码数
		int pageNumber = sumCount / Constant.SINGERR_PAGE_RECORD_COUNT;
		if (sumCount % Constant.SINGERR_PAGE_RECORD_COUNT != 0) {
			pageNumber++;
		}
		return pageNumber;
	}

	public List<SingerVo> findSinger(int currPageNo, String singer_initial, String singer_areaId, String singer_sex,
			String singer_type) {
		List<SingerVo> singerList = null;
		int sumCount = this.singerDAO.singerCount(singer_initial, singer_areaId, singer_sex, singer_type);
		// System.out.println(sumCount);
		// 计算总页码数
		int pageNumber = sumCount / Constant.SINGERR_PAGE_RECORD_COUNT;
		if (sumCount % Constant.SINGERR_PAGE_RECORD_COUNT != 0) {
			pageNumber++;
		}
		// 调整当前得有效页码
		if (currPageNo <= 0) {
			currPageNo = 1;
		} else if (currPageNo >= pageNumber) {
			currPageNo = pageNumber;
		}
		List<SingerPo> singerPoList = this.singerDAO.findSinger(currPageNo, Constant.SINGERR_PAGE_RECORD_COUNT,
				singer_initial, singer_areaId, singer_sex, singer_type);
		singerList = new ArrayList<SingerVo>();
		SingerVo vo = null;
		if (singerPoList != null) {
			for (SingerPo po : singerPoList) {
				vo = new SingerVo(po);
				// System.out.println(vo.getSinger_id());
				singerList.add(vo);
			}
		}
		return singerList;
	}

	public SingerVo findSingerById(int singer_id) {
		SingerVo singerVo = null;
		SingerPo singerPo = this.singerDAO.findSingerById(singer_id);
		singerVo = new SingerVo(singerPo);

		// singerVo添加cd数量
		int cdCount = cdDAO.countCDBySingerId(singer_id);
		singerVo.setCountCD(cdCount);
		// singerVo添加song数量
		int songCount = songDAO.countSongBySingerId(singer_id);
		singerVo.setCountSong(songCount);
		// singerVo添加song列表
		List<SongPO> songPOList = songDAO.findSongBySingerId(singer_id);
		List<SongVo> songVOList = new ArrayList<SongVo>();
		SongVo songVo = null;
		for (SongPO songPO : songPOList) {
			songVo = new SongVo(songPO);
			CdPo cd = cdDAO.findCDById(songPO.getCdId());
			songVo.setCdPo(cd);
			songVOList.add(songVo);
		}
		singerVo.setSongList(songVOList);
		// 获取单曲所属专辑名

		// singerVo添加专辑列表
		List<CdPo> cdPOList = cdDAO.fingCdBySingerId(singer_id);
		List<CdVo> cdVOList = new ArrayList<CdVo>();
		for (CdPo po : cdPOList) {
			cdVOList.add(new CdVo(po));
		}
		singerVo.setCdList(cdVOList);
		return singerVo;
	}

}
