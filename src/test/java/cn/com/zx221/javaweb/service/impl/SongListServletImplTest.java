package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.service.ISongListService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SongVo;

/**
 * 歌曲歌单service
 * @author ZSM
 *
 * @time 2019年8月8日下午6:24:12
 */
public class SongListServletImplTest {
	private ISongListService service=null;
	@Before
	public void createFactory() {
		 service = ServiceFactory.getFactoryInstance().creatSongListService();
	}
	@Test
	public void findSongVoBySongListId() {
		List<SongVo> list = this.service.findSongVoBySongListId(2);
		Assert.assertEquals(2, list.size());
	}
}
