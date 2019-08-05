package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class SongPO {
	private int songId;
	private String songName;
	private int songSinger;
	private int mvId;
	private int cdId;
	private int songPlayCount;
	private int songDownLoadCount;
	private int songCollectionCount;
	private Timestamp songPublishDate;
	private String songUrl;
	private String cyricUrl;
	private String songTime;//在此修改了songtime的类型，改为String类型的
	private int songTypeId;
	private String songPicUrl;
	public String getSongPicUrl() {
		return songPicUrl;
	}

	public void setSongPicUrl(String songPicUrl) {
		this.songPicUrl = songPicUrl;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getSongSinger() {
		return songSinger;
	}

	public void setSongSinger(int songSinger) {
		this.songSinger = songSinger;
	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public int getCdId() {
		return cdId;
	}

	public void setCdId(int cdId) {
		this.cdId = cdId;
	}

	public int getSongPlayCount() {
		return songPlayCount;
	}

	public void setSongPlayCount(int songPlayCount) {
		this.songPlayCount = songPlayCount;
	}

	public int getSongDownLoadCount() {
		return songDownLoadCount;
	}

	public void setSongDownLoadCount(int songDownLoadCount) {
		this.songDownLoadCount = songDownLoadCount;
	}

	public int getSongCollectionCount() {
		return songCollectionCount;
	}

	public void setSongCollectionCount(int songCollectionCount) {
		this.songCollectionCount = songCollectionCount;
	}

	public Timestamp getSongPublishDate() {
		return songPublishDate;
	}

	public void setSongPublishDate(Timestamp songPublishDate) {
		this.songPublishDate = songPublishDate;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public String getCyricUrl() {
		return cyricUrl;
	}

	public void setCyricUrl(String cyricUrl) {
		this.cyricUrl = cyricUrl;
	}

	public String getSongTime() {
		return songTime;
	}

	public void setSongTime(String songTime) {
		this.songTime = songTime;
	}

	public int getSongTypeId() {
		return songTypeId;
	}

	public void setSongTypeId(int songTypeId) {
		this.songTypeId = songTypeId;
	}

	

}
