package cn.com.zx221.javaweb.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.dao.IUserDAO;
import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.SongPO;
import cn.com.zx221.javaweb.po.UserPO;

public class TestSongDAOImpl {
	private IUserDAO userDAO;
	private ISongDAO songDAO;

	@Before
	public void before() {
		this.songDAO = DAOFactory.getFactoryInstance().createSongDAO();
		this.userDAO = DAOFactory.getFactoryInstance().createUserDAO();
	}
	@Test
	public void countSongBySingerId() {
     int count = songDAO.countSongBySingerId(2);
     System.out.println(count);
	}
	@Test
	public void findSongBySingerId() {
		List<SongPO> songList = songDAO.findSongBySingerId(2);
		System.out.println(songList.size());
	}
	@Test
	public void testSearchCurrPageSongs() {
		List<SongListPO> songList = this.songDAO.searchSongList(null);
		Assert.assertTrue(songList.size() == 3);
	}
	@Test
	public void testSearchUser() {
		UserPO user = this.userDAO.searchUser(1);
		System.out.println(user.getUserLoginId());
	}

}
