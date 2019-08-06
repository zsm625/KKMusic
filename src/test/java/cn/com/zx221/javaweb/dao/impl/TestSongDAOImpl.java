package cn.com.zx221.javaweb.dao.impl;

import java.util.List;

import org.junit.Test;

import cn.com.zx221.javaweb.dao.DAOFactory;
import cn.com.zx221.javaweb.dao.ISongDAO;
import cn.com.zx221.javaweb.po.SongPO;

public class TestSongDAOImpl {
	ISongDAO songDAO = DAOFactory.getFactoryInstance().createSongDAO();
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
}
