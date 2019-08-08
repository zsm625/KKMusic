package cn.com.zx221.javaweb.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ICdDAO;
import cn.com.zx221.javaweb.po.CdPo;

/**
 * 对专辑数据库的操作测试
 * 
 * @author ZSM
 *
 * @time 2019年8月2日下午6:22:01
 */
public class CdDAOImplTest {
	private ICdDAO dao = null;

	@Before
	public void createDao() {
		dao = DAOFactory.getFactoryInstance().createCdDAO();
	}

	@Test
	public void findCDTest() {
		Date date1 = new Date(2018 - 01 - 01);

		Date date2 = new Date();
		System.out.println("date1" + date1 + "   date2" + date2);
		Timestamp startTime = new Timestamp(date1.getTime());
		Timestamp endTime = new Timestamp(date2.getTime());
		System.out.println("start" + startTime + "    end" + endTime);
		List<CdPo> findCD = dao.findCD(startTime, endTime, "内地", null);
		Assert.assertEquals(2, findCD.size());
	}

	@Test
	public void findCDByIdTest() {
		CdPo po = dao.findCDById(3);
		System.out.println(po.getCd_singerId());
		System.out.println(po.getCd_name());
	}

	@Test
	public void findCDByName() {
		List<CdPo> list = dao.findCDByName("明天");
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void countCDBySingerId() {
		int count = dao.countCDBySingerId(1);
		System.out.println(count);
	}

	@Test
	public void findCdBySingerId() {
		List<CdPo> cdList = dao.fingCdBySingerId(1);
		System.out.println(cdList.size());
	}

	@Test
	public void searchCdBySongid() {
		CdPo cdpo = dao.searchCdBySongid(1);
		System.out.println(cdpo.getCd_name());
	}

}
