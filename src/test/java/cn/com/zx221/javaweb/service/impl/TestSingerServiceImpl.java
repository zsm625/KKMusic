package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.service.SingerService;
import cn.com.zx221.javaweb.vo.SingerVo;
import junit.framework.Assert;

public class TestSingerServiceImpl {
	private SingerService singer;

	@Before
	public void before() {
		this.singer = ServiceFactory.getFactoryInstance().createSingerService();
	}
	@Test
	public void testFindSinger() {
		List<SingerVo> singerList = this.singer.findSinger(2,null, null, null, null);
		System.out.println(singerList.size());
		Assert.assertEquals("h", singerList.get(9).getSinger_initial());
	}
}
