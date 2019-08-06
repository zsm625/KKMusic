package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SongListVO;

public class SongServiceImplTest {
	private ISongService songservice;

	@Before
	public void before() {
		this.songservice = ServiceFactory.getFactoryInstance().createSongService();
	}

	@Test
	public void testSeacheSongList() {
		List<SongListVO> songList = this.songservice.seacheSongList(null);
		// Assert.assertTrue(songList.size() == 20);
	}
}
