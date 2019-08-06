package cn.com.zx221.javaweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ICdDAO;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.CdPo;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.service.ICdService;
import cn.com.zx221.javaweb.vo.CdVo;

public class CdServiceImpl implements ICdService {
	private ICdDAO cdDao = DAOFactory.getFactoryInstance().createCdDAO();
	private SingerDAO singerDao = DAOFactory.getFactoryInstance().createSingerDAO();
	private ISongDAO songDao = DAOFactory.getFactoryInstance().createSongDAO();
	/**
	 * 首页显示数据
	 */
	public List<CdVo> findCd(String keyword) {
		List<CdVo> result = null;

		if ("最新上架".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) - 1, c.get(Calendar.DAY_OF_MONTH));
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, null, null);

			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					CdVo vo = new CdVo(po);
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("本周热销".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH) - 7);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, null, null);
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}

		if ("音乐人专区".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCDBySingerType(startTime, endTime, "民谣");
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("2018新声力量绽放".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			System.out.println(time + "," + time2);
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, null, null);
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("2018内地专辑推荐".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, "内地", null);
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("2018欧美专辑推荐".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, "欧美", null);
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("2018港台专辑推荐".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, "港台", null);
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		if ("2018影视剧OST推荐".equals(keyword)) {
			Calendar c = Calendar.getInstance();
			c.set(c.get(Calendar.YEAR) - 1, 11, 31, 23, 59, 59);
			Date time = c.getTime();
			Timestamp endTime = new Timestamp(time.getTime());
			c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
			Date time2 = c.getTime();
			Timestamp startTime = new Timestamp(time2.getTime());
			List<CdPo> cdList = cdDao.findCD(startTime, endTime, null, "华语群星");
			if (cdList != null) {
				result = new ArrayList<CdVo>();
				for (CdPo po : cdList) {
					CdVo vo = new CdVo(po);
					SingerPo singerPo = singerDao.findSingerById(po.getCd_singerId());
					vo.setCdPublisher(singerPo.getSinger_name());
					result.add(vo);
				}
			}
		}
		return result;
	}

	/**
	 * 根据id找专辑信息
	 * 
	 * @author ZSM
	 * @param cdId
	 * @return
	 */
	public CdVo findCdById(int cdId) {
		CdVo vo = null;
		
		CdPo po = cdDao.findCDById(cdId);
		if (po != null) {
			vo = new CdVo(po);
			SingerPo singerP = singerDao.findSingerById(vo.getCd_singerId());
			vo.setCdPublisher(singerP.getSinger_name());
//			List<SongPO> songPos = songDao.findSongsById(vo.getCd_id());
//			List<String> songNames = new ArrayList<String>();
//			List<String> songUrl = new ArrayList<String>();
//			 List<String> songTime = new ArrayList<String>();
//			if(songPos!=null) {
//				for(SongPO song:songPos ) {
//					songNames.add(song.getSongName());
//					songUrl.add(song.getSongUrl());
//					songTime.add(song.getSongTime());
//				}
//				vo.setSongName(songNames);
//				vo.setSongTime(songTime);
//				vo.setSongUrl(songUrl);
//			}
		}
		return vo;
	}

}
