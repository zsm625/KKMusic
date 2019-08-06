package cn.com.zx221.javaweb.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.SingerDAO;
import cn.com.zx221.javaweb.po.SingerPo;

public class TestSingerDAOImpl {
	private SingerDAO singer;
	/*private String a;*/
	
	@Before
	public void before() {
		this.singer = DAOFactory.getFactoryInstance().createSingerDAO();
		/*System.out.println(singer);*/
	}
	@Test
	public void testSingerCount() {
		int count = this.singer.singerCount("热门", "全部",  "男",  "摇滚");
		System.out.println(count);
	}
	@Test
	public void testFindSinger() {
		List<SingerPo> singerList = this.singer.findSinger(1,30,"x","内地 ","全部","全部");
		System.out.println(singerList.size());
//		Assert.assertEquals(4, singerList.size());
		//Assert.assertEquals("林俊杰", singerList.get(0).getSinger_name());
	}
	@Test
	public void testFindSingerById() {
		SingerPo singer = this.singer.findSingerById(1);
		System.out.println(singer.getSinger_name());
	}
}
