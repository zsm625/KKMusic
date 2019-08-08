package cn.com.zx221.javaweb.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.IMVDao;
import cn.com.zx221.javaweb.po.MVPO;
import junit.framework.Assert;

/**
 * 对MV数据库的操作测试
 * 
 * @author hj
 * @time 2019年8月3日 下午2:33:01
 */
public class MVDAOImplTest {
	private IMVDao mvDAO;

	@Before
	public void before() {
		this.mvDAO = DAOFactory.getFactoryInstance().creatMVDAo();

	}

	@Test
	public void testMVCount() {
		System.out.println("testMVCount......");
		int count = this.mvDAO.MVCount(null, null);
		System.out.println(count);
		Assert.assertEquals(35, count);
		count = this.mvDAO.MVCount("内地", "儿歌");
		System.out.println(count);
	}

	@Test
	public void testSearchCurrPageMV() {
		System.out.println("testSearchCurrPageMV......");
		List<MVPO> mvList = this.mvDAO.searchCurrPageMV(1, 1, "内地", "儿歌");
		// List<MVPO> mvList = this.mvDAO.searchCurrPageMV(1, 1, "本地", "儿歌");
		System.out.println("区域：" + mvList.get(0).getMvArea());
		// Assert.assertEquals(1,mvList.size());
	}

	@Test
	public void testfindMVPlayCount() {
		System.out.println("testfindMVPlayCount....");
		int playCount = this.mvDAO.findMVPlayCount(1);
		System.out.println(playCount);
	}
}
