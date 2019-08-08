package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SongListVO;
import cn.com.zx221.javaweb.vo.SongVo;
import junit.framework.Assert;

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
	
	@Test
	public void testFindSongBySongId() {
		SongVo vo = this.songservice.findSongById(1);
		System.out.println(vo);
		Assert.assertTrue(vo.getSongName().equals("光年之外"));
	}
}
