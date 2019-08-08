package cn.com.zx221.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.IMVDao;
import cn.com.zx221.javaweb.po.MVPO;
import cn.com.zx221.javaweb.service.IMVService;
import cn.com.zx221.javaweb.vo.MVVO;

public class MVServiceImpl implements IMVService {
	private IMVDao mvDAO = DAOFactory.getFactoryInstance().creatMVDAo();

	public List<MVVO> selectMV(int currPageNo, int number, String mvArea, String mvType) {
		if (number < 0) {
			number = 20;
		}
		List<MVVO> mvList = null;

		int sumCount = this.mvDAO.MVCount(mvArea, mvType);
		int maxPage = sumCount / number;
		if (sumCount % number != 0) {
			maxPage++;
		}
		// 调整页码
		if (currPageNo <= 0) {
			currPageNo = 1;
		} else if (currPageNo >= maxPage) {
			currPageNo = maxPage;
		}
		// 获取有效页码对应的mvList
		List<MVPO> mvPOList = this.mvDAO.searchCurrPageMV(currPageNo, number, mvArea, mvType);
		// 将mvPOList转变成VOList
		mvList = new ArrayList<MVVO>();
		for (MVPO mvpo : mvPOList) {
			MVVO vo = new MVVO();

			vo.setMvArea(mvpo.getMvArea());
			vo.setMvId(mvpo.getMvId());
			vo.setMvIntroduce(mvpo.getMvIntroduce());
			vo.setMvIssue(mvpo.getMvIssue());
			vo.setMvName(mvpo.getMvName());
			vo.setMvPlayCount(mvpo.getMvPlayCount());
			vo.setMvSingerName(mvpo.getMvSingerName());
			vo.setMvType(mvpo.getMvType());

			mvList.add(vo);
		}
		return mvList;
	}

	// 不分页
	public List<MVVO> selectMV1(String keyword1, String keyword2) {
		List<MVVO> mvList = null;

		return null;
	}

}
