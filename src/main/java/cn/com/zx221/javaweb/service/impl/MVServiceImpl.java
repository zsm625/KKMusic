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

	/**
	 * 1.验证页码的有效性 1>基于dao查询出所有MV的数量 2>根据每页显示的MV数计算出总页码 3>根据总页码,调整有效的当前页码
	 * 2.获取有效页码对应的MV List(PO) 1>调用DAO的条件查询方法,获取当前页的PO List(当前页码)
	 */
	@Override
	public List<MVVO> selectMV(int currPageNo, int number, String mvArea, String mvType) {
		if (number < 0) {
			number = 20;
		}
		List<MVVO> mvList = null;

		int sumCount = this.mvDAO.MVCount(mvArea, mvType);
		// maxPage 总页数
		// currPageNo 当前页码
		int maxPage = sumCount / number;
		if (sumCount % number != 0 || maxPage == 0) {
			maxPage++;
		}
		// 调整页码
		if (currPageNo <= 0) {
			currPageNo = 1;
		} else if (currPageNo > maxPage) {
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
			vo.setMvUrl(mvpo.getMvUrl());

			mvList.add(vo);
		}
		return mvList;
	}

}
