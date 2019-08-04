package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.service.SingerService;
import cn.com.zx221.javaweb.util.Constant;
import cn.com.zx221.javaweb.vo.SingerVo;

public class SingerServiceImpl implements SingerService {
	private SingerDAO singerDAO = DAOFactory.getFactoryInstance().createSingerDAO();
    public int PageNumber(String singer_initial, String areaId, String singer_sex, String singer_type) {
    	int sumCount = this.singerDAO.singerCount(singer_initial, areaId, singer_sex, singer_type);
		//System.out.println(sumCount);
		// 计算总页码数
		int pageNumber = sumCount / Constant.SINGERR_PAGE_RECORD_COUNT;
		if (sumCount % Constant.SINGERR_PAGE_RECORD_COUNT != 0) {
			pageNumber++;
		}
		return pageNumber;
    }
	public List<SingerVo> findSinger(int currPageNo,String singer_initial, String areaId, String singer_sex, String singer_type) {
		List<SingerVo> singerList = null;
		int pageNumber = PageNumber(singer_initial,areaId,singer_sex,singer_type);
		// 调整当前得有效页码
		if (currPageNo <= 0) {
			currPageNo = 1;
		} else if (currPageNo >= pageNumber) {
			currPageNo = pageNumber;
		}
		List<SingerPo> singerPoList = this.singerDAO.findSinger(currPageNo,Constant.SINGERR_PAGE_RECORD_COUNT,singer_initial, areaId, singer_sex, singer_type);
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
}
