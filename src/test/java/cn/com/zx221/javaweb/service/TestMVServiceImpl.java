package cn.com.zx221.javaweb.service;
/**
 * 
 * @author hj
 * @time 2019年8月3日 下午11:45:33
 */

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.vo.MVVO;

public class TestMVServiceImpl {
	private IMVService mvService;

	@Before
	public void before() {
		this.mvService = ServiceFactory.getFactoryInstance().createMVService();
	}

	@Test
	public void testSelectMV() {
		List<MVVO> mvList = this.mvService.selectMV(1, 1, null, null, "1");
		System.out.println("mvList--->" + mvList);
		if (mvList != null && mvList.size() > 0) {
			for (int i = 0; i < mvList.size(); i++) {
				System.out.println("MV名称：" + mvList.get(i).getMvName());
				System.out.println("ID:" + mvList.get(i).getMvId());
			}
		}
	}
}
