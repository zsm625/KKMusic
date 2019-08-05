package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Test;

import cn.com.zx221.javaweb.service.ICdService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.util.Constant;
import cn.com.zx221.javaweb.vo.CdVo;

/**
 * 对专辑的业务层逻辑的测试
 * 
 * @author ZSM
 *
 * @time 2019年8月4日下午3:00:38
 */
public class CdSerrviceImplTest {
	@Test
	public void cdServiceTest() {
		ICdService cd = ServiceFactory.getFactoryInstance().createCdService();
		String[] listTitle = Constant.CD_LIST_TITLE;
		for (int i = 0; i < listTitle.length; i++) {
			List<CdVo> findCd = cd.findCd("2018影视剧OST推荐");
			System.out.println(listTitle[i]);
			if (findCd != null) {
				for (CdVo cdVo : findCd) {
					System.out.println(cdVo.getCd_publishDate());
				}
			}
		}
	}

}
