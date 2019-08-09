package cn.com.zx221.javaweb.vo;

import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.UserPO;

public class SongListVO extends SongListPO {
	private SongListPO songlistpo;
	// 扩展的属性
	private UserPO userPO;

	public void setUserPO(UserPO userPO) {
		this.userPO = userPO;
	}

	public UserPO getUserPO() {
		return userPO;
	}

	public SongListVO(SongListPO songlistpo) {
		this.songlistpo = songlistpo;
	}

	@Override
	public String getSonglistPicUrl() {
		return songlistpo.getSonglistPicUrl();
	}

	@Override
	public int getSonglistId() {
		return songlistpo.getSonglistId();
	}

	@Override
	public int getSonglistUserId() {
		return songlistpo.getSonglistUserId();
	}

	@Override
	public String getSonglistName() {
		return songlistpo.getSonglistName();
	}

	@Override
	public int getSonglistTypeId() {
		return songlistpo.getSonglistTypeId();
	}

	@Override
	public int getSonglistAccessCount() {
		return songlistpo.getSonglistAccessCount();
	}

	@Override
	public String getSonglistIntroduce() {
		return songlistpo.getSonglistIntroduce();
	}

	@Override
	public int getSonglistCollection() {
		return songlistpo.getSonglistCollection();
	}

	@Override
	public String getSonglistTags() {
		return songlistpo.getSonglistTags();
	}

}
