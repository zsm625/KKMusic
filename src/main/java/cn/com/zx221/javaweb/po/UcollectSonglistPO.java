package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class UcollectSonglistPO {
	private int uSonglistId;
	private int userId;
	private int songlistid;
	private Timestamp collectionDate;

	public int getuSonglistId() {
		return uSonglistId;
	}

	public void setuSonglistId(int uSonglistId) {
		this.uSonglistId = uSonglistId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSonglistid() {
		return songlistid;
	}

	public void setSonglistid(int songlistid) {
		this.songlistid = songlistid;
	}

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
	}

}
