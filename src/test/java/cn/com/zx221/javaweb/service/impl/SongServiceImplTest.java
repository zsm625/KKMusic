package cn.com.zx221.javaweb.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.service.ISongService;
import cn.com.zx221.javaweb.service.ServiceFactory;
import cn.com.zx221.javaweb.vo.SlsongListVO;
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
		List<SongListVO> songList = this.songservice.seacheSongList("国语");
		System.out.println(songList.get(0).getSonglistName());
	}

	@Test
	public void testSearchSlsongList() {
		List<SlsongListVO> songlist = this.songservice.searchSlsongList(2);
		System.out.println(songlist.size());
	}

	@Test
	public void testSearchSongVo() {
		List<SlsongListVO> slsongListVOs = this.songservice.searchSlsongList(2);
		for (SlsongListVO slsongListVO : slsongListVOs) {
			System.out.println("歌曲名:" + slsongListVO.getSongVo().getSongName());
			System.out.println("歌手名：" + slsongListVO.getSongVo().getSingerPo().getSinger_name());
			System.out.println("专辑名：" + slsongListVO.getSongVo().getCdPo().getCd_name());
			System.out.println("播放时长：" + slsongListVO.getSongVo().getSongTime());
		}
	}

	@Test
	public void testSearchSongVO() {
		int a = 2;
		SongListVO songlistvo = this.songservice.searchSongList(a);
		System.out.println("i=" + a + "的歌单名称为:" + songlistvo.getSonglistName());
	}
	
	@Test
	public void testFindSongBySongId() {
		SongVo vo = this.songservice.findSongById(1);
		System.out.println(vo);
		Assert.assertTrue(vo.getSongName().equals("光年之外"));
	}
}
