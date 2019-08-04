package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

/**
 * ¸èÇú¸èµ¥±í
 * 
 * @author 25070
 *
 */
public class SlsongListPO {
	private int slsongId;
	private int songlistId;
	private int songId;
	private Timestamp collectionDate;

	public int getSlsongId() {
		return slsongId;
	}

	public void setSlsongId(int slsongId) {
		this.slsongId = slsongId;
	}

	public int getSonglistId() {
		return songlistId;
	}

	public void setSonglistId(int songlistId) {
		this.songlistId = songlistId;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
	}

}
