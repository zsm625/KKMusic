package cn.com.zx221.javaweb.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.vo.SlsongListVO;
import cn.com.zx221.javaweb.vo.SongListVO;

public class SongServiceTest {

	private ISongService songservice;

	@Before
	public void before() {
		this.songservice = ServiceFactory.getFactoryInstance().createSongService();
	}

	@Test
	public void testSlsongList() {
		List<SlsongListVO> slsonglist = this.songservice.searchSlsongList(2);
		System.out.println(slsonglist.get(2).getSongId());
	}

	@Test
	public void testSearchSongList() {
		SongListVO songlistvo = this.songservice.searchSongList(2);
		System.out.println("歌单列表的名称:" + songlistvo.getSonglistName());

	}

}
